package com.duokan.reader.ui.surfing;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.fl;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.ui.p051b.C1278d;

/* renamed from: com.duokan.reader.ui.surfing.o */
class C1528o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1522i f11578a;

    C1528o(C1522i c1522i) {
        this.f11578a = c1522i;
    }

    public void run() {
        ai.m3980a().m3888a(this.f11578a);
        C1278d.m9042c().m9049a(this.f11578a);
        fl.m5554a().m5561a(this.f11578a);
        ft.m5575a().m5581a(this.f11578a);
        PersonalPrefs.m5175a().m5204a(this.f11578a);
        PersonalPrefs.m5175a().m5202a(this.f11578a);
        PersonalPrefs.m5175a().m5203a(this.f11578a);
        this.f11578a.f11554v.addPrimaryClipChangedListener(this.f11578a);
    }
}
