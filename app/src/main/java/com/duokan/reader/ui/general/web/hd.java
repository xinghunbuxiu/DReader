package com.duokan.reader.ui.general.web;

import android.os.Handler;
import android.os.Message;
import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hd implements as {
    /* renamed from: a */
    final /* synthetic */ Handler f7921a;
    /* renamed from: b */
    final /* synthetic */ hb f7922b;

    hd(hb hbVar, Handler handler) {
        this.f7922b = hbVar;
        this.f7921a = handler;
    }

    /* renamed from: a */
    public void mo1831a() {
        PersonalPrefs.m5175a().m5232h(true);
        this.f7921a.sendMessageDelayed(Message.obtain(this.f7921a, 0), 5000);
    }
}
