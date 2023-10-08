package vedant.tiwari.tummoc_assignment.activities.internal_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vedant.tiwari.tummoc_assignment.R
import vedant.tiwari.tummoc_assignment.activities.internal_screen.fav.Favorite
import vedant.tiwari.tummoc_assignment.databinding.ActivityInternalBinding

class Internal : AppCompatActivity() {

    lateinit var binding: ActivityInternalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getStringExtra("screen").equals("cart")) {
            binding.toolbarTitle.text = "Cart"
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame_layout, Favorite())
                .addToBackStack(null)
                .commit()
        }

    }
}