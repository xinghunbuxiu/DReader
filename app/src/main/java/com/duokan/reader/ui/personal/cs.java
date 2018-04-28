package com.duokan.reader.ui.personal;

import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.social.message.ar;
import com.duokan.reader.ui.general.be;
import java.util.List;

class cs implements ar {
    /* renamed from: a */
    final /* synthetic */ List f8420a;
    /* renamed from: b */
    final /* synthetic */ C0342j f8421b;
    /* renamed from: c */
    final /* synthetic */ cr f8422c;

    cs(cr crVar, List list, C0342j c0342j) {
        this.f8422c = crVar;
        this.f8420a = list;
        this.f8421b = c0342j;
    }

    /* renamed from: a */
    public void mo1181a() {
        if (this.f8420a.size() > 0) {
            this.f8422c.f8419b.f8408a.f8402b.removeAll(this.f8420a);
            this.f8422c.f8419b.mo1901a(false);
        }
        be.m10287a(this.f8422c.f8419b.getContext(), String.format(this.f8422c.f8419b.getResources().getString(C0258j.personal__message_push_view__succeed), new Object[]{Integer.valueOf(this.f8420a.size())}), 0).show();
        this.f8421b.dismiss();
        if (this.f8422c.f8418a != null) {
            this.f8422c.f8418a.run();
        }
    }

    /* renamed from: a */
    public void mo1182a(String str) {
        be.m10286a(this.f8422c.f8419b.getContext(), C0258j.personal__message_push_view__fail, 0).show();
    }
}
