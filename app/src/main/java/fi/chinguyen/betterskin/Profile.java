package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * User profile contain routine and user data
 */
public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
    }
    //Listen to button in Profile

    /**
     * Method to go to About Me
     * @param view
     */
    public void goToAboutMe(View view) {
        Intent intent = new Intent(this, aboutMe.class);
        startActivity(intent);
    }

    /**
     * Method to go to saved morning routine
     * @param view
     */
    public void goToMorningRoutine(View view) {
        Intent intent = new Intent(this, SavedMorningRoutine.class);
        startActivity(intent);
    }

    /**
     * Method to go to saved evening routine
     * @param view
     */
    public void goToEveningRoutine(View view) {
        Intent intent = new Intent(this, SavedEveningRoutine.class);
        startActivity(intent);
    }

    /**
     * Method to go to take quiz
     * @param view
     */
    public void doQuiz(View view) {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }

    /**
     * Method to Logout
     * @param view
     */
    public void logout(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
