package com.example.msearing.bluetoothtest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClickListeners {
    public static View.OnClickListener buttonListener(final Activity activity) {
        // stuff to do when button is clicked
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "you did button!", Toast.LENGTH_SHORT).show();
                ((MyActivity) activity).switchFragment("BLE");
            }
        };
    }
}
