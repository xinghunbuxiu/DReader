package com.duokan.reader.ui.reading;

import android.os.Handler;
import android.os.Message;

class mi extends Handler {
    /* renamed from: a */
    final /* synthetic */ mh f10626a;

    mi(mh mhVar) {
        this.f10626a = mhVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f10626a.mo2265a();
                this.f10626a.f9728d.sendEmptyMessageDelayed(1, 1000);
                return;
            default:
                return;
        }
    }
}
