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
