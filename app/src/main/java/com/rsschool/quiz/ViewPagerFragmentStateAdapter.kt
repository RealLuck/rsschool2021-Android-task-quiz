package com.rsschool.quiz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentStateAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
        override fun getItemCount(): Int {
            return 6
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> QuizFragment.newInstance(1 ,R.style.Theme_Quiz_First)
                1 -> QuizFragment.newInstance(2 ,R.style.Theme_Quiz_Second)
                2 -> QuizFragment.newInstance(3 ,R.style.Theme_Quiz_Third)
                3 -> QuizFragment.newInstance(4 ,R.style.Theme_Quiz_Fourth)
                4 -> QuizFragment.newInstance(5 ,R.style.Theme_Quiz_Five)
                else -> ResultFragment.newInstance(0,R.style.Theme_Quiz_First)
            }
        }
    }
