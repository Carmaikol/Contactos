package com.karma.contactos.account

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.karma.contactos.R
import com.karma.contactos.model.Account
import com.karma.contactos.model.FullAccount
import com.karma.contactos.model.NormalAccount
import kotlinx.android.synthetic.main.account_list_item.view.*


/**
 * This adapter handles a list of Accounts
 */
class AccountAdapter(private var items: ArrayList<Account>, private val context: Context) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.account_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val account: Account = items[position]

        holder.accountId?.text = account.accountId.toString()
        holder.accountName?.text = account.accountName


        //Two viewholders would be optimum
        if (account is FullAccount) {

            holder.tvAccountBalanceInCents?.text = account.accountBalanceInCents.toString()
            holder.accountCurrency?.text = account.accountCurrency
            holder.accountNumber?.text = account.accountNumber
            holder.accountType?.text = account.accountType
            holder.alias?.text = account.alias
            holder.iban?.text = account.iban
            holder.linkedAccount?.text = account.linkedAccountId.toString()
            holder.productName?.text = account.productName
            holder.productType?.text = account.productType.toString()
            holder.savings?.text = account.savingsTargetReached.toString()
            holder.targetAmount?.text = account.targetAmountInCents.toString()


            //Make sure to return to original state
            holder.linkedAccount?.visibility = View.VISIBLE
            holder.productName?.visibility = View.VISIBLE
            holder.productType?.visibility = View.VISIBLE
            holder.savings?.visibility = View.VISIBLE
            holder.targetAmount?.visibility = View.VISIBLE


        } else if (account is NormalAccount) {
            holder.tvAccountBalanceInCents?.text = account.accountBalanceInCents.toString()
            holder.accountCurrency?.text = account.accountCurrency

            holder.accountNumber?.text = account.accountNumber
            holder.accountType?.text = account.accountType
            holder.alias?.text = account.alias
            holder.iban?.text = account.iban


            holder.linkedAccount?.visibility = View.GONE
            holder.productName?.visibility = View.GONE
            holder.productType?.visibility = View.GONE
            holder.savings?.visibility = View.GONE
            holder.targetAmount?.visibility = View.GONE

        }
    }


    // Gets the number of accounts in the list
    override fun getItemCount(): Int {
        return items.size
    }


    fun updateList(list: ArrayList<Account>) {
        items = list
        notifyDataSetChanged()


    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each account to
        val tvAccountBalanceInCents: TextView? = view.tv_account_balanceInCents
        val accountCurrency: TextView? = view.tv_account_currency
        val accountId: TextView? = view.tv_account_id
        val accountName: TextView? = view.tv_account_name
        val accountNumber: TextView? = view.tv_account_number
        val accountType: TextView? = view.tv_account_type
        val alias: TextView? = view.tv_alias
        val iban: TextView? = view.tv_iban


        val linkedAccount: TextView? = view.tv_linkedaccount
        val productName: TextView? = view.tv_productName
        val productType: TextView? = view.tv_productType
        val savings: TextView? = view.tv_savings
        val targetAmount: TextView? = view.tv_targetamount
    }


}