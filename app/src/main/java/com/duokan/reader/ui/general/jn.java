package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;

class jn implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ji f7451a;

    jn(ji jiVar) {
        this.f7451a = jiVar;
    }

    public void onClick(View view) {
        if (this.f7451a.f7442f == null) {
            this.f7451a.f7442f = new hp(this.f7451a.getContext());
            this.f7451a.f7442f.m9769b(C0247i.general__web_window_view__sys_client);
            this.f7451a.f7442f.m9769b(C0247i.general__web_window_view__copy);
            this.f7451a.f7442f.m9767a(new jo(this));
        }
        this.f7451a.f7442f.show();
    }
}
