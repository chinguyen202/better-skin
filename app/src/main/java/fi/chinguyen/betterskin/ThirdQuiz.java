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
    private String userPregnancy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quiz);
    }
    public void getSkinMoreInformation(){

        RadioGroup sensitiveSkin = findViewById(R.id.sensitiveRadioGroup);
        RadioGroup pregnancy = findViewById(R.id.pregnancyRadioGroup);
        // Listen to the user's choice
        RadioButton selectedSensitiveSkin  = findViewById(sensitiveSkin.getCheckedRadioButtonId());
        RadioButton selectedPregnancy = findViewById(pregnancy.getCheckedRadioButtonId());
        // Get RadioButton text
        userSensitivity = selectedSensitiveSkin.getText().toString();
        userPregnancy = selectedPregnancy.getText().toString();
    }
    public void goToGenerateRoutine(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, userSensitivity);
        intent.putExtra(EXTRA_MESSAGE, userPregnancy);
        startActivity(intent);
    }
}