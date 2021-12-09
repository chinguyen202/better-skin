package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    void insertProduct(Product product );

    @Insert
    void insertSkinGoal(SkinGoal skinGoal);

    @Insert
    void insertSkinType(SkinType skinType);

    @Insert
    void insertTime(Time time);

    @Query("SELECT * FROM Product")
    List<Product> getAllProduct();

<<<<<<< HEAD

    @Query("SELECT * FROM Product WHERE product_name LIKE (:productName)")
    List<Product> getProductByName(String productName);

    @Query("SELECT * FROM Product INNER JOIN `Skin Goal` USING (productID) WHERE skin_goal LIKE (:skinGoal)")
    Product getProductBySkinGoal(String skinGoal);

    @Query("SELECT * FROM Product INNER JOIN SkinType USING (productID) WHERE skin_type LIKE (:skinType)")
    Product getProductBySkinType(String skinType);

    @Query("SELECT * FROM Product INNER JOIN `Time to use` USING (productID) WHERE time_use LIKE(:timeUse)")
    Product getProductByTime(String timeUse);

    @Query("SELECT * FROM Product INNER JOIN SkinType USING (productID) INNER JOIN `Skin Goal` USING (productID) " +
            "WHERE skin_type LIKE (:skinType) AND skin_goal LIKE (:skinGoal)")
    Product getProductBySkinTypeAndSkinGoal(String skinType, String skinGoal);

    @Query("SELECT * FROM Product INNER JOIN SkinType USING (productID) " +
            "INNER JOIN `SKIN GOAL` USING (productID) " +
            "INNER JOIN `Time to use` USING (productID)" +
            "WHERE skin_goal LIKE (:skinGoal) AND skin_type LIKE (:skinType) AND step_use LIKE (:stepUse)")
    Product getProductByAllInput(String stepUse,String skinGoal,String skinType);
=======
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
>>>>>>> master

    @Update
    void updateProduct(Product product);

    @Update
    void updateSkinGoal(SkinGoal skinGoal);

    @Update
    void updateSkinType(SkinType skinType);

    @Update
    void updateTime(Time time);

    @Delete
    void deleteProduct(Product product);

    @Delete
    void deleteSkinGoal(SkinGoal skinGoal);

    @Delete
    void deleteSkinType(SkinType skinType);

    @Delete
    void deleteTime(Time time);

}
