package fi.chinguyen.betterskin;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.User;

public class aboutMe extends AppCompatActivity {

    TextView displayUsername, displayPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_layout);

        displayUsername = findViewById(R.id.displayUsername);
        displayPassword = findViewById(R.id.displayPassword);

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        int user = dataDao.getUserID();



    }
}
