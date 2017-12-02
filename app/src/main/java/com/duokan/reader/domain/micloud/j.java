package com.duokan.reader.domain.micloud;

import android.content.Context;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.o;
import com.duokan.reader.common.async.work.q;

import java.util.concurrent.ThreadPoolExecutor;

public class j extends bg {
    protected /* synthetic */ o e(c cVar) {
        return b((i) cVar);
    }

    public j(Context context, String str, String str2, q qVar, ThreadPoolExecutor threadPoolExecutor) {
        super(context, str, str2, qVar, threadPoolExecutor);
    }

    public final i b(String str) {
        return (i) a(new k(this, str));
    }

    public i a(String str, String str2, String str3, int i) {
        c b = b(str);
        if (b == null) {
            b = new i(j(), k(), str, str, str2, str3, i);
        }
        return (i) b(b);
    }

    public void a(i iVar) {
        a((c) iVar, new l(this));
        c((c) iVar);
    }

    protected d b(i iVar) {
        return new d(a(), iVar, b());
    }
}
