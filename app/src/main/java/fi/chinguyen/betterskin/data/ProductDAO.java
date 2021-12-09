package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ApplicationDAO {

    @Insert
    long create(Product product);

    @Query("SELECT * FROM Product")
    List<Product> getAllProduct();

    @Query("SELECT * FROM Product WHERE `Step use` like stepUse")
    List<Product> getProductByStep(stepUse);

    @Update
    int updateProduct(Product product);




}
