package com.duokan.reader.ui.personal;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.cloud.a;

import java.text.Collator;
import java.util.List;
import java.util.Locale;

class ca implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ by d;

    ca(by byVar, List list, List list2, Runnable runnable) {
        this.d = byVar;
        this.a = list;
        this.b = list2;
        this.c = runnable;
    }

    public void run() {
        Collator instance = Collator.getInstance(Locale.CHINESE);
        a a = a.a(this.a);
        a.a(instance);
        a.b(instance);
        TaskHandler.PostTask(new cb(this, a));
    }
}
