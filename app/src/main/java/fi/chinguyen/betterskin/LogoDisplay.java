package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import fi.chinguyen.betterskin.data.Product;
import fi.chinguyen.betterskin.data.ProductDB;

/*
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
*/
public class LogoDisplay extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_display);




        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        // Animated confetti made in the direction of https://github.com/DanielMartinus/Konfetti
        {final KonfettiView konfettiView = findViewById(R.id.viewConfetti);
            konfettiView.build()
                    .addColors(Color.WHITE)
                    .setDirection(0.0, 359.0)
                    .setSpeed(5f, 10f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                    .addSizes(new Size(12, 6f))
                    .setPosition(-50f, display.widthPixels + 50f, -50f, -50f)
                    .streamFor(300, 5000L);
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoDisplay.this, Welcome.class);
                startActivity(intent);
            }
        },3000);
    }
}