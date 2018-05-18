package com.duokan.reader.domain.bookshelf;

import android.util.Pair;
import com.duokan.core.p027b.UrlTools;
import com.duokan.core.p027b.p028a.HttpConfig;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.http.protocol.HTTP;

class ew implements Callable<Integer> {
    /* renamed from: a */
    final /* synthetic */ ev f3141a;

    ew(ev evVar) {
        this.f3141a = evVar;
    }

    public /* synthetic */ Object call() {
        return m4444a();
    }

    /* renamed from: a */
    public Integer m4444a() {
        Object obj;
        if (ev.f3130j || ev.f3131k.get() < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int i = 0;
        Object obj2 = obj;
        while (this.f3141a.f3139h != 0 && this.f3141a.f3139h != 1 && i < 2) {
            if (obj2 != null) {
                Pair b = C0641o.m2934i().m2960b(this.f3141a.f3135d);
                if (b != null) {
                    List linkedList = new LinkedList();
                    linkedList.add(new Pair(HTTP.TARGET_HOST, UrlTools.getHost((String) b.first)));
                    this.f3141a.f3139h = this.f3141a.m4442a((String) b.second, new HttpConfig().setPairList(linkedList));
                    if (this.f3141a.f3140i instanceof SocketTimeoutException) {
                        ev.f3131k.incrementAndGet();
                    } else if (this.f3141a.f3139h == 1008 || this.f3141a.f3139h == 1007) {
                        ev.f3131k.incrementAndGet();
                    }
                    if (this.f3141a.f3139h == 1005 && this.f3141a.f3140i != null) {
                        C1163a.m8627k().m8649a((String) b.second, this.f3141a.f3140i);
                    }
                }
            } else {
                int i2 = 0;
                Object obj3 = null;
                while (i2 < this.f3141a.f3135d.length) {
                    String str = this.f3141a.f3135d[i2];
                    this.f3141a.f3139h = this.f3141a.m4442a(str, new HttpConfig().m721a(i2 == 0 ? 2 : 0));
                    if (this.f3141a.f3139h == 0 || this.f3141a.f3139h == 1) {
                        break;
                    }
                    if (this.f3141a.f3140i instanceof SocketTimeoutException) {
                        obj3 = 1;
                    } else if (this.f3141a.f3139h == 1008 || this.f3141a.f3139h == 1007) {
                        int obj32 = 1;
                    }
                    if (this.f3141a.f3139h == 1005 && this.f3141a.f3140i != null) {
                        C1163a.m8627k().m8649a(str, this.f3141a.f3140i);
                    }
                    i2++;
                }
                if (obj32 != null) {
                    ev.f3131k.decrementAndGet();
                }
            }
            if (obj2 == null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            i++;
        }
        return Integer.valueOf(this.f3141a.f3139h);
    }
}
