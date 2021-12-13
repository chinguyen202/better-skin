package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThirdQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSensitivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quiz);
    }
    public void getSkinSensitivity(View view){

        RadioGroup sensitiveSkin = findViewById(R.id.sensitiveRadioGroup);
        // Listen to the user's choice
        RadioButton selectedSensitiveSkin  = findViewById(sensitiveSkin.getCheckedRadioButtonId());
        // Get RadioButton text
        userSensitivity = selectedSensitiveSkin.getText().toString();
        Log.d("Hi", userSensitivity);
    }


    public void goToGenerateRoutine(View view) {
        userQuizChoices.getInstance().addToUserChoices(userSensitivity);
        Intent intent = new Intent(this, GenerateMorningRoutine.class);
        intent.putExtra(EXTRA_MESSAGE, userSensitivity);
        startActivity(intent);
    }
}