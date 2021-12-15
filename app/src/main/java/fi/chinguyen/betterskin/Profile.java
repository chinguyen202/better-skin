package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void redoQuiz(View view) {
        Intent intent = new Intent(this, FirstQuiz.class);
        startActivity(intent);
    }
}
