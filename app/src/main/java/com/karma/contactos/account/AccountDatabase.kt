package com.karma.contactos.account

import android.util.Log
import com.beust.klaxon.Klaxon
import com.karma.contactos.model.Account
import com.karma.contactos.model.FullAccount
import com.karma.contactos.model.NormalAccount
import com.karma.contactos.modelanimal.OtherData
import java.util.ArrayList


/**
 * Esta clase se encargaria de hacer las queries a la base de datos y devolverlos.
 * Los problemas encontrados son la estructura inconsistende del json proporcionado.
 * Se convierten los int en String.
 *
 */
class AccountDatabase {


    var fullList: ArrayList<Account> = ArrayList()
    var onlyList: ArrayList<Account> = ArrayList()


    private val json1: String = """
        {
        "accountBalanceInCents": 985000,
        "accountCurrency": "EUR",
        "accountId": 748757694,
        "accountName": "Hr P L G N StellingTD",
        "accountNumber": "748757694",
        "accountType": "PAYMENT",
        "alias": "",
        "isVisible": true,
        "iban": "NL23INGB0748757694"
        }
    """
    private val json2: String = """
        {
        "accountBalanceInCents": 1000000,
        "accountCurrency": "EUR",
        "accountId": 700000027559,
        "accountName": ",",
        "accountNumber": "748757732",
        "accountType": "PAYMENT",
        "alias": "",
        "isVisible": false,
        "iban": "NL88INGB0748757732"
        }
    """
    val json3: String =
            """
        {
        "accountBalanceInCents": 15000,
        "accountCurrency": "EUR",
        "accountId": 700000027559,
        "accountName": "",
        "accountNumber": "H 177-27066",
        "accountType": "SAVING",
        "alias": "G\\UfffdLSAVINGSdiacrits",
        "iban": "",
        "isVisible": true,
        "linkedAccountId": 748757694,
        "productName": "Oranje Spaarrekening",
        "productType": 1000,
        "savingsTargetReached": 1,
        "targetAmountInCents": 2000
        }
    """


    /**
     * Parse the data from the json
     */
    fun getContactsFromDatabase(): ArrayList<Account> {
        val result = Klaxon()
                .parse<NormalAccount>(json1)

        val result2 = Klaxon()
                .parse<NormalAccount>(json2)


        val result3 = Klaxon()
                .parse<FullAccount>(json3)


        val list: ArrayList<Account> = ArrayList()
        result?.let { list.add(it) }
        result2?.let { list.add(it) }
        result3?.let { list.add(it) }

        Log.d("Database", "List  $list")

        //Save locally for later use
        fullList = list

        return list
    }

    /**
     * Filters the elements with isVisible true
     */
    fun getOnlyVisible(): ArrayList<Account> {

        onlyList = fullList.filter { x -> x.isVisible } as ArrayList<Account>


        return onlyList
    }


    /**
     * Read additional data
     */
    fun fillOtherData() {

        val other = Klaxon()
                .parse<OtherData>("""
        {
        "failedAccountTypes": "CREDITCARDS",
        "resultCode": "OK"
        }
        """)


    }

}