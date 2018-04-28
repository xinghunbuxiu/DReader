package com.duokan.reader.domain.micloud;

import android.content.Context;
import com.duokan.reader.common.async.work.C0520o;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0529q;
import java.util.concurrent.ThreadPoolExecutor;

public class aa extends bg<C1084z, C1079u> {
    /* renamed from: e */
    protected /* synthetic */ C0520o mo1478e(C0523c c0523c) {
        return m8043a((C1084z) c0523c);
    }

    public aa(Context context, String str, String str2, C0529q<C1084z> c0529q, ThreadPoolExecutor threadPoolExecutor) {
        super(context, str, str2, c0529q, threadPoolExecutor);
    }

    /* renamed from: b */
    public final C1084z m8045b(String str) {
        return (C1084z) m2355a(new ab(this, str));
    }

    /* renamed from: a */
    public C1084z m8044a(String str, String str2, bi biVar, int i) {
        C0523c b = m8045b(str);
        if (b == null) {
            b = new C1084z(m8041i(), m8042j(), str, str, str2, biVar, i);
        }
        return (C1084z) m2367c(b);
    }

    /* renamed from: a */
    protected C1079u m8043a(C1084z c1084z) {
        return new C1079u(m2354a(), c1084z, m2363b());
    }
}
