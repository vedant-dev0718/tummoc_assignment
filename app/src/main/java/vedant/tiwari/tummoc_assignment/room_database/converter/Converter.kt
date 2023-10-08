package vedant.tiwari.tummoc_assignment.room_database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import vedant.tiwari.tummoc_assignment.room_database.model.ShoppingResponse

class Converters {
    @TypeConverter
    fun fromShoppingResponse(value: String): ShoppingResponse {
        val type = object : TypeToken<ShoppingResponse>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun shoppingResponseToString(shoppingResponse: ShoppingResponse): String {
        return Gson().toJson(shoppingResponse)
    }
}