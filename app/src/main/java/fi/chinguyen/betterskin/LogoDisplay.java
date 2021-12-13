package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fi.chinguyen.betterskin.data.AppDAO;
import fi.chinguyen.betterskin.data.AppDB;
import fi.chinguyen.betterskin.data.SkincareProduct;

public class LogoDisplay extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_display);

        //List<data.Product> list = Arrays.asList((new ProductData()).addProductData());
        //Log.d("data", "onCreate: " + list.get(0));

        AppDB data = AppDB.getInstance(this);
        AppDAO dataDao = data.appDao();

        List<SkincareProduct> list = dataDao.getProductByStepUse("Clean");
        Log.d("data", "lengtg: " + list.size());

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoDisplay.this, Welcome.class);
                startActivity(intent);
                //finish();
            }
        },3000);

    }
}