package vedant.tiwari.tummoc_assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vedant.tiwari.tummoc_assignment.R
import vedant.tiwari.tummoc_assignment.activities.internal_screen.fav.FavoriteViewModel
import vedant.tiwari.tummoc_assignment.databinding.FavItemBinding
import vedant.tiwari.tummoc_assignment.room_database.entity.FavoriteItem

class FavouriteAdapter(
    private val favList: List<FavoriteItem>,
    private val viewModel: FavoriteViewModel
) :
    RecyclerView
    .Adapter<FavouriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteAdapter.FavoriteViewHolder =
        FavoriteViewHolder(
            FavItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FavouriteAdapter.FavoriteViewHolder, position: Int) =
        holder.bind(favList[position])

    override fun getItemCount(): Int = favList.size

    inner class FavoriteViewHolder(private val binding: FavItemBinding) :
        RecyclerView.ViewHolder
            (binding.root) {
        var fav = true;

        fun bind(item: FavoriteItem) {
            binding.subTitle.text = item.name
            binding.money.text = "₹" + item.price

            binding.fav.setOnClickListener {
                fav = if (fav) {
                    Glide.with(itemView.context).load(R.drawable.baseline_favorite_24)
                        .into(binding.fav)
                    false;
                } else {
                    viewModel.deleteFavorite(item.id)
                    Glide.with(itemView.context).load(R.drawable.baseline_favorite_border_24)
                        .into(binding.fav)
                    true;
                }
            }

        }

    }
}