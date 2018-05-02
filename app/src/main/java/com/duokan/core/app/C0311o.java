package com.duokan.core.app;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.duokan.core.app.o */
class C0311o implements Callback {
    /* renamed from: a */
    final /* synthetic */ BaseActivity f536a;

    C0311o(BaseActivity mActivity) {
        this.f536a = mActivity;
    }

    public boolean handleMessage(Message message) {
        this.f536a.unlockScreen();
        this.f536a.closeScreenTimeout();
        return true;
    }
}
