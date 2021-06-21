package com.rsschool.quiz

object QuestionsData {

    fun getQuestions(): ArrayList<QuestionsRepo>{
        val questionsList = ArrayList<QuestionsRepo>()
        val q1 = QuestionsRepo(1,
            "Столица России",
            arrayListOf("Москва", "Екантеренбург", "Новосибирск", "Сочи", "Казань"),
            0
        )
        questionsList.add(q1)

        val q2 = QuestionsRepo(
            2,
            "Столица Англии",
            arrayListOf("Ливерпуль"," Манчестер", "Лондон", "Брюгге","Москва"),
            2
        )
        questionsList.add(q2)

        val q3 = QuestionsRepo(
            3,
            "Столица Испании",
            arrayListOf("Барселона", "Бильбао", "Мальорка", "Мадрид","Севилья"),
            3
        )
        questionsList.add(q3)

        val q4 = QuestionsRepo(
            4,
            "Столица Венгрии",
            arrayListOf("Буда", "Будапешт", "Братислава", "Вена","Субботица"),
            1
        )
        questionsList.add(q4)

        val q5 = QuestionsRepo(
            5,
            "Столица Австралии",
            arrayListOf("Мельбурн", "Сидней", "Канберра", "Брисбен","Перт"),
            2
        )
        questionsList.add(q5)

        return questionsList
    }
}