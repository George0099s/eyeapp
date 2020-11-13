package com.group3p1.healthyEye.domain.model

import android.os.Parcel
import android.os.Parcelable

data class ExerciseModel(val id: String = "", val title: String = "no data", val text: String = "no data", val group: Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeInt(group)
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