package com.example.derayanbimaalamsyah.ankokadedicoding.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/*

Created Derayan Bima Alamsyah
*/


//IMPLEMENTASI DARI KOTLIN EXTENSIONS
@Parcelize
data class ClubModel(
        val name: String?, val image:Int?, val description: String?
) : Parcelable