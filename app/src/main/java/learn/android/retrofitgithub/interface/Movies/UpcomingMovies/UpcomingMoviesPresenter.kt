package learn.android.retrofitgithub.`interface`.Movies.UpcomingMovies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import learn.android.retrofitgithub.ServiceGenerator
import learn.android.retrofitgithub.`interface`.Movies.PopularMovies.PopularMovieClient
import learn.android.retrofitgithub.model.MovieData
import learn.android.retrofitgithub.model.TvList
import nasima.Movies.PopularMovies.PopularMoviesAdapter
import nasima.Movies.UpcomingMovies.UpcomingMoviesAdapter

/**
 * Created by nasima on 08/11/17.
 *
 */
class UpcomingMoviesPresenter(var mRecyclerView: RecyclerView, var context: Context){

    private var mAdapter: UpcomingMoviesAdapter? = null
    private  var moviesList: MovieData = MovieData()
    private var movieDetail : MovieData = MovieData()
    private   var  tvLists : TvList = TvList()

    fun submit() {
        var movies = ServiceGenerator.createService(UpcomingMoviesClient::class.java)
        var moviesget : Observable<MovieData> = movies.upcomingmovies()
        moviesget.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(object : Observer<MovieData> {
                    override fun onNext(t: MovieData) {
                        for(i in t.results!!.indices) {
                            moviesList = t
                            mAdapter = UpcomingMoviesAdapter(moviesList)
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