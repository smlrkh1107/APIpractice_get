package kun.hee.apipractice_get

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kun.hee.apipractice_get.datas.User
import kun.hee.apipractice_get.utils.ConnectServer
import kun.hee.apipractice_get.utils.ContextUtil
import kun.hee.apipractice_get.utils.GlobalData
import org.json.JSONObject

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {

    }

    override fun setValues() {





//  1.5초동안 로고를 보여준 뒤, 로그인 액티비티로 전환
        Handler().postDelayed({
            if (ContextUtil.getUserToken(mContext) == "") { //로그인정보있니?
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish() // 뒤로가기해도 이 화면으로 가지지 않아.
            }
            else { //자동로그인이네
//                토큰이 저장되어있다면, 이 토큰으로 사용자 정보를 받아서
//                GlobalData에 저장하고 액티비티 전환.
                ConnectServer.getRequestMyInfo(mContext, object :ConnectServer.JsonResponseHandler{
                    override fun onResponse(json: JSONObject) {
                        Log.d("내정보응답", json.toString())

                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")
                        val nowUser = User.getUserFromJSonObject(user)
                        GlobalData.loginUser = nowUser

                        val myIntent = Intent(mContext, MyPageActivity::class.java)
                        startActivity(myIntent)
                        finish() // 뒤로가기해도 이 화면으로 가지지 않아.
                    }
                    })

            }
        },2500)

    }
}


