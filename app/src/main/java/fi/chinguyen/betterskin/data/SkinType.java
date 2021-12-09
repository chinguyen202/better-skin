package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SkinType")
public class SkinType{

    @PrimaryKey
    private int productID;

    @ColumnInfo(name = "skin_type")
    @NonNull
    private String skinType;

    public SkinType(int productID, @NonNull String skinType) {
        this.productID = productID;
        this.skinType = skinType;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @NonNull
    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(@NonNull String skinType) {
        this.skinType = skinType;
    }

    @Override
    public String toString() {
        return "SkinType{" +
                "productID=" + productID +
                ", skinType='" + skinType + '\'' +
                '}';
    }
}
