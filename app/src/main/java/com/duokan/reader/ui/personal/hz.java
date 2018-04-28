package com.duokan.reader.ui.personal;

import android.os.Handler.Callback;
import android.os.Message;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hz implements Callback {
    /* renamed from: a */
    final /* synthetic */ hy f8694a;

    hz(hy hyVar) {
        this.f8694a = hyVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0 || !PersonalPrefs.m5175a().m5250z()) {
            return false;
        }
        ai.m3980a().mo973a(true, true);
        return true;
    }
}
