package fi.chinguyen.betterskin.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {
                    SkincareProduct.class,
                    User.class,
                    MorningRoutine.class,
                    EveningRoutine.class},
        version = 2
)

public abstract class AppDB extends RoomDatabase {
    private static final String dbName = "betterSkin.db";

    //The database exposes DAOs through an abstract "getter" method for each @Dao
    public abstract AppDAO appDao();

    //defined a singleton to prevent having multiple instances of the database opened at the same time
    private static AppDB INSTANCE;

    //returns the singleton,create database first time it's accessed from an existing database
    //execute in 1 thread
    public static synchronized AppDB getInstance(Context context){
        if(INSTANCE == null){
            
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDB.class, dbName)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .createFromAsset("betterSkin.db")
                        .build();

            }
        return INSTANCE;

    }
}




