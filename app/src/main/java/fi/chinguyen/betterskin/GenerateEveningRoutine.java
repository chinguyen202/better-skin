package fi.chinguyen.betterskin;

import android.content.Intent;
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
import fi.chinguyen.betterskin.data.User;

public class GenerateEveningRoutine extends AppCompatActivity {
    private static final String TAG = "TEST MODE";
    private static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private static final String productList = "com.example.better-skin.MESSAGE";
    AppDB data;
    AppDAO appDao;
    EveningRoutine pmRoutine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evening_routine_layout);

        data = AppDB.getInstance(this);
        appDao = data.appDao();

        Log.d(TAG, userQuizChoices.getInstance().getUserChoices().toString());
        ArrayList<String> userChoices = userQuizChoices.getInstance().getUserChoices();
        ArrayList<String> eveningRoutine = new ArrayList<>();


        String cleaner = appDao.getProductByInput("Clean",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        String moisturizer = appDao.getProductByInput("Moisturizer",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        String treat = appDao.getProductByInput("Treat",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");

        eveningRoutine.add(cleaner);
        eveningRoutine.add(treat);
        eveningRoutine.add(moisturizer);
        Log.d(TAG, "product: " + eveningRoutine.toString());
        //Insert evening Routine to database
        EveningRoutine pmRoutine = new EveningRoutine();

        pmRoutine.setCleanser(cleaner);
        pmRoutine.setMoisturizer(moisturizer);
        pmRoutine.setTreat(treat);
        pmRoutine.setUserID(appDao.getUserID());
        appDao.addPMRoutine(pmRoutine);
        //Log.d(TAG,"inserted: "+pmRoutine.toString());



        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, eveningRoutine);
        ListView eveningRoutineList = findViewById(R.id.eveningRoutineList);
        eveningRoutineList.setAdapter(arrayAdapter);

        eveningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d(TAG, eveningRoutineList.toString());
            Intent nextActivity = new Intent(GenerateEveningRoutine.this, DisplayMorningProductInfo.class);
            nextActivity.putStringArrayListExtra("product",eveningRoutine);
            nextActivity.putExtra(EXTRA_MESSAGE, i);
            startActivity(nextActivity);
        });
    }
    public void goToProfile(View view) {
        Log.d("Profile",userQuizChoices.getInstance().getUserChoices().toString());
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }


}
