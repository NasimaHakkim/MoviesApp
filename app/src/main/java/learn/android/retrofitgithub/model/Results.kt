package learn.android.retrofitgithub.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nasima on 02/11/17.
 */
class Results() : Parcelable {
    var vote_average: String? = null

    var backdrop_path: String? = null

    var adult: String? = null

    var id: String? = null

    var title: String? = null

    var overview: String? = null

    var original_language: String? = null

    var genre_ids: Array<String>? = null

    var release_date: String? = null

    var original_title: String? = null

    var vote_count: String? = null

    var poster_path: String? = null

    var video: String? = null

    var popularity: String? = null

    constructor(parcel: Parcel) : this() {
        vote_average = parcel.readString()
        backdrop_path = parcel.readString()
        adult = parcel.readString()
        id = parcel.readString()
        title = parcel.readString()
        overview = parcel.readString()
        original_language = parcel.readString()
        genre_ids = parcel.createStringArray()
        release_date = parcel.readString()
        original_title = parcel.readString()
        vote_count = parcel.readString()
        poster_path = parcel.readString()
        video = parcel.readString()
        popularity = parcel.readString()
    }

    override fun toString(): String {
        return "ClassPojo [vote_average = $vote_average, backdrop_path = $backdrop_path, adult = $adult, id = $id, title = $title, overview = $overview, original_language = $original_language, genre_ids = $genre_ids, release_date = $release_date, original_title = $original_title, vote_count = $vote_count, poster_path = $poster_path, video = $video, popularity = $popularity]"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(vote_average)
        parcel.writeString(backdrop_path)
        parcel.writeString(adult)
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(original_language)
        parcel.writeStringArray(genre_ids)
        parcel.writeString(release_date)
        parcel.writeString(original_title)
        parcel.writeString(vote_count)
        parcel.writeString(poster_path)
        parcel.writeString(video)
        parcel.writeString(popularity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }
}

