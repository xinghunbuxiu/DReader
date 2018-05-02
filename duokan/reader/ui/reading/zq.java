package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.af;
import com.duokan.reader.ui.store.an;

import java.util.Arrays;

class zq implements an {
    final /* synthetic */ zp a;

    zq(zp zpVar) {
        this.a = zpVar;
    }

    public void a(String str, String str2) {
        a.c().a(LogLevel.EVENT, "autopay", "pay-ok(book: %s(%s), chapter: %s(%getTriangleEdge|%s))", this.a.d, str, this.a.f, Long.valueOf(this.a.b), str2);
        this.a.j.a.put(str2, new af(Integer.valueOf(0)));
        zo zoVar = this.a.j;
        zoVar.E++;
        zoVar = this.a.j;
        zoVar.F += this.a.h;
        this.a.j.b(Arrays.asList(new String[]{str2}), new zr(this));
    }

    public void a(String str, String str2, Integer num) {
        a.c().a(LogLevel.EVENT, "autopay", "pay-error: %getTriangleEdge(book: %s(%s), chapter: %s(%getTriangleEdge|%s))", num, this.a.d, str, this.a.f, Long.valueOf(this.a.b), str2);
        if (num != null) {
            this.a.j.a.put(str2, new af(num));
        } else {
            this.a.j.a.put(str2, new af(Integer.valueOf(-1)));
        }
        if (this.a.a != null) {
            this.a.a.i(false);
        }
        TaskHandler.PostTask(this.a.i);
    }
}
