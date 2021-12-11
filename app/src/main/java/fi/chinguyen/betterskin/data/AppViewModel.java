package fi.chinguyen.betterskin.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private final LiveData<List<SkincareProduct>> productList;
    private AppRepository appRepository;

    public AppViewModel(Application application){
        super(application);
        appRepository = new AppRepository(application);
        this.productList = appRepository.loadAllProduct();
    }

    LiveData<List<SkincareProduct>> loadAllProduct(){
        return productList;
    }
}
