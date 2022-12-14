package fi.chinguyen.betterskin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Timer;
import java.util.TimerTask;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

/**
 * Display the BetterSkin logo
 */
public class LogoDisplay extends AppCompatActivity implements View.OnTouchListener {
    private Timer timer;
    private Boolean isTouched = false;

    @Override
/**
 * Set up logo animation and logic
 */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_display);
        LinearLayout logoLayout = (LinearLayout) findViewById(R.id.logoLayout);

        // Animated confetti made following the direction of https://github.com/DanielMartinus/Konfetti
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        {final KonfettiView konfettiView = findViewById(R.id.viewConfetti);
            konfettiView.build().addColors(Color.WHITE)
                    .setDirection(0.0, 359.0)
                    .setSpeed(5f, 10f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000L)
                    .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                    .addSizes(new Size(12, 6f))
                    .setPosition(-50f, display.widthPixels + 50f, -50f, -50f)
                    .streamFor(300, 5000L);
        }

        //Go to Login after 3 minutes
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Set activity to go to login when screen is touched
                if(!isTouched){
                    Intent intent = new Intent(LogoDisplay.this, Login.class);
                    startActivity(intent);
                }
            }
        },3000);
        logoLayout.setOnTouchListener(this);
    }


    /**
     * Set activity to go to login when screen is touched
     * @param v
     * @param event
     * @return
     */
    public boolean onTouch(View v, MotionEvent event) {
        isTouched = true;
                startActivity(new Intent(LogoDisplay.this, Login.class));
        return true;
    }
}