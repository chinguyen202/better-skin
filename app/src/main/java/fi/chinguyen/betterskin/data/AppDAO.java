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

    //Select all product
    @Query("Select * from SkincareProduct")
    LiveData<List<SkincareProduct>> loadAllProduct();

    //Select product by using step in which product is used for
    @Query("Select * from SkincareProduct Where stepUse like :stepUse")
    List<SkincareProduct> getProductByStepUse(String stepUse);

    //List product name
    @Query("Select productName from skincareProduct ")
    public List<Name> loadName();

    //Select product based on time use
    @Query("SELECT productName FROM skincareProduct WHERE timeUse like :timeUse")
    public List<Name> getProductByTime(String timeUse);

    //select product using all input from user
    @Query("SELECT productName FROM skincareProduct WHERE stepUse like :stepUse AND skinGoal like :skinGoal AND skinType like :skinType AND timeUse like :timeUse")
    public List<Name> getProductByInput(String stepUse,String skinGoal,String skinType,String timeUse);

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
