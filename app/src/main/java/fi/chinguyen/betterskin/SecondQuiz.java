package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fi.chinguyen.betterskin.data.User;

public class SecondQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSkinGoal;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_quiz);
        user = (User) getIntent().getSerializableExtra("registerUser");

    }
    public void getSkinMainGoal(View view){
        RadioGroup mainGoalGroup= findViewById(R.id.mainGoalGroup);
        // Listen to the user's choice
        RadioButton skinMainGoal  = (RadioButton)findViewById(mainGoalGroup.getCheckedRadioButtonId());
        // Get RadioButton text
        userSkinGoal = skinMainGoal.getText().toString();
        Log.d("Hi", userSkinGoal);
    }

    public void goToThirdQuiz(View view) {
        userQuizChoices.getInstance().addToUserChoices(userSkinGoal);
        Intent intent = new Intent(this, ThirdQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, userSkinGoal);
        intent.putExtra("registerUser",user);
        startActivity(intent);
    }
}