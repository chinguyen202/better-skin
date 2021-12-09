package fi.chinguyen.betterskin.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//database class
@Database(
        entities = {Product.class,SkinType.class,SkinGoal.class,Time.class,ProductName.class},
        version = 1
)

public abstract class ProductDB extends RoomDatabase {
    public abstract ProductDAO productDAO();

    private static ProductDB productDB;

    public static ProductDB getInstance(Context context) {
        if(productDB == null ) {
            synchronized (ProductDB.class) {
                if (productDB == null) {
                    productDB = Room.databaseBuilder(context.getApplicationContext(), ProductDB.class, "skincare-product").allowMainThreadQueries().createFromAsset("database/product.db").build();
                }
            }
        }
        return productDB;
    }
}
