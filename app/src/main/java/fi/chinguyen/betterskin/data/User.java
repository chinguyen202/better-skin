package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private long uID;

    @ColumnInfo(name = "fullName")
    @NonNull
    private String fullName;

    @ColumnInfo(name = "username")
    @NonNull
    private String username;

    @ColumnInfo(name = "password")
    @NonNull
    private String password;

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    public User(long userID, @NonNull String fullName, @NonNull String username, @NonNull String password, String phoneNumber) {
        this.uID = userID;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public long getUserID() {
        return uID;
    }

    public void setUserID(int userID) {
        this.uID = userID;
    }

    @NonNull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + uID +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}