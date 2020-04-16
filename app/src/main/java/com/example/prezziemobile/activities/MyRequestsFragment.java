package com.example.prezziemobile.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prezziemobile.R;
import com.example.prezziemobile.adapters.MyRequestsRecyclerAdapter;
import com.example.prezziemobile.model.RequestObject;
import com.example.prezziemobile.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MyRequestsFragment extends Fragment {

    private Fragment fragment = MyRequestsFragment.this;
    //private AppCompatTextView textViewName;
    private RecyclerView recyclerViewMyRequests;
    private List<RequestObject> listMyRequests;
    private MyRequestsRecyclerAdapter myRequestsRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //super.onCreate(savedInstanceState);
        //initViews();
        //initObjects();

        View view = inflater.inflate(R.layout.fragment_myrequests, container, false);
        recyclerViewMyRequests = view.findViewById(R.id.recyclerViewMyRequests);

        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listMyRequests = new ArrayList<>();
        myRequestsRecyclerAdapter = new MyRequestsRecyclerAdapter(listMyRequests);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewMyRequests.setLayoutManager(mLayoutManager);
        recyclerViewMyRequests.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMyRequests.setHasFixedSize(true);
        recyclerViewMyRequests.setAdapter(myRequestsRecyclerAdapter);
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

        String usernameMyRequests;

        SharedPreferences loginData = fragment.getActivity().getSharedPreferences("logindata", Context.MODE_PRIVATE);
        usernameMyRequests = loginData.getString("username", "Peter Lustig");

        listMyRequests.clear();
        listMyRequests.addAll(databaseHelper.getMyRequests(usernameMyRequests));
        myRequestsRecyclerAdapter.notifyDataSetChanged();
    }
}
