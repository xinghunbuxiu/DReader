package com.duokan.reader.ui.reading;

import android.os.Handler;
import android.os.Message;

class ly extends Handler {
    final /* synthetic */ lx a;

    ly(lx lxVar) {
        this.a = lxVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.a();
                this.a.d.sendEmptyMessageDelayed(1, 1000);
                return;
            default:
                return;
        }
    }
}
