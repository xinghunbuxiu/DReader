package com.duokan.reader.ui.personal;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class jh implements Callback {
    final /* synthetic */ it a;

    jh(it itVar) {
        this.a = itVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0 || !PersonalPrefs.a().y()) {
            return false;
        }
        ai.a().a(true, true);
        return true;
    }
}
