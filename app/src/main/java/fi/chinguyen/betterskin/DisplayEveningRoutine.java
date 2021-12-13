package fi.chinguyen.betterskin;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayEveningRoutine extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.better-skin.MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_product_info);

        ImageView productImg = (ImageView) findViewById(R.id.product);
        TextView introduction = (TextView) findViewById(R.id.introduction);
        Bundle b = getIntent().getExtras();
        int a = b.getInt(GenerateMorningRoutine.EXTRA_MESSAGE, 0);
        ArrayList<String> productInformation = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_display, productInformation);
        ListView instruction = findViewById(R.id.listViewInstruction);

        if (a == 0) {
            Log.d("boo", "I am 0");
            productImg.setImageResource(R.drawable.cleansing_transparent);
            productInformation.add("Pull you hair back.");
            productInformation.add("Wash your hands.");
            productInformation.add("Wet your face by apply lukewarm water to your face.");
            productInformation.add("Squeeze a dime-size amount of cleanser, bubble it and apply it on you face.");
            productInformation.add("Then massage your face and neck for 1 minute. When you are finished cleansing your skin, rinse your face off with lukewarm water.");
            productInformation.add("You can use a washcloth to remove the cleanser after washing.");
            instruction.setAdapter(arrayAdapter);
        } else if (a == 1) {
            Log.d("boo", "I am 1");
            productImg.setImageResource(R.drawable.serum_transparent);
            // -- This information following this article https://www.garnier.in/skin-care-tips/how-to-use-face-serum
            productInformation.add("To apply, take a pea-sized amount (about 3-4 drops) into your palms.");
            productInformation.add("Spread it between your palms without rubbing too much.");
            productInformation.add("Dab the serum all over your face and neck using small and gentle tapping motions.");
            productInformation.add("Wait for a couple of minutes for the serum to completely penetrate your skin");
            instruction.setAdapter(arrayAdapter);
        } else if (a == 2) {
            Log.d("boo", "I am 2");
            productImg.setImageResource(R.drawable.moisturizer_transparent);
            // -- This information following this article https://www.wikihow.com/Apply-Moisturizer
            productInformation.add("Use an almond-sized amount of product for each application.");
            productInformation.add("Dab a small amount of the moisturizer on different areas of your face.");
            productInformation.add("Gently spread the moisturizer evenly around your face with your fingertips.");
            instruction.setAdapter(arrayAdapter);
        }

    }
}

