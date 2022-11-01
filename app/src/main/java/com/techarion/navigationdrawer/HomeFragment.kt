package com.techarion.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.techarion.navigationdrawer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = findNavController()
           binding.btnGoToNextScreen.setOnClickListener {
              findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
           }

    }


}