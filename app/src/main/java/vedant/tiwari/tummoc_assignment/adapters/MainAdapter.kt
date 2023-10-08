package vedant.tiwari.tummoc_assignment.adapters

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vedant.tiwari.tummoc_assignment.R
import vedant.tiwari.tummoc_assignment.activities.internal_screen.fav.FavoriteViewModel
import vedant.tiwari.tummoc_assignment.databinding.CategoriesItemBinding
import vedant.tiwari.tummoc_assignment.room_database.model.Category

class MainAdapter(var categoryList: List<Category>, var favoriteViewModel: FavoriteViewModel) :
    RecyclerView.Adapter<MainAdapter
    .MainViewHolder>
        () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter
    .MainViewHolder =
        MainViewHolder(
            CategoriesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: MainAdapter
        .MainViewHolder, position: Int
    ) = holder.bind(categoryList[position])

    override fun getItemCount(): Int = categoryList.size

    inner class MainViewHolder(private val binding: CategoriesItemBinding) : RecyclerView.ViewHolder
        (binding.root) {

        var enable = true;

        fun bind(item: Category) {
            binding.title.text = item.name

            binding.expandedBtn.setOnClickListener {
                if (enable) {
                    Glide.with(itemView.context).load(R.drawable.baseline_keyboard_arrow_up_24)
                        .into(binding.expandedBtn)
                    binding.mainRv.visibility = GONE
                    enable = false
                } else {
                    Glide.with(itemView.context).load(R.drawable.baseline_keyboard_arrow_down_24)
                        .into(binding.expandedBtn)
                    binding.mainRv.visibility = VISIBLE
                    enable = true
                }
            }
            val adapter = CategoryItemAdapter(item.items,favoriteViewModel)
            binding.mainRv.adapter = adapter
        }
    }

}