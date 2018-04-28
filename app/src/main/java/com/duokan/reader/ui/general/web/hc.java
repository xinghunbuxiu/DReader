package com.duokan.reader.ui.general.web;

import android.os.Handler.Callback;
import android.os.Message;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hc implements Callback {
    /* renamed from: a */
    final /* synthetic */ hb f7920a;

    hc(hb hbVar) {
        this.f7920a = hbVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0 || !PersonalPrefs.m5175a().m5249y()) {
            return false;
        }
        ai.m3980a().mo973a(true, true);
        return true;
    }
}
