package com.duokan.reader.ui.personal;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hm implements Callback {
    final /* synthetic */ hl a;

    hm(hl hlVar) {
        this.a = hlVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0 || !PersonalPrefs.a().y()) {
            return false;
        }
        ai.a().a(true, true);
        return true;
    }
}
