package learn.android.retrofitgithub.`interface`.Movies.UpcomingMovies

import io.reactivex.Observable
import learn.android.retrofitgithub.model.MovieData
import retrofit2.http.GET

/**
 * Created by nasima on 08/11/17.
 */
interface UpcomingMoviesClient {

    @GET("movie/upcoming?api_key=ca9f63bcfe365cfce725b4d8c0e29050&language=en-US&page=1")
    fun upcomingmovies(): Observable<MovieData>
}