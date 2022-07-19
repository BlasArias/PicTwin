package cl.ucn.disc.dsm.pictwin.frontend;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*
*The Main Activity
*/
public class MainActivity extends AppCompatActivity {

    /*
     *The UserViewModel
     */
    private UserViewModel userViewModel;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the Recycler View from the layout
        RecyclerView recyclerView = findViewById(R.id.am_rv_twins);

        //The layout of the Recycler View
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        //Build The Adapter
        UserAdapter adapter = new UserAdapter();

        //Build The UserViewModel
        this.userViewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(super.getApplication())
                .create(UserViewModel.class);

        //Watch the view model
        userViewModel.getUserLiveData().observe(this, user -> {
                    //Update The Adapter
                    adapter.setUser(user);

                    //Refresh the GUI
                    adapter.notifyDataSetChanged();

                });
    }
    /*
     *Show The Application
     */
    protected void onStart() {
        super.onStart();
        //Load the data from backend
        userViewModel.update();
    }
}