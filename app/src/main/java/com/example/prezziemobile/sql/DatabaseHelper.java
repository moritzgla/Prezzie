package com.example.prezziemobile.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.prezziemobile.model.Profile;
    //import com.example.prezziemobile.model.Customer;
import com.example.prezziemobile.model.RequestObject;
//import com.example.prezziemobile.model.Souvenir;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;

    // Database name
    private static final String DATABASE_NAME = "PrezzieMobile.db3";

    // Table names
    private static final String TABLE_PROFILE = "profile";
    //private static final String TABLE_CUSTOMER = "customer";
    private static final String TABLE_REQUEST = "request";
    private static final String TABLE_SOUVENIR = "souvenir";

    //Column names (all tables)
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_SOUVENIR_ID = "souvenir_id";

    //Column names (profile)
    private static final String COLUMN_EMAIL = "email";
    //private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_SUR_NAME = "sur_name";
    private static final String COLUMN_BIRTHDAY = "birthday";
    private static final String COLUMN_DESCRIPTION_USER = "description_user";
    private static final String COLUMN_IS_LOGGED_IN = "is_logged_in";
    private static final String COLUMN_COUNTRY_USER = "country_user";


    //Column names (request)
    private static final String COLUMN_REQUEST_ID = "request_id";
    //private static final String COLUMN_USERNAME = "username";
    //private static final String COLUMN_SOUVENIR_ID = "souvenir_id";
    private static final String COLUMN_AMOUNT = "amount";
    private static final String COLUMN_REWARD = "reward";
    private static final String COLUMN_STATUS = "status";

    //Column names (souvenir)
    //private static final String COLUMN_SOUVENIR_ID = "souvenir_id";
    private static final String COLUMN_SOUVENIR_NAME = "souvenir_name";
    private static final String COLUMN_COUNTRY_SOUVENIR = "country_souvenir";
    private static final String COLUMN_DESCRIPTION_SOUVENIR = "description_souvenir";
    private static final String COLUMN_PRICE = "price";


    //Create Profile Table
    private String CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_PROFILE + "("
            + COLUMN_USERNAME + " TEXT PRIMARY KEY," + COLUMN_EMAIL + " TEXT," + COLUMN_PASSWORD + " TEXT," + COLUMN_FIRST_NAME + " TEXT," + COLUMN_SUR_NAME + " TEXT," + COLUMN_BIRTHDAY +
            " DATE," + COLUMN_COUNTRY_USER + " TEXT," + COLUMN_DESCRIPTION_USER + " TEXT," + COLUMN_IS_LOGGED_IN + " BOOLEAN" + ")";

    /*Create Customer Table
    private String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
            + COLUMN_USERNAME + " TEXT PRIMARY KEY," + COLUMN_COUNTRY_USER + " TEXT," + ")";*/

    //Create Request Table
    private String CREATE_REQUEST_TABLE = "CREATE TABLE " + TABLE_REQUEST + "("
            + COLUMN_REQUEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USERNAME + " TEXT,"
            + COLUMN_SOUVENIR_ID + " INTEGER," + COLUMN_AMOUNT + " TEXT," + COLUMN_REWARD + " TEXT," + COLUMN_STATUS + " TEXT," +
            " FOREIGN KEY (" + COLUMN_USERNAME + ") REFERENCES " + TABLE_PROFILE + "(" + COLUMN_USERNAME + ") ON UPDATE CASCADE ON DELETE SET NULL," + " FOREIGN KEY (" + COLUMN_SOUVENIR_ID + ") REFERENCES " + TABLE_SOUVENIR + "(" + COLUMN_SOUVENIR_ID + ") ON UPDATE CASCADE ON DELETE SET NULL" + ")";

    //Create Souvenir Table
    private String CREATE_SOUVENIR_TABLE = "CREATE TABLE " + TABLE_SOUVENIR + "("
            + COLUMN_SOUVENIR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_COUNTRY_SOUVENIR + " TEXT,"
            + COLUMN_SOUVENIR_NAME + " TEXT," + COLUMN_DESCRIPTION_SOUVENIR + " TEXT," + COLUMN_PRICE + " TEXT" + ")";

    //Drop tables
    private String DROP_PROFILE_TABLE = "DROP TABLE IF EXISTS " + TABLE_PROFILE;
    //private String DROP_CUSTOMER_TABLE = "DROP TABLE IF EXISTS " + TABLE_CUSTOMER;
    private String DROP_REQUEST_TABLE = "DROP TABLE IF EXISTS " + TABLE_REQUEST;
    private String DROP_SOUVENIR_TABLE = "DROP TABLE IF EXISTS " + TABLE_SOUVENIR;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*public DatabaseHelper(Fragment fragment) {
        super(fragment, DATABASE_NAME, null, DATABASE_VERSION);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROFILE_TABLE);
        //db.execSQL(CREATE_CUSTOMER_TABLE);
        db.execSQL(CREATE_REQUEST_TABLE);
        db.execSQL(CREATE_SOUVENIR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_PROFILE_TABLE);
        //db.execSQL(DROP_CUSTOMER_TABLE);
        db.execSQL(DROP_REQUEST_TABLE);
        db.execSQL(DROP_SOUVENIR_TABLE);

        // Create tables again
        onCreate(db);
    }

    public void addProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, profile.getEmail());
        values.put(COLUMN_USERNAME, profile.getUsername());
        values.put(COLUMN_PASSWORD, profile.getPassword());
        values.put(COLUMN_FIRST_NAME, profile.getFirstName());
        values.put(COLUMN_SUR_NAME, profile.getSurName());
        values.put(COLUMN_BIRTHDAY, profile.getBirthday());
        values.put(COLUMN_COUNTRY_USER, profile.getCountryUser());
        values.put(COLUMN_DESCRIPTION_USER, profile.getDescriptionUser());

        // Inserting Row
        db.insert(TABLE_PROFILE, null, values);
        db.close();
    }

    public List<Profile> getAllProfiles() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_EMAIL,
                COLUMN_USERNAME,
                COLUMN_PASSWORD,
                COLUMN_FIRST_NAME,
                COLUMN_SUR_NAME,
                COLUMN_BIRTHDAY,
                COLUMN_COUNTRY_USER,
                COLUMN_DESCRIPTION_USER,
                COLUMN_IS_LOGGED_IN
        };
        // sorting orders
        String sortOrder =
                COLUMN_USERNAME + " ASC";
        List<Profile> profileList = new ArrayList<Profile>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order

        if (cursor.moveToFirst()) {
            do {
                Profile profile = new Profile();
                profile.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                profile.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                profile.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                profile.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
                profile.setSurName(cursor.getString(cursor.getColumnIndex(COLUMN_SUR_NAME)));
                profile.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDAY)));
                profile.setCountryUser(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_USER)));
                profile.setDescriptionUser(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_USER)));
                //profile.setLoggedIn(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(COLUMN_IS_LOGGED_IN))));
                // Adding user record to list
                profileList.add(profile);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return profileList;
    }



    //get one Profile
    public Profile getProfile(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USERNAME,
                COLUMN_EMAIL,
                COLUMN_FIRST_NAME,
                COLUMN_SUR_NAME,
                COLUMN_COUNTRY_USER,
                COLUMN_DESCRIPTION_USER,
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order

        Profile profile = new Profile();

        if (cursor.moveToFirst()) {


            profile.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
            profile.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
            profile.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
            profile.setSurName(cursor.getString(cursor.getColumnIndex(COLUMN_SUR_NAME)));
            profile.setDescriptionUser(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_USER)));
            profile.setDescriptionUser(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_USER)));

        }

        cursor.close();
        db.close();
        return profile;
    }


    public String getUsername(String email){

        // String of column to fetch
        String [] columns = {COLUMN_USERNAME};

        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order

        cursor.moveToFirst();

        String usernameHeader = cursor.getString(cursor.getColumnIndex("username"));


        cursor.close();
        db.close();

        return usernameHeader;
    }


    public void updateProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, profile.getEmail());
        //values.put(COLUMN_USERNAME, profile.getUsername());
        values.put(COLUMN_PASSWORD, profile.getPassword());
        values.put(COLUMN_FIRST_NAME, profile.getFirstName());
        values.put(COLUMN_SUR_NAME, profile.getSurName());
        values.put(COLUMN_BIRTHDAY, profile.getBirthday());
        values.put(COLUMN_DESCRIPTION_USER, profile.getDescriptionUser());
        //values.put(COLUMN_IS_LOGGED_IN, profile.isLoggedIn());

        // updating row
        db.update(TABLE_PROFILE, values, COLUMN_USERNAME + " = ?",
                new String[]{String.valueOf(profile.getUsername())});
        db.close();
    }

    public void deleteProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_PROFILE, COLUMN_USERNAME + " = ?",
                new String[]{String.valueOf(profile.getUsername())});
        db.close();
    }


    //CheckUsername
    public boolean checkUsername(String username) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USERNAME + " = ?";

        // selection argument
        String[] selectionArgs = {username};

        // query user table with condition
        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    //CheckProfile by username and password
    public boolean checkProfileUsername(String username, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USERNAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {username, password};

        // query user table with conditions
        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    //CheckEmail
    public boolean checkEmail(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USERNAME
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    //CheckProfile by email and password
    public boolean checkProfileEmail(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USERNAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        Cursor cursor = db.query(TABLE_PROFILE, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


    //Add a RequestObject

    public void addRequest(RequestObject requestObject) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valuesSouvenir = new ContentValues();

        //valuesSouvenir.put(COLUMN_SOUVENIR_ID, requestObject.getSouvenirId());
        valuesSouvenir.put(COLUMN_SOUVENIR_NAME, requestObject.getSouvenirName());
        valuesSouvenir.put(COLUMN_COUNTRY_SOUVENIR, requestObject.getCountrySouvenir());
        valuesSouvenir.put(COLUMN_DESCRIPTION_SOUVENIR, requestObject.getDescriptionSouvenir());
        valuesSouvenir.put(COLUMN_PRICE, requestObject.getPrice());

        db.insert(TABLE_SOUVENIR, null, valuesSouvenir);

        // String of column to fetch
        String selectQuery = "SELECT * FROM " + TABLE_SOUVENIR;

        db = this.getReadableDatabase();


        // query user table with condition
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToLast();

        int lastSouvenirId = cursor.getInt(cursor.getColumnIndex("souvenir_id"));


        cursor.close();

        db = this.getWritableDatabase();

        ContentValues valuesRequest = new ContentValues();

        //valuesRequest.put(COLUMN_REQUEST_ID, requestObject.getRequestId());
        valuesRequest.put(COLUMN_USERNAME, requestObject.getUsernameRequest());
        valuesRequest.put(COLUMN_SOUVENIR_ID, lastSouvenirId);
        valuesRequest.put(COLUMN_AMOUNT, requestObject.getAmount());
        valuesRequest.put(COLUMN_REWARD, requestObject.getReward());
        valuesRequest.put(COLUMN_STATUS, requestObject.getStatus());




        // Inserting Row
        db.insert(TABLE_REQUEST, null, valuesRequest);
        db.close();
    }


    /*//Get a list with All Requests
    public List<RequestObject> getAllRequests() {

        List<RequestObject> requestObjectList = new ArrayList<RequestObject>();


        String selectQuery = "SELECT r." + COLUMN_REQUEST_ID + ", r." + COLUMN_USERNAME + ", r." + COLUMN_AMOUNT + ", r." + COLUMN_REWARD + ", r." + COLUMN_STATUS + ", s." + COLUMN_SOUVENIR_NAME + ", s." + COLUMN_COUNTRY_SOUVENIR + ", s." + COLUMN_DESCRIPTION_SOUVENIR +
                " FROM " + TABLE_REQUEST + " r " +
                "INNER JOIN " + TABLE_SOUVENIR + " s ON s." + COLUMN_SOUVENIR_ID + " = r." + COLUMN_SOUVENIR_ID;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                RequestObject requestObject = new RequestObject();

                requestObject.setUsernameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                requestObject.setRequestId(cursor.getInt(cursor.getColumnIndex(COLUMN_REQUEST_ID)));
                requestObject.setAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_AMOUNT)));
                requestObject.setReward(cursor.getFloat(cursor.getColumnIndex(COLUMN_REWARD)));
                requestObject.setStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)));
                requestObject.setSouvenirName(cursor.getString(cursor.getColumnIndex(COLUMN_SOUVENIR_NAME)));
                requestObject.setCountrySouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_SOUVENIR)));
                requestObject.setDescriptionSouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_SOUVENIR)));

                // Adding user record to list
                requestObjectList.add(requestObject);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return requestObjectList;

    }

    //Get a list with My Requests
    public List<RequestObject> getMyRequests(String username) {

        List<RequestObject> myRequestObjectList = new ArrayList<RequestObject>();


        String selectQuery = "SELECT r." + COLUMN_REQUEST_ID + ", r." + COLUMN_USERNAME + ", r." + COLUMN_AMOUNT + ", r." + COLUMN_REWARD + ", r." + COLUMN_STATUS + ", s." + COLUMN_SOUVENIR_NAME + ", s." + COLUMN_COUNTRY_SOUVENIR + ", s." + COLUMN_DESCRIPTION_SOUVENIR +
                " FROM " + TABLE_REQUEST + " r " +
                "INNER JOIN " + TABLE_SOUVENIR + " s ON s." + COLUMN_SOUVENIR_ID + " = r." + COLUMN_SOUVENIR_ID +
                " WHERE r." + COLUMN_USERNAME + " = '" + username + "'";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                RequestObject requestObject = new RequestObject();

                requestObject.setUsernameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                requestObject.setRequestId(cursor.getInt(cursor.getColumnIndex(COLUMN_REQUEST_ID)));
                requestObject.setAmount(cursor.getInt(cursor.getColumnIndex(COLUMN_AMOUNT)));
                requestObject.setReward(cursor.getFloat(cursor.getColumnIndex(COLUMN_REWARD)));
                requestObject.setStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)));
                requestObject.setSouvenirName(cursor.getString(cursor.getColumnIndex(COLUMN_SOUVENIR_NAME)));
                requestObject.setCountrySouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_SOUVENIR)));
                requestObject.setDescriptionSouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_SOUVENIR)));

                // Adding user record to list
                myRequestObjectList.add(requestObject);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return myRequestObjectList;


    }*/

    //Get a list with All Requests
    public List<RequestObject> getAllRequests() {

        List<RequestObject> requestObjectList = new ArrayList<RequestObject>();
        RequestObject requestObject1 = new RequestObject();

        requestObject1.setFirstNameRequest("Moritz");
        requestObject1.setSurnameRequest("Glandien");
        requestObject1.setEmailRequest("morgla2000@gmail.com");
        requestObject1.setBirthdayRequest("02.03.2000");
        requestObject1.setCountryUserRequest("Germany");
        requestObject1.setDescriptionUserRequest("Coder");
        requestObject1.setUsernameRequest("moritz.gla");
        requestObject1.setRequestId(1);
        requestObject1.setAmount("1");
        requestObject1.setReward("2");
        requestObject1.setStatus("new");
        requestObject1.setSouvenirName("Cigar");
        requestObject1.setCountrySouvenir("Cuba");
        requestObject1.setDescriptionSouvenir("Original cigar from Cuba");
        requestObject1.setPrice("2");

        requestObjectList.add(requestObject1);

        RequestObject requestObject2 = new RequestObject();

        requestObject2.setFirstNameRequest("Moritz");
        requestObject2.setSurnameRequest("Glandien");
        requestObject2.setEmailRequest("morgla2000@gmail.com");
        requestObject2.setBirthdayRequest("02.03.2000");
        requestObject2.setCountryUserRequest("Germany");
        requestObject2.setDescriptionUserRequest("Coder");
        requestObject2.setUsernameRequest("moritz.gla");
        requestObject2.setRequestId(1);
        requestObject2.setAmount("1");
        requestObject2.setReward("6");
        requestObject2.setStatus("new");
        requestObject2.setSouvenirName("Sachertorte");
        requestObject2.setCountrySouvenir("Austria");
        requestObject2.setDescriptionSouvenir("Original Sachertorte from Vienna");
        requestObject2.setPrice("5");

        requestObjectList.add(requestObject2);


        String selectQuery = "SELECT r." + COLUMN_REQUEST_ID + ", r." + COLUMN_USERNAME + ", r." + COLUMN_AMOUNT +
                ", r." + COLUMN_REWARD + ", r." + COLUMN_STATUS + ", s." + COLUMN_SOUVENIR_NAME + ", s." + COLUMN_COUNTRY_SOUVENIR +
                ", s." + COLUMN_DESCRIPTION_SOUVENIR + ", s." + COLUMN_PRICE + ", p." + COLUMN_EMAIL + ", p." + COLUMN_FIRST_NAME + ", p." + COLUMN_SUR_NAME +
                ", p." + COLUMN_BIRTHDAY + ", p." + COLUMN_COUNTRY_USER + ", p." + COLUMN_DESCRIPTION_USER +
                " FROM " + TABLE_REQUEST + " r " +
                "INNER JOIN " + TABLE_SOUVENIR + " s ON s." + COLUMN_SOUVENIR_ID + " = r." + COLUMN_SOUVENIR_ID +
                " INNER JOIN " + TABLE_PROFILE + " p ON p." + COLUMN_USERNAME + " = r." + COLUMN_USERNAME;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                RequestObject requestObject = new RequestObject();

                requestObject.setFirstNameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
                requestObject.setSurnameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_SUR_NAME)));
                requestObject.setEmailRequest(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                requestObject.setBirthdayRequest(cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDAY)));
                requestObject.setCountryUserRequest(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_USER)));
                requestObject.setDescriptionUserRequest(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_USER)));
                requestObject.setUsernameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                requestObject.setRequestId(cursor.getInt(cursor.getColumnIndex(COLUMN_REQUEST_ID)));
                requestObject.setAmount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                requestObject.setReward(cursor.getString(cursor.getColumnIndex(COLUMN_REWARD)));
                requestObject.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                requestObject.setStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)));
                requestObject.setSouvenirName(cursor.getString(cursor.getColumnIndex(COLUMN_SOUVENIR_NAME)));
                requestObject.setCountrySouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_SOUVENIR)));
                requestObject.setDescriptionSouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_SOUVENIR)));

                // Adding user record to list
                requestObjectList.add(requestObject);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return requestObjectList;

    }

    //Get a list with My Requests
    public List<RequestObject> getMyRequests(String username) {

        List<RequestObject> myRequestObjectList = new ArrayList<RequestObject>();


        String selectQuery = "SELECT r." + COLUMN_REQUEST_ID + ", r." + COLUMN_USERNAME + ", r." + COLUMN_AMOUNT +
                ", r." + COLUMN_REWARD + ", r." + COLUMN_STATUS + ", s." + COLUMN_SOUVENIR_NAME + ", s." + COLUMN_COUNTRY_SOUVENIR +
                ", s." + COLUMN_DESCRIPTION_SOUVENIR + ", s." + COLUMN_PRICE + ", p." + COLUMN_EMAIL + ", p." + COLUMN_FIRST_NAME + ", p." + COLUMN_SUR_NAME +
                ", p." + COLUMN_BIRTHDAY + ", p." + COLUMN_COUNTRY_USER + ", p." + COLUMN_DESCRIPTION_USER +
                " FROM " + TABLE_REQUEST + " r " +
                "INNER JOIN " + TABLE_SOUVENIR + " s ON s." + COLUMN_SOUVENIR_ID + " = r." + COLUMN_SOUVENIR_ID +
                " INNER JOIN " + TABLE_PROFILE + " p ON p." + COLUMN_USERNAME + " = r." + COLUMN_USERNAME +
                " WHERE r." + COLUMN_USERNAME + " = '" + username + "'";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                RequestObject requestObject = new RequestObject();

                requestObject.setFirstNameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
                requestObject.setSurnameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_SUR_NAME)));
                requestObject.setEmailRequest(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                requestObject.setBirthdayRequest(cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDAY)));
                requestObject.setCountryUserRequest(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_USER)));
                requestObject.setDescriptionUserRequest(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_USER)));
                requestObject.setUsernameRequest(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                requestObject.setRequestId(cursor.getInt(cursor.getColumnIndex(COLUMN_REQUEST_ID)));
                requestObject.setAmount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)));
                requestObject.setReward(cursor.getString(cursor.getColumnIndex(COLUMN_REWARD)));
                requestObject.setPrice(cursor.getString(cursor.getColumnIndex(COLUMN_PRICE)));
                requestObject.setStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)));
                requestObject.setSouvenirName(cursor.getString(cursor.getColumnIndex(COLUMN_SOUVENIR_NAME)));
                requestObject.setCountrySouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY_SOUVENIR)));
                requestObject.setDescriptionSouvenir(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_SOUVENIR)));

                // Adding user record to list
                myRequestObjectList.add(requestObject);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return myRequestObjectList;

    }





    public String getOneRequest() {



        String selectQuery = "SELECT r." + COLUMN_REQUEST_ID + ", r." + COLUMN_USERNAME + ", r." + COLUMN_AMOUNT +
                ", r." + COLUMN_REWARD + ", r." + COLUMN_STATUS + ", s." + COLUMN_SOUVENIR_NAME + ", s." + COLUMN_COUNTRY_SOUVENIR +
                ", s." + COLUMN_DESCRIPTION_SOUVENIR + ", s." + COLUMN_PRICE + ", p." + COLUMN_EMAIL + ", p." + COLUMN_FIRST_NAME + ", p." + COLUMN_SUR_NAME +
                ", p." + COLUMN_BIRTHDAY + ", p." + COLUMN_COUNTRY_USER + ", p." + COLUMN_DESCRIPTION_USER +
                " FROM " + TABLE_REQUEST + " r " +
                "INNER JOIN " + TABLE_SOUVENIR + " s ON s." + COLUMN_SOUVENIR_ID + " = r." + COLUMN_SOUVENIR_ID +
                " INNER JOIN " + TABLE_PROFILE + " p ON p." + COLUMN_USERNAME + " = r." + COLUMN_USERNAME;


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        String souvenirName = "Test";
        if (cursor.moveToFirst()) {
            do {
                souvenirName = cursor.getString(cursor.getColumnIndex("souvenir_name"));
            } while (cursor.moveToNext());

        }





        cursor.close();
        db.close();

        return souvenirName;

    }
}


