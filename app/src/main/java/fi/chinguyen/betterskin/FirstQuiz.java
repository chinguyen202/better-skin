package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import fi.chinguyen.betterskin.data.User;

public class FirstQuiz extends AppCompatActivity {
    public static final String TAG = "Test mode";
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSkinType;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz);
        user = (User) getIntent().getSerializableExtra("registerUser");
        userQuizChoices.getInstance().clearChoices();
    }
    public void getSkinType(View view){
        RadioGroup skinType = findViewById(R.id.skinType);
        // Listen to the user's choice
        RadioButton selectedSkinType  = findViewById(skinType.getCheckedRadioButtonId());
        // Get RadioButton text
        userSkinType = selectedSkinType.getText().toString();
        Log.d(TAG, userSkinType);
    }


    public void goToSecondQuiz(View view) {
        userQuizChoices.getInstance().addToUserChoices(userSkinType);
        Intent intent = new Intent(this, SecondQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, userSkinType);
        intent.putExtra("registerUser",user);
        startActivity(intent);
    }
}