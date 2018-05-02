package com.duokan.reader.domain.micloud;

import android.content.Context;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.o;
import com.duokan.reader.common.async.work.q;

import java.util.concurrent.ThreadPoolExecutor;

public class aa extends bg {
    protected /* synthetic */ o e(c cVar) {
        return a((z) cVar);
    }

    public aa(Context context, String str, String str2, q qVar, ThreadPoolExecutor threadPoolExecutor) {
        super(context, str, str2, qVar, threadPoolExecutor);
    }

    public final z b(String str) {
        return (z) a(new ab(this, str));
    }

    public z a(String str, String str2, bi biVar, int i) {
        c b = b(str);
        if (b == null) {
            b = new z(j(), k(), str, str, str2, biVar, i);
        }
        return (z) c(b);
    }

    protected u a(z zVar) {
        return new u(a(), zVar, b());
    }
}
