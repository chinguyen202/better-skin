package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * table to store evening routine
 */

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

    /**
     * Method to get evening routine ID
     * @return int pmId
     */
    public int getPmId() {
        return pmId;
    }

    /**
     * set evening routine ID
     * @param pmId
     */
    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    /**
     * get evening cleanser
     * @return String cleanser
     */
    public String getCleanser() {
        return cleanser;
    }

    /**
     * set evening cleanser
     * @param cleanser
     */
    public void setCleanser(String cleanser) {
        this.cleanser = cleanser;
    }

    /**
     * get evening treat
     * @return String treat
     */
    public String getTreat() {
        return treat;
    }

    /**
     * set evening treat treat
     * @param treat
     */
    public void setTreat(String treat) {
        this.treat = treat;
    }

    /**
     * get evening moisturizer
     * @return
     */
    public String getMoisturizer() {
        return moisturizer;
    }

    /**
     * set evening moisturizer
     * @param moisturizer
     */
    public void setMoisturizer(String moisturizer) {
        this.moisturizer = moisturizer;
    }

    /**
     * get user ID
     * @return int User ID
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

    /**
     * convert to String
     * @return String contain evening routine data: pmId, cleanser, treat, moisturizer, userID
     */
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
