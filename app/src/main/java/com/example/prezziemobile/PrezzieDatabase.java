/*
package com.example.prezziemobile;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class, Customer.class, Request.class, Souvenir.class, SouvenirInfo.class}, version = 1)
public abstract class PrezzieDatabase extends RoomDatabase {
    private static PrezzieDatabase instance;

    public abstract ProfileDao profileDao();
    public abstract CustomerDao customerDao();
    public abstract RequestDao requestDao();
    public abstract SouvenirDao souvenirDao();
    public abstract SouvenirInfoDao souvenirInfoDao();

    public static synchronized PrezzieDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PrezzieDatabase.class, "prezzie_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
*/
