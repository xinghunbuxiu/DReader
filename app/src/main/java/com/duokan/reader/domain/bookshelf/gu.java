package com.duokan.reader.domain.bookshelf;

import android.util.Pair;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.p027b.p028a.C0320a;
import com.duokan.core.p027b.p028a.C0321b;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.statistics.C1163a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

class gu implements Callable<Pair<Integer, Long>> {
    /* renamed from: a */
    final /* synthetic */ gt f3264a;

    gu(gt gtVar) {
        this.f3264a = gtVar;
    }

    public /* synthetic */ Object call() {
        return m4590a();
    }

    /* renamed from: a */
    public Pair<Integer, Long> m4590a() {
        long id = UIdleHandler.getCurrentThread().getId();
        if (this.f3264a.m4576o()) {
            this.f3264a.f3263g = true;
            return new Pair(Integer.valueOf(1), Long.valueOf(id));
        }
        int i;
        String str = this.f3264a.f3261e ? this.f3264a.f3259c.f4497f : this.f3264a.f3259c.f4494c;
        OutputStream d;
        try {
            int i2;
            C0352r e = this.f3264a.f3258b.bv();
            String str2 = this.f3264a.f3260d + "!";
            try {
                e.mo416a(str2, this.f3264a.f3261e ? this.f3264a.f3259c.f4499h : this.f3264a.f3259c.f4496e);
            } catch (FileAlreadyExistsException e2) {
            }
            i = C0559f.m2476b().m2485d() ? 20 : 10;
            d = e.mo424d(str2);
            C0321b.m726a(str, d, new C0320a().m721a(i).m724b(131072));
            d.close();
            InputStream c = e.mo422c(str2);
            String a = C0366o.m1029a(c, "md5");
            c.close();
            long j = this.f3264a.f3261e ? this.f3264a.f3259c.f4499h : this.f3264a.f3259c.f4496e;
            String str3 = this.f3264a.f3261e ? this.f3264a.f3259c.f4498g : this.f3264a.f3259c.f4495d;
            Object obj = j == c.mo428c() ? 1 : null;
            Object obj2 = (obj == null || !a.startsWith(str3)) ? null : 1;
            if (obj2 != null) {
                if (e.mo419a(str2, this.f3264a.f3260d)) {
                    i2 = 0;
                } else if (this.f3264a.m4576o()) {
                    i2 = 1;
                } else {
                    C0328a.m757c().m746a(LogLevel.ERROR, "epub-l", "fail to download the resource " + str);
                    i2 = 1006;
                }
            } else if (obj == null) {
                C0328a.m757c().m749a(LogLevel.ERROR, "epub-l", "fail to download the resource %s(size error: %s!=%s)", str, Long.valueOf(c.mo428c()), Long.valueOf(j));
                C1163a.m8627k().m8639a(this.f3264a.f3258b, this.f3264a.f3259c.f4492a, str3, a);
                i2 = 1007;
            } else {
                C0328a.m757c().m749a(LogLevel.ERROR, "epub-l", "fail to download the resource %s(md5 error: %s!=%s)", str, a, str3);
                C1163a.m8627k().m8639a(this.f3264a.f3258b, this.f3264a.f3259c.f4492a, str3, a);
                i2 = 1008;
            }
            i = i2;
        } catch (Throwable e3) {
            C0328a.m757c().m748a(LogLevel.ERROR, "epub-l", "fail to download the resource " + str, e3);
            i = 1006;
        } catch (Throwable e32) {
            C0328a.m757c().m748a(LogLevel.ERROR, "epub-l", "fail to download the resource " + str, e32);
            i = 1000;
        }
        if (i == 0 || i == 1) {
            this.f3264a.f3263g = true;
        }
        return new Pair(Integer.valueOf(i), Long.valueOf(id));
    }
}
