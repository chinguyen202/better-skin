package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * Modify welcome class
 */
public class Welcome extends AppCompatActivity {

    private Button getStart;

    /**
     * Method to start quiz
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        getStart = findViewById(R.id.btnStart);
        getStart.setOnClickListener(view ->{
            Intent firstQuiz = new Intent(Welcome.this, FirstQuiz.class);
            startActivity(firstQuiz);
        });

    }

}