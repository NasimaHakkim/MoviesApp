package learn.android.retrofitgithub.`interface`.Movies.Contacts

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.fragment_movies.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.`interface`.Movies.PopularMovies.PopularMoviesPresenter
import learn.android.retrofitgithub.hide
import learn.android.retrofitgithub.show
import android.content.ContentResolver
import android.database.Cursor
import android.provider.ContactsContract
import android.renderscript.ScriptIntrinsicYuvToRGB
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import learn.android.retrofitgithub.R.id.recycler_view
import learn.android.retrofitgithub.R.id.recycler_view_contact
import javax.sql.StatementEvent


/**
 * Created by nasima on 15/11/17.
 */
class ContactsFragment : Fragment(),OnItemClickListener {


    lateinit var contact:Contact
    var adapter :ContactAdapter? = null
    var name:String = ""
    var number:String = ""
    var contactList : ArrayList<String> = ArrayList()

    var appNavigation : AppNavigationListenre? = null


    var contacts: ArrayList<Contact> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        loadContacts()
    }

    private fun loadContacts() {
            object : AsyncTask<Void, Void, ArrayList<Contact>>() {
                override fun onPreExecute() {
                    contactprogressBar.show()
                }

                override fun doInBackground(vararg params: Void): ArrayList<Contact> {
                    getContacts()
                    //return contactList
                    return contacts
                }

                override fun onPostExecute(result: ArrayList<Contact>) {
                    Log.i("result",result.toString())
                    adapter = ContactAdapter(result,clickListener = this@ContactsFragment)
                    adapter!!.DataAdapter(context)
                    recycler_view_contact!!.setAdapter(adapter)
                    contactprogressBar.hide()
                }

            }.execute()


    }


    private fun initRecyclerView() {
        recycler_view_contact.layoutManager = LinearLayoutManager(context)

    }


    private fun getContacts() {

        var phones:Cursor = activity.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            name =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            contacts.add(Contact(name,number))
        }
        phones.close()
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is AppNavigationListenre) {
            appNavigation = context
        }
    }

    override fun onItemClick(data: Contact) {
        Log.d("ON ITEM CLICK"," .. TRIGGERED")
        appNavigation?.loadDetails(data)
    }

}