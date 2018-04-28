package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class os extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ PagesFrameView f10756a;

    os(PagesFrameView pagesFrameView) {
        this.f10756a = pagesFrameView;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            this.f10756a.m12426a(intent.getIntExtra("level", 0));
        }
    }
}
