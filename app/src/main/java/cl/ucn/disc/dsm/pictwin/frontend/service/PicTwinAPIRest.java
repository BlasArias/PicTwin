package cl.ucn.disc.dsm.pictwin.frontend.service;

import cl.ucn.disc.dsm.pictwin.frontend.model.User;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface PicTwinAPIRest {
    /**
     * Retrieve the user
     * @param email to use
     * @param password to use
     * @return the User.l
     */
    @GET("/users")
    Call<User> retrieveUser(@Query("email")String email, @Query(value = "password", encoded = true)
            String password);
}
