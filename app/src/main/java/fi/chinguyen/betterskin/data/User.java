package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int userID;

    @ColumnInfo(name = "username")
    @NonNull
    public String userName;

    @ColumnInfo(name = "password")
    @NonNull
    public String password;


}
