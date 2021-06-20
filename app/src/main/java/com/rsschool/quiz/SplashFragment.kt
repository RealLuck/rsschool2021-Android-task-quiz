package com.rsschool.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.rsschool.quiz.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.green)
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val thisAnswersList: IntArray = intArrayOf(-1, -1, -1, -1, -1)
        Handler(Looper.getMainLooper()).postDelayed({
            view?.findNavController()
                ?.navigate(SplashFragmentDirections.actionSplashFragmentToQuizFragment(thisAnswersList, 0))
        }, 3000)
        return binding.root
    }
}
