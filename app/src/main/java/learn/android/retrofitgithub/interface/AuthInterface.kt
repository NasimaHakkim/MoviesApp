package learn.android.retrofitgithub.`interface`

/**
 * Created by venu on 31-10-2017.
 */
interface AuthInterface {
    fun setAuth(user: String,pass: String)
    fun getAuth(): String
}