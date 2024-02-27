package com.sandiarta.anmpweek1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sandiarta.anmpweek1.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!= null){
            val resultGame = ResultFragmentArgs.fromBundle(requireArguments()).playerResult
            val score = ResultFragmentArgs.fromBundle(requireArguments()).playerScore.toString()
            if(resultGame){
                binding.textViewResult.text = "WIN"
            }else{
                binding.textViewResult.text = "GAME OVER"
            }
            binding.textViewScore.text = "Your score is $score"
        }

        binding.buttonBackMain.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}