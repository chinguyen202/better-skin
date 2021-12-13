package fi.chinguyen.betterskin.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(
        entities = {SkincareProduct.class},
        version = 1
)
public abstract class AppDB extends RoomDatabase {
    public SkincareProduct[] applicationDao;

    public abstract AppDAO appDao();

    private static AppDB INSTANCE;

    public static synchronized AppDB getInstance(Context context){
        if(INSTANCE == null){
            
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDB.class, "skincare.db")
                        .fallbackToDestructiveMigration()
                       // .addCallback(roomCallBack)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .createFromAsset("SkincareProduct.db")
                        .build();

            }
        return INSTANCE;

      /*  private static .Callback roomCallBack = new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(appDb);
                new PopulateDB(INSTANCE).execute();
            }
        };*/
    }
/*
    private static class PopulateDB extends AsyncTask<Void,Void,Void>{
        private AppDAO appDao;

        public PopulateDB(AppDB appDb){
            this.appDao = appDb.appDao();
        }

        @Override
        protected Void doInBackground(Void...voids){
            appDao.addProduct(new SkincareProduct());
            return null;
        }*/
    }




