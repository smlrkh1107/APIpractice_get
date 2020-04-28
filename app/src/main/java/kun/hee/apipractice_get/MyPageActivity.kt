package kun.hee.apipractice_get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_page.*
import kun.hee.apipractice_get.utils.GlobalData

class MyPageActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
10
        nameTxt.text = GlobalData.loginUser?.name //?로 받을시, 자동로그인시 앱이 죽지는 않는데 가져오질 못해
        phoneTxt.text = GlobalData.loginUser?.phoneNum

    }


}
