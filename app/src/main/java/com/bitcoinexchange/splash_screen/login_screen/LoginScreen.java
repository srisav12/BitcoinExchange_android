package com.bitcoinexchange.splash_screen.login_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bitcoinexchange.R;
import com.bitcoinexchange.splash_screen.dashboard_screen.DashboardScreen;
import com.bitcoinexchange.splash_screen.forget_password_screen.ForgetPasswordScreen;
import com.bitcoinexchange.splash_screen.forget_user_id_screen.ForgetUserIDScreen;
import com.bitcoinexchange.splash_screen.security_pin_login_screen.SecurityPinLoginScreen;

/**
 * Created by Shashank Rawat on 10/8/2017.
 */

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private EditText userIdET, passwordET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        viewInitialisation();
    }

    private void viewInitialisation() {
        context = this;
        userIdET = (EditText) findViewById(R.id.userIdET);
        passwordET = (EditText) findViewById(R.id.passwordET);

        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.forgetPassworNav).setOnClickListener(this);
        findViewById(R.id.forgetUserIdNav).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.loginButton:
                if(!TextUtils.isEmpty(userIdET.getText().toString())){
                    if(!TextUtils.isEmpty(passwordET.getText().toString())){
                        Intent securityPinIntent = new Intent(context, SecurityPinLoginScreen.class);
                        startActivity(securityPinIntent);
                        finish();
                    }else {
                        Snackbar.make(passwordET, getString(R.string.err_password_entry), Snackbar.LENGTH_LONG).show();
                        passwordET.requestFocus();
                    }
                }else {
                    Snackbar.make(userIdET, getString(R.string.err_user_id_entry), Snackbar.LENGTH_LONG).show();
                    userIdET.requestFocus();
                }
                break;

            case R.id.forgetPassworNav:
                Intent forgetPasswordIntent = new Intent(context, ForgetPasswordScreen.class);
                startActivity(forgetPasswordIntent);
                break;

            case R.id.forgetUserIdNav:
                Intent forgetUserIdIntent = new Intent(context, ForgetUserIDScreen.class);
                startActivity(forgetUserIdIntent);
                break;
        }
    }
}
