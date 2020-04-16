package com.example.prezziemobile.activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prezziemobile.R;
import com.example.prezziemobile.adapters.RequestsRecyclerAdapter;
import com.example.prezziemobile.model.RequestObject;
import com.example.prezziemobile.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllRequestsFragment extends Fragment {
    private Fragment fragment = AllRequestsFragment.this;
    //private AppCompatTextView textViewName;
    private RecyclerView recyclerViewRequests;
    private List<RequestObject> listRequests;
    private RequestsRecyclerAdapter requestsRecyclerAdapter;
    private DatabaseHelper databaseHelper;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //super.onCreate(savedInstanceState);
        //initViews();
        //initObjects();

        View view = inflater.inflate(R.layout.fragment_allrequests, container, false);
        recyclerViewRequests = view.findViewById(R.id.recyclerViewRequests);


        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listRequests = new ArrayList<>();
        requestsRecyclerAdapter = new RequestsRecyclerAdapter(listRequests);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewRequests.setLayoutManager(mLayoutManager);
        recyclerViewRequests.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRequests.setHasFixedSize(true);
        recyclerViewRequests.setAdapter(requestsRecyclerAdapter);
        databaseHelper = new DatabaseHelper(getActivity());

        getDataFromSQLite();

    }




  /*  *//**
     * This method is to initialize views
     *//*
    private void initViews() {
        recyclerViewRequests = (RecyclerView) getView().findViewById(R.id.recyclerViewRequests);
    }*/
/*
    *//**
     * This method is to initialize objects to be used
     *//*
    private void initObjects() {
        listRequests = new ArrayList<>();
        requestsRecyclerAdapter = new RequestsRecyclerAdapter(listRequests);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewRequests.setLayoutManager(mLayoutManager);
        recyclerViewRequests.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRequests.setHasFixedSize(true);
        recyclerViewRequests.setAdapter(requestsRecyclerAdapter);
        databaseHelper = new DatabaseHelper(getActivity());

        getDataFromSQLite();
    }*/

   /* @SuppressLint("StaticFieldLeak")
    private class GetDataTask extends AsyncTask <Void, Void, Void>{

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
    }

    *//**
     * This method is to fetch all user records from SQLite
     *//*
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.

        new GetDataTask().execute();
    }*/

    private void getDataFromSQLite() {
        listRequests.clear();
        listRequests.addAll(databaseHelper.getAllRequests());
        requestsRecyclerAdapter.notifyDataSetChanged();
    }
}
