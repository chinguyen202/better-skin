package fi.chinguyen.betterskin.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
<<<<<<< HEAD
        entities = {SkincareProduct.class,User.class,MorningRoutine.class,EveningRoutine.class,},
=======
        entities = {SkincareProduct.class},
>>>>>>> feature/implementDatabase
        version = 1
)
public abstract class AppDB extends RoomDatabase {
    public SkincareProduct[] applicationDao;

    //The database exposes DAOs through an abstract "getter" method for each @Dao
    public abstract AppDAO appDao();
    public abstract UserDao userDao();
    public abstract MorningRoutineDao morningRoutineDao();
    public abstract EveningRoutineDao eveningRoutineDao();
    //defined a singleton to prevent having multiple instances of the database opened at the same time
    private static AppDB INSTANCE;
    //returns the singleton,create database first time it's accessed from an existing database
    public static synchronized AppDB getInstance(Context context){
        if(INSTANCE == null){
            
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDB.class, "skincare.db")
                        .fallbackToDestructiveMigration()
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .createFromAsset("betterSkin.db")
                        .build();

            }
        return INSTANCE;

    }
}




