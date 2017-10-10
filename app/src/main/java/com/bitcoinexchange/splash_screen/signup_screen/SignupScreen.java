package com.bitcoinexchange.splash_screen.signup_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.bitcoinexchange.R;
import com.bitcoinexchange.splash_screen.security_pin_creation_screen.SecurityPinCreationScreen;
import com.bitcoinexchange.splash_screen.utils.Utilities;

/**
 * Created by Shashank Rawat on 10/8/2017.
 */

public class SignupScreen extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private EditText sponsorIdET, nameET, mobileNoET, emailET, passwordET, confirmPasswordET;
    private CheckBox tncCheckbox;
    private String sponsorIDValue, nameValue, mobileNoValue, emailValue, passwordValue, confirmPasswordValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        viewInitialisation();
    }

    private void viewInitialisation() {
        context = this;
        sponsorIdET = (EditText) findViewById(R.id.sponsorIdET);
        nameET = (EditText) findViewById(R.id.nameET);
        mobileNoET = (EditText) findViewById(R.id.mobileNoET);
        emailET = (EditText) findViewById(R.id.emailIDET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        confirmPasswordET = (EditText) findViewById(R.id.confirmPasswordET);
        tncCheckbox = (CheckBox) findViewById(R.id.tncCheckBox);

        findViewById(R.id.signupButton).setOnClickListener(this);
        findViewById(R.id.tncNav).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signupButton:
                sponsorIDValue = sponsorIdET.getText().toString();
                nameValue = nameET.getText().toString();
                mobileNoValue = mobileNoET.getText().toString();
                emailValue = emailET.getText().toString();
                passwordValue = passwordET.getText().toString();
                confirmPasswordValue = confirmPasswordET.getText().toString();
                validateDetails();
                break;

            case R.id.tncNav:
                Utilities.openLinkInBrowser(context, "http://www.google.com");
                break;
        }
    }

    private void validateDetails() {
        if(!TextUtils.isEmpty(sponsorIDValue)){
            if (!TextUtils.isEmpty(nameValue)){
                if(!TextUtils.isEmpty(mobileNoValue)){
                    if(!TextUtils.isEmpty(emailValue)){
                        if(!TextUtils.isEmpty(passwordValue)){
                            if(!TextUtils.isEmpty(confirmPasswordValue)){
                                if(mobileNoValue.length()==10){
                                    if(Utilities.validate(emailValue)){
                                        if(passwordValue.equals(confirmPasswordValue)){
                                            if(tncCheckbox.isChecked()){
                                                Intent securityPinIntent = new Intent(context, SecurityPinCreationScreen.class);
                                                startActivity(securityPinIntent);
                                                finish();
                                            }else {
                                                Snackbar.make(tncCheckbox, getString(R.string.err_tnc_accept), Snackbar.LENGTH_LONG).show();
                                            }
                                        }else {
                                            Snackbar.make(passwordET, getString(R.string.err_password_mismatch), Snackbar.LENGTH_LONG).show();
                                            passwordET.requestFocus();
                                        }
                                    }else {
                                        Snackbar.make(emailET, getString(R.string.err_email_validation), Snackbar.LENGTH_LONG).show();
                                        emailET.requestFocus();
                                    }
                                }else {
                                    Snackbar.make(mobileNoET, getString(R.string.err_phone_number_validation), Snackbar.LENGTH_LONG).show();
                                    mobileNoET.requestFocus();
                                }
                            }else {
                                Snackbar.make(confirmPasswordET, getString(R.string.err_confirm_password_entry), Snackbar.LENGTH_LONG).show();
                                confirmPasswordET.requestFocus();
                            }
                        }else {
                            Snackbar.make(passwordET, getString(R.string.err_password_entry), Snackbar.LENGTH_LONG).show();
                            passwordET.requestFocus();
                        }
                    }else {
                        Snackbar.make(emailET, getString(R.string.err_email_entry), Snackbar.LENGTH_LONG).show();
                        emailET.requestFocus();
                    }
                }else {
                    Snackbar.make(mobileNoET, getString(R.string.err_mobile_entry), Snackbar.LENGTH_LONG).show();
                    mobileNoET.requestFocus();
                }
            }else {
                Snackbar.make(nameET, getString(R.string.err_name_entry), Snackbar.LENGTH_LONG).show();
                nameET.requestFocus();
            }
        }else {
            Snackbar.make(sponsorIdET, getString(R.string.err_sponsor_id_entry), Snackbar.LENGTH_LONG).show();
            sponsorIdET.requestFocus();
        }
    }
}
