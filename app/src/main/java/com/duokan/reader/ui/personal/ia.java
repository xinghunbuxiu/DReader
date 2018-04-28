package com.duokan.reader.ui.personal;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class ia implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Handler f8696a;
    /* renamed from: b */
    final /* synthetic */ hy f8697b;

    ia(hy hyVar, Handler handler) {
        this.f8697b = hyVar;
        this.f8696a = handler;
    }

    public void onClick(View view) {
        PersonalPrefs.m5175a().m5232h(!PersonalPrefs.m5175a().m5249y());
        this.f8697b.m11966d();
        if (PersonalPrefs.m5175a().m5250z()) {
            this.f8696a.sendMessageDelayed(Message.obtain(this.f8696a, 0), 1000);
            return;
        }
        this.f8696a.removeMessages(0);
        ai.m3980a().m3944s();
    }
}
