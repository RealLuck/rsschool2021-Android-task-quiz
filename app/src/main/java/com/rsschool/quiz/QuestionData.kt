package com.rsschool.quiz

object QuestionsData {

    fun getQuestions(): ArrayList<QuestionsRepo>{
        val questionsList = ArrayList<QuestionsRepo>()
        val q1 = QuestionsRepo(1,
            "1 вопрос: 1 + 1",
            arrayListOf("2", "3", "4", "5", "6"),
            0
        )
        questionsList.add(q1)

        val q2 = QuestionsRepo(
            2,
            "2 вопрос: 8 + 5",
            arrayListOf("1"," 3", "13", "5","9"),
            2
        )
        questionsList.add(q2)

        val q3 = QuestionsRepo(
            3,
            "3 вопрос: 6 - 5",
            arrayListOf("6", "2", "7", "1","9"),
            3
        )
        questionsList.add(q3)

        val q4 = QuestionsRepo(
            4,
            "4 вопрос: 0 + 4?",
            arrayListOf("9", "4", "7", "5","1"),
            1
        )
        questionsList.add(q4)

        val q5 = QuestionsRepo(
            5,
            "5 вопрос: 8 + 6",
            arrayListOf("10", "13", "14", "18","87"),
            2
        )
        questionsList.add(q5)

        return questionsList
    }
}