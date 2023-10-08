package vedant.tiwari.tummoc_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vedant.tiwari.tummoc_assignment.R
import vedant.tiwari.tummoc_assignment.activities.internal_screen.fav.FavoriteViewModel
import vedant.tiwari.tummoc_assignment.databinding.CartItemBinding
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem
import vedant.tiwari.tummoc_assignment.room_database.model.Item

class CategoryItemAdapter(
    private var itemList: List<Item>,
    var favoriteViewModel: FavoriteViewModel
) : RecyclerView
.Adapter<CategoryItemAdapter.CategoryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder =
        CategoryItemViewHolder(
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) =
        holder.bind(itemList[position])

    override fun getItemCount(): Int = itemList.size

    inner class CategoryItemViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder
            (binding.root) {
        var fav = true;

        fun bind(item: Item) {

            binding.subTitle.text = item.name
            binding.money.text = "₹" + item.price
//            Glide.with(itemView.context).load(Uri.parse(item.icon)).into(binding.cartImage)
            if (favoriteViewModel.checkIfFavoriteExists(itemView.context, item.id)) {
                Glide.with(itemView.context).load(R.drawable.baseline_favorite_24)
                    .into(binding.fav)
            } else {
                Glide.with(itemView.context).load(R.drawable.baseline_favorite_border_24)
                    .into(binding.fav)
            }
            binding.fav.setOnClickListener {
                fav = if (fav) {
                    Glide.with(itemView.context).load(R.drawable.baseline_favorite_24)
                        .into(binding.fav)
                    favoriteViewModel.insertFavorite(
                        itemView.context, FavoriteItem(
                            item.id, item.name, item
                                .icon, item.price
                        )
                    )
                    false;
                } else {
                    Glide.with(itemView.context).load(R.drawable.baseline_favorite_border_24)
                        .into(binding.fav)
                    true;
                }
            }
        }

    }
}