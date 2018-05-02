package com.duokan.reader.domain.plugins.dict;

import android.content.Context;
import com.duokan.reader.ui.general.ap;
import java.io.File;

/* renamed from: com.duokan.reader.domain.plugins.dict.e */
class C1110e extends ap {
    /* renamed from: a */
    final /* synthetic */ C1109d f5394a;

    C1110e(C1109d c1109d, Context context) {
        this.f5394a = c1109d;
        super(context);
    }

    protected void onOk() {
        new File(C1115j.f5405a + File.separator + this.f5394a.f5391a.m8409c()).delete();
        this.f5394a.f5393c.mo2519h(this.f5394a.f5392b, 1);
        super.onOk();
    }
}
