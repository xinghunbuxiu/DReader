package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class lz extends BroadcastReceiver {
    final /* synthetic */ lx a;

    lz(lx lxVar) {
        this.a = lxVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.g();
    }
}
