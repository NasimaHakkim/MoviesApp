package learn.android.retrofitgithub.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nasima on 02/11/17.
 */

class MovieData() : Parcelable {
    var results: Array<Results>? = null

    var page: String? = null

    var total_pages: String? = null

    var total_results: String? = null

    constructor(parcel: Parcel) : this() {
        page = parcel.readString()
        total_pages = parcel.readString()
        total_results = parcel.readString()
    }

    override fun toString(): String {
        return "ClassPojo [results = $results, page = $page, total_pages = $total_pages, total_results = $total_results]"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(page)
        parcel.writeString(total_pages)
        parcel.writeString(total_results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }
}
