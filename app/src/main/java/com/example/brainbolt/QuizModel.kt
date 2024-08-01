package com.example.brainbolt

import android.os.Parcel
import android.os.Parcelable

data class QuizModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val time: String,
    val questionList: List<QuestionModel>
){
    constructor(): this(0,"","","", emptyList())
}

data class QuestionModel(
    val question: String,
    val options: List<String>,
    val correct: String
) : Parcelable {
    constructor() : this("", emptyList(), "")

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringList(options)
        parcel.writeString(correct)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionModel> {
        override fun createFromParcel(parcel: Parcel): QuestionModel {
            return QuestionModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionModel?> {
            return arrayOfNulls(size)
        }
    }
}