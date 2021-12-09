package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "Product")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int productID;

    @ColumnInfo(name = "product_name")
    @NonNull
    private String productName;

    @ColumnInfo(name = "step_use")
    @NonNull
    private String stepUse;

    public Product(int productID, String productName, String stepUse) {
        this.productID = productID;
        this.productName = productName;
        this.stepUse = stepUse;
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

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", stepUse='" + stepUse + '\'' +
                '}';
    }
}

