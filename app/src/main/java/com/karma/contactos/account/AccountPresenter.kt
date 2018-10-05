package com.karma.contactos.account


import com.karma.contactos.MainActivity
import com.karma.contactos.model.Account
import java.util.ArrayList

/**
 * This class handles business logic
 */
class AccountPresenter(private val activity: MainActivity) {

    lateinit var contactList: ArrayList<Account>
    lateinit var visibleList: ArrayList<Account>

    var database: AccountDatabase = AccountDatabase()
    var mode: Int = 0


    init {
        database.fillOtherData()
    }


    /**
     * Returns the list
     */
    fun getList(): ArrayList<Account> {

        return contactList

    }


    /**
     * Get contacts from database
     */
    fun getContactsFromDatabase(): ArrayList<Account> {
        // With real databases, Promises would be needed to
        // manage concurrency
        contactList = database.getContactsFromDatabase()

        return contactList
    }


    /**
     * Filter the data with isVisible = false
     */
    fun getOnlyVisibleFromDatabase(): ArrayList<Account> {
        // With real databases, Promises would be needed to
        // manage asynchronous operations.
        contactList = database.getOnlyVisible()

        return contactList
    }


    /**
     * Change mode.
     * Show all accounts
     * Show only visible
     */
    fun changeMode() {

        var list: ArrayList<Account> = ArrayList()

        mode = if (mode == 0) {
            list = getOnlyVisibleFromDatabase()
            1
        } else {
            list = getContactsFromDatabase()
            0
        }

        activity.setListToAdapter(list)

    }


}
