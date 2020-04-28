package kun.hee.apipractice_get.datas

import java.util.*

class User {

//    JSON 파싱 기초
    var id:Int = 0 //int 정의 안해줘도 됨.
    var login_id = ""
    var name = ""
    var phoneNum = ""
    var memo = ""


//    JSON 파싱 응용
    var storeCategory = Category() //내가만든 그 class
    var createdAt = Calendar.getInstance()  //날짜형식

}