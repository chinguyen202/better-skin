package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hello", userQuizChoices.getInstance().getUserChoices().toString());

    }
    public void goToFirstQuiz(View view) {
        Intent intent = new Intent(this, FirstQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, true);
        startActivity(intent);
    }

}
