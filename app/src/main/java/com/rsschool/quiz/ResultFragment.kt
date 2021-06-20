package com.rsschool.quiz

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.rsschool.quiz.databinding.FragmentResultBinding
import kotlin.system.exitProcess

class ResultFragment: Fragment() {

    private var _binding: FragmentResultBinding?= null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()
    private var answersList = intArrayOf()
    private lateinit var thisQuestionsList: ArrayList<QuestionsRepo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentResultBinding.inflate(inflater,container,false)
        answersList = args.answersArray
        thisQuestionsList = QuestionsData.getQuestions()
        binding.apply {

            textViewResult.text = "Result: ${resultCount()}%"

            exitButton.setOnClickListener {
                activity?.finish();
                exitProcess(-1)
            }

            backButton.setOnClickListener {
                val thisAnswersList: IntArray = intArrayOf(-1, -1, -1, -1, -1)
                    view?.findNavController()
                        ?.navigate(ResultFragmentDirections.
                        actionResultFragmentToQuizFragment(thisAnswersList, 0))
            }
        }
            return binding.root
        }



    private fun resultCount(): Int {
        var resultCount = 0.0
        for (i in answersList.indices)
        {
            if (answersList[i] == thisQuestionsList[i].correctAnswer)
                resultCount++

        }
        val result = (resultCount/5.0)*100
        return result.toInt()
    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
