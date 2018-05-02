package com.duokan.reader.ui.personal;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hn implements OnClickListener {
    final /* synthetic */ Handler a;
    final /* synthetic */ hl b;

    hn(hl hlVar, Handler handler) {
        this.b = hlVar;
        this.a = handler;
    }

    public void onClick(View view) {
        PersonalPrefs.a().h(!PersonalPrefs.a().x());
        this.b.d();
        if (PersonalPrefs.a().y()) {
            this.a.sendMessageDelayed(Message.obtain(this.a, 0), 1000);
            return;
        }
        this.a.removeMessages(0);
        ai.a().s();
    }
}
