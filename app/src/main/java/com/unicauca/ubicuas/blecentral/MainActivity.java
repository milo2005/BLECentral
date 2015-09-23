package com.unicauca.ubicuas.blecentral;

import android.app.Activity;
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

import java.util.UUID;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {

    static final ParcelUuid SERVICE_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");
    static final UUID DESCRIPTOR_UUID = UUID.fromString("0000b82d-0000-1000-8000-00805f9b34fb");
    static final UUID CHARACTERISTIC_UUID = UUID.fromString("0000b83d-0000-1000-8000-00805f9b34fb");

    Switch state;
    TextView txtState;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtState = (TextView) findViewById(R.id.txt_state);

        state = (Switch) findViewById(R.id.state);
        state.setOnClickListener(this);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);
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
}
