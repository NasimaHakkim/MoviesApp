package com.learn2crack.retrofitrxjava.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.items.view.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.model.MovieData
import learn.android.retrofitgithub.model.TvList
import org.w3c.dom.Text


import java.util.ArrayList
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import learn.android.retrofitgithub.R.attr.layoutManager


class DataAdapter(private var mMoviesList: MovieData) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {



    //private var mMoviesList: MovieData? = null


    //fun DataAdapter(moviesList: MovieData) {
      //   mMoviesList=  moviesList
    //}

    private val FOUR_COLUMN_ROW_TYPE = 4
    private val THREE_COLUMN_ROW_TYPE = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       // if(mMoviesList.page.isNullOrEmpty()){
         //   holder.tvNameMovie.setText(mTvList.genres!![position].name)
           // holder.tvId.setText(mTvList.genres!![position].id)
        //}
        //else {
           // holder.tvNameMovie.setText(mMoviesList?.results!![position].title)
            holder.tvId.setText(mMoviesList?.results!![position].id)
            holder.tvVote.setText(mMoviesList?.results!![position].vote_count)
        //}


    }

    override fun getItemCount(): Int {
        return mMoviesList?.results!!.size
    }




    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /*private val mTvName: TextView
        private val mTvid: TextView
        private val mTvVote: TextView

        init {

            mTvName = view.tvNameMovie as TextView
            mTvid = view.tvId as TextView
            mTvVote = view.tvVote as TextView
        }*/

        val tvNameMovie: TextView = view.tvNameMovie as TextView
        val tvId: TextView = view.tvId as TextView
        val tvVote: TextView = view.tvVote as TextView

    }
}
