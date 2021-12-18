package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;

/**
 * contain user data (fullname, username)
 */
public class aboutMe extends AppCompatActivity {

    TextView displayUsername, displayFullname;
    @Override

    /**
     * logic and set up for about me session
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_layout);

        //Find textView
        displayUsername = findViewById(R.id.displayUsername);
        displayFullname = findViewById(R.id.displayFullname);

        //Access database method
        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();

        //Get shared preferences to get user's info
        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String usernameInfo = loginUser.getString("userName", "");
        Log.d("userInfo", usernameInfo);

        //Display user's info to textView
        displayUsername.setText("Username: " + usernameInfo);
        displayFullname.setText("Full name: " + dataDao.getFullNameByUsername(usernameInfo));

    }

    /**
     * Method to go Profile
     * @param view
     */
    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
