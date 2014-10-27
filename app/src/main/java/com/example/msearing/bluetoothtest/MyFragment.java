package com.example.msearing.bluetoothtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyFragment extends Fragment {

    View rootView;

    public MyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my, container, false);

        attachButton();

        return rootView;
    }

    private void attachButton() {
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(ClickListeners.buttonListener(getActivity()));
    }

}
