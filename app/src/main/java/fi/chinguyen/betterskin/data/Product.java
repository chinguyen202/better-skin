package fi.chinguyen.betterskin.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Product ID")
    private int productID;

    @ColumnInfo(name = "Product name")
    private String productName;

    @ColumnInfo(name = "Time to use")
    private String timeUse;

    @ColumnInfo(name = "Step")
    private String stepUse;

    @ColumnInfo(name = "Skin type")
    private String skinGoal;

    @ColumnInfo(name = "Skin goal")
    private String skinType;

    @ColumnInfo(name = "Sensitive Level")
    private boolean sensitiveSkin;

    @ColumnInfo(name = "Pregnant state")
    private boolean pregnant;

    public Product(int productID, String productName, String timeUse, String stepUse, String skinGoal, String skinType, boolean sensitiveSkin, boolean pregnant) {
        this.productID = productID;
        this.productName = productName;
        this.timeUse = timeUse;
        this.stepUse = stepUse;
        this.skinGoal = skinGoal;
        this.skinType = skinType;
        this.sensitiveSkin = sensitiveSkin;
        this.pregnant = pregnant;
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

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
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

    public boolean isSensitiveSkin() {
        return sensitiveSkin;
    }

    public void setSensitiveSkin(boolean sensitiveSkin) {
        this.sensitiveSkin = sensitiveSkin;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", timeUse='" + timeUse + '\'' +
                ", stepUse='" + stepUse + '\'' +
                ", skinGoal='" + skinGoal + '\'' +
                ", skinType='" + skinType + '\'' +
                ", sensitiveSkin=" + sensitiveSkin +
                ", pregnant=" + pregnant +
                '}';
    }
}

