package vedant.tiwari.tummoc_assignment.adapters

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vedant.tiwari.tummoc_assignment.databinding.CategoriesItemBinding
import vedant.tiwari.tummoc_assignment.room_database.model.Category

class MainAdapter(var categoryList: List<Category>) : RecyclerView.Adapter<MainAdapter
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

        var enable = false;

        fun bind(item: Category) {
            binding.title.text = item.name
            binding.expandedBtn.setOnClickListener {
                if (enable) {
                    binding.mainRv.visibility = GONE
                    enable = false
                } else {
                    binding.mainRv.visibility = VISIBLE
                    enable = true
                }
            }
            val adapter = CategoryItemAdapter(item.items)
            binding.mainRv.adapter = adapter
        }
    }

}