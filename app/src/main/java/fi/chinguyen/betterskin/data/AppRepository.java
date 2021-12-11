package fi.chinguyen.betterskin.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {

    private SkincareProduct[] applicationDao;
    private LiveData<List<SkincareProduct>> list;

    //Constructor to call the database class
    public AppRepository(Application application){
        AppDB productDb = AppDB.getInstance(application);
        this.applicationDao = productDb.applicationDao;
        list = loadAllProduct();
    }

    public LiveData<List<SkincareProduct>> loadAllProduct(){
        return list;
    }
}
