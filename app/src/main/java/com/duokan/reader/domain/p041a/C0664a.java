package com.duokan.reader.domain.p041a;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0709k;

/* renamed from: com.duokan.reader.domain.a.a */
public class C0664a implements ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f2218a = (!C0664a.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<C0664a> f2219b = new aj();
    /* renamed from: c */
    private final Context f2220c;
    /* renamed from: d */
    private final C0709k f2221d;
    /* renamed from: e */
    private WebSession f2222e;

    private C0664a(Context context, C0709k c0709k) {
        this.f2220c = context;
        this.f2221d = c0709k;
    }

    /* renamed from: a */
    public static void m3110a(Context context, C0709k c0709k) {
        f2219b.m709a(new C0664a(context, c0709k));
    }

    /* renamed from: a */
    public static C0664a m3108a() {
        return (C0664a) f2219b.m707a();
    }

    /* renamed from: a */
    public void m3114a(String str, C0670f c0670f) {
        if (!f2218a && TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (f2218a || c0670f != null) {
            new C0665b(this, C0643q.f2173a, str, c0670f).open();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void m3113a(String str, int i, String str2, String str3, C0669e c0669e) {
        if (!f2218a && (i <= 0 || i >= 6)) {
            throw new AssertionError();
        } else if (f2218a || c0669e != null) {
            this.f2221d.m3495a(new C0667c(this, str, i, str2, str3, c0669e));
        } else {
            throw new AssertionError();
        }
    }
}
