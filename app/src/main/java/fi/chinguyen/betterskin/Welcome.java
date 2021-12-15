package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fi.chinguyen.betterskin.data.User;

public class Welcome extends AppCompatActivity {

    private Button getStart;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        user = (User) getIntent().getSerializableExtra("registerUser");

        getStart = findViewById(R.id.btnStart);
        getStart.setOnClickListener(view ->{
            Intent firstQuiz = new Intent(Welcome.this, FirstQuiz.class);
            firstQuiz.putExtra("registerUser",user);
            startActivity(firstQuiz);
        });

    }

}