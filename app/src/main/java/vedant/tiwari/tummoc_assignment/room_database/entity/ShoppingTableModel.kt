package vedant.tiwari.tummoc_assignment.room_database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import vedant.tiwari.tummoc_assignment.room_database.model.ShoppingResponse

@Entity(tableName = "shopping_table")
data class ShoppingTableModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val shoppingResponse: ShoppingResponse
)

