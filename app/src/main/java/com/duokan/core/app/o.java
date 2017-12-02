package com.duokan.core.app;

import android.os.Handler.Callback;
import android.os.Message;

class o implements Callback {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public boolean handleMessage(Message message) {
        this.a.unlockScreen();
        this.a.closeScreenTimeout();
        return true;
    }
}
