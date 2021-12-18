package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Create a table name skincareProduct to store skincare product
 */
@Entity(tableName = "skincareProduct")
public class SkincareProduct {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int productID;

    @ColumnInfo(name = "productName")
    @NonNull
    private String productName;

    @ColumnInfo(name = "stepUse")
    @NonNull
    private String stepUse;

    @ColumnInfo(name = "skinGoal")
    private String skinGoal;

    @ColumnInfo(name = "skinType")
    private String skinType;

    @ColumnInfo(name = "sensitiveSkin")
    private String sensitiveSkin;

    @ColumnInfo(name = "timeUse")
    private String timeUse;

    /**
     * Skincare product constructor
     * @param productID
     * @param productName
     * @param stepUse
     * @param skinGoal
     * @param skinType
     * @param sensitiveSkin
     * @param timeUse
     */
    public SkincareProduct(int productID, String productName, String stepUse, String skinGoal, String skinType, String sensitiveSkin, String timeUse) {
        this.productID = productID;
        this.productName = productName;
        this.stepUse = stepUse;
        this.skinGoal = skinGoal;
        this.skinType = skinType;
        this.sensitiveSkin = sensitiveSkin;
        this.timeUse = timeUse;
    }

    /**
     * Method to get product ID
     * @return product ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Method to set Product ID
     * @param productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Method to get product name
     * @return product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Method to set product name
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Method to get step use
     */
    public String getStepUse() {
        return stepUse;
    }

    /**
     * Method to set step use
     * @param stepUse
     */
    public void setStepUse(String stepUse) {
        this.stepUse = stepUse;
    }

    /**
     * Method to get user skin goal
     * @return user goal
     */
    public String getSkinGoal() {
        return skinGoal;
    }

    /**
     * Method to set user skin goal
     * @param skinGoal
     */
    public void setSkinGoal(String skinGoal) {
        this.skinGoal = skinGoal;
    }

    /**
     * Method to get user skin type
     * @return skin type
     */
    public String getSkinType() {
        return skinType;
    }

    /**
     * Method to set user skin type
     * @param skinType
     */
    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    /**
     * Method to get that user skin is sensitive or not
     * @return user skin is sensitive or not
     */
    public String getSensitiveSkin() {
        return sensitiveSkin;
    }

    /**
     * Method to set User sensitive skin
     * @param sensitiveSkin
     */
    public void setSensitiveSkin(String sensitiveSkin) {
        this.sensitiveSkin = sensitiveSkin;
    }

    /**
     * Method to get time use
     * @return time use
     */
    public String getTimeUse() {
        return timeUse;
    }

    /**
     * Method to set user time use
     * @param timeUse
     */
    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    /**
     * Method to set data to string
     * @return String contain product: ID, name, step use, skin: goal, type, sensitive and time use
     */
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
