package com.duokan.reader.domain.micloud;

import android.content.Context;
import com.duokan.reader.common.async.work.C0520o;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0529q;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.duokan.reader.domain.micloud.j */
public class C1069j extends bg<C1068i, C1063d> {
    /* renamed from: e */
    protected /* synthetic */ C0520o mo1478e(C0523c c0523c) {
        return m8234b((C1068i) c0523c);
    }

    public C1069j(Context context, String str, String str2, C0529q<C1068i> c0529q, ThreadPoolExecutor threadPoolExecutor) {
        super(context, str, str2, c0529q, threadPoolExecutor);
    }

    /* renamed from: b */
    public final C1068i m8235b(String str) {
        return (C1068i) m2355a(new C1070k(this, str));
    }

    /* renamed from: a */
    public C1068i m8232a(String str, String str2, String str3, int i) {
        C0523c b = m8235b(str);
        if (b == null) {
            b = new C1068i(m8041i(), m8042j(), str, str, str2, str3, i);
        }
        return (C1068i) m2362b(b);
    }

    /* renamed from: a */
    public void m8233a(C1068i c1068i) {
        m2359a((C0523c) c1068i, new C1071l(this));
        m2367c((C0523c) c1068i);
    }

    /* renamed from: b */
    protected C1063d m8234b(C1068i c1068i) {
        return new C1063d(m2354a(), c1068i, m2363b());
    }
}
