package com.vitraining.riilcashsample;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vitraining.riilcashsdk.api.RiilCash;
import com.vitraining.riilcashsdk.api.RiilCashCallback;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    String URL = "https://common.remcash.com/";

    ActionBar actionBar;
    Toolbar toolbar;

    EditText edtAction;
    Button btnRun;
    TextView txtResult;
    SpinnerDialog spinnerDialog;

    String result;

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
        edtAction = findViewById(R.id.edtAction);
        btnRun = findViewById(R.id.btnRun);
        txtResult = findViewById(R.id.txtResult);
        edtAction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.edtAction) {
            edtAction.setError(null);
            loadSpinnerAction();
            spinnerDialog.showSpinerDialog();
        }
    }

    private void loadSpinnerAction() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Login");
        items.add("Create Account");
        items.add("List Country");
        items.add("List Currency");
        items.add("List Mto");
        items.add("List Bank");
        items.add("List Provider");
        items.add("List User");
        items.add("Get User");
        items.add("Check Account");
        items.add("People By Name");
        items.add("People By Parent");
        items.add("Forgot Password");
        items.add("Single People By Name");
        items.add("Deposit");
        items.add("Get Deposit");
        items.add("Process Deposit");
        items.add("Withdrawal");
        items.add("Get Withdrawal");
        items.add("Process Withdrawal");
        items.add("Get Bank Transfer");
        items.add("Process Bank Transfer");
        items.add("Create Payment");
        items.add("Send Money");

        spinnerDialog = new SpinnerDialog(this, items, "Select Action");

        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Log.e(TAG, "item: " + item);

                edtAction.setText(item);

                hideKeyboard();
            }
        });
    }

    private void hideKeyboard() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void btnRunClick(View view) {
        switch (edtAction.getText().toString()) {
            case "Login":
                login();
                return;

            case "Create Account":
                createAccount();
                return;

            case "List Country":
                country();
                return;

            case "List Currency":
                currency();
                return;

            case "List Mto":
                mto();
                return;

            case "List Bank":
                bank();
                return;

            case "List Provider":
                provider();
                return;

            case "List User":
                listUser();
                return;

            case "Get User":
                getUser();
                return;

            case "Check Account":
                checkAccount();
                return;

            case "People By Name":
                peopleByName();
                return;

            case "People By Parent":
                peopleByParent();
                return;

            case "Forgot Password":
                forgotPassword();
                return;

            case "Single People By Name":
                singlePeopleByName();
                return;

            case "Deposit":
                deposits();
                return;

            case "Get Deposit":
                getDeposit();
                return;

            case "Process Deposit":
                processDeposit();
                return;

            case "Withdrawal":
                withdrawals();
                return;

            case "Get Withdrawal":
                getWithdrawal();
                return;

            case "Process Withdrawal":
                processWithdrawal();
                return;

            case "Get Bank Transfer":
                getBankTransfer();
                return;

            case "Process Bank Transfer":
                processBankTransfer();
                return;

            case "Create Payment":
                createPayment();
                return;

            case "Send Money":
                sendMoney();
                return;

            default:
        }
    }

    private void login() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.login(this, URL, "akhdaniel2@gmail.com", "1", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "login--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "login--> onError: " + response);
            }
        });
    }

    private void createAccount() {
        RiilCash riilCash = new RiilCash(this);
        result = riilCash.peoples(
                this,
                    URL,
                "heru",
                "remcash.com",
                "alwaysdelheru@gmail.com",
                "087812341234",
                "National ID",
                "1234567890",
                "1997-06-06",
                "Indonesia",
                1,
                "123456",
                1234,
                "user");
        txtResult.setText(result);
        Log.e(TAG, "createAccount--> result: " + result);
    }

    private void country() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.country(this, URL, "lll", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "country--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "country--> onError: " + response);
            }
        });
    }

    private void currency() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.currency(this, URL, "lll", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "country--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "country--> onError: " + response);
            }
        });
    }

    private void mto() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.mto(this, URL, "lll", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "mto--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "mto--> onError: " + response);
            }
        });
    }

    private void bank() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.bank(this, URL, "lll", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "bank--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "bank--> onError: " + response);
            }
        });
    }

    private void provider() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.provider(this, URL, "lll", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "provider--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "provider--> onError: " + response);
            }
        });
    }

    private void listUser() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.listUser(this, URL, "lll", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "listUser--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "listUser--> onError: " + response);
            }
        });
    }

    private void getUser() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.getUser(this, URL, "lll", "123", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getUser--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getUser--> onError: " + response);
            }
        });
    }

    private void checkAccount() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.checkAccount(this, URL, "lll", "123", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "checkAccount--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "checkAccount--> onError: " + response);
            }
        });
    }

    private void peopleByName() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.peopleByName(this, URL, "lll", "heru@gmail.com", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "peopleByName--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "peopleByName--> onError: " + response);
            }
        });
    }

    private void peopleByParent() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.peopleByParent(this, URL, "lll", 123, new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "peopleByParent--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "peopleByParent--> onError: " + response);
            }
        });
    }

    private void forgotPassword() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.forgotPassword(this, URL, "lll", "heru@gmail.com", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "forgotPassword--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "forgotPassword--> onError: " + response);
            }
        });
    }

    private void singlePeopleByName() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.singlePeopleByName(this, URL, "lll", "heru@gmail.com", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "forgotPassword--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "forgotPassword--> onError: " + response);
            }
        });
    }

    private void deposits() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.deposits(
                this,
                URL,
                "lll",
                "GCD2CPMHHYLOBMOHSWO2HOWYMYOA7LX..ULIKXMHTJ32",
                Double.parseDouble("100"),
                "USD",
                0,
                "e3r432490423n",
                "e3r432490423",
                new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onError: " + response);
            }
        });
    }

    private void getDeposit() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.getDeposit(this, URL, "lll", "GCD2CQ36G4SQTPEUULIKXMHTJ32", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onError: " + response);
            }
        });
    }

    private void processDeposit() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.processDeposit(this, URL, "lll", "e3r432490423", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onError: " + response);
            }
        });
    }

    private void withdrawals() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.withdrawals(
                this,
                URL,
                "lll",
                "GCD2CPMHHYLOBMOHSWO2HOWYMYOA7LX..ULIKXMHTJ32",
                Double.parseDouble("100"),
                "USD",
                0,
                "e3r432490423n",
                "e3r432490423",
                new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onError: " + response);
            }
        });
    }

    private void getWithdrawal() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.getWithdrawal(this, URL, "lll", "GCD2CQ36G4SQTPEUULIKXMHTJ32", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getWithdrawal--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getWithdrawal--> onError: " + response);
            }
        });
    }

    private void processWithdrawal() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.processWithdrawal(this, URL, "lll", "e3r432490423", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onError: " + response);
            }
        });
    }

    private void getBankTransfer() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.getBankTransfer(this, URL, "lll", "GCD2CQ36G4SQTPEUULIKXMHTJ32", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getWithdrawal--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getWithdrawal--> onError: " + response);
            }
        });
    }

    private void processBankTransfer() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.processBankTransfer(this, URL, "lll", "e3r432490423", new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "getDeposit--> onError: " + response);
            }
        });
    }

    private void createPayment() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.createPayment(
                this,
                URL,
                "lll",
                "GCD2CPMHHYLOLXBTTQ36G4SQTPEUULIKXMHTJ32",
                "GC7457834758TQ36G4SQTPEUULIKXMHTJ32",
                Double.parseDouble("100"),
                "USD",
                "XYX43584854300",
                new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onError: " + response);
            }
        });
    }

    private void sendMoney() {
        RiilCash riilCash = new RiilCash(this);
        riilCash.sendMoney(
                this,
                URL,
                "lll",
                "GCD2CPMHHYLOLXBTTQ36G4SQTPEUULIKXMHTJ32",
                "GC7457834758TQ36G4SQTPEUULIKXMHTJ32",
                Double.parseDouble("100"),
                Double.parseDouble("1400"),
                "USD",
                "IDR",
                "XYX43584854300",
                0,
                0,
                "2019-09-02 09:23:20",
                new RiilCashCallback() {
            public void onSuccess(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onSuccess: " + response);
            }

            public void onError(String response){
                txtResult.setText(response);
                Log.e(TAG, "deposits--> onError: " + response);
            }
        });
    }
}
