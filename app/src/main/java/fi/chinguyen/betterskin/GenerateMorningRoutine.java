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
import fi.chinguyen.betterskin.data.MorningRoutine;

public class GenerateMorningRoutine extends AppCompatActivity {
    public static final String TAG = "Test mode";
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    String cleanser, moisturizer, treat, spf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning_routine_layout);
        Log.d("User choices:", userQuizChoices.getInstance().getUserChoices().toString());
        SharedPreferences loginUser = getSharedPreferences("login", Activity.MODE_PRIVATE);
        String loginName = loginUser.getString("userName", "");
        ArrayList<String> userChoices = userQuizChoices.getInstance().getUserChoices();
        ArrayList<String> morningRoutine = new ArrayList<>();

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();

        cleanser = dataDao.getProductByInput("Clean",userChoices.get(1),userChoices.get(0), userChoices.get(2),"AM");
        Log.d(TAG,"product"+cleanser);
        moisturizer = dataDao.getProductByInput("Moisturizer",userChoices.get(1),userChoices.get(0), userChoices.get(2),"AM");
        Log.d(TAG,"product"+moisturizer);
        treat = dataDao.getProductByInput("Treat",userChoices.get(1),userChoices.get(0), userChoices.get(2),"AM");
        Log.d(TAG,"product"+treat);
        spf = dataDao.getSpfProduct("SPF");
        morningRoutine.add(cleanser);
        morningRoutine.add(treat);
        morningRoutine.add(moisturizer);
        morningRoutine.add(spf);

        Log.d(TAG, "product: " + morningRoutine.toString());

        //Create a morning routine
        MorningRoutine amRoutine = new MorningRoutine();
        amRoutine.setCleanser(cleanser);
        amRoutine.setMoisturizer(moisturizer);
        amRoutine.setTreat(treat);
        amRoutine.setSpf(spf);
        amRoutine.setUserID(dataDao.getIdByUsername(loginName));
        //insert morning Routine to database
        dataDao.addAMRoutine(amRoutine);
        Log.d(TAG,"inserted: "+ amRoutine.toString());

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, morningRoutine);
        ListView  morningRoutineList = findViewById(R.id.morningRoutineList);
        morningRoutineList.setAdapter(arrayAdapter);

        morningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d(TAG, morningRoutine.toString());
            Intent nextActivity = new Intent(GenerateMorningRoutine.this, DisplayProductInfo.class);
            nextActivity.putStringArrayListExtra("product",morningRoutine);
            nextActivity.putExtra(EXTRA_MESSAGE, i);
            startActivity(nextActivity);
        });

    }

    public void getEveningRoutine(View view) {
        Intent intent = new Intent(this, GenerateEveningRoutine.class);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    private Boolean validateMorningRoutine(MorningRoutine amRoutine){
        if(amRoutine.getCleanser().isEmpty() || amRoutine.getMoisturizer().isEmpty() ||amRoutine.getTreat().isEmpty()||amRoutine.getSpf().isEmpty()){
            return false;
        }
        return true;

    }


}
