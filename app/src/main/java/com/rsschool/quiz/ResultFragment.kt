package com.rsschool.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // достаю вопросы и ответы из аргументов
        answersList = args.answersArray
        thisQuestionsList = QuestionsData.getQuestions()
        binding.apply {
            // вывожу результат
            textViewResult.text = "Result: ${resultCount()}%"
            // кнопка выход
            exitButton.setOnClickListener {
                activity?.finish();
                exitProcess(-1)
            }
            // кнопка назад, которая начинает квиз заного
            backButton.setOnClickListener {
                val thisAnswersList: IntArray = intArrayOf(-1, -1, -1, -1, -1)
                    view?.findNavController()
                        ?.navigate(ResultFragmentDirections.
                        actionResultFragmentToQuizFragment(thisAnswersList, 0))
            }
            // кнопка поделиться результатом
            shareButton.setOnClickListener {
                val sendIntent = Intent()
                var questionNumber = 1
                var thisAnswer = 0
                val msg = StringBuilder("")
                // формирую сообщение с результатами
                msg.apply {
                    append("Your result: ${resultCount()}%\n\n")
                    for (question in thisQuestionsList) {
                        append(
                            "${questionNumber++}) ${question.question}\n" +
                                    "Your answer: ${question.answers?.get(answersList[thisAnswer++])} \n\n"
                                )
                            }
                }.toString()

                    sendIntent.action = Intent.ACTION_SEND
                    sendIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "${msg}"
                    )
                    sendIntent.type = "text/plain"
                    startActivity(sendIntent)
            }
        }
            return binding.root
        }


    // Считаю процентв правильных ответов
    private fun resultCount(): Int {
        var resultCount = 0.0
        for (i in answersList.indices)
        {
            if (answersList[i] == thisQuestionsList[i].correctAnswer)
                resultCount++

        }
        val result = (resultCount/answersList.size)*100
        return result.toInt()
    }



    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
