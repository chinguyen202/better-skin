package fi.chinguyen.betterskin.data;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

////Intersection class to connect user with evening routine
public class UserWithMorningRoutine {
    @Embedded
    public UserEntity user;
    @Relation(parentColumn = "uId", entityColumn = "userId")
    public List<MorningRoutine> morningRoutines;

    public List<MorningRoutine> getMorningRoutines(){
        return morningRoutines;
    }

    @NonNull
    @Override
    public String toString(){
        return user.getName();

    }
}
