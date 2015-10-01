package com.unicauca.ubicuas.blecentral;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {

    static final ParcelUuid SERVICE_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");
    static final UUID DESCRIPTOR_UUID = UUID.fromString("0000b82d-0000-1000-8000-00805f9b34fb");
    static final UUID CHARACTERISTIC_UUID = UUID.fromString("0000b83d-0000-1000-8000-00805f9b34fb");

    Switch state;
    TextView txtState;
    ListView list;

    BluetoothManager manager;
    BluetoothAdapter adapter;
    BluetoothLeScanner scanner;
    MyScanCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtState = (TextView) findViewById(R.id.txt_state);

        state = (Switch) findViewById(R.id.state);
        state.setOnClickListener(this);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        manager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        adapter = manager.getAdapter();
        scanner = adapter.getBluetoothLeScanner();
    }


    //region ListView Listener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    //endregion

    //region Switch Listener
    @Override
    public void onClick(View v) {

    }
    //endregion

    public void startScan(){
        ScanSettings settings = new ScanSettings.Builder().build();
        List<ScanFilter> filters = new ArrayList<>();

        ScanFilter filter = new ScanFilter.Builder()
                .setServiceUuid(SERVICE_UUID)
                .build();

        filters.add(filter);

        callback = new MyScanCallback();

        scanner.startScan(filters,settings,callback);

    }

    public void stopScan(){
        if(callback!=null){
            scanner.stopScan(callback);
            callback=null;
        }
    }

    public class MyScanCallback extends ScanCallback{

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    }


}
