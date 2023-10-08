package vedant.tiwari.tummoc_assignment.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vedant.tiwari.tummoc_assignment.activities.internal_screen.Internal
import vedant.tiwari.tummoc_assignment.activities.internal_screen.fav.FavoriteViewModel
import vedant.tiwari.tummoc_assignment.adapters.MainAdapter
import vedant.tiwari.tummoc_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.favSection.setOnClickListener {
            startActivity(
                Intent(this, Internal::class.java)
                    .putExtra("screen", "fav")
            )
        }

        binding.favSection.setOnClickListener {
            startActivity(
                Intent(this, Internal::class.java)
                    .putExtra("screen", "cart")
            )
        }
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]

        mainViewModel.getShopDetails(this).observe(this, Observer { shopDetails ->
            if (shopDetails != null) {
                adapter = MainAdapter(shopDetails.shoppingResponse.categories,favoriteViewModel)
                binding.mainRv.adapter = adapter
            } else {

            }
        })


    }
}