package com.duokan.reader.ui.reading;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aec extends BroadcastReceiver {
    final /* synthetic */ adm a;

    private aec(adm com_duokan_reader_ui_reading_adm) {
        this.a = com_duokan_reader_ui_reading_adm;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.HEADSET_PLUG".equals(action)) {
            if (intent.hasExtra("state") && intent.getIntExtra("state", 0) == 0) {
                this.a.b();
            }
        } else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.getProfileConnectionState(1) == 0) {
                this.a.b();
            }
        }
    }
}
