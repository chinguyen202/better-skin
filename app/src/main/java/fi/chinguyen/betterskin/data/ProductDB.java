package fi.chinguyen.betterskin.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDB extends RoomDatabase {
    public abstract ApplicationDAO productDAO();
    private static ProductDB productDB;

    public static ProductDB get(Context context) {
        if(null == productDB){
            productDB = Room.databaseBuilder(context.getApplicationContext(), ProductDB.class,"skincare-product").allowMainThreadQueries().build();
        }
        return productDB;
    }
}
