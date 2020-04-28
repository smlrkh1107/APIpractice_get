package kun.hee.apipractice_get.datas

import org.json.JSONObject
import java.util.*

class User {

//    JSON 파싱 기초
    var id:Int = 0 //int 정의 안해줘도 됨.
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""


//    JSON 파싱 응용
    var storeCategory = Category() //내가만든 그 class
    var createdAt = Calendar.getInstance()  //날짜형식


//    JSONObject를 User 객체로 변환해주는 함수!
    companion object {
        fun getUserFromJSonObject (json:JSONObject) :User {
            val parsedUser = User()
            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")



            return parsedUser
    }
}

}