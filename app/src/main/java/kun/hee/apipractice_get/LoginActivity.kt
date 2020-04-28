package kun.hee.apipractice_get

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kun.hee.apipractice_get.datas.User
import kun.hee.apipractice_get.utils.ConnectServer
import kun.hee.apipractice_get.utils.ContextUtil
import kun.hee.apipractice_get.utils.GlobalData
import org.json.JSONObject

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {
        loginBtn.setOnClickListener {
            val id = idEdt.text.toString()
            val pw = pwEdt.text.toString()

            ConnectServer.postRequestLogin(mContext, id, pw, object: ConnectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("로그인응답", json.toString())

                    val code = json.getInt("code")

                    if (code == 200){
                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")
                        val token = data.getString("token")

                        val nowLoginUser = User.getUserFromJSonObject(user)

                        GlobalData.loginUser = nowLoginUser
                        ContextUtil.setUserToken(mContext, token)

                        val myIntent = Intent(mContext, MyPageActivity::class.java)
                        startActivity(myIntent)
                    }

                    else {
                        val message = json.getString("message")
                        runOnUiThread{
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
        }

    }

    override fun setValues() {

    }


}
