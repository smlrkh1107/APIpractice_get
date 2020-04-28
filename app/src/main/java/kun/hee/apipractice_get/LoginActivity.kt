package kun.hee.apipractice_get

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import kun.hee.apipractice_get.utils.ConnectServer
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
                }

            })
        }

    }

    override fun setValues() {

    }


}
