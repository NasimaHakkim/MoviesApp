package learn.android.retrofitgithub.`interface`.Movies.PopularMovies

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movies.*
import learn.android.retrofitgithub.*


/**
 * Created by nasima on 07/11/17.
 */
class PopularMoviesFragment: Fragment() {

    lateinit var mPopularMoviesPresenter:PopularMoviesPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar.show()
        initRecyclerView()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    private fun initRecyclerView() {
        recycler_view.layoutManager = StaggeredGridLayoutManager(2,1)
        recycler_view.setHasFixedSize(true)
        mPopularMoviesPresenter = PopularMoviesPresenter(recycler_view,context)
        mPopularMoviesPresenter.submit()
        progressBar.hide()
    }

}