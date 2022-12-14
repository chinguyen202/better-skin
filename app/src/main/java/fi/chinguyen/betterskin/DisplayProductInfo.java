package fi.chinguyen.betterskin;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/**
 * Display product info when the user click on the product
 */
public class DisplayProductInfo extends AppCompatActivity {
    /**
     * Logic and set up for the display product info
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_product_info);

        //Find ImageView
        ImageView productImg= (ImageView) findViewById(R.id.product);

        //Get intend
        Bundle b = getIntent().getExtras();
        int a = b.getInt(GenerateMorningRoutine.EXTRA_MESSAGE, 0);
        ArrayList<String> ProductList=getIntent().getExtras().getStringArrayList("product");
        ArrayList<String> productInformation = new ArrayList<>();

        //Display product info in ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.display_product_intruction, productInformation);
        ListView instruction = findViewById(R.id.listViewInstruction);

        //Control what will appear when user click to each product in ListView
        if (a == 0) {
            productImg.setImageResource(R.drawable.cleansing_transparent);
            // -- This information following this article https://www.biore.com/en-us/blog/brightening/how-to-use-cleanser/
            productInformation.add("Pull you hair back.");
            productInformation.add("Wash your hands.");
            productInformation.add("Wet your face by apply lukewarm water to your face.");
            productInformation.add("Squeeze a dime-size amount of cleanser, bubble it and apply it on you face.");
            productInformation.add("Then massage your face and neck for 1 minute. When you are finished cleansing your skin, rinse your face off with lukewarm water.");
            productInformation.add("You can use a washcloth to remove the cleanser after washing.");
            instruction.setAdapter(arrayAdapter);
        } else if (a == 1) {
            if (ProductList.get(1).toLowerCase().contains("toner")){
                productImg.setImageResource(R.drawable.toner_transparent);
                // -- This information following this article https://www.womenshealthmag.com/beauty/a19952473/how-to-use-facial-toner/
                productInformation.add("Soak a cotton pad with toner, then swipe it over your entire face, neck, and chest.");
                productInformation.add("If you want to go green and skip the cotton pad, you can also put a few drops of toner to the palms of your hands and then press them into your face.");
            }else{
                productImg.setImageResource(R.drawable.serum_transparent);
                // -- This information following this article https://www.garnier.in/skin-care-tips/how-to-use-face-serum
                productInformation.add("To apply, take a pea-sized amount (about 3-4 drops) into your palms.");
                productInformation.add("Spread it between your palms without rubbing too much.");
                productInformation.add("Dab the serum all over your face and neck using small and gentle tapping motions.");
                productInformation.add("Wait for a couple of minutes for the serum to completely penetrate your skin");
            }
            instruction.setAdapter(arrayAdapter);
        } else if (a == 2) {
            if (ProductList.get(2).toLowerCase().contains("oil")){
                productImg.setImageResource(R.drawable.oil_transparent_);
                // -- This information following this article https://www.womenshealthmag.com/beauty/a19952473/how-to-use-facial-toner/
                productInformation.add("One to three drops of your choice of oil is enough to cover your whole face and deliver the benefits your skin needs.");
                productInformation.add("Dab or pat the oils, pushing them into your pores, rather than just sliding them around on the skin???s surface. This will help your skin absorb the oil and make use of its benefits much quicker.");
            }else{
            productImg.setImageResource(R.drawable.moisturizer_transparent);
            // -- This information following this article https://www.wikihow.com/Apply-Moisturizer
            productInformation.add("Use an almond-sized amount of product for each application.");
            productInformation.add("Dab a small amount of the moisturizer on different areas of your face.");
            productInformation.add("Gently spread the moisturizer evenly around your face with your fingertips.");
            }
            instruction.setAdapter(arrayAdapter);
        } else {
            productImg.setImageResource(R.drawable.suncreen_transparent);
            // -- This information following this article https://www.arlingtondermatology.net/2020/07/10/tips-for-applying-sunscreen-to-your-face/
            productInformation.add("Apply a generous amount of sunscreen.");
            productInformation.add("As a rule of thumb, you need about a nickel-sized dollop for your face.");
            productInformation.add("Cover your neck and upper chest as well.");
            productInformation.add("Rub excess sunscreen onto the backs of your hands.");
            instruction.setAdapter(arrayAdapter);
        }
    }
}


