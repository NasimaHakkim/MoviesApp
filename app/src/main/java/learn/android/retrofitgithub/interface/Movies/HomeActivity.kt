package nasima.Movies

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_home.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.`interface`.Movies.Contacts.AppNavigationListenre
import learn.android.retrofitgithub.`interface`.Movies.Contacts.Contact
import learn.android.retrofitgithub.`interface`.Movies.Contacts.ContactsFragment
import learn.android.retrofitgithub.`interface`.Movies.Contacts.DetailsFragment
import learn.android.retrofitgithub.`interface`.Movies.PopularMovies.PopularMoviesFragment
import nasima.home.HomePagerAdapter

/**
 * Created by nasima on 07/11/17.
 */
class HomeActivity:AppCompatActivity(), AppNavigationListenre{

    val pageTitle: ArrayList<String> = ArrayList()

    var mHomeSectionAdapter : HomePagerAdapter? = null

    lateinit var contactList: ContactsFragment
    lateinit var details: DetailsFragment
    lateinit var mFragmentTransaction: FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mHomeSectionAdapter = HomePagerAdapter(supportFragmentManager)
        homeViewPager.adapter = mHomeSectionAdapter
        homeViewPager.offscreenPageLimit = 4
        navigation.setupWithViewPager(homeViewPager)
        navigation.setSelectedTabIndicatorColor(resources.getColor(R.color.text))
        navigation.setTabTextColors(resources.getColor(R.color.text),resources.getColor(R.color.textDark))

    }



    override fun loadDetails(data: Contact) {
        mFragmentTransaction = supportFragmentManager.beginTransaction()
        mFragmentTransaction.addToBackStack(null)
        var bundle = Bundle()
        bundle.putParcelable("CONTACTS",data)
        details = DetailsFragment()
        details.arguments = bundle
        Log.d("LOAD DETAILS"," ........................ triggered")
        mFragmentTransaction.replace(R.id.contactContainer,details).commit()
    }

}