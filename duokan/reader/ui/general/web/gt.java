package com.duokan.reader.ui.general.web;

import android.os.Handler;
import android.os.Message;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class gt implements as {
    final /* synthetic */ Handler a;
    final /* synthetic */ gr b;

    gt(gr grVar, Handler handler) {
        this.b = grVar;
        this.a = handler;
    }

    public void a() {
        PersonalPrefs.a().h(true);
        this.a.sendMessageDelayed(Message.obtain(this.a, 0), 5000);
    }
}
