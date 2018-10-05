package com.karma.contactos

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.support.v7.widget.DividerItemDecoration

import android.widget.Toast
import com.karma.contactos.account.AccountAdapter
import com.karma.contactos.account.AccountPresenter
import com.karma.contactos.model.Account


/**
 *
 * @author Miguel Aguilera Zorzo
 *
 *
 *
 * This application handles a list.
 * It can change between two modes(Full, Only Visible)
 */
class MainActivity : AppCompatActivity() {


    private lateinit var presenter: AccountPresenter
    private lateinit var adapter: AccountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        presenter = AccountPresenter(this)
        setUpRecyclerView()


        fab.setOnClickListener {

            presenter.changeMode()

        }
    }


    /**
     * This function handles the creation of the recycler view.
     * Also handles linking it to an adapter.
     */
    private fun setUpRecyclerView() {

        rv_account_list.layoutManager = LinearLayoutManager(this)
        rv_account_list.addItemDecoration(DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))


        adapter = AccountAdapter(presenter.getContactsFromDatabase(), this)
        rv_account_list.adapter = adapter


    }


    fun setListToAdapter(list: ArrayList<Account>) {

        adapter.updateList(list)
        Toast.makeText(this, "Mode changed!", Toast.LENGTH_SHORT)

    }


    /**
     * Create an intent to share the list.
     * Account is a Parceable object.
     */
    private fun launchIntent() {

        //This intent can be sent to another Activity or Widget

        // var i : Intent = Intent(this,OtherActivity.kt)
        // i.putParcelableArrayListExtra("list",presenter.contactList)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_widget -> {
                //Launch intent to share the list
                launchIntent()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
