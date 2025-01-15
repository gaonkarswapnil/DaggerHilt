package com.example.dihilt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dihilt.Constant.TAG
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    @ForSQL
    lateinit var userRepository: UserRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        userRepository.saveUser("oliver@rw.com", "11111")
        Log.d(TAG, "$userRepository")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}