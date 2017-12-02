package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class oj extends BroadcastReceiver {
    final /* synthetic */ PagesFrameView a;

    oj(PagesFrameView pagesFrameView) {
        this.a = pagesFrameView;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.a(this.a.getSystemTime());
    }
}
