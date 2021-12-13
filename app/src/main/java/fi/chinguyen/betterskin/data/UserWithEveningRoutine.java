package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;


//Intersection class to connect user with evening routine
public class UserWithEveningRoutine {
    @Embedded
    public UserEntity user;
    @Relation(parentColumn = "uId", entityColumn = "userId")
    public List<EveningRoutine> eveningRoutines;

    public List<EveningRoutine> getEveningRoutines(){
        return eveningRoutines;
    }

    @NonNull
    @Override
    public String toString(){
        return user.getName();

    }
}
