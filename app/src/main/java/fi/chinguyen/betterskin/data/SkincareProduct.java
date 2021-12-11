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
    private String sensitiveSkin;
    private String timeUse;

    public SkincareProduct(int productID, String productName, String stepUse, String skinGoal, String skinType, String sensitiveSkin, String timeUse) {
        this.productID = productID;
        this.productName = productName;
        this.stepUse = stepUse;
        this.skinGoal = skinGoal;
        this.skinType = skinType;
        this.sensitiveSkin = sensitiveSkin;
        this.timeUse = timeUse;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStepUse() {
        return stepUse;
    }

    public void setStepUse(String stepUse) {
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

    public String getSensitiveSkin() {
        return sensitiveSkin;
    }

    public void setSensitiveSkin(String sensitiveSkin) {
        this.sensitiveSkin = sensitiveSkin;
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
                ", sensitiveSkin='" + sensitiveSkin + '\'' +
                ", timeUse='" + timeUse + '\'' +
                '}';
    }
}
