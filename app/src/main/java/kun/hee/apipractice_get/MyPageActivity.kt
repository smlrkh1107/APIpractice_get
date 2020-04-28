package kun.hee.apipractice_get

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_my_page.*
import kun.hee.apipractice_get.utils.ContextUtil
import kun.hee.apipractice_get.utils.GlobalData

class MyPageActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        logoutBtn.setOnClickListener {
            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("로그아웃")
            alert.setMessage("정말 로그아웃 하시겠습니까?")
            alert.setPositiveButton("로그아웃",{dialog, which ->
//            로그인은 토큰가져오기였으니, 로그아웃은 토큰없애자
                ContextUtil.setUserToken(mContext,"") //토큰을 지우면~
//            다시로그인화면으로이동
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish()
            })
            alert.setNegativeButton("취소", null)
            alert.show()





        }

    }

    override fun setValues() {
10
        nameTxt.text = GlobalData.loginUser?.name //?로 받을시, 자동로그인시 앱이 죽지는 않는데 가져오질 못해
        phoneTxt.text = GlobalData.loginUser?.phoneNum

    }


}
