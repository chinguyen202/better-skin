package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    public void getSkinMainGoal(){

        RadioGroup skinMainGoal = findViewById(R.id.mainGoalGroup);
        // Listen to the user's choice
        RadioButton mainGoalGroup  = (RadioButton)findViewById(skinMainGoal.getCheckedRadioButtonId());
        // Get RadioButton text
        userSkinGoal = mainGoalGroup.getText().toString();
    }

    public void goToThirdQuiz(View view) {
        Intent intent = new Intent(this, ThirdQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, userSkinGoal);
        startActivity(intent);
    }
}