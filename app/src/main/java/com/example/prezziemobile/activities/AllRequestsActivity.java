/*
package com.example.prezziemobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.prezziemobile.R;
import com.example.prezziemobile.adapters.RequestsRecyclerAdapter;
import com.example.prezziemobile.model.RequestObject;
import com.example.prezziemobile.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class AllRequestsActivity extends AppCompatActivity {

    private AppCompatActivity activity = AllRequestsActivity.this;
    //private AppCompatTextView textViewName;
    private RecyclerView recyclerViewRequests;
    private List<RequestObject> listRequests;
    private RequestsRecyclerAdapter requestsRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_allrequests);
        initViews();
        initObjects();
    }

    private void initViews() {
        recyclerViewRequests = (RecyclerView) findViewById(R.id.recyclerViewRequests);
    }

    private void initObjects() {
        listRequests = new ArrayList<>();
        requestsRecyclerAdapter = new RequestsRecyclerAdapter(listRequests);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewRequests.setLayoutManager(mLayoutManager);
        recyclerViewRequests.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRequests.setHasFixedSize(true);
        recyclerViewRequests.setAdapter(requestsRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        getDataFromSQLite();
    }

    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listRequests.clear();
                listRequests.addAll(databaseHelper.getAllRequests());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                requestsRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
*/
