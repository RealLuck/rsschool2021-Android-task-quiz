package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.rsschool.quiz.databinding.FragmentQuizBinding

class QuizFragment: Fragment() {

    private var binding: FragmentQuizBinding ?= null
    private val _binding get() = binding!!
    private var actionCallBack:FragmentAction?=null

    open interface FragmentAction {
        fun nextAction()
        fun previousAction()
    }

    override fun onAttach(context: Context) {
        actionCallBack = context as FragmentAction
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val theme = arguments?.getInt(THEME) ?: 0
        val page = arguments?.getInt(PAGE) ?: 0
        val previous = _binding.previousButton
        val next = _binding.nextButton
        context?.theme?.applyStyle(theme, true)
        _binding.toolbar.title = "Question ${page}"
        previous.setOnClickListener{actionCallBack?.previousAction()}
        next.setOnClickListener{actionCallBack?.nextAction()}
        if(page==1)previous.isEnabled = false
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(page: Int, theme: Int): QuizFragment {
            val fragment = QuizFragment()
            val args = Bundle()
            args.putInt(THEME, theme)
            args.putInt(PAGE, page)
            fragment.arguments = args

            return fragment
        }

        private const val PAGE = "PAGE"
        private const val THEME = "THEME"
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}