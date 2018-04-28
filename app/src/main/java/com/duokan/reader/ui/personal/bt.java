package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.cloud.C0840a;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

class bt implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f8360a;
    /* renamed from: b */
    final /* synthetic */ List f8361b;
    /* renamed from: c */
    final /* synthetic */ Runnable f8362c;
    /* renamed from: d */
    final /* synthetic */ br f8363d;

    bt(br brVar, List list, List list2, Runnable runnable) {
        this.f8363d = brVar;
        this.f8360a = list;
        this.f8361b = list2;
        this.f8362c = runnable;
    }

    public void run() {
        Collator instance = Collator.getInstance(Locale.CHINESE);
        C0840a a = C0840a.m5251a(this.f8360a);
        a.m5259a(instance);
        a.m5263b(instance);
        UThread.post(new bu(this, a));
    }
}
