/*
package com.example.prezziemobile;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "request_table",
        foreignKeys ={
                @ForeignKey(entity = Customer.class, parentColumns = "username", childColumns = "username", onDelete = CASCADE),
        @ForeignKey(entity = Souvenir.class, parentColumns = "souvenir_id", childColumns = "souvenir_id", onDelete = CASCADE)})
public class Request {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "souvenir_id")
    private String souvenirID;

    @PrimaryKey
    private String username;

    private int amount;
    private int reward;
    private String status;

    public Request(String username, int amount, int reward, String status) {
        this.username = username;
        this.amount = amount;
        this.reward = reward;
        this.status = status;
    }

    public void setSouvenirID(String souvenirID) {
        this.souvenirID = souvenirID;
    }

    public String getSouvenirID() {
        return souvenirID;
    }

    public String getUsername() {
        return username;
    }

    public int getAmount() {
        return amount;
    }

    public int getReward() {
        return reward;
    }

    public String getStatus() {
        return status;
    }
}
*/
