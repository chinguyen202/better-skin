package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstQuiz extends AppCompatActivity {
    public static final String TAG = "Test mode";
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSkinType;
    RadioGroup skinType;
    RadioButton selectedSkinType;
    Button goToSecondQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quiz);

        goToSecondQuiz = findViewById(R.id.btnNext1);
        skinType = findViewById(R.id.skinType);
        //Clear the old choices when the user take the quiz again
        userQuizChoices.getInstance().clearChoices();

        // //Go to second quiz when button "next" is clicked
        goToSecondQuiz.setOnClickListener(view->{
            //set condition to check if user choose one
            if(skinType.getCheckedRadioButtonId() == -1){
                //If user choose nothing, show a message
                Log.d("TEST","User didn't click");
                Toast.makeText(FirstQuiz.this, "Please choose one", Toast.LENGTH_SHORT).show();
            } else {
                //If user choose, save user choice and go to next activity
                userQuizChoices.getInstance().addToUserChoices(userSkinType);
                Intent intent = new Intent(this, SecondQuiz.class);
                intent.putExtra(EXTRA_MESSAGE, userSkinType);
                startActivity(intent);

            }

            });
        }

        //Method to do while radio button in first quiz is clicked
        public void getSkinType(View view){

            // Listen to the user's choice
            selectedSkinType = findViewById(skinType.getCheckedRadioButtonId());
            // Get RadioButton text
            userSkinType = selectedSkinType.getText().toString();
            Log.d(TAG, userSkinType);
        }




/*
    public void GotoSecondQuiz (View view){
            if (skinType.getCheckedRadioButtonId() == -1) {
                Log.d("TEST","User didn't click");
                Toast.makeText(FirstQuiz.this, "Please choose one", Toast.LENGTH_SHORT).show();
            } else {
                userQuizChoices.getInstance().addToUserChoices(userSkinType);
                Intent intent = new Intent(this, SecondQuiz.class);
                intent.putExtra(EXTRA_MESSAGE, userSkinType);
                startActivity(intent);

        }
    };*/
}