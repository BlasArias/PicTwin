package cl.ucn.disc.dsm.pictwin.frontend;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import cl.ucn.disc.dsm.pictwin.frontend.model.Pic;
import cl.ucn.disc.dsm.pictwin.frontend.model.Twin;
import cl.ucn.disc.dsm.pictwin.frontend.model.User;
import cl.ucn.disc.dsm.pictwin.frontend.service.UserRepository;

/*
 *The viewModel of User
 *
 */
public final class UserViewModel extends AndroidViewModel {

    /*
         *The Executor with two threads
         */
        private static final Executor EXECUTOR = Executors.newFixedThreadPool(2);
        /*
         *The repository
         */
        private final UserRepository userRepository = new UserRepository();
        /*
         *The container of user
         */
        private final MutableLiveData<User> userLiveData = new MutableLiveData<>();
        /*
         *The Constructor
         *@param application to use
         */
        public UserViewModel(@NonNull Application application) {
            super(application);
        }
        /*
         *Return the LiveData of User
         */
        public LiveData<User> getUserLiveData() {
            return this.userLiveData;
        }

        /*
         *Refresh or get the data
         */
        public void update(){

        //Only load if we dont have data
            if(this.userLiveData.getValue() == null){
                this.retrieveUserFromNetworkInBackground();
            }
        }

        /*
         *The Test to popular the Twin
         *
         */
        private static Twin builderTwin(long n){
            Pic my = new Pic();
            my.setId(n);

            Pic yours = new Pic();
            yours.setId(n + 1);

            Twin twin = new Twin();
            twin.setId(n);
            twin.setMy(my);
            twin.setYours(yours);

            return twin;
        }

        /*
         *Retrieve User from API Rest in background
         */

        private void retrieveUserFromNetworkInBackground() {
            //Run in background
            EXECUTOR.execute(() -> {

                //Get the User from Repository
                Optional<User> oUser = this.userRepository.retrieveUser("admin@ucn.cl","admin123");

                //Set the User only if exist
                oUser.ifPresent(this.userLiveData::postValue);
            });

        }
}
