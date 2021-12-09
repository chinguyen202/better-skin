package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProductName {
    @PrimaryKey
    @NonNull
    String productName;


}
