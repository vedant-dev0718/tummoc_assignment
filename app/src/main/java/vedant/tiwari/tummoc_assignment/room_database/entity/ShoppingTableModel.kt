package vedant.tiwari.tummoc_assignment.room_database.entity


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "shopping_table")
data class ShoppingTableModel(

	@field:ColumnInfo(name = "message")
	val message: String? = null,

	@field:ColumnInfo(name = "error")
	val error: Any? = null,

	@field:ColumnInfo(name = "status")
	val status: Boolean? = null,

	@field:ColumnInfo(name = "categories")
val categories: List<CategoriesItem?>? = null
)

data class ItemsItem(

	@field:ColumnInfo(name = "price")
	val price: Any? = null,

	@field:ColumnInfo(name = "name")
	val name: String? = null,

	@field:ColumnInfo(name = "icon")
	val icon: String? = null,

	@field:ColumnInfo(name = "id")
	val id: Int? = null
)

data class CategoriesItem(

	@field:ColumnInfo(name = "name")
	val name: String? = null,

	@PrimaryKey
	@field:ColumnInfo(name = "id")
	val id: Int? = null,

	@field:ColumnInfo(name = "items")
	val items: List<ItemsItem?>? = null
)
