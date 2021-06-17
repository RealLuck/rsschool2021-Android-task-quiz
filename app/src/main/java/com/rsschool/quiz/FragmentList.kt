package com.rsschool.quiz

class FragmentList {
    companion object {
        var fragmentList = listOf(
            QuizFragment.newInstance(1,R.style.Theme_Quiz_Five),
            QuizFragment.newInstance(2,R.style.Theme_Quiz_Second),
            QuizFragment.newInstance(3,R.style.Theme_Quiz_Third),
            QuizFragment.newInstance(4,R.style.Theme_Quiz_Fourth),
            QuizFragment.newInstance(5,R.style.Theme_Quiz_First),
            ResultFragment.newInstance(0)
        )
    }
}