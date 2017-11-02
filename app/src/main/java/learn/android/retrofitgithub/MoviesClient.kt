package learn.android.retrofitgithub

import io.reactivex.Observable
import learn.android.retrofitgithub.model.MovieData
import learn.android.retrofitgithub.model.TvList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by venu on 30-10-2017.
 */
interface MoviesClient {

    @GET("discover/movie?api_key=ca9f63bcfe365cfce725b4d8c0e29050&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun popularMovies(): Observable<MovieData>

    @GET("genre/tv/list?api_key=ca9f63bcfe365cfce725b4d8c0e29050&language=en-US")
    fun tvList(): Observable<TvList>
}
