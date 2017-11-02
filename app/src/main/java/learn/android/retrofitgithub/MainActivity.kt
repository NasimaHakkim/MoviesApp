package learn.android.retrofitgithub

import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable

import android.os.Bundle
import android.util.Log
import android.view.View
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import learn.android.retrofitgithub.model.MovieData
import learn.android.retrofitgithub.model.TvList
import java.util.*
import io.reactivex.disposables.CompositeDisposable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import com.learn2crack.retrofitrxjava.adapter.DataAdapter
import kotlin.collections.ArrayList
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.GridLayoutManager






class MainActivity : AppCompatActivity(){

    private var mRecyclerView: RecyclerView? = null

    private var mAdapter: DataAdapter? = null

    private  var moviesList: MovieData = MovieData()

    private   var  tvLists : TvList = TvList()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        //supportActionBar(true)

        submitButtonMovies.setOnClickListener{ submit() }
        submitButtonTv.setOnClickListener{ submitTv()}

    }


    private fun initRecyclerView() {

        mRecyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        mRecyclerView!!.setHasFixedSize(true)
        //val layoutManager = LinearLayoutManager(applicationContext)
        //var gaggeredGridLayoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(3, 1)

        val layoutManager = GridLayoutManager(this, 12,0,false)

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                // 5 is the sum of items in one repeated section
                when (position % 7) {
                // first two items span 3 columns each
                    0, 1 ,2 ,3 -> return 3
                // next 3 items span 2 columns each
                    4 , 5 ,6 -> return 4
                }
                throw IllegalStateException("internal error")
            }
        }
        mRecyclerView!!.layoutManager = layoutManager
    }

    private fun submitTv() {
        var tv = ServiceGenerator.createService(MoviesClient::class.java)
        var tvList : Observable<TvList> = tv.tvList()
        tvList.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(object : Observer<TvList>{
                    override fun onSubscribe(d: Disposable) {
                        Log.i("subscribed ","-------------------------Tv list data")

                    }

                    override fun onError(e: Throwable) {
                        Log.e("errror",e.toString())
                    }

                    override fun onNext(t: TvList) {
                       for(i in t.genres!!.indices) {
                           Log.i("Tv's", t.genres!!.get(i).id + "==>" + t.genres!!.get(i).name)

                               tvLists = t
                               mAdapter = DataAdapter(moviesList)
                               mRecyclerView!!.setAdapter(mAdapter)

                        }
                    }

                    override fun onComplete() {
                        Log.i("in-Tv list--->","onComplete()")
                    }

                })


    }

    fun submit() {

        var movies = ServiceGenerator.createService(MoviesClient::class.java)

        var moviesget : Observable<MovieData> = movies.popularMovies()

        moviesget.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(object : Observer<MovieData> {
                    override fun onNext(t: MovieData) {
                        Log.i("page",t.page)
                        for(i in t.results!!.indices) {
                            Log.i("Movies", t.results!!.get(i).id + "==>" + t.results!!.get(i).title)
                            moviesList = t
                            mAdapter = DataAdapter(moviesList)
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
