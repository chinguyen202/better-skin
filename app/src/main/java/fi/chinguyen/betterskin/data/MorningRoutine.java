package fi.chinguyen.betterskin.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Create a table to store user's morning routine
 */
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

    /**
     * get morning routine ID
     * @return morning routine ID
     */
    public int getAmId() {
        return amId;
    }

    /**
     * set morning routine ID
     * @param amId
     */
    public void setAmId(int amId) {
        this.amId = amId;
    }

    /**
     * get cleanser product
     * @return String cleanser
     */
    public String getCleanser() {
        return cleanser;
    }

    /**
     * set cleanser
     * @param cleanser
     */
    public void setCleanser(String cleanser) {
        this.cleanser = cleanser;
    }

    /**
     * get morning treat
     * @return String treat
     */
    public String getTreat() {
        return treat;
    }

    /**
     * set morning treat
     * @param treat
     */
    public void setTreat(String treat) {
        this.treat = treat;
    }

    /**
     * get morning moisturizer
     * @return String moisturizer
     */
    public String getMoisturizer() {
        return moisturizer;
    }

    /**
     * set moisturizer
     * @param moisturizer
     */
    public void setMoisturizer(String moisturizer) {
        this.moisturizer = moisturizer;
    }

    /**
     * get SPF (UV protection)
     * @return String spf
     */
    public String getSpf() {
        return spf;
    }

    /**
     * set morning spf
     * @param spf
     */
    public void setSpf(String spf) {
        this.spf = spf;
    }

    /**
     * get user ID
     * @return int userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * set user ID
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
