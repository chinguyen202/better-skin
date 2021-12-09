package fi.chinguyen.betterskin.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Skin Goal")
public class SkinGoal {

    @PrimaryKey
    private int productID;

    @ColumnInfo(name = "skin_goal")
    private String skinGoal;

    public SkinGoal(int productID, String skinGoal) {
        this.productID = productID;
        this.skinGoal = skinGoal;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSkinGoal() {
        return skinGoal;
    }

    public void setSkinGoal(String skinGoal) {
        this.skinGoal = skinGoal;
    }

    @Override
    public String toString() {
        return "SkinGoal{" +
                "productID=" + productID +
                ", skinGoal='" + skinGoal + '\'' +
                '}';
    }
}
