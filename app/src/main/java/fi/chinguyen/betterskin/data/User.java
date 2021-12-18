package fi.chinguyen.betterskin.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Create a table name users to store user data
 */
@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    Integer uID;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "fullName")
    String fullName;

    /**
     * Method to get user ID
     * @return
     */


    public Integer getuID() {
        return uID;
    }
    /**
     * Method to get user name
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method to set user name
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method to get Password
     * @return
     */
    public String getPassword() {
        return password;
    }


    /**
     * Method to set Password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to get full name
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Method to set full name
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

