package vedant.tiwari.tummoc_assignment.activities.internal_screen.fav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vedant.tiwari.tummoc_assignment.adapters.FavouriteAdapter
import vedant.tiwari.tummoc_assignment.databinding.FragmentFavoriteBinding

class Favorite : Fragment() {

    companion object {
        fun newInstance() = Favorite()
    }

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]

        viewModel.getAllFavorites(requireContext()).observe(viewLifecycleOwner, Observer { favoriteItems ->
            if (favoriteItems != null) {
                val adapter = FavouriteAdapter(favoriteItems, viewModel)
                binding.favRv.adapter = adapter
            } else {

            }
        })


    }

}