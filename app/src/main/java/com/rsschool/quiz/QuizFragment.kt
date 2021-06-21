package com.rsschool.quiz


import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.rsschool.quiz.databinding.FragmentQuizBinding
import androidx.navigation.fragment.navArgs


class QuizFragment: Fragment() {

    private var _binding: FragmentQuizBinding ? = null
    private val binding get() = _binding!!
    private var thisQuestionsList: ArrayList<QuestionsRepo>? = null
    private val args: QuizFragmentArgs by navArgs()
    private var thisSelectedOptionPosition: Int = - 10
    private var thisSelectedOption: String = ""
    private var currentQuestion: Int = 0
    private var answersArray = intArrayOf()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // достаю из аргументов номер текущего вопроса
        currentQuestion = args.currentQuestion
        // применяю тему
        setTheme()
        _binding = FragmentQuizBinding.inflate(inflater,container,false)
        // достаю список всех вопросов
        thisQuestionsList = QuestionsData.getQuestions()
        answersArray = args.answersArray
        showQuestion(answersArray[currentQuestion])
        // системная кнопка назад
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            previous()
        }

        binding.apply {

            // кнопка назад в навбаре + проверка когда ее не показывать
            if (currentQuestion != 0) {
                toolbar.setNavigationOnClickListener {
                    previous()
                }
            } else {
                toolbar.navigationIcon = null
            }
            // логика доступности кнопки далее
            radioGroup.setOnCheckedChangeListener { _, _ ->
                binding.nextButton.isEnabled = true
            }

            if (radioGroup.checkedRadioButtonId != -1) {
                binding.nextButton.isEnabled = true
            }
            // логика доступности кнопки предыдущий
            if (currentQuestion == 0) {
                binding.previousButton.isEnabled = false
            }

            previousButton.setOnClickListener {
                previous()
            }
            // логика кнопки далее: проверка ,что это не последниц вопрос и передача аргументов
            nextButton.setOnClickListener {

                if (currentQuestion != QuestionsData.getQuestions().size - 1) {
                    getNumberOfAnswers()
                    if (thisSelectedOptionPosition != -10) {
                        answersArray?.set(currentQuestion, thisSelectedOptionPosition)
                        currentQuestion++
                        view?.findNavController()?.navigate(
                            QuizFragmentDirections.actionQuizFragmentSelf(
                                answersArray, currentQuestion
                            )
                        )

                    } else Toast.makeText(requireContext(), "Как ты это сделал?", Toast.LENGTH_SHORT).show()
                } else {
                    getNumberOfAnswers()
                    answersArray?.set(currentQuestion, thisSelectedOptionPosition)
                    view?.findNavController()?.navigate(
                        QuizFragmentDirections.actionQuizFragmentToResultFragment(answersArray!!)
                    )
                }
            }
        }
        return binding.root
    }
    // логика выбора темы и покраса статус бара от номера вопроса + проверка на темную тему
    private fun setTheme() {
        val theme: Int
        val color: Int
        when (currentQuestion) {
            0 -> {
                theme = R.style.Theme_Quiz_First
                color = R.color.deep_orange_100_dark
            }
            1 ->{
                theme = R.style.Theme_Quiz_Second
                color = R.color.yellow_100_dark
            }
            2 -> {
                theme = R.style.Theme_Quiz_Third
                color = R.color.deep_purple_100_dark
            }
            3 -> {
                theme = R.style.Theme_Quiz_Fourth
                color = R.color.red_dark
            }
            else -> {
                theme = R.style.Theme_Quiz_Five
                color = R.color.aqua_dark
            }
        }
        requireContext().setTheme(theme)
        if (resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES) {
            requireActivity().window.statusBarColor =
                ContextCompat.getColor(requireActivity(), R.color.black)
        } else {
            requireActivity().window.statusBarColor =
                ContextCompat.getColor(requireActivity(), color)
        }
    }
    // логика кнопки назада/предыдущий
    private fun previous() {
        if (currentQuestion != 0) {
            currentQuestion--
            view?.findNavController()?.navigate(
                QuizFragmentDirections.actionQuizFragmentSelf(
                    answersArray, currentQuestion)
            )
        }
    }
    // отрисовка данныхЖ вопросы, варианты ответов , заголовок, кнопки
    private fun showQuestion(answer: Int?) {
        binding.radioGroup.clearCheck()
        val question = thisQuestionsList!![currentQuestion]
        binding.question.text = question.question
        binding.optionOne.text = question.answers?.get(0) ?: ""
        binding.optionTwo.text = question.answers?.get(1) ?: ""
        binding.optionThree.text = question.answers?.get(2) ?: ""
        binding.optionFour.text = question.answers?.get(3) ?: ""
        binding.optionFive.text = question.answers?.get(4) ?: ""
        binding.toolbar.title = "Question ${currentQuestion + 1}"
        binding.apply {
            if (currentQuestion == thisQuestionsList?.size?.minus(1))
                nextButton.text = "Submit"
            else
                nextButton.text = "Next"

            when (answer) {
                0 -> radioGroup.check(R.id.option_one)
                1 -> radioGroup.check(R.id.option_two)
                2 -> radioGroup.check(R.id.option_three)
                3 -> radioGroup.check(R.id.option_four)
                4 -> radioGroup.check(R.id.option_five)
            }
        }
    }
    // запоминаем ответы
    private fun getNumberOfAnswers() {
        thisSelectedOptionPosition = binding.radioGroup.checkedRadioButtonId


        if (-1 != thisSelectedOptionPosition) {

            when (thisSelectedOptionPosition) {
                R.id.option_one -> thisSelectedOptionPosition = 0
                R.id.option_two -> thisSelectedOptionPosition = 1
                R.id.option_three -> thisSelectedOptionPosition = 2
                R.id.option_four -> thisSelectedOptionPosition = 3
                R.id.option_five -> thisSelectedOptionPosition = 4
            }
        }
        if (-1 != thisSelectedOptionPosition) {

            when (thisSelectedOptionPosition) {
                R.id.option_one -> thisSelectedOption = binding.optionOne.text.toString()
                R.id.option_two -> thisSelectedOption = binding.optionTwo.text.toString()
                R.id.option_three -> thisSelectedOption = binding.optionThree.text.toString()
                R.id.option_four -> thisSelectedOption = binding.optionFour.text.toString()
                R.id.option_five -> thisSelectedOption = binding.optionFive.text.toString()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}