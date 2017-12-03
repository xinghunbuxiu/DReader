package com.duokan.core.app;

import android.os.Handler.Callback;
import android.os.Message;

class o implements Callback {
    final /* synthetic */ BaseActivity a;

    o(BaseActivity baseActivityVar) {
        this.a = baseActivityVar;
    }

    public boolean handleMessage(Message message) {
        this.a.unlockScreen();
        this.a.closeScreenTimeout();
        return true;
    }
}
