package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;

public class SavedMorningRoutine extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    String cleanser, moisturizer, treat,  spf;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_morning_routine);

        //Get shared preference from Login
        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String loginName = loginUser.getString("userName", "");

        //Access to database method
        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        int user = dataDao.getIdByUsername(loginName);

        //Create arrayList for saved morning product
        ArrayList<String> savedMorningProduct = new ArrayList<>();

        //Get saved morning product from database
        cleanser = dataDao.getAMCleanser(user);
        moisturizer = dataDao.getAMMoisturizer(user);
        treat = dataDao.getAMTreat(user);
        spf = dataDao.getSpf(user);

        //Add saved product to database
        savedMorningProduct.add(cleanser);
        savedMorningProduct.add(treat);
        savedMorningProduct.add(moisturizer);
        savedMorningProduct.add(spf);

        //Display in ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, savedMorningProduct);
        ListView  morningRoutineList = findViewById(R.id.savedMorningRoutineList);

        if(cleanser != null) {
            morningRoutineList.setAdapter(arrayAdapter);

            //Listen to user's click on the list view and open new activity
            morningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent nextActivity = new Intent(SavedMorningRoutine.this, DisplayProductInfo.class);
                nextActivity.putStringArrayListExtra("product", savedMorningProduct);
                nextActivity.putExtra(EXTRA_MESSAGE, i);
                startActivity(nextActivity);
            });
        }else{
            //Set empty listview
            morningRoutineList.setEmptyView(findViewById(R.id.emptyElement));

        }
    }

    //Method to go to saved evening routine
    public void goToSavedEveningRoutine(View view) {
        Intent intent = new Intent(this, SavedEveningRoutine.class);
        startActivity(intent);
    }

    //Method to go to profile
    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}

