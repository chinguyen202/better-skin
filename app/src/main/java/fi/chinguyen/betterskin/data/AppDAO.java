package fi.chinguyen.betterskin.data;


import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addProduct(SkincareProduct skincareProduct);

    @Query("Select * from SkincareProduct")
    LiveData<List<SkincareProduct>> loadAllProduct();

    @Query("Select * from SkincareProduct Where stepUse like :stepUse")
    List<SkincareProduct> getProductByStepUse(String stepUse);

    @Query("Select productName from skincareProduct ")
    public List<Name> loadName();

    @Query("SELECT productName FROM skincareProduct WHERE timeUse like :timeUse")
    public List<Name> getProductByTime(String timeUse);

    @Query("SELECT productName FROM skincareProduct WHERE skinGoal like :skinGoal AND skinType like :skinType")
    public List<Name> getProductByInput(String skinGoal,String skinType);

    @Update
    public void updateProduct(SkincareProduct skincareProduct);

    @Delete
    public void deleteProduct(SkincareProduct skincareProduct);

    public class Name{
        @ColumnInfo(name = "productName")
        public String productName;

        @Override
        public String toString(){
            return productName;
        }
    }
}
