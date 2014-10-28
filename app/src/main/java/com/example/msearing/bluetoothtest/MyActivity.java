package com.example.msearing.bluetoothtest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class MyActivity extends Activity {
    Map<String, Fragment> fragments;
    private static final int REQUEST_ENABLE_BT = 87;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new MyFragment())
                    .commit();
        }

        setupFragments();
    }

    private void setupFragments() {
        fragments = new HashMap<String, Fragment>();
        fragments.put("BLE", new BLEFragment());
        fragments.put("Home", new MyFragment());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "Bluetooth is set up!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "error or user sucks", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                Toast.makeText(this, "wat", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    public void switchFragment(String targetFragmentName) {
        Fragment targetFragment = fragments.get(targetFragmentName);
        if (targetFragment != null) {
            getFragmentManager().beginTransaction().replace(R.id.container, targetFragment).commit();
        } else {
            Toast.makeText(this, "Bluetooth is set up!", Toast.LENGTH_SHORT).show();
        }

//        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
