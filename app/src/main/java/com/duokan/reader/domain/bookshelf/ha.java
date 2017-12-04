package com.duokan.reader.domain.bookshelf;

import android.util.Pair;

import com.duokan.core.b.a.a;
import com.duokan.core.b.a.b;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.sys.j;
import com.duokan.core.sys.o;
import com.duokan.core.sys.r;
import com.duokan.reader.common.c.f;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

import miuipub.date.Calendar;

class ha implements Callable {
    final /* synthetic */ gz a;

    ha(gz gzVar) {
        this.a = gzVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Pair a() {
        OutputStream d;
        long id = j.a().getId();
        if (this.a.o()) {
            this.a.g = true;
            return new Pair(Integer.valueOf(1), Long.valueOf(id));
        }
        int i;
        String str = this.a.e ? this.a.c.f : this.a.c.c;
        try {
            int i2;
            r e = this.a.b.bt();
            String str2 = this.a.d + "!";
            try {
                e.a(str2, this.a.e ? this.a.c.h : this.a.c.e);
            } catch (FileAlreadyExistsException e2) {
            }
            i = f.b().d() ? 20 : 10;
            d = e.d(str2);
            b.a(str, d, new a().a(i).b(131072));
            d.close();
            InputStream c = e.c(str2);
            String a = o.a(c, "md5");
            c.close();
            long j = this.a.e ? this.a.c.h : this.a.c.e;
            String str3 = this.a.e ? this.a.c.g : this.a.c.d;
            Object obj = j == c.c() ? 1 : null;
            Object obj2 = (obj == null || !a.startsWith(str3)) ? null : 1;
            if (obj2 != null) {
                if (e.a(str2, this.a.d)) {
                    i2 = 0;
                } else if (this.a.o()) {
                    i2 = 1;
                } else {
                    com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub-OnDismissListener", "fail to download the resource " + str);
                    i2 = 1006;
                }
            } else if (obj == null) {
                com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub-OnDismissListener", "fail to download the resource %s(size error: %s!=%s)", str, Long.valueOf(c.c()), Long.valueOf(j));
                com.duokan.reader.domain.statistics.a.k().a(this.a.b, this.a.c.a, str3, a);
                i2 = 1007;
            } else {
                com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub-OnDismissListener", "fail to download the resource %s(md5 error: %s!=%s)", str, a, str3);
                com.duokan.reader.domain.statistics.a.k().a(this.a.b, this.a.c.a, str3, a);
                i2 = 1008;
            }
            i = i2;
        } catch (Throwable e3) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub-OnDismissListener", "fail to download the resource " + str, e3);
            i = 1006;
        } catch (Throwable e32) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub-OnDismissListener", "fail to download the resource " + str, e32);
            i = Calendar.MILLISECOND_OF_SECOND;
        }
        if (i == 0 || i == 1) {
            this.a.g = true;
        }
        return new Pair(Integer.valueOf(i), Long.valueOf(id));
    }
}
