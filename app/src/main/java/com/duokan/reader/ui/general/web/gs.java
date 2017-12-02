package com.duokan.reader.ui.general.web;

import android.os.Handler.Callback;
import android.os.Message;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class gs implements Callback {
    final /* synthetic */ gr a;

    gs(gr grVar) {
        this.a = grVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0 || !PersonalPrefs.a().x()) {
            return false;
        }
        ai.a().a(true, true);
        return true;
    }
}
