package fi.chinguyen.betterskin;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class

userQuizChoices extends AppCompatActivity {
    private ArrayList<String> userChoices = new ArrayList<>();;
    private static final userQuizChoices ourInstance = new userQuizChoices();
    public static userQuizChoices getInstance() {
        return ourInstance;
    }

    public void addToUserChoices(String choice) {
        userChoices.add(choice);
    }

    public ArrayList<String> getUserChoices() {
        return userChoices;
    }

}

