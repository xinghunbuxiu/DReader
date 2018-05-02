package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class kp extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ kn f6719a;

    kp(kn knVar) {
        this.f6719a = knVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.MEDIA_MOUNTED".equals(intent.getAction())) {
            this.f6719a.mo1721e();
        }
    }
}
