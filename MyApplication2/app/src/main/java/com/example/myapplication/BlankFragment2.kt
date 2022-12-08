package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentBlank1Binding
import com.example.myapplication.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {

    private lateinit var binding : FragmentBlank2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = FragmentBlank2Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.textView7)
        textView.text =  arguments?.getString("veri").toString()

        view.findViewById<Button>(R.id.button5).setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_blankFragment2_to_blankFragment)
        }

    }


}