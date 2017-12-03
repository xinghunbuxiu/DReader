package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ui.store.o;

class zp implements Runnable {
    final /* synthetic */ aaq a;
    final /* synthetic */ long b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ short h;
    final /* synthetic */ Runnable i;
    final /* synthetic */ zo j;

    zp(zo zoVar, aaq com_duokan_reader_ui_reading_aaq, long j, Runnable runnable, String str, String str2, String str3, String str4, short s, Runnable runnable2) {
        this.j = zoVar;
        this.a = com_duokan_reader_ui_reading_aaq;
        this.b = j;
        this.c = runnable;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = s;
        this.i = runnable2;
    }

    public void run() {
        if (!this.j.q) {
            if (this.a.j(this.b).b(Boolean.valueOf(true))) {
                TaskHandler.PostTask(this.c);
                return;
            }
            a.c().a(LogLevel.EVENT, "autopay", "pay(book: %s(%s), chapter: %s(%getScaledTouchSlop|%s))", this.d, this.e, this.f, Long.valueOf(this.b), this.g);
            o.a().a(this.e, this.g, this.h, new zq(this));
        }
    }
}
