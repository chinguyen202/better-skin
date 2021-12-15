package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import fi.chinguyen.betterskin.data.User;

public class Profile extends AppCompatActivity {

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        user = (User) getIntent().getSerializableExtra("User");
    }

    public void goToAboutMe(View view) {
        Intent intent = new Intent(this, aboutMe.class);
        startActivity(intent);
    }

    public void goToMorningRoutine(View view) {
        Intent intent = new Intent(this, GenerateMorningRoutine.class);
        startActivity(intent);
    }

    public void goToEveningRoutine(View view) {
        Intent intent = new Intent(this, GenerateEveningRoutine.class);
        startActivity(intent);
    }

    public void redoQuiz(View view) {
        Intent intent = new Intent(this, FirstQuiz.class);
        startActivity(intent);
    }
}
