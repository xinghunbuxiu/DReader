package com.duokan.reader.ui.reading;

import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

class ro implements im {
    /* renamed from: a */
    final /* synthetic */ ee f10906a;
    /* renamed from: b */
    final /* synthetic */ rn f10907b;

    ro(rn rnVar, ee eeVar) {
        this.f10907b = rnVar;
        this.f10906a = eeVar;
    }

    /* renamed from: a */
    public void mo1021a(C0800c c0800c) {
        C1167a.m8671d().m8683b(this.f10906a.getId(), this.f10906a.m4155H().f3455c);
        new rp(this, C0643q.f2173a, c0800c).open();
        if (c0800c.m4247s() == BookPackageType.EPUB_OPF) {
            c0800c.m4208b(new af(Boolean.valueOf(true)));
        }
        if (!PersonalPrefs.m5175a().m5239o()) {
            ft.m5575a().m5583a(c0800c.ar());
        }
        this.f10907b.f10904a.run();
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        this.f10907b.f10904a.run();
    }
}
