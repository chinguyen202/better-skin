package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

////Intersection class to connect user with morning routine
public class MorningRoutineOfUser {
    @Embedded public User user;
    @Relation(
            parentColumn = "uID",
            entityColumn = "userID"
    )
    public MorningRoutine morningRoutine;
}
