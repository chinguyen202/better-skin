package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eveningRoutine")
public class EveningRoutine {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int pmId;

    @ColumnInfo(name = "Cleanser")
    private String cleanser;

    @ColumnInfo(name = "Treat")
    private String treat;

    @ColumnInfo(name = "Moisturizer")
    private String moisturizer;

    private int userID;

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "EveningRoutine{" +
                "pmId=" + pmId +
                ", cleanser='" + cleanser + '\'' +
                ", treat='" + treat + '\'' +
                ", moisturizer='" + moisturizer + '\'' +
                ", userID=" + userID +
                '}';
    }
}
