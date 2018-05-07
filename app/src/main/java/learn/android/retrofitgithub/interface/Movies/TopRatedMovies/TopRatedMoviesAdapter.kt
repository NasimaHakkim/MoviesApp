package learn.android.retrofitgithub.`interface`.Movies.TopRatedMovies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.items_toprated.view.*
import kotlinx.android.synthetic.main.items_upcoming.view.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.model.MovieData
import nasima.Movies.UpcomingMovies.UpcomingMoviesAdapter

/**
 * Created by nasima on 08/11/17.
 */
class TopRatedMoviesAdapter(private var mMoviesList: MovieData) : RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder>() , RecyclerView.OnItemTouchListener {


    lateinit var mContext: Context

    fun DataAdapter(context: Context) {
        mContext = context
    }

    private val FOUR_COLUMN_ROW_TYPE = 4
    private val THREE_COLUMN_ROW_TYPE = 3



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_toprated, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val imgUrl = "http://image.tmdb.org/t/p/original" + mMoviesList.results!![position].backdrop_path
        holder.tvNameMovie.setText(mMoviesList?.results!![position].title)
        holder.tvreleasedate.setText(mMoviesList?.results!![position].vote_average)
        Glide.with(mContext)
                .load(imgUrl)
                .apply( RequestOptions()
                        .override(800, 800) // set exact size
                        // keep memory usage low by fitting into (w x h) [optional]
                )
                .into(holder.tvPhotoMovie)



    }

    override fun getItemCount(): Int {
        return mMoviesList?.results!!.size
    }




    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNameMovie: TextView = view.MovieNameTVtoprated as TextView
        val tvPhotoMovie: ImageView = view.MoviePhotoIVtoprated as ImageView
        val tvreleasedate: TextView = view.textView as TextView

    }


    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
