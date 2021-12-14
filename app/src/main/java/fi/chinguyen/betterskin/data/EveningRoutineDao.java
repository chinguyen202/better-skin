package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EveningRoutineDao {

    @Insert
    void addEveningRoutine(EveningRoutine eveningRoutine);

    @Query("Select * from eveningRoutine")
    public List<MorningRoutine> getMorningRoutine();

    @Query("Select * from eveningRoutine where userID = :userId")
    public List<MorningRoutine> getEveningRoutineByUserId(long userId);

    @Update
    void updateEveningRoutine(EveningRoutine eveningRoutine);

    @Delete
    void deleteEveningRoutine(EveningRoutine eveningRoutine);

}
