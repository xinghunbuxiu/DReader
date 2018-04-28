package com.duokan.reader.ui.personal;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class jx implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Handler f8796a;
    /* renamed from: b */
    final /* synthetic */ jg f8797b;

    jx(jg jgVar, Handler handler) {
        this.f8797b = jgVar;
        this.f8796a = handler;
    }

    public void onClick(View view) {
        PersonalPrefs.m5175a().m5232h(!PersonalPrefs.m5175a().m5249y());
        this.f8797b.m12047a();
        if (PersonalPrefs.m5175a().m5250z()) {
            this.f8796a.sendMessageDelayed(Message.obtain(this.f8796a, 0), 5000);
            return;
        }
        this.f8796a.removeMessages(0);
        ai.m3980a().m3944s();
    }
}
