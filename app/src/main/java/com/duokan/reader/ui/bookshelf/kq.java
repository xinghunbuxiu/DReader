package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class kq extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ kn f6720a;

    kq(kn knVar) {
        this.f6720a = knVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action)) {
            this.f6720a.mo1721e();
        }
    }
}
