package com.swaiot.accountdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.swaiot.accountsdk.AccountInfo;
import com.swaiot.accountsdk.SwaiotAccountActivity;
import com.swaiot.accountsdk.TokenInfo;

public class MainActivity extends SwaiotAccountActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FIXME: change to right appkey and appsalt
                swaiotLogin("","");
            }
        });

        Button getAccountBtn = findViewById(R.id.getAccount);
        getAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tokenInfo!=null){
                    getAccountInfo();
                }else{
                    Log.w(getClass().getSimpleName(),"login first");
                }
            }
        });

        Button logoutBtn = findViewById(R.id.logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    @Override
    protected void onGetTokenFail(final int errCode, final String errMessage) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(null!=errMessage){
                    TextView resultTextView = findViewById(R.id.content);
                    resultTextView.setText("login failure,failure code = " + errCode + " failure message = "+errMessage);
                }

            }
        });
    }

    @Override
    protected void onGetTokenSuccess(final TokenInfo token) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(null!=token){
                    TextView resultTextView = findViewById(R.id.content);
                    resultTextView.setText("login success token.ak = "+ token.access_token+" token.rk= "+token.refresh_token+ " token.startTime =" +token.startTime + " token.expireIn = " + token.expires_in);
                }

            }
        });
    }

    @Override
    protected void onGetAccountInfoFail(final int errCode, final String errMessage) {
        Log.d(getClass().getSimpleName(),"java call onGetAccountInfoFail code = "+errCode + " msg = " + errMessage);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(null!=errMessage){
                    TextView resultTextView = findViewById(R.id.content);
                    resultTextView.setText("onGetAccountInfoFail failure,failure code = " + errCode + " failure message = "+errMessage);
                }
            }
        });

    }

    @Override
    protected void onGetAccountInfoSuccess(final AccountInfo accountInfo) {
        Log.d(getClass().getSimpleName(),"java call onAccountInfo accountInfo.openid = " + accountInfo.open_id);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(null!=accountInfo){
                    TextView resultTextView = findViewById(R.id.content);
                    resultTextView.setText("java call onAccountInfo accountInfo.openid = " + accountInfo.open_id);
                }
            }
        });

    }

    @Override
    protected String appKey() {
        //FIXME: change to right appkey
        return "";
    }


}
