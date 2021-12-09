package fi.chinguyen.betterskin.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Time to use")
public class Time{

    @PrimaryKey
    private int productID;

    @ColumnInfo(name = "time_use")
    private String timeUse;

    public Time(int productID, String timeUse) {
        this.productID = productID;
        this.timeUse = timeUse;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    @Override
    public String toString() {
        return "Time{" +
                "productID=" + productID +
                ", timeUse='" + timeUse + '\'' +
                '}';
    }
}
