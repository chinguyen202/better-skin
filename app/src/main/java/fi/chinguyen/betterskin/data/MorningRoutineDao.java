package fi.chinguyen.betterskin.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MorningRoutineDao {

    @Insert
    void insertAMRoutine(MorningRoutine morningRoutine);


}
