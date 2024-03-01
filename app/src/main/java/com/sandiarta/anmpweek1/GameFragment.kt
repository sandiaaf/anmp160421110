package com.sandiarta.anmpweek1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.sandiarta.anmpweek1.databinding.FragmentGameBinding
import com.sandiarta.anmpweek1.databinding.FragmentMainBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    var totalScore = 0
    var correctAns = ""

    fun RandomNum(): Int {
        return Random.nextInt(1, 101)
    }
    fun addRandomNum(num1:Int, num2:Int): Int {
        var result = num1+num2
        return result
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var num1 = RandomNum()
        var num2 = RandomNum()
        binding.textViewNum1.text = num1.toString()
        binding.textViewNum2.text = num2.toString()

        if(arguments!= null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.textViewTurn.text = "$name's turn"
        }

        binding.buttonSubmit.setOnClickListener {

            val answer = binding.editTextResult.text.toString()
            if (answer == ""){
                Toast.makeText(requireContext(), "Masukkan jawaban anda!", Toast.LENGTH_SHORT).show()
            }
            else{
                val totalNum = addRandomNum(num1,num2)
                this.correctAns += "$totalNum\n"
                if(totalNum == answer.toInt()){
                    this.totalScore++
                    num1 = RandomNum()
                    num2 = RandomNum()
                    binding.textViewNum1.text = num1.toString()
                    binding.textViewNum2.text = num2.toString()

                    binding.editTextResult.setText("")

                }
                else{
                    var resultGame = ResultAnswer()
                    val action = GameFragmentDirections.actionResultFragment(resultGame,this.totalScore, this.correctAns)
                    Navigation.findNavController(it).navigate(action)
                    binding.editTextResult.setText("")

                }
            }

        }
    }

    fun ResultAnswer(): Boolean{
        if(this.totalScore == 3){
            return true
        }
        return false
    }
}