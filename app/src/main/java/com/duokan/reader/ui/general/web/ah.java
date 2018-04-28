package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.UThread;

class ah implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7574a;
    /* renamed from: b */
    final /* synthetic */ Runnable f7575b;
    /* renamed from: c */
    final /* synthetic */ af f7576c;

    ah(af afVar, String str, Runnable runnable) {
        this.f7576c = afVar;
        this.f7574a = str;
        this.f7575b = runnable;
    }

    public void run() {
        if (TextUtils.equals(this.f7576c.f7572a.mEditText.getText(), this.f7574a)) {
            UThread.runOnThread(this.f7575b);
        }
    }
}
