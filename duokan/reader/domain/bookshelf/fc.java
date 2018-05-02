package com.duokan.reader.domain.bookshelf;

import android.util.Pair;

import com.duokan.core.b.UrlTools;
import com.duokan.reader.common.webservices.duokan.p;

import org.apache.http.protocol.HTTP;

import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

class fc implements Callable {
    final /* synthetic */ fb a;

    fc(fb fbVar) {
        this.a = fbVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        Object obj;
        if (fb.j || fb.k.get() < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int i = 0;
        Object obj2 = obj;
        while (this.a.h != 0 && this.a.h != 1 && i < 2) {
            if (obj2 != null) {
                Pair b = p.i().b(this.a.d);
                if (b != null) {
                    List linkedList = new LinkedList();
                    linkedList.add(new Pair(HTTP.TARGET_HOST, a.c((String) b.first)));
                    this.a.h = this.a.a((String) b.second, new UrlTools.a().a(linkedList));
                    if (this.a.i instanceof SocketTimeoutException) {
                        fb.k.incrementAndGet();
                    } else if (this.a.h == 1008 || this.a.h == 1007) {
                        fb.k.incrementAndGet();
                    }
                    if (this.a.h == 1005 && this.a.i != null) {
                        com.duokan.reader.domain.statistics.a.k().a((String) b.second, this.a.i);
                    }
                }
            } else {
                int i2 = 0;
                Object obj3 = null;
                while (i2 < this.a.d.length) {
                    String str = this.a.d[i2];
                    this.a.h = this.a.a(str, new UrlTools.a().a(i2 == 0 ? 2 : 0));
                    if (this.a.h == 0 || this.a.h == 1) {
                        break;
                    }
                    if (this.a.i instanceof SocketTimeoutException) {
                        obj3 = 1;
                    } else if (this.a.h == 1008 || this.a.h == 1007) {
                        int i3 = 1;
                    }
                    if (this.a.h == 1005 && this.a.i != null) {
                        com.duokan.reader.domain.statistics.a.k().a(str, this.a.i);
                    }
                    i2++;
                }
                if (obj3 != null) {
                    fb.k.decrementAndGet();
                }
            }
            if (obj2 == null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            i++;
        }
        return Integer.valueOf(this.a.h);
    }
}
