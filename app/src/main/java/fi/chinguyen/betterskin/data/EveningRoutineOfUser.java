package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;


//Intersection class to connect user with evening routine
public class EveningRoutineOfUser {
    @Embedded public User user;
    @Relation(
            parentColumn = "uID",
            entityColumn = "userID"
    )
    public EveningRoutine eveningRoutine;
}
