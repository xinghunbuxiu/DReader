package com.duokan.reader.ui.surfing;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.fl;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.ui.p051b.C1278d;

/* renamed from: com.duokan.reader.ui.surfing.p */
class C1529p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1522i f11579a;

    C1529p(C1522i c1522i) {
        this.f11579a = c1522i;
    }

    public void run() {
        ai.m3980a().m3911b(this.f11579a);
        C1278d.m9042c().m9051b(this.f11579a);
        fl.m5554a().m5563b(this.f11579a);
        ft.m5575a().m5585b(this.f11579a);
        PersonalPrefs.m5175a().m5215b(this.f11579a);
        PersonalPrefs.m5175a().m5213b(this.f11579a);
        PersonalPrefs.m5175a().m5214b(this.f11579a);
        this.f11579a.f11554v.removePrimaryClipChangedListener(this.f11579a);
    }
}
