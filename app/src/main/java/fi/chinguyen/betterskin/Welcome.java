package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private Button getStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Method to start quiz
        getStart = findViewById(R.id.btnStart);
        getStart.setOnClickListener(view ->{
            Intent firstQuiz = new Intent(Welcome.this, FirstQuiz.class);
            startActivity(firstQuiz);
        });

    }

}