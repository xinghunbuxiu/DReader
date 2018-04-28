package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class gv extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ gu f10277a;

    gv(gu guVar) {
        this.f10277a = guVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            this.f10277a.m14267a(intent.getIntExtra("level", 0));
        }
    }
}
