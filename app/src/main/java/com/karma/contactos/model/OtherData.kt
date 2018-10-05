package com.karma.contactos.modelanimal

import com.beust.klaxon.Json


data class OtherData(

        @Json(name = "failedAccountTypes") val failedAccountTypes: String,
        @Json(name = "resultCode") val resultCode: String


)