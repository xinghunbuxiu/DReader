package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;
import com.duokan.reader.ReaderEnv.PrivatePref;

/* renamed from: com.duokan.reader.domain.cloud.push.c */
class C0858c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0857b f4109a;

    C0858c(C0857b c0857b) {
        this.f4109a = c0857b;
    }

    public void run() {
        this.f4109a.m5667f();
        Object prefString = this.f4109a.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_notify_account", "");
        String prefString2 = this.f4109a.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_notify_account_token", "");
        if (!TextUtils.isEmpty(prefString2)) {
            this.f4109a.m5666e(prefString2);
        } else if (!TextUtils.isEmpty(prefString)) {
            this.f4109a.m5669f((String) prefString);
        }
        this.f4109a.f4105f.m8483a(this.f4109a);
        this.f4109a.f4104e.m3494a(C0857b.m5649a());
    }
}
