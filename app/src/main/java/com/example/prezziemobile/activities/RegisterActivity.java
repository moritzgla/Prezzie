package com.example.prezziemobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.example.prezziemobile.R;
import com.example.prezziemobile.helpers.InputValidation;
import com.example.prezziemobile.model.Profile;
import com.example.prezziemobile.sql.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import android.text.Editable;
import android.text.TextWatcher;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private ScrollView scrollView;

    private TextInputLayout textInputLayoutFirstName;
    private TextInputLayout textInputLayoutSurname;
    private TextInputLayout textInputLayoutBirthday;
    private TextInputLayout textInputLayoutCountry;
    private TextInputLayout textInputLayoutDescriptionUser;
    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutEmailRegister;
    private TextInputLayout textInputLayoutPasswordRegister;
    private TextInputLayout textInputLayoutPasswordConfirm;



    private TextInputEditText textInputEditTextFirstName;
    private TextInputEditText textInputEditTextSurname;
    private TextInputEditText textInputEditTextBirthday;
    private TextInputEditText textInputEditTextCountry;
    private TextInputEditText textInputEditTextDescriptionUser;
    private TextInputEditText textInputEditTextUsername;
    private TextInputEditText textInputEditTextEmailRegister;
    private TextInputEditText textInputEditTextPasswordRegister;
    private TextInputEditText textInputEditTextPasswordConfirm;



    private AppCompatButton buttonRegister;
    private AppCompatTextView loginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerscroll);

        //getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        scrollView = findViewById(R.id.scrollViewRegister);

        textInputLayoutFirstName = findViewById(R.id.textInputLayoutFirstName);
        textInputLayoutSurname = findViewById(R.id.textInputLayoutSurname);
        textInputLayoutBirthday = findViewById(R.id.textInputLayoutBirthday);
        textInputLayoutCountry = findViewById(R.id.textInputLayoutCountry);
        textInputLayoutDescriptionUser = findViewById(R.id.textInputLayoutDescriptionUser);
        textInputLayoutUsername = findViewById(R.id.textInputLayoutUsername);
        textInputLayoutEmailRegister = findViewById(R.id.textInputLayoutEmailRegister);
        textInputLayoutPasswordRegister = findViewById(R.id.textInputLayoutPasswordRegister);
        textInputLayoutPasswordConfirm = findViewById(R.id.textInputLayoutPasswordConfirm);

        textInputEditTextFirstName = findViewById(R.id.textInputEditTextFirstName);
        textInputEditTextSurname = findViewById(R.id.textInputEditTextSurname);
        textInputEditTextBirthday = findViewById(R.id.textInputEditTextBirthday);
        textInputEditTextCountry = findViewById(R.id.textInputEditTextCountry);
        textInputEditTextDescriptionUser = findViewById(R.id.textInputEditTextDescriptionUser);
        textInputEditTextUsername = findViewById(R.id.textInputEditTextUsername);
        textInputEditTextEmailRegister = findViewById(R.id.textInputEditTextEmailRegister);
        textInputEditTextPasswordRegister = findViewById(R.id.textInputEditTextPasswordRegister);
        textInputEditTextPasswordConfirm = findViewById(R.id.textInputEditTextPasswordConfirm);


        buttonRegister = findViewById(R.id.buttonRegister);

        loginLink = findViewById(R.id.loginLink);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        buttonRegister.setOnClickListener(this);
        loginLink.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        profile = new Profile();

    }


    /**
     * This implemented method is to listen the click on view
     *
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonRegister:
                postDataToSQLite();
                break;

            case R.id.loginLink:
                // Navigate to LoginActivity
                Intent intentLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentLogin);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextFirstName, textInputLayoutFirstName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextSurname, textInputLayoutSurname, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextBirthday, textInputLayoutBirthday, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextCountry, textInputLayoutCountry, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextDescriptionUser, textInputLayoutDescriptionUser, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextUsername, textInputLayoutUsername, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmailRegister, textInputLayoutEmailRegister, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmailRegister, textInputLayoutEmailRegister, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPasswordRegister, textInputLayoutPasswordRegister, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPasswordRegister, textInputEditTextPasswordConfirm,
                textInputLayoutPasswordConfirm, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkEmail(textInputEditTextEmailRegister.getText().toString().trim())) {

            profile.setFirstName(textInputEditTextFirstName.getText().toString().trim());
            profile.setSurName(textInputEditTextSurname.getText().toString().trim());
            profile.setBirthday(textInputEditTextBirthday.getText().toString().trim());
            profile.setCountryUser(textInputEditTextCountry.getText().toString().trim());
            profile.setDescriptionUser(textInputEditTextDescriptionUser.getText().toString().trim());
            profile.setUsername(textInputEditTextUsername.getText().toString().trim());
            profile.setEmail(textInputEditTextEmailRegister.getText().toString().trim());
            profile.setPassword(textInputEditTextPasswordRegister.getText().toString().trim());

            databaseHelper.addProfile(profile);

            Intent registeredIntent = new Intent(RegisterActivity.this, LoginActivity.class);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(scrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
            startActivity(registeredIntent);

        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(scrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextFirstName.setText(null);
        textInputEditTextSurname.setText(null);
        textInputEditTextBirthday.setText(null);
        textInputEditTextCountry.setText(null);
        textInputEditTextDescriptionUser.setText(null);
        textInputEditTextUsername.setText(null);
        textInputEditTextEmailRegister.setText(null);
        textInputEditTextPasswordRegister.setText(null);
        textInputEditTextPasswordConfirm.setText(null);
    }
}
