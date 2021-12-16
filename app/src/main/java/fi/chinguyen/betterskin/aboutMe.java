package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;

public class aboutMe extends AppCompatActivity {

    TextView displayUsername, displayFullname;
    @Override
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
}
