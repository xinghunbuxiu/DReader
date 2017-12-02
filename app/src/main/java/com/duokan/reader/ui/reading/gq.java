package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class gq extends BroadcastReceiver {
    final /* synthetic */ gp a;

    gq(gp gpVar) {
        this.a = gpVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            this.a.a(intent.getIntExtra("level", 0));
        }
    }
}
