package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ot extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ PagesFrameView f10757a;

    ot(PagesFrameView pagesFrameView) {
        this.f10757a = pagesFrameView;
    }

    public void onReceive(Context context, Intent intent) {
        this.f10757a.m12432a(this.f10757a.getSystemTime());
    }
}
