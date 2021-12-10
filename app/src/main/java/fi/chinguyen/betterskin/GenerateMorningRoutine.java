package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GenerateMorningRoutine extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning_routine_layout);
    }
    public void returnToProfile(View view) {
        Log.d("Profile",userQuizChoices.getInstance().getUserChoices().toString());
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
