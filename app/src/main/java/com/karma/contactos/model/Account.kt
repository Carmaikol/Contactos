package com.karma.contactos.model

import android.os.Parcel
import android.os.Parcelable


/**
 * Parent class
 */
open class Account(


        open val accountId: Long,
        open val accountName: String,
        open val isVisible: Boolean

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(accountId)
        parcel.writeString(accountName)
        parcel.writeByte(if (isVisible) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Account> {
        override fun createFromParcel(parcel: Parcel): Account {
            return Account(parcel)
        }

        override fun newArray(size: Int): Array<Account?> {
            return arrayOfNulls(size)
        }
    }
}





