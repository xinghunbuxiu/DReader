package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class js extends BroadcastReceiver {
    final /* synthetic */ jp a;

    js(jp jpVar) {
        this.a = jpVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action)) {
            this.a.c();
        }
    }
}
