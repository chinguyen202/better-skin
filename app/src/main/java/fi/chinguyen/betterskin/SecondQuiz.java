package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SecondQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSkinGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_quiz);
    }

    //Method to do while radio button in second quiz is clicked
    public void getSkinMainGoal(View view){
        RadioGroup mainGoalGroup= findViewById(R.id.mainGoalGroup);
        // Listen to the user's choice
        RadioButton skinMainGoal  = (RadioButton)findViewById(mainGoalGroup.getCheckedRadioButtonId());
        // Get RadioButton text
        userSkinGoal = skinMainGoal.getText().toString();
    }

    //Go to third quiz when button "next" is clicked
    public void goToThirdQuiz(View view) {
        //Add user's choice to singleton arrayList
        userQuizChoices.getInstance().addToUserChoices(userSkinGoal);
        Intent intent = new Intent(this, ThirdQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, userSkinGoal);
        startActivity(intent);
    }
}