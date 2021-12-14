package fi.chinguyen.betterskin.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "morningRoutines")
public class MorningRoutine {

    @PrimaryKey(autoGenerate = true)
    int amId;

    @ColumnInfo(name = "Cleanser")
    String cleanser;

    @ColumnInfo(name = "Treat")
    String treat;

    @ColumnInfo(name = "Moisturizer")
    String moisturizer;

    @ColumnInfo(name = "SPF")
    String spf;

    @ColumnInfo(name = "userID")
    int userID;

    public int getAmId() {
        return amId;
    }

    public void setAmId(int amId) {
        this.amId = amId;
    }

    public String getCleanser() {
        return cleanser;
    }

    public void setCleanser(String cleanser) {
        this.cleanser = cleanser;
    }

    public String getTreat() {
        return treat;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }

    public String getMoisturizer() {
        return moisturizer;
    }

    public void setMoisturizer(String moisturizer) {
        this.moisturizer = moisturizer;
    }

    public String getSpf() {
        return spf;
    }

    public void setSpf(String spf) {
        this.spf = spf;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
