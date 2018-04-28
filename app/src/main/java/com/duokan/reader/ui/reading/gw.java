package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class gw extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ gu f10278a;

    gw(gu guVar) {
        this.f10278a = guVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f10278a.m14268a(this.f10278a.getSystemTime());
    }
}
