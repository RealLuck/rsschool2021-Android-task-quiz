package com.rsschool.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.rsschool.quiz.FragmentList.Companion.fragmentList
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , QuizFragment.FragmentAction{
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager2 = binding.viewpager2
        viewPager2.adapter = ViewPagerFragmentStateAdapter(this)
        viewPager2.offscreenPageLimit = 5
    }
    override fun nextAction() {
        viewPager2.currentItem++
    }

    override fun previousAction() {
        --viewPager2.currentItem
    }

    override fun pageCount():Int? {
        return viewPager2.adapter?.itemCount
    }
}

