package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;

public class GenerateMorningRoutine extends AppCompatActivity {
    public static final String TAG = "Test mode";
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning_routine_layout);
        Log.d("Hi", userQuizChoices.getInstance().getUserChoices().toString());
        ArrayList<String> userChoices = userQuizChoices.getInstance().getUserChoices();
        ArrayList<String> morningRoutine = new ArrayList<>();

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        String cleaner = dataDao.getProductByInput("Clean",userChoices.get(1),userChoices.get(0), userChoices.get(2),"AM");
        Log.d(TAG,"product"+cleaner);
        String moisturizer = dataDao.getProductByInput("Moisturizer",userChoices.get(1),userChoices.get(0), userChoices.get(2),"AM");
        Log.d(TAG,"product"+moisturizer);
        String treat = dataDao.getProductByInput("Treat",userChoices.get(1),userChoices.get(0), userChoices.get(2),"AM");
        Log.d(TAG,"product"+treat);
        String spf = dataDao.getSpfProduct("SPF");
        morningRoutine.add(cleaner);
        morningRoutine.add(treat);
        morningRoutine.add(moisturizer);
        morningRoutine.add(spf);
        Log.d(TAG, "product: " + morningRoutine.toString());
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, morningRoutine);
        ListView  morningRoutineList = findViewById(R.id.morningRoutineList);


        morningRoutineList.setAdapter(arrayAdapter);

        morningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d(TAG, morningRoutine.toString());
            Intent nextActivity = new Intent(GenerateMorningRoutine.this, DisplayMorningProductInfo.class);
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


}
