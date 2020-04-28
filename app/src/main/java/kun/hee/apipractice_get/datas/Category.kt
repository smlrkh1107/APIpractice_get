package kun.hee.apipractice_get.datas

import org.json.JSONObject

class Category {

    companion object{
        fun getCategoryFromJson(json:JSONObject) : Category {
            val ct = Category()
            ct.id = json.getInt("id")
            ct.title = json.getString("title")
            ct.color = json.getString("color")

            return ct

        }
    }


    var id = 0
    var title = ""
    var color =""
}