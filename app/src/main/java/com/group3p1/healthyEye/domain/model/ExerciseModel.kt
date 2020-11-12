package com.group3p1.healthyEye.domain.model

import android.os.Parcel
import android.os.Parcelable

data class ExerciseModel(val title: String = "", val text: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExerciseModel> {
        override fun createFromParcel(parcel: Parcel): ExerciseModel {
            return ExerciseModel(parcel)
        }

        override fun newArray(size: Int): Array<ExerciseModel?> {
            return arrayOfNulls(size)
        }
    }
}