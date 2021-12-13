package fi.chinguyen.betterskin.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "morningRoutine")
public class MorningRoutine {

    @PrimaryKey(autoGenerate = true)
    private long morningRId;

    private String cleanser;
    private String treat;
    private String moisturizer;
    private String spf;
    private long userID;

    public MorningRoutine(long morningRId, String cleanser, String treat, String moisturizer, String spf, long userID) {
        this.morningRId = morningRId;
        this.cleanser = cleanser;
        this.treat = treat;
        this.moisturizer = moisturizer;
        this.spf = spf;
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

    public String getSpf() {
        return spf;
    }

    public void setSpf(String spf) {
        this.spf = spf;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "MorningRoutine{" +
                "morningRId=" + morningRId +
                ", cleanser='" + cleanser + '\'' +
                ", treat='" + treat + '\'' +
                ", moisturizer='" + moisturizer + '\'' +
                ", spf='" + spf + '\'' +
                ", userID=" + userID +
                '}';
    }
}
