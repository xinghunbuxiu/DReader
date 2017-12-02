package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class gr extends BroadcastReceiver {
    final /* synthetic */ gp a;

    gr(gp gpVar) {
        this.a = gpVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.a(this.a.getSystemTime());
    }
}
