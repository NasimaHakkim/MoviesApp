package learn.android.retrofitgithub.`interface`.Movies.Contacts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contact_list.*
import learn.android.retrofitgithub.R

/**
 * Created by nasima on 16/11/17.
 */
class DetailsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_contact_list,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle: Bundle = arguments
        var data: Contact = bundle.getParcelable("CONTACTS")
        contactnameTextView.text = data.name
        contactnumberTextView.text = data.number
        Log.d("DETAILS", " .................. loaded")
        Log.d("BUNDLE data", " ////////////// "+data.name+" ............ "+data.number)
    }

}