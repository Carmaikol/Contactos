package com.karma.contactos.model

class NormalAccount(

        val accountBalanceInCents: Int,
        val accountCurrency: String,
        override val accountId: Long,
        override val accountName: String,
        val accountNumber: String,
        val accountType: String,
        val alias: String?,
        override val isVisible: Boolean,
        val iban: String

) : Account(accountId, accountName, isVisible)