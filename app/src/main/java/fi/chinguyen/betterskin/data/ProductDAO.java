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

<<<<<<< HEAD:app/src/main/java/fi/chinguyen/betterskin/data/ApplicationDAO.java
    @Query("SELECT * FROM Product WHERE `Skin goal` like :goal")
    List<Product> searchProd:

    puctByGoal(String goal);

    @Query("SELECT * FROM Product WHERE `Skin type` like :skintype")
    List<Product> searchProductBySkintype(String skintype);

    @Query("SELECT * FROM Product WHERE `Product ID` like :ProductId")
    Product getById(long ProductId);
=======
    @Query("SELECT * FROM Product WHERE `Step use` like stepUse")
    List<Product> getProductByStep(stepUse);
>>>>>>> 9d6b60b786b6f8fce6f48ea5da0b8e0087149c49:app/src/main/java/fi/chinguyen/betterskin/data/ProductDAO.java

    @Update
    int updateProduct(Product product);




}
