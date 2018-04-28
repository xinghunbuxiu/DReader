package com.duokan.reader.ui.personal;

import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.social.message.ar;
import com.duokan.reader.ui.general.be;
import java.util.List;

class cb implements ar {
    /* renamed from: a */
    final /* synthetic */ List f8391a;
    /* renamed from: b */
    final /* synthetic */ C0342j f8392b;
    /* renamed from: c */
    final /* synthetic */ ca f8393c;

    cb(ca caVar, List list, C0342j c0342j) {
        this.f8393c = caVar;
        this.f8391a = list;
        this.f8392b = c0342j;
    }

    /* renamed from: a */
    public void mo1181a() {
        if (this.f8391a.size() > 0) {
            this.f8393c.f8390b.f8379a.removeAll(this.f8391a);
            this.f8393c.f8390b.mo1901a(false);
        }
        be.m10287a(this.f8393c.f8390b.getContext(), String.format(this.f8393c.f8390b.getResources().getString(C0258j.personal__message_center_view__succeed), new Object[]{Integer.valueOf(this.f8391a.size())}), 0).show();
        this.f8392b.dismiss();
        if (this.f8393c.f8389a != null) {
            this.f8393c.f8389a.run();
        }
    }

    /* renamed from: a */
    public void mo1182a(String str) {
        be.m10286a(this.f8393c.f8390b.getContext(), C0258j.personal__message_center_view__fail, 0).show();
    }
}
