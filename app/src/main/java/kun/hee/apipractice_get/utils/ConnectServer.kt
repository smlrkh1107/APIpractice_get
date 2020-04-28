package kun.hee.apipractice_get.utils

import android.content.Context
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ConnectServer {
    interface JsonResponseHandler{ //제이슨 응답을 처리해준다
        fun onResponse(json: JSONObject)
    }

    companion object{


        private val BASE_URL = "http://192.168.0.243:5000"

        fun postRequestLogin(context: Context, id:String, pw:String, handler: JsonResponseHandler?) {
            val client = OkHttpClient()
            val urlStr = "${BASE_URL}/auth"

            val formBody = FormBody.Builder() //캐리어 열자 -> add로 짐넣자
                .add("login_id", id) //짐넣기 login_id는 저 주소에서 받는 이름.
                .add("password", pw) //저 링크에서 받겠다는 이름이 password
                .build() //캐리어닫자

            val request = Request.Builder() //비행기티켓   request는 okhttp3받기
                .url(urlStr) //어디로갈래?
                .post(formBody) //가는방법 (짐첨부?)
//                .header() //API가 header를 요구하면 추가해야 함.
                .build() //표출력


            client.newCall(request).enqueue(object : Callback { //object[익명] 알트 앤터
                override fun onFailure(call: Call, e: IOException) {

                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {

                    val body = response.body!!.string() //toString놉.
                    val json = JSONObject(body)

                    handler?.onResponse(json) //핸들러있니 ? 있으면 반응좀 =>? : null가능

                }
            })

        }




        fun putRequestSignUp(context: Context, id:String, pw:String, name:String, phoneNum:String, handler: JsonResponseHandler?){
            val client = OkHttpClient()
            val urlStr = "${BASE_URL}/auth"

            val formBody = FormBody.Builder() //formData로 담아달라고 했자낭
                .add("login_id", id)
                .add("password", pw)
                .add("name", name)
                .add("phone", phoneNum)
                .build()

            val request = Request.Builder()
                .url(urlStr)
                .put(formBody)
                .build()

            client.newCall(request).enqueue(object : Callback{ // {}를 해야 object alt+enter됨
                override fun onFailure(call: Call, e: IOException) {

                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body!!.string()
                    val json = JSONObject(body)

                    handler?.onResponse(json)
                }

            })


        }
    }

}