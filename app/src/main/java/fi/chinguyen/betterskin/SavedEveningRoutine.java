package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;

public class SavedEveningRoutine extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    String cleanser, moisturizer, treat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_evening_routine);

        //Get shared preference from Login
        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String loginName = loginUser.getString("userName", "");

        //Access to database method
        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        int user = dataDao.getIdByUsername(loginName);

        //Create arrayList for saved evening product
        ArrayList<String> savedEveningProduct = new ArrayList<>();

        //Get saved evening product from database
        cleanser = dataDao.getPMCleanser(user);
        moisturizer = dataDao.getPMMoisturizer(user);
        treat = dataDao.getPMTreat(user);

        //Add saved product to database
        savedEveningProduct.add(cleanser);
        savedEveningProduct.add(treat);
        savedEveningProduct.add(moisturizer);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, savedEveningProduct);
        ListView savedEveningRoutineList = findViewById(R.id.savedEveningRoutineList);

        if (cleanser != null){
             //Display in ListView
             savedEveningRoutineList.setAdapter(arrayAdapter);

            //Listen to user's click on the list view and open new activity
            savedEveningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent nextActivity = new Intent(SavedEveningRoutine.this, DisplayProductInfo.class);
                nextActivity.putStringArrayListExtra("product", savedEveningProduct);
                nextActivity.putExtra(EXTRA_MESSAGE, i);
                startActivity(nextActivity);
            });
        }else{
            //set an empty view
                TextView emptyView = findViewById(R.id.emptyElement);
                savedEveningRoutineList.setEmptyView(emptyView);
        };
    }

    //Method to go Profile
    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}


