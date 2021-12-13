package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM User")
    public List<User> getAllUser();

    @Query("SELECT * FROM User WHERE uID = :id")
    public User getUserById(long id);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
