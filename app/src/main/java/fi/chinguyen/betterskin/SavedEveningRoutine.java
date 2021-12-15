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

public class SavedEveningRoutine extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";
    String cleanser, moisturizer, treat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_evening_routine);

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        int user = dataDao.getUserID();
        ArrayList<String> savedEveningProduct = new ArrayList<>();

        cleanser = dataDao.getPMCleanser(user);
        moisturizer = dataDao.getPMMoisturizer(user);
        treat = dataDao.getPMTreat(user);

        savedEveningProduct.add(cleanser);
        savedEveningProduct.add(treat);
        savedEveningProduct.add(moisturizer);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, savedEveningProduct);
        ListView savedEveningRoutineList = findViewById(R.id.savedEveningRoutineList);
        savedEveningRoutineList.setAdapter(arrayAdapter);

        savedEveningRoutineList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent nextActivity = new Intent(SavedEveningRoutine.this, DisplayProductInfo.class);
            nextActivity.putStringArrayListExtra("product",savedEveningProduct);
            nextActivity.putExtra(EXTRA_MESSAGE, i);
            startActivity(nextActivity);
        });
    }
    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
