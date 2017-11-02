package learn.android.retrofitgithub.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nasima on 02/11/17.
 */

class TvList() : Parcelable {
    var genres: Array<Genres>? = null

    constructor(parcel: Parcel) : this() {

    }

    override fun toString(): String {
        return "ClassPojo [genres = $genres]"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvList> {
        override fun createFromParcel(parcel: Parcel): TvList {
            return TvList(parcel)
        }

        override fun newArray(size: Int): Array<TvList?> {
            return arrayOfNulls(size)
        }
    }
}
