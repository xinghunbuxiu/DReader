package com.duokan.reader.ui.bookshelf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class jq extends BroadcastReceiver {
    final /* synthetic */ jp a;

    jq(jp jpVar) {
        this.a = jpVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.c();
    }
}
