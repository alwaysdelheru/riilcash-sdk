package com.vitraining.riilcashsample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vitraining.riilcashsdk.api.RiilCash;
import com.vitraining.riilcashsdk.api.RiilCashCallback;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    String URL = "https://common.remcash.com/";

    ActionBar actionBar;
    Toolbar toolbar;

    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;

    private static final String MyPREFERENCES = "MyPrefs" ;
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initUi();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        setTitle("Riilcash SDK Sample");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    private void initUi() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // set default login
        edtUsername.setText("akhdaniel2@gmail.com");
        edtPassword.setText("1");
    }

    public void btnLoginClick(View view) {
        login();
    }

    private void login() {
        RiilCash riilCash = new RiilCash(this, URL);
        riilCash.login(edtUsername.getText().toString(), edtPassword.getText().toString(), new RiilCashCallback() {
            // login success
            public void onSuccess(String response){
                Log.i(TAG, "login--> onSuccess: " + response);
                try {
                    JSONObject mainObject = new JSONObject((response));
                    String message = mainObject.getString("message");

                    JSONObject dataObject = mainObject.getJSONObject("data");
                    Integer id = dataObject.getInt("id");
                    String public_id = dataObject.getString("public");
                    String token = dataObject.getString("token");
                    String name = dataObject.getString("name");

                    Log.i(TAG, "onSuccess--> public_id: " + public_id);
                    Log.i(TAG, "onSuccess--> token: " + token);
                    Log.i(TAG, "onSuccess--> name: " + name);

                    saveLoginData(id, public_id, token, name);
                    openDashboard();

                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                } catch (JSONException je) {
                    Log.e(TAG, "unexpected JSON exception", je);
                    Toast.makeText(MainActivity.this, je.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            // login failed or error
            public void onError(String response){
                Log.e(TAG, "login--> onError: " + response);
                try {
                    JSONObject mainObject = new JSONObject((response));
                    String message = mainObject.getString("message");

                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                } catch (JSONException je) {
                    Log.e(TAG, "unexpected JSON exception", je);
                    Toast.makeText(MainActivity.this, je.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openDashboard() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    private void saveLoginData(Integer id, String public_id, String token, String name) {
        setPreference("USER_ID", String.valueOf(id));
        setPreference("PUBLIC", public_id);
        setPreference("TOKEN", token);
        setPreference("EMAIL", edtUsername.getText().toString());
        setPreference("NAME", edtUsername.getText().toString());
    }

    private void setPreference(String key, String value){
        sharedPreferences = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


}
