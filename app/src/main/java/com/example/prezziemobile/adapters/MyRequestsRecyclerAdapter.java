package com.example.prezziemobile.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prezziemobile.R;
import com.example.prezziemobile.model.RequestObject;

import java.util.List;

public class MyRequestsRecyclerAdapter extends RecyclerView.Adapter<MyRequestsRecyclerAdapter.MyRequestViewHolder> {


    private List<RequestObject> listRequests;

    public MyRequestsRecyclerAdapter(List<RequestObject> listRequests) {
        this.listRequests = listRequests;
    }

    @Override
    public MyRequestsRecyclerAdapter.MyRequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_myrequest_recycler, parent, false);

        return new MyRequestsRecyclerAdapter.MyRequestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyRequestsRecyclerAdapter.MyRequestViewHolder holder, int position) {
        holder.textViewSouvenirName.setText(listRequests.get(position).getSouvenirName());
        holder.textViewCountrySouvenir.setText(listRequests.get(position).getCountrySouvenir());
        holder.textViewUsernameRequest.setText(listRequests.get(position).getUsernameRequest());
        holder.textViewCountryUserRequest.setText(listRequests.get(position).getCountryUserRequest());
        holder.textViewPrice.setText(listRequests.get(position).getPrice());
        holder.textViewAmount.setText(listRequests.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
        Log.v(RequestsRecyclerAdapter.class.getSimpleName(),""+listRequests.size());
        return listRequests.size();
    }


    /**
     * ViewHolder class
     */

    public class MyRequestViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewSouvenirName;
        public AppCompatTextView textViewCountrySouvenir;
        public AppCompatTextView textViewUsernameRequest;
        public AppCompatTextView textViewCountryUserRequest;
        public AppCompatTextView textViewPrice;
        public AppCompatTextView textViewAmount;

        public MyRequestViewHolder(View view) {
            super(view);
            textViewSouvenirName = view.findViewById(R.id.textViewSouvenirName);
            textViewCountrySouvenir = view.findViewById(R.id.textViewCountrySouvenir);
            textViewUsernameRequest = view.findViewById(R.id.textViewUsernameRequest);
            textViewCountryUserRequest = view.findViewById(R.id.textViewCountryUserRequest);
            textViewPrice = view.findViewById(R.id.textViewPrice);
            textViewAmount = view.findViewById(R.id.textViewAmount);
        }
    }
}



