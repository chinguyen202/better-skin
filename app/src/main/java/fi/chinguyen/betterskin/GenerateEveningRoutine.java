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

public class GenerateEveningRoutine extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    private static final String productList = "com.example.better-skin.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evening_routine_layout);

        ArrayList<String> userChoices = userQuizChoices.getInstance().getUserChoices();
        ArrayList<String> eveningRoutine = new ArrayList<>();

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        String cleaner = dataDao.getProductByInput("Clean",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        String moisturizer = dataDao.getProductByInput("Moisturizer",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        String treat = dataDao.getProductByInput("Treat",userChoices.get(1),userChoices.get(0), userChoices.get(2),"PM");
        eveningRoutine.add(cleaner);
        eveningRoutine.add(treat);
        eveningRoutine.add(moisturizer);
        Log.d("data", "product: " + eveningRoutine.toString());
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, eveningRoutine);
        ListView eveningRoutineList = findViewById(R.id.eveningRoutineList);
        eveningRoutineList.setAdapter(arrayAdapter);

        eveningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d("hI", eveningRoutineList.toString());
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
