package learn.android.retrofitgithub.`interface`.Movies.Contacts

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.items.view.*
import kotlinx.android.synthetic.main.items_contact.view.*
import learn.android.retrofitgithub.R
import learn.android.retrofitgithub.model.MovieData
import nasima.Movies.PopularMovies.PopularMoviesAdapter

/**
 * Created by nasima on 15/11/17.
 *
 */
class ContactAdapter(var contactList:ArrayList<Contact>,var clickListener: OnItemClickListener) : RecyclerView.Adapter<ContactAdapter.ViewHolder>()  {

    lateinit var mContext: Context

    fun DataAdapter(context: Context) {
        mContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.contact.setText(contactList[position].name)
        holder.number.setText(contactList[position].number)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) ,View.OnClickListener{
        val contact: TextView = view.contactName as TextView
        val number: TextView = view.contactNumber as TextView

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            Log.d("ITEM", " .. CLICKED")
            val position = adapterPosition
            Log.d("POSITION"," ....................."+position)
            clickListener.onItemClick(contactList[position])
        }

    }





}