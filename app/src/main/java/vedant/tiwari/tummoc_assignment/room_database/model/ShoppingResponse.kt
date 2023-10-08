package vedant.tiwari.tummoc_assignment.room_database.model

data class ShoppingResponse(
    val status: Boolean,
    val message: String,
    val error: String,
    val categories: List<Category>
)

data class Category(
    val id: Int,
    val name: String,
    val items: List<Item>
)

data class Item(
    val id: Int,
    val name: String,
    val icon: String,
    val price: Double
)
