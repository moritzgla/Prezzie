/*
package com.example.prezziemobile;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfileDao {

    @Insert
    void insert(Profile profile);

    @Update
    void update (Profile profile);

    @Delete
    void delete (Profile profile);

    @Query("DELETE FROM profile_table")
    void deleteAll (Profile profile);

    @Query("SELECT * FROM profile_table ORDER BY username DESC")
    LiveData<List<Profile>> getAllProfiles();

    @Query("SELECT * FROM profile_table WHERE profile_table.email LIKE :emailentry")
    Profile getProfile(String emailentry);
}
*/
