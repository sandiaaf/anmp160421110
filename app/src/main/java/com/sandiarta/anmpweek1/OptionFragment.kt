package com.sandiarta.anmpweek1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sandiarta.anmpweek1.databinding.FragmentMainBinding
import com.sandiarta.anmpweek1.databinding.FragmentOptionBinding

class OptionFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOptionBinding
    private val level= arrayOf("Easy", "Medium", "Hard")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_dropdown_item_1line,level)
        binding.txtLevel.setAdapter(adapter)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionBinding.inflate(inflater, container, false)
        return binding.root
    }
}