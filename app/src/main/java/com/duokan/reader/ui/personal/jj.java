package com.duokan.reader.ui.personal;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class jj implements OnClickListener {
    final /* synthetic */ Handler a;
    final /* synthetic */ it b;

    jj(it itVar, Handler handler) {
        this.b = itVar;
        this.a = handler;
    }

    public void onClick(View view) {
        PersonalPrefs.a().h(!PersonalPrefs.a().x());
        this.b.a();
        if (PersonalPrefs.a().y()) {
            this.a.sendMessageDelayed(Message.obtain(this.a, 0), 5000);
            return;
        }
        this.a.removeMessages(0);
        ai.a().s();
    }
}
