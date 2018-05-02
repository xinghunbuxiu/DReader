package com.duokan.reader.domain.a;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.i;

public class a implements ah {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private final i d;
    private r e;

    private a(Context context, i iVar) {
        this.c = context;
        this.d = iVar;
    }

    public static void a(Context context, i iVar) {
        b.a(new a(context, iVar));
    }

    public static a a() {
        return (a) b.a();
    }

    public void a(String str, g gVar) {
        if (!a && TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (a || gVar != null) {
            new b(this, str, gVar).open();
        } else {
            throw new AssertionError();
        }
    }

    public void a(String str, int i, String str2, String str3, f fVar) {
        if (!a && (i <= 0 || i >= 6)) {
            throw new AssertionError();
        } else if (a || fVar != null) {
            this.d.a(new c(this, str, i, str2, str3, fVar));
        } else {
            throw new AssertionError();
        }
    }
}
