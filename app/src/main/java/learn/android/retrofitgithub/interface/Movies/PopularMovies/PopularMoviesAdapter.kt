package nasima.Movies.PopularMovies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.items.view.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.model.MovieData

/**
 * Created by nasima on 08/11/17.
 */
class PopularMoviesAdapter(private var mMoviesList: MovieData) : RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() , RecyclerView.OnItemTouchListener {

    lateinit var mContext: Context

    fun DataAdapter(context: Context) {
        mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrl = "http://image.tmdb.org/t/p/original" + mMoviesList.results!![position].poster_path
        holder.tvNameMovie.setText(mMoviesList?.results!![position].title)
        Glide.with(mContext)
                .load(imgUrl)
                .apply( RequestOptions()
                        .override(800, 800)
                )
                .into(holder.tvPhotoMovie)
    }

    override fun getItemCount(): Int {
        return mMoviesList?.results!!.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNameMovie: TextView = view.MovieNameTV as TextView
        val tvPhotoMovie: ImageView = view.MoviePhotoIV as ImageView

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
