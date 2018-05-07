package nasima.home



import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import learn.android.retrofitgithub.`interface`.Movies.Contacts.ContactsFragment
import learn.android.retrofitgithub.`interface`.Movies.PopularMovies.PopularMoviesFragment
import learn.android.retrofitgithub.`interface`.Movies.TopRatedMovies.TopRatedMoviesFragment
import learn.android.retrofitgithub.`interface`.Movies.UpcomingMovies.UpcomingMoviesFragment

/**
 * Created by nasima on 07/11/17.
 */
class HomePagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {

        when( position ) {
            0 -> return PopularMoviesFragment()
            1 -> return TopRatedMoviesFragment()
            2 -> return UpcomingMoviesFragment()
            3 -> return ContactsFragment()
            else ->return null

        }

    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Popular"

            1 -> "Top Rated"

            2 -> "Upcoming"

            3-> "Contacts"

            else -> {
                return null
            }
        }


    }
}