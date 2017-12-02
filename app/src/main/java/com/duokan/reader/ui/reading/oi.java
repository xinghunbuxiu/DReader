package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class oi extends BroadcastReceiver {
    final /* synthetic */ PagesFrameView a;

    oi(PagesFrameView pagesFrameView) {
        this.a = pagesFrameView;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            this.a.a(intent.getIntExtra("level", 0));
        }
    }
}
