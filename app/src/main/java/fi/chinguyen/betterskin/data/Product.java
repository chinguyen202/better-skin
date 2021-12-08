package fi.chinguyen.betterskin.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Product ID")
    private long id;

    @ColumnInfo(name = "Product name")
    private String name;

    @ColumnInfo(name = "Step")
    private String step;

    @ColumnInfo(name = "Time to use")
    private String timeUse;

    @ColumnInfo(name = "Skin goal")
    private String goal;

    @ColumnInfo(name = "Skin type")
    private String skinType;

    @ColumnInfo(name = "Sensitive Level")
    private boolean sensitiveLevel;

    @ColumnInfo(name = "Pregnant state")
    private boolean pregnant;

    public Product(long id, String name, String step, String timeUse, String goal, String skinType, boolean sensitiveLevel, boolean pregnant) {
        this.id = id;
        this.name = name;
        this.step = step;
        this.timeUse = timeUse;
        this.goal = goal;
        this.skinType = skinType;
        this.sensitiveLevel = sensitiveLevel;
        this.pregnant = pregnant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public boolean isSensitiveLevel() {
        return sensitiveLevel;
    }

    public void setSensitiveLevel(boolean sensitiveLevel) {
        this.sensitiveLevel = sensitiveLevel;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", step='" + step + '\'' +
                ", timeUse='" + timeUse + '\'' +
                ", goal='" + goal + '\'' +
                ", skinType='" + skinType + '\'' +
                ", sensitiveLevel=" + sensitiveLevel +
                ", pregnant=" + pregnant +
                '}';
    }
}