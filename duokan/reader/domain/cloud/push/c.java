package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;

import com.duokan.reader.ReaderEnv.PrivatePref;

class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        this.a.f();
        Object prefString = this.a.g.getPrefString(PrivatePref.PERSONAL, "mi_push_notify_account", "");
        String prefString2 = this.a.g.getPrefString(PrivatePref.PERSONAL, "mi_push_notify_account_token", "");
        if (!TextUtils.isEmpty(prefString2)) {
            this.a.e(prefString2);
        } else if (!TextUtils.isEmpty(prefString)) {
            this.a.f((String) prefString);
        }
        this.a.f.a(this.a);
        this.a.e.add(b.a());
    }
}
