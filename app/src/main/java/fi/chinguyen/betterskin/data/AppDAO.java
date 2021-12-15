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

import java.util.ArrayList;
import java.util.List;

@Dao
public interface AppDAO {
    //conflict resolution strategy: insert same product will replace the old product
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addProduct(SkincareProduct skincareProduct);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void registerUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAMRoutine(MorningRoutine morningRoutine);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPMRoutine(EveningRoutine eveningRoutine);

    @Query("SELECT * FROM users where username = :username AND password =:password")
    User getUser(String username,String password);

    @Transaction
    @Query("Select * from morningRoutines where userID = :uID")
    List<MorningRoutine> getAMRoutineOfUser(int uID);

    @Transaction
    @Query("Select * from eveningRoutine where userID = :uID")
    List<EveningRoutine> getPMRoutineOfUser(int uID);

    @Transaction
    @Query("Select cleanser from eveningRoutine where userID = :uID")
    String getAMCleanser(int uID);

    //Select all product
    @Query("Select * from SkincareProduct")
    LiveData<List<SkincareProduct>> loadAllProduct();

    //Select product by using step in which product is used for
    @Query("Select * from SkincareProduct Where stepUse like :stepUse")
    List<SkincareProduct> getProductByStepUse(String stepUse);

    //List product name
    @Query("Select productName from skincareProduct ")
    Name loadName();

    //Select product based on time use
    @Query("SELECT productName FROM skincareProduct WHERE timeUse like :timeUse")
    public Name getProductByTime(String timeUse);

    //select product using all input from user
    @Query("SELECT productName FROM skincareProduct WHERE stepUse like :stepUse AND skinGoal like :skinGoal AND skinType like :skinType AND sensitiveSkin like :sensitiveSkin AND timeUse like :timeUse")
    public String getProductByInput(String stepUse, String skinGoal, String skinType, String sensitiveSkin, String timeUse);

    //Select product by using step in which product is used for
    @Query("SELECT productName from SkincareProduct Where stepUse like :stepUse")
    public String getSpfProduct(String stepUse);


    @Query("Select * from eveningRoutine")
    public List<EveningRoutine> getEveningRoutine();

    @Query("Select * from eveningRoutine where userID = :userId")
    public List<EveningRoutine> getEveningRoutineByUserId(long userId);

    @Update
    void updateEveningRoutine(EveningRoutine eveningRoutine);

    @Delete
    void deleteEveningRoutine(EveningRoutine eveningRoutine);

    @Query("Select uID from users")
    public int getUserID();

    @Query("Select * from users")
    List<User> getAllUser();

    @Query("Select username from users")
    String getUsername();

    @Query("Select fullName from users")
    String getFullname();

    @Query("Select password from users")
    String getPassword();

    @Query("Select username from users where username=(:username) AND password=(:password)")
    User logIn(String username, String password);

    @Update
    public void updateProduct(SkincareProduct skincareProduct);

    //delete product from database
    @Delete
    public void deleteProduct(SkincareProduct skincareProduct);

    @Delete
    void deleteUser(User user);

    public class Name{
        @ColumnInfo(name = "productName")
        public String productName;

        @Override
        public String toString(){
            return productName;
        }
    }

}
