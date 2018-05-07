package learn.android.retrofitgithub.`interface`.Movies.TopRatedMovies

import io.reactivex.Observable
import learn.android.retrofitgithub.model.MovieData
import retrofit2.http.GET

/**
 * Created by nasima on 08/11/17.
 */
interface TopRatedMoviesClient {

    @GET("movie/top_rated?api_key=ca9f63bcfe365cfce725b4d8c0e29050&language=en-US&page=1")
    fun toprated(): Observable<MovieData>
}