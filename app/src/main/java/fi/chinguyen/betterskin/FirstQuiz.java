package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class FirstQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSkinType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz);
    }
    public void getSkinType(View view){
        RadioGroup skinType = findViewById(R.id.skinType);
        // Listen to the user's choice
        RadioButton selectedSkinType  = findViewById(skinType.getCheckedRadioButtonId());
        // Get RadioButton text
        userSkinType = selectedSkinType.getText().toString();
        Log.d("Hi", userSkinType);
    }


    public void goToSecondQuiz(View view) {
        userQuizChoices.getInstance().addToUserChoices(userSkinType);
        Intent intent = new Intent(this, SecondQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, userSkinType);
        startActivity(intent);
    }
}