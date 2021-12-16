package fi.chinguyen.betterskin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.EveningRoutine;

public class GenerateEveningRoutine extends AppCompatActivity {
    private static final String TAG = "TEST MODE";
    private static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private static final String productList = "com.example.better-skin.MESSAGE";
    AppDB data;
    AppDAO appDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evening_routine_layout);

        //Get shared preferences from login
        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String loginName = loginUser.getString("userName", "");

        //Access to database method
        data = AppDB.getInstance(this);
        appDao = data.appDao();

        //Get user's choices singleton arrayList
        ArrayList<String> userChoices = userQuizChoices.getInstance().getUserChoices();

        //Create arrayList for evening product
        ArrayList<String> eveningRoutine = new ArrayList<>();

        //Get product based on user's choices from database
        String cleaner = appDao.getProductByInput("Clean",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        String moisturizer = appDao.getProductByInput("Moisturizer",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        String treat = appDao.getProductByInput("Treat",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");

        //Add product to evening product arrayList
        eveningRoutine.add(cleaner);
        eveningRoutine.add(treat);
        eveningRoutine.add(moisturizer);
        Log.d(TAG, "product: " + eveningRoutine.toString());

        //Insert evening Routine to database
        EveningRoutine pmRoutine = new EveningRoutine();

        pmRoutine.setCleanser(cleaner);
        pmRoutine.setMoisturizer(moisturizer);
        pmRoutine.setTreat(treat);
        pmRoutine.setUserID(appDao.getIdByUsername(loginName));
        appDao.addPMRoutine(pmRoutine);

        //Display product
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, eveningRoutine);
        ListView eveningRoutineList = findViewById(R.id.eveningRoutineList);
        eveningRoutineList.setAdapter(arrayAdapter);

        //Listen to user's click on the list view and open new activity
        eveningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d(TAG, eveningRoutineList.toString());
            Intent nextActivity = new Intent(GenerateEveningRoutine.this, DisplayProductInfo.class);
            nextActivity.putStringArrayListExtra("product",eveningRoutine);
            nextActivity.putExtra(EXTRA_MESSAGE, i);
            startActivity(nextActivity);
        });
    }

    //Activity when profile button is clicked
    public void goToProfile(View view) {
        Log.d("Profile",userQuizChoices.getInstance().getUserChoices().toString());
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }


}
