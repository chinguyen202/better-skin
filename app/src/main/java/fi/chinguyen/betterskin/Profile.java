package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
    }

    public void goToAboutMe(View view) {
        Intent intent = new Intent(this, aboutMe.class);
        startActivity(intent);
    }

    public void goToMorningRoutine(View view) {
        Intent intent = new Intent(this, SavedMorningRoutine.class);
        startActivity(intent);
    }

    public void goToEveningRoutine(View view) {
        Intent intent = new Intent(this, SavedEveningRoutine.class);
        startActivity(intent);
    }

    public void doQuiz(View view) {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
