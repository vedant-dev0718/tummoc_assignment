package vedant.tiwari.tummoc_assignment.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import vedant.tiwari.tummoc_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.getShopDetails(this).observe(this, Observer { shopDetails ->
            if (shopDetails != null) {
                Log.d("vedant", shopDetails.toString())
            } else {
                // Handle the case when shopDetails is null
            }
        })
    }
}