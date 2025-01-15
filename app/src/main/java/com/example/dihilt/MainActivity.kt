package com.example.dihilt

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dihilt.Constant.TAG
import com.example.dihilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    @Inject
//    lateinit var userRepository: UserRepository

    @Inject
    lateinit var loggerService1: LoggerService

    @Inject
    lateinit var loggerService2: LoggerService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val first = MainFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMainFragment, first)
            commit()
        }
//        Log.d(TAG, "$userRepository")
//        userRepository.saveUser("test@t.e","111111")
    }
}