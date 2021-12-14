package fi.chinguyen.betterskin.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eveningRoutine")
public class EveningRoutine {

    @PrimaryKey(autoGenerate = true)
    private long morningRId;

    private String cleanser;
    private String treat;
    private String moisturizer;
    private long userID;

    public EveningRoutine(long morningRId, String cleanser, String treat, String moisturizer, long userID) {
        this.morningRId = morningRId;
        this.cleanser = cleanser;
        this.treat = treat;
        this.moisturizer = moisturizer;
        this.userID = userID;
    }

    public long getMorningRId() {
        return morningRId;
    }

    public void setMorningRId(long morningRId) {
        this.morningRId = morningRId;
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

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "EveningRoutine{" +
                "morningRId=" + morningRId +
                ", cleanser='" + cleanser + '\'' +
                ", treat='" + treat + '\'' +
                ", moisturizer='" + moisturizer + '\'' +
                ", userID=" + userID +
                '}';
    }
}
