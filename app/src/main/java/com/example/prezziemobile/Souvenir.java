/*
package com.example.prezziemobile;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "souvenir_table",
        foreignKeys ={
                @ForeignKey(entity = SouvenirInfo.class, parentColumns = "souvenir_name", childColumns = "souvenir_name", onDelete = CASCADE),
                @ForeignKey(entity = SouvenirInfo.class, parentColumns = "country_souvenir", childColumns = "country_souvenir", onDelete = CASCADE)})
public class Souvenir {

    @PrimaryKey
    @ColumnInfo(name = "souvenir_id")
    private int souvenirID;

    @ColumnInfo(name = "country_souvenir")
    private String countrySouvenir;

    @ColumnInfo(name = "souvenir_name")
    private String souvenirName;

    @ColumnInfo(name = "description_souvenir")
    private String descriptionSouvenir;

    public Souvenir(String countrySouvenir, String souvenirName, String descriptionSouvenir) {
        this.countrySouvenir = countrySouvenir;
        this.souvenirName = souvenirName;
        this.descriptionSouvenir = descriptionSouvenir;
    }

    public void setSouvenirID(int souvenirID) {
        this.souvenirID = souvenirID;
    }

    public int getSouvenirID() {
        return souvenirID;
    }

    public String getCountrySouvenir() {
        return countrySouvenir;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public String getDescriptionSouvenir() {
        return descriptionSouvenir;
    }
}
*/
