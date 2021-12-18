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

/**
 * Application data access object
 */
@Dao
public interface AppDAO {
    /**conflict
     * resolution strategy: insert same product will replace the old product
     * @param skincareProduct
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addProduct(SkincareProduct skincareProduct);

    /**
     * Insert user
     * @param user
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    public void registerUser(User user);

    /**
     * Insert morning routine
     * @param morningRoutine
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addAMRoutine(MorningRoutine morningRoutine);

    /**
     * Insert evening routine
     * @param eveningRoutine
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addPMRoutine(EveningRoutine eveningRoutine);

    /**
     * Get list of morning routine by user ID
     * @param uID
     * @return morning routine list
     */
    @Transaction
    @Query("Select * from morningRoutines where userID = :uID order by amId desc")
    List<MorningRoutine> getAMRoutineOfUser(int uID);

    /**
     * Get latest morning moisturiser of user by userID
     * @param uID
     * @return morning moisturizer
     */
    @Transaction
    @Query("SELECT moisturizer FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getAMMoisturizer(int uID);

    /**
     * Get latest morning treat product of user by userID
     * @param uID
     * @return morning treat
     */
    @Transaction
    @Query("SELECT treat FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getAMTreat(int uID);

    /**
     * Get latest Spf of user by userID
     * @param uID
     * @return morning spf
     */
    @Transaction
    @Query("SELECT SPF FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getSpf(int uID);

    /**
     * Get latest morning cleanser of user by userID
     * @param uID
     * @return morning cleanser
     */
    @Transaction
    @Query("SELECT cleanser FROM morningRoutines WHERE userID = :uID order by amId desc")
    String getAMCleanser(int uID);

    /**
     * Get list of evening routine by user ID
     * @param uID
     * @return evening routine
     */
    @Transaction
    @Query("Select * from eveningRoutine where userID = :uID")
    List<EveningRoutine> getPMRoutineOfUser(int uID);

    /**
     * Get latest evening cleanser of user by userID
     * @param uID
     * @return evening cleanser
     */
    @Transaction
    @Query("SELECT cleanser FROM eveningRoutine WHERE userID = :uID order by pmId desc")
    String getPMCleanser(int uID);

    /**
     * Get latest evening moisturizer of user by userID
     * @param uID
     * @return evening moisturizer
     */
    @Transaction
    @Query("SELECT moisturizer FROM eveningRoutine WHERE userID = :uID order by pmId desc")
    String getPMMoisturizer(int uID);

    /**
     * Get latest evening treat of user by userID
     * @param uID
     * @return evening treat
     */
    @Transaction
    @Query("SELECT treat FROM eveningRoutine WHERE userID = :uID order by pmId desc")
    String getPMTreat(int uID);


    /**
     * Select all product
     * @return all product
     */
    @Query("Select * from SkincareProduct")
    LiveData<List<SkincareProduct>> loadAllProduct();

    /**
     * Select product by using step in which product is used for
     * @param stepUse
     * @return product
     */
    @Query("Select * from SkincareProduct Where stepUse like :stepUse")
    List<SkincareProduct> getProductByStepUse(String stepUse);

    /**
     * Select product based on time use
     * @param timeUse
     * @return product
     */
    @Query("SELECT productName FROM skincareProduct WHERE timeUse like :timeUse")
    public String getProductByTime(String timeUse);

    /**
     * select product using all input from user
     * @param stepUse
     * @param skinGoal
     * @param skinType
     * @param sensitiveSkin
     * @param timeUse
     * @return product
     */
    @Query("SELECT productName FROM skincareProduct WHERE stepUse like :stepUse AND skinGoal like :skinGoal AND skinType like :skinType AND sensitiveSkin like :sensitiveSkin AND timeUse like :timeUse")
    public String getProductByInput(String stepUse, String skinGoal, String skinType, String sensitiveSkin, String timeUse);

    /**
     * Select product by using step in which product is used for
     * @param stepUse
     * @return product
     */
    @Query("SELECT productName from SkincareProduct Where stepUse like :stepUse")
    public String getSpfProduct(String stepUse);

    /**
     * get uID
     * @return uID
     */
    @Query("Select uID from users")
    public int getUserID();

    /**
     * get user
     * @return user
     */
    @Query("Select * from users")
    List<User> getAllUser();

    /**
     * Get user by username
     * @param username
     * @return user
     */
    @Query("Select * from users where username = :username")
    public List<User> getUserByUsername(String username);

    /**
     * Get user name from user
     * @return username
     */
    @Query("Select username from users")
    String getUsername();

    /**
     * Get username with ID
     * @param id
     * @return username
     */
    @Query("Select username from users where uID = :id")
    public String getUsernameByID(int id);

    /**
     * Get all user name
     * @return list of user
     */
    @Query("Select username from users")
    public List<User> getAllUsername();

    /**
     * get fullname with username
     * @param username
     * @return fullname
     */
    @Query("Select fullName from users where username = :username")
    String getFullNameByUsername(String username);

    /**
     * get uID with username
     * @param username
     * @return uID
     */
    @Query("Select uID from users where username = :username")
    Integer getIdByUsername(String username);

    /**
     * Pull the username from database using username and password
     * @param username
     * @param password
     * @return username
     */
    @Query("Select username from users where username=(:username) AND password=(:password)")
    User logIn(String username, String password);

    /**
     * update product data in database
     * @param skincareProduct
     */
    @Update
    public void updateProduct(SkincareProduct skincareProduct);


    /**
     * Update user info in database
     * @param user
     */
    @Update
    void updateUserInfo(User user);

    /**
     * delete product from database
     * @param skincareProduct
     */
    @Delete
    public void deleteProduct(SkincareProduct skincareProduct);

    /**
     * Delete user from database
     * @param user
     */
    @Delete
    void deleteUser(User user);

    /**
     * Delete morning routine from database
     * @param morningRoutine
     */
    @Delete
    void deleteAmRoutine(MorningRoutine morningRoutine);

    /**
     * Delete evening routine from database
     * @param eveningRoutine
     */
    @Delete
    void deletePmRoutine(EveningRoutine eveningRoutine);


}
