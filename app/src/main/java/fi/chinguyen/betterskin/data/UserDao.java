package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Room;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM users WHERE userId=(:userId) and password =(:password)")
    UserEntity login(String userId, String password);

    @Query("SELECT * FROM users")
    public List<UserEntity> getAllUser();

    @Query("SELECT * FROM users WHERE id = :id")
    public UserEntity getUserById(long id);

    @Update
    void updateUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);
}
