package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

//<<<<<<< HEAD
//<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
//=======
import android.os.Bundle; 
//>>>>>>> master
//=======
import android.os.Bundle; 
//=======
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
//>>>>>>> master
=======
import android.widget.TextView;
>>>>>>> master

import java.util.Timer;
import java.util.TimerTask;
>>>>>>> f21e63fa5c9f2a7551d9b44dffb36c4380817a17

public class
MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

/*<<<<<<< HEAD
=======
    }
    public void goToFirstQuiz(View view) {
        Intent intent = new Intent(this, FirstQuiz.class);
        intent.putExtra(EXTRA_MESSAGE, true);
        startActivity(intent);
>>>>>>> master
    }*/
=======
        Log.d("hello", userQuizChoices.getInstance().getUserChoices().toString());
    }
>>>>>>> master
}