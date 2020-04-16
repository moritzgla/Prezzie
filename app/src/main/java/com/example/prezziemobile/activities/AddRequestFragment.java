package com.example.prezziemobile.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.example.prezziemobile.R;
import com.example.prezziemobile.helpers.InputValidationAddRequest;
import com.example.prezziemobile.model.Profile;
import com.example.prezziemobile.model.RequestObject;
import com.example.prezziemobile.sql.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.example.prezziemobile.activities.MainActivity;

public class AddRequestFragment extends Fragment implements View.OnClickListener {

    private AppCompatTextView textViewUsernameAdd;
    private Fragment fragment = AddRequestFragment.this;
    //private Class<MainActivity> activity = MainActivity.class;
    //Context applicationContext = MainActivity.getApplicationContext();

    private ScrollView scrollView;

    private TextInputLayout textInputLayoutSouvenirName;
    private TextInputLayout textInputLayoutCountrySouvenir;
    private TextInputLayout textInputLayoutAmount;
    private TextInputLayout textInputLayoutPrice;
    private TextInputLayout textInputLayoutReward;
    private TextInputLayout textInputLayoutStatus;
    private TextInputLayout textInputLayoutDescriptionSouvenir;


    private TextInputEditText textInputEditTextSouvenirName;
    private TextInputEditText textInputEditTextCountrySouvenir;
    private TextInputEditText textInputEditTextAmount;
    private TextInputEditText textInputEditTextPrice;
    private TextInputEditText textInputEditTextReward;
    private TextInputEditText textInputEditTextStatus;
    private TextInputEditText textInputEditTextDescriptionSouvenir;

    private AppCompatButton buttonSubmit;

    private DatabaseHelper databaseHelper;
    private RequestObject requestObject;
    private InputValidationAddRequest inputValidationAddRequest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_request_fragment, container, false);



        scrollView = view.findViewById(R.id.scrollViewAddRequest);

        textInputLayoutSouvenirName = view.findViewById(R.id.textInputLayoutSouvenirName);
        textInputLayoutCountrySouvenir = view.findViewById(R.id.textInputLayoutCountrySouvenir);
        textInputLayoutAmount = view.findViewById(R.id.textInputLayoutAmount);
        textInputLayoutPrice = view.findViewById(R.id.textInputLayoutPrice);
        textInputLayoutReward = view.findViewById(R.id.textInputLayoutReward);
        textInputLayoutStatus = view.findViewById(R.id.textInputLayoutStatus);
        textInputLayoutDescriptionSouvenir = view.findViewById(R.id.textInputLayoutDescriptionSouvenir);

        textInputEditTextSouvenirName = view.findViewById(R.id.textInputEditTextSouvenirName);
        textInputEditTextCountrySouvenir = view.findViewById(R.id.textInputEditTextCountrySouvenir);
        textInputEditTextAmount = view.findViewById(R.id.textInputEditTextAmount);
        textInputEditTextPrice = view.findViewById(R.id.textInputEditTextPrice);
        textInputEditTextReward = view.findViewById(R.id.textInputEditTextReward);
        textInputEditTextStatus = view.findViewById(R.id.textInputEditTextStatus);
        textInputEditTextDescriptionSouvenir = view.findViewById(R.id.textInputEditTextDescriptionSouvenir);

        buttonSubmit = view.findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(getActivity());
        requestObject = new RequestObject();
        inputValidationAddRequest = new InputValidationAddRequest(getActivity());


        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSubmit) {
            postDataToSQLite();
        }
    }

    private void postDataToSQLite(){

        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextSouvenirName, textInputLayoutSouvenirName, getString(R.string.error_message_empty))) {
            return;
        }
        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextCountrySouvenir, textInputLayoutCountrySouvenir, getString(R.string.error_message_empty))) {
            return;
        }
        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextAmount, textInputLayoutAmount, getString(R.string.error_message_empty))) {
            return;
        }
        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextPrice, textInputLayoutPrice, getString(R.string.error_message_empty))) {
            return;
        }
        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextReward, textInputLayoutReward, getString(R.string.error_message_empty))) {
            return;
        }
        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextStatus, textInputLayoutStatus, getString(R.string.error_message_empty))) {
            return;
        }
        if (!inputValidationAddRequest.isInputEditTextFilled(textInputEditTextDescriptionSouvenir, textInputLayoutDescriptionSouvenir, getString(R.string.error_message_empty))) {
            return;
        }
            String usernameAdd;

            SharedPreferences loginData = fragment.getActivity().getSharedPreferences("logindata", Context.MODE_PRIVATE);
            usernameAdd = loginData.getString("username", "Peter Lustig");

            requestObject.setUsernameRequest(usernameAdd);
            requestObject.setSouvenirName(textInputEditTextSouvenirName.getText().toString().trim());
            requestObject.setCountrySouvenir(textInputEditTextCountrySouvenir.getText().toString().trim());
            requestObject.setAmount(textInputEditTextAmount.getText().toString().trim());
            requestObject.setPrice(textInputEditTextPrice.getText().toString().trim());
            requestObject.setReward(textInputEditTextReward.getText().toString().trim());
            requestObject.setStatus(textInputEditTextStatus.getText().toString().trim());
            requestObject.setDescriptionSouvenir(textInputEditTextDescriptionSouvenir.getText().toString().trim());

            databaseHelper.addRequest(requestObject);

            Snackbar.make(scrollView, getString(R.string.success_message_add), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();




    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextSouvenirName.setText(null);
        textInputEditTextCountrySouvenir.setText(null);
        textInputEditTextAmount.setText(null);
        textInputEditTextPrice.setText(null);
        textInputEditTextReward.setText(null);
        textInputEditTextStatus.setText(null);
        textInputEditTextDescriptionSouvenir.setText(null);

    }
}
