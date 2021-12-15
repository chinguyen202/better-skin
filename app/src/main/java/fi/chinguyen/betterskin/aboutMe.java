package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.User;

public class aboutMe extends AppCompatActivity {

    TextView displayUsername, displayFullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_layout);

        displayUsername = findViewById(R.id.displayUsername);
        displayFullname = findViewById(R.id.displayFullname);

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        int user = dataDao.getUserID();

        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String usernameInfo = loginUser.getString("userName", "");
        Log.d("userInfo", usernameInfo);

        displayUsername.setText("Username: " + usernameInfo);
        displayFullname.setText("Full name: " + dataDao.getFullNameByUsername(usernameInfo));

    }
}
