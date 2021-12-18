package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Modify the second quiz
 */
public class SecondQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSkinGoal;
    RadioGroup mainGoalGroup;
    @Override
    /**
     * Modify the third quiz button
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_quiz);

        mainGoalGroup= findViewById(R.id.mainGoalGroup);

        Button goToThirdQuiz = findViewById(R.id.btnNext2);
        //Go to third quiz when button "next" is clicked
        goToThirdQuiz.setOnClickListener(view ->{
            //Set condition for user to choose one choice
            if(mainGoalGroup.getCheckedRadioButtonId() == -1){
                //If user choose nothing, show a message
                Toast.makeText(SecondQuiz.this,"Please choose one",Toast.LENGTH_SHORT).show();
            }else{
                //If user chose one, save user choice and go to third Quiz
                userQuizChoices.getInstance().addToUserChoices(userSkinGoal);
                Intent intent = new Intent(this, ThirdQuiz.class);
                intent.putExtra(EXTRA_MESSAGE, userSkinGoal);
                startActivity(intent);
            }
        });

    }

    /**
     * Method to do while radio button in second quiz is clicked
     * @param view
     */
    public void getSkinMainGoal(View view){
        // Listen to the user's choice
        RadioButton skinMainGoal  = findViewById(mainGoalGroup.getCheckedRadioButtonId());
        // Get RadioButton text
        userSkinGoal = skinMainGoal.getText().toString();
    }
/*
    //Go to third quiz when button "next" is clicked
    public void goToThirdQuiz(View view) {
        //Add user's choice to singleton arrayList
        userQuizChoices.getInstance().addToUserChoices(userSkinGoal);
        Intent intent = new Intent(this, ThirdQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, userSkinGoal);
        startActivity(intent);
    }*/
}