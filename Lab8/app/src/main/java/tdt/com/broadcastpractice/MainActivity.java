package tdt.com.broadcastpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NetWorkChangeReceiver receiver;
    private TextView message;
    private Button btnOpenWifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handleEvent();
        checkInternetConnection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registBroadcastReceiver();
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver,filter);
    }

    private void registBroadcastReceiver() {
        IntentFilter filter = new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(broadcastReceiver,filter);
    }

    private void checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnectedOrConnecting()){
            message.setText("WIFI ON");
        }
        else{
            message.setText("Application need wifi connection");
        }
    }

    private void handleEvent() {
        btnOpenWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWifiSetting();
            }
        });

    }

    private void goToWifiSetting() {
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    private void initView() {
        btnOpenWifi = findViewById(R.id.btnGoToWifi);
        message = findViewById(R.id.message1);
    }

    private BroadcastReceiver broadcastReceiver = new NetWorkChangeReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            checkInternetConnection();
        }
    };
}
