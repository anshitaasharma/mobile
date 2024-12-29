package com.example.medicineapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String medicineName = intent.getStringExtra("medicineName");
        Toast.makeText(context, "Time to take your medicine: " + medicineName, Toast.LENGTH_LONG).show();
    }
}
