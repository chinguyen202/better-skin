package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MorningRoutineDao {

    @Insert
    void addMorningRoutine(MorningRoutine morningRoutine);

    @Query("Select * from MorningRoutine")
    public List<MorningRoutine> getMorningRoutine();

    @Query("Select * from MorningRoutine where userID = :userId")
    public List<MorningRoutine> getMorningRoutineByUserId(long userId);

    @Update
    void updateMorningRoutine(MorningRoutine morningRoutine);

    @Delete
    void deleteMorningRoutine(MorningRoutine morningRoutine);

}
