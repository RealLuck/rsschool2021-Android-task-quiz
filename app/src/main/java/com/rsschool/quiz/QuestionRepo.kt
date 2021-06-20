package com.rsschool.quiz

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.ArrayList

@Parcelize
data class QuestionsRepo (

    val number: Int,
    val question: String,
    val answers: ArrayList<String>?,
    val correctAnswer: Int,
): Parcelable