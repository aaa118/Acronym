package com.acronymmeaning.example.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sf(val sf: String, val lfs: List<Lf>): Parcelable

@Parcelize
data class Lf(val lf: String, val freq: Int, val since: Int, val vars: List<Var>): Parcelable

@Parcelize
data class Var(val lf: String, val freq: Int, val since: Int): Parcelable
