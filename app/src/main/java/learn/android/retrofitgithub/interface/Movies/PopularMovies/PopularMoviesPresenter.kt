package learn.android.retrofitgithub.`interface`.Movies.PopularMovies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ProgressBar
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*
import learn.android.retrofitgithub.*
import learn.android.retrofitgithub.R.id.progressBar
import learn.android.retrofitgithub.model.MovieData
import learn.android.retrofitgithub.model.TvList
import nasima.Movies.PopularMovies.PopularMoviesAdapter

/**
 * Created by nasima on 07/11/17.
 */
class PopularMoviesPresenter(var mRecyclerView: RecyclerView,var context: Context){

    private var mAdapter: PopularMoviesAdapter? = null
    private  var moviesList: MovieData = MovieData()
    private var movieDetail : MovieData = MovieData()
    private   var  tvLists : TvList = TvList()


    fun submit() {

        var movies = ServiceGenerator.createService(PopularMovieClient::class.java)
        var moviesget : Observable<MovieData> = movies.popularMovies()
        moviesget.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(object : Observer<MovieData> {
                    override fun onNext(t: MovieData) {
                        for(i in t.results!!.indices) {
                            moviesList = t
                            mAdapter = PopularMoviesAdapter(moviesList)
                            mAdapter!!.DataAdapter(context)
                            mRecyclerView!!.setAdapter(mAdapter)
                        }
                    }
                    override fun onSubscribe(d: Disposable) {
                        Log.i("subscribed ","-------------------------Movies data")
                    }
                    override fun onError(e: Throwable) {
                        Log.e("errror",e.toString())
                    }
                    override fun onComplete() {
                        Log.i("in-Movies--->","onComplete()")
                    }
                })




    }

}