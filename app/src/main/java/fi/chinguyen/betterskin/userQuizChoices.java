package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/**
 * Set up method for user quiz choices
 */
public class userQuizChoices extends AppCompatActivity {

    /**
     * Create singleton arrayList for user's choices
     */
    private ArrayList<String> userChoices = new ArrayList<>();;
    private static final userQuizChoices ourInstance = new userQuizChoices();

    /**
     * get instance
     * @return ourInstance
     */
    public static userQuizChoices getInstance() {
        return ourInstance;
    }

    /**
     * Method to add user choices
     * @param choice
     */
    public void addToUserChoices(String choice) {
        userChoices.add(choice);
    }

    /**
     * Method to get user choices
     * @return user choices
     */
    public ArrayList<String> getUserChoices() {
        return userChoices;
    }

    /**
     * Method to clear user choices
     */
    public void clearChoices(){userChoices.clear();};

}

