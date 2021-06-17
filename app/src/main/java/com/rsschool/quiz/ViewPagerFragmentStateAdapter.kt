package com.rsschool.quiz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rsschool.quiz.FragmentList.Companion.fragmentList

class ViewPagerFragmentStateAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
        override fun getItemCount(): Int {
            return 6
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> fragmentList[0]
                1 -> fragmentList[1]
                2 -> fragmentList[2]
                3 -> fragmentList[3]
                4 -> fragmentList[4]
                5 -> fragmentList[5]
                else -> throw IllegalArgumentException("Smth went wrong")
            }
        }
    }
