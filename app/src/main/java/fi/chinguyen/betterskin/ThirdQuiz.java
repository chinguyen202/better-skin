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
 * Modify the third quiz
 */
public class ThirdQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private String userSensitivity;
    public  RadioGroup sensitiveSkin;
    public RadioButton selectedSensitiveSkin;
    public Button goToGenerateRoutine;

    /**
     * Modify the third quiz
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quiz);

        sensitiveSkin = findViewById(R.id.sensitiveRadioGroup);
        goToGenerateRoutine = findViewById(R.id.btnNext3);
        /**
         * Set a condition when user click Generate Routine button
         */
        goToGenerateRoutine.setOnClickListener(view->{

            if(sensitiveSkin.getCheckedRadioButtonId() == -1){
                //If user choose nothing, show a message
                Toast.makeText(ThirdQuiz.this,"Please choose one!",Toast.LENGTH_SHORT).show();
            }else{
                //If user choose one, go to next activity
                //Add user's choice to singleton arrayList
                userQuizChoices.getInstance().addToUserChoices(userSensitivity);
                Intent intent = new Intent(this, GenerateMorningRoutine.class);
                intent.putExtra(EXTRA_MESSAGE, userSensitivity);
                startActivity(intent);
            }
        });

    }

    /**
     * Method to do while radio button in third quiz is clicked
     * @param view
     */
    public void getSkinSensitivity(View view){
        // Listen to the user's choice
        selectedSensitiveSkin  = findViewById(sensitiveSkin.getCheckedRadioButtonId());
        // Get RadioButton text
        userSensitivity = selectedSensitiveSkin.getText().toString();
    }


}