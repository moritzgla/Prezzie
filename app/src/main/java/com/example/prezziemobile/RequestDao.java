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
public interface RequestDao {
    @Insert
    void insert(Request request);

    @Update
    void update (Request request);

    @Delete
    void delete (Request request);

    @Query("DELETE FROM request_table")
    void deleteAll (Request request);

    @Query("SELECT * FROM request_table ORDER BY souvenir_id DESC")
    LiveData <List<Request>> getAllRequests();
}

*/
