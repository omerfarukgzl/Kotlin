package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.ActivityKitapBinding
import com.example.myapplication.databinding.ActivityKitapTanitimBinding
import com.example.myapplication.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {

    private lateinit var navController: NavController
    private lateinit var binding : FragmentBlank1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding  = ActivityKitapBinding.inflate(layoutInflater)
        binding  = FragmentBlank1Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button4).setOnClickListener{
            val gonderilecekVeri = binding?.textView5?.text.toString()
            val bundle = bundleOf("veri" to gonderilecekVeri)
            Navigation.findNavController(it).navigate(R.id.action_blankFragment_to_blankFragment2,bundle)
        }
    }





}