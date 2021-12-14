package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(User user);

  //  @Query("Select userID from users")
   // int getUserID();

    @Query("Select username from users")
    String getUsername();

    @Query("Select fullName from users")
    String getFullname();

    @Query("Select username from users where username=(:username) AND password=(:password)")
    User logIn(String username, String password);



    @Delete
    void deleteUser(User user);
}
