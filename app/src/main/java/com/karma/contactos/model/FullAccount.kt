package com.karma.contactos.model


class FullAccount(
        val accountBalanceInCents: Int,
        val accountCurrency: String,
        override val accountId: Long,
        override val accountName: String,
        val accountNumber: String,
        val accountType: String,
        val alias: String?,
        override val isVisible: Boolean,
        val iban: String,
        val linkedAccountId: Int,
        val productName: String,
        val productType: Int,
        val savingsTargetReached: Int,
        val targetAmountInCents: Int
) : Account(accountId, accountName, isVisible)