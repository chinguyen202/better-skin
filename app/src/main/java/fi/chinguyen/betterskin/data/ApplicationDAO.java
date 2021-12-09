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

    @Query("SELECT * FROM Product WHERE `Skin goal` like :goal")
    List<Product> searchProd:

    puctByGoal(String goal);

    @Query("SELECT * FROM Product WHERE `Skin type` like :skintype")
    List<Product> searchProductBySkintype(String skintype);

    @Query("SELECT * FROM Product WHERE `Product ID` like :ProductId")
    Product getById(long ProductId);

    @Update
    int updateProduct(Product product);




}
