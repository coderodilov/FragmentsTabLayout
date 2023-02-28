package uz.coderodilov.fragmentstablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import uz.coderodilov.fragmentstablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragment(LoginFragment())
        

        binding.tabLayout.addOnTabSelectedListener(this)

    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when(tab?.position){
            0 -> setFragment(LoginFragment())
            1 -> setFragment(SignUpFragment())
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }
}