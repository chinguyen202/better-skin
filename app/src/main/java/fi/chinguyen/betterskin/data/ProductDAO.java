package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    long create(Product product);

    @Query("SELECT * FROM Product")
    List<Product> getAll();

    @Query("SELECT * FROM Product ORDER BY goal")
    List<Product> getAllByGoal();

    @Query("SELECT * FROM Product WHERE id= :ProductId")
    Product getById(long ProductId);
}
