package learn.android.retrofitgithub.`interface`.Movies.TopRatedMovies

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_toprated.*
import kotlinx.android.synthetic.main.fragment_upcoming.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.`interface`.Movies.UpcomingMovies.UpcomingMoviesPresenter
import learn.android.retrofitgithub.hideProgressDialog
import learn.android.retrofitgithub.showProgressDialog

/**
 * Created by nasima on 07/11/17.
 */
class TopRatedMoviesFragment:Fragment() {

    lateinit var mMoviesPresenter: TopRatedMoviesPresenter
    lateinit var mRecylerView : RecyclerView




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_toprated, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    private fun initRecyclerView() {


        //mRecylerView = (RecyclerView) findViewById(R.id.recycler_view)
        recycler_view_toprated.layoutManager = StaggeredGridLayoutManager(1,1)
        recycler_view_toprated.setHasFixedSize(true)
        mMoviesPresenter = TopRatedMoviesPresenter(recycler_view_toprated,context)

        //var gaggeredGridLayoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(2, 1)
        //mPopularMoviesPresenter = PopularMoviesPresenter(,context)
        activity.showProgressDialog("Loading")
        mMoviesPresenter.submit()
        activity.hideProgressDialog()
        /* layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
             override fun getSpanSize(position: Int): Int {
                 // 5 is the sum of items in one repeated section
                 when ((position % 11)) {
                 // first two items span 3 columns each
                     0, 1 ,2 ,3 -> return 3
                 // next 3 items span 2 columns each
                     4 , 5 ,6 -> return 4
                     7 , 8, 9, 10 -> return 3
                 }
                 throw IllegalStateException("internal error")
             }
         }*/
        //  mRecylerView!!.layoutManager = gaggeredGridLayoutManager

    }


}