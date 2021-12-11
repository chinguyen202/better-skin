package fi.chinguyen.betterskin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;

public class GenerateMorningRoutine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning_routine_layout);
        ArrayList<String> userChoices = userQuizChoices.getInstance().getUserChoices();
        ArrayList<String> morningRoutine = new ArrayList<>();

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();
        String cleaner = dataDao.getProductByInput("Clean",userChoices.get(1),userChoices.get(0),"AM").toString();
//        String moisturizer = dataDao.getProductByInput("Moisturizer",userChoices.get(1),userChoices.get(0),"AM").toString();
        String treat = dataDao.getProductByInput("Treat",userChoices.get(1),userChoices.get(0),"AM").toString();
        String spf = dataDao.getSpfProduct("SPF").toString();
        morningRoutine.add(cleaner);
//        morningRoutine.add(moisturizer);
        morningRoutine.add(treat);
        morningRoutine.add(spf);
        Log.d("data", "product: " + morningRoutine.toString());
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, morningRoutine);
        ListView  morningRoutineList = findViewById(R.id.morningRoutineList);
        morningRoutineList.setAdapter(arrayAdapter);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }


}
