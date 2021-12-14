package fi.chinguyen.betterskin.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {


    private LiveData<List<SkincareProduct>> list;

    //Constructor to call the database class
    public AppRepository(Application application){
        AppDB productDb = AppDB.getInstance(application);
       // this.applicationDao = productDb.applicationDao;
        list = loadAllProduct();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<SkincareProduct>> loadAllProduct(){

        return list;
    }
}
