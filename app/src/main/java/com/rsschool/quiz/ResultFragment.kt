package com.rsschool.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentQuizBinding

class ResultFragment: Fragment() {

    private var binding: FragmentQuizBinding?= null
    private val _binding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val theme = arguments?.getInt(ResultFragment.THEME) ?: 0
        binding= FragmentQuizBinding.inflate(inflater,container,false)
        return _binding.root
    }


    companion object {
        fun newInstance(result:Int,theme:Int): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putInt(THEME, theme)
            args.putInt(RESULT, result)
            fragment.arguments = args
            return fragment
        }

        private const val RESULT = "PAGE"
        private const val THEME = "THEME"
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
