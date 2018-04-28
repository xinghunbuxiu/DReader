package com.duokan.reader.domain.document.txt;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.kernel.txtlib.DkTxtLib;
import com.duokan.reader.ReaderEnv;

public class aa implements ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f4874a = (!aa.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<aa> f4875b = new aj();
    /* renamed from: c */
    private final DkTxtLib f4876c = new DkTxtLib();
    /* renamed from: d */
    private final String f4877d;

    protected aa(Context context, ReaderEnv readerEnv) {
        this.f4877d = readerEnv.getKernelDirectory().getAbsolutePath();
        this.f4876c.initialize(this.f4877d);
    }

    /* renamed from: a */
    public DkTxtLib m7377a() {
        if (f4874a || this.f4876c != null) {
            return this.f4876c;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public String m7378b() {
        return this.f4877d;
    }

    /* renamed from: a */
    public static void m7375a(Context context, ReaderEnv readerEnv) {
        f4875b.m709a(new aa(context, readerEnv));
    }

    /* renamed from: c */
    public static aa m7376c() {
        return (aa) f4875b.m707a();
    }
}
