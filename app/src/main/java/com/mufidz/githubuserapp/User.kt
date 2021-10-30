package com.mufidz.githubuserapp

import android.os.Parcel
import android.os.Parcelable

data class User(
    var name: String?,
    var company: String?,
    var location: String?,
    var repo: String?,
    var follower: String?,
    var following: String?,
    var photo: Int
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(repo)
        parcel.writeString(follower)
        parcel.writeString(following)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
