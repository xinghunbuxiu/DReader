package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class jr extends BroadcastReceiver {
    final /* synthetic */ jp a;

    jr(jp jpVar) {
        this.a = jpVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.MEDIA_MOUNTED".equals(intent.getAction())) {
            this.a.c();
        }
    }
}
