package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "skincareProduct")
public class SkincareProduct {

    @PrimaryKey(autoGenerate = true)
    private int productID;

    private String productName;
    private String stepUse;
    private String skinGoal;
    private String skinType;
    private String timeUse;

    public SkincareProduct(int productID, @NonNull String productName, @NonNull String stepUse, String skinGoal, String skinType, String timeUse) {
        this.productID = productID;
        this.productName = productName;
        this.stepUse = stepUse;
        this.skinGoal = skinGoal;
        this.skinType = skinType;
        this.timeUse = timeUse;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    @NonNull
    public String getStepUse() {
        return stepUse;
    }

    public void setStepUse(@NonNull String stepUse) {
        this.stepUse = stepUse;
    }

    public String getSkinGoal() {
        return skinGoal;
    }

    public void setSkinGoal(String skinGoal) {
        this.skinGoal = skinGoal;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    @Override
    public String toString() {
        return "SkincareProduct{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", stepUse='" + stepUse + '\'' +
                ", skinGoal='" + skinGoal + '\'' +
                ", skinType='" + skinType + '\'' +
                ", timeUse='" + timeUse + '\'' +
                '}';
    }
}
