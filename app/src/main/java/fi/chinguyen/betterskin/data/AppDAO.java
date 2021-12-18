package fi.chinguyen.betterskin.data;


import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Dao
public interface AppDAO {
    //conflict resolution strategy: insert same product will replace the old product
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addProduct(SkincareProduct skincareProduct);

    //Insert user
    @Insert(onConflict = OnConflictStrategy.FAIL)
    public void registerUser(User user);

    //Insert morning routine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addAMRoutine(MorningRoutine morningRoutine);

    //Insert evening routine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addPMRoutine(EveningRoutine eveningRoutine);

    //Get list of morning routine by user ID
    @Transaction
    @Query("Select * from morningRoutines where userID = :uID order by amId desc")
    List<MorningRoutine> getAMRoutineOfUser(int uID);

    //Get latest morning moisturiser of user by userID
    @Transaction
    @Query("SELECT moisturizer FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getAMMoisturizer(int uID);

    //Get latest morning treat product of user by userID
    @Transaction
    @Query("SELECT treat FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getAMTreat(int uID);

    //Get latest Spf of user by userID
    @Transaction
    @Query("SELECT SPF FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getSpf(int uID);

    //Get latest morning cleanser of user by userID
    @Transaction
    @Query("SELECT cleanser FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getAMCleanser(int uID);

    //Get list of evening routine by user ID
    @Transaction
    @Query("Select * from eveningRoutine where userID = :uID")
    List<EveningRoutine> getPMRoutineOfUser(int uID);

    //Get latest evening cleanser of user by userID
    @Transaction
    @Query("SELECT cleanser FROM eveningRoutine WHERE userID = :uID order by pmId desc")
    String getPMCleanser(int uID);

    //Get latest evening moisturizer of user by userID
    @Transaction
    @Query("SELECT moisturizer FROM eveningRoutine WHERE userID = :uID order by pmId desc")
    String getPMMoisturizer(int uID);

    //Get latest evening treat of user by userID
    @Transaction
    @Query("SELECT treat FROM eveningRoutine WHERE userID = :uID order by pmId desc")
    String getPMTreat(int uID);


    //Select all product
    @Query("Select * from SkincareProduct")
    LiveData<List<SkincareProduct>> loadAllProduct();

    //Select product by using step in which product is used for
    @Query("Select * from SkincareProduct Where stepUse like :stepUse")
    List<SkincareProduct> getProductByStepUse(String stepUse);

    //Select product based on time use
    @Query("SELECT productName FROM skincareProduct WHERE timeUse like :timeUse")
    public String getProductByTime(String timeUse);

    //select product using all input from user
    @Query("SELECT productName FROM skincareProduct WHERE stepUse like :stepUse AND skinGoal like :skinGoal AND skinType like :skinType AND sensitiveSkin like :sensitiveSkin AND timeUse like :timeUse")
    public String getProductByInput(String stepUse, String skinGoal, String skinType, String sensitiveSkin, String timeUse);

    //Select product by using step in which product is used for
    @Query("SELECT productName from SkincareProduct Where stepUse like :stepUse")
    public String getSpfProduct(String stepUse);

    @Query("Select uID from users")
    public int getUserID();

    @Query("Select * from users")
    List<User> getAllUser();

    @Query("Select * from users where username = :username")
    public List<User> getUserByUsername(String username);


    @Query("Select username from users")
    String getUsername();

    @Query("Select username from users where uID = :id")
    public String getUsernameByID(int id);

    @Query("Select username from users")
    public List<User> getAllUsername();


    @Query("Select fullName from users where username = :username")
    String getFullNameByUsername(String username);

    @Query("Select uID from users where username = :username")
    Integer getIdByUsername(String username);

    //Pull the username from database using username and password
    @Query("Select username from users where username=(:username) AND password=(:password)")
    User logIn(String username, String password);

    //update product data in database
    @Update
    public void updateProduct(SkincareProduct skincareProduct);


    //Update user info in database
    @Update
    void updateUserInfo(User user);

    //delete product from database
    @Delete
    public void deleteProduct(SkincareProduct skincareProduct);

    //Delete user from database
    @Delete
    void deleteUser(User user);

    //Delete morning routine from database
    @Delete
    void deleteAmRoutine(MorningRoutine morningRoutine);

    //Delete evening routine from database
    @Delete
    void deletePmRoutine(EveningRoutine eveningRoutine);


}
