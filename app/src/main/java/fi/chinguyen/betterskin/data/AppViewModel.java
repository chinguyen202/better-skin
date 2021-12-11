package fi.chinguyen.betterskin.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class AppViewModel extends ViewModel {
    private Application application;
    private LiveData<List<SkincareProduct>> productList;
    private AppRepository appRepository;

    public AppViewModel(Application application){
        this.application = application;
        appRepository = new AppRepository(application);
        this.productList = appRepository.loadAllProduct();
    }

    public LiveData<List<SkincareProduct>> loadAllProduct(){
        return productList = appRepository.loadAllProduct();
    }
}
