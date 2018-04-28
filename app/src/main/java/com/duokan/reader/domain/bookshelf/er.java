package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import java.util.List;
import java.util.Map;

class er implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f3119a;
    /* renamed from: b */
    final /* synthetic */ String f3120b;
    /* renamed from: c */
    final /* synthetic */ List f3121c;
    /* renamed from: d */
    final /* synthetic */ Map f3122d;
    /* renamed from: e */
    final /* synthetic */ ag f3123e;
    /* renamed from: f */
    final /* synthetic */ ee f3124f;

    er(ee eeVar, boolean z, String str, List list, Map map, ag agVar) {
        this.f3124f = eeVar;
        this.f3119a = z;
        this.f3120b = str;
        this.f3121c = list;
        this.f3122d = map;
        this.f3123e = agVar;
    }

    public void run() {
        C0672a b = C0709k.m3476a().m3502b(PersonalAccount.class);
        new es(this, b.mo832b(), C0630c.f2119a, b).open();
    }
}
