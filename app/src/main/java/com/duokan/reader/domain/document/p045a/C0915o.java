package com.duokan.reader.domain.document.p045a;

import android.content.Context;
import com.duokan.kernel.pdflib.DkPdfLib;
import com.duokan.reader.ReaderEnv;

/* renamed from: com.duokan.reader.domain.document.a.o */
public class C0915o {
    /* renamed from: a */
    static final /* synthetic */ boolean f4325a = (!C0915o.class.desiredAssertionStatus());
    /* renamed from: b */
    private static C0915o f4326b = null;
    /* renamed from: c */
    private final DkPdfLib f4327c = new DkPdfLib();
    /* renamed from: d */
    private final String f4328d;

    protected C0915o(Context context, ReaderEnv readerEnv) {
        this.f4328d = readerEnv.getKernelDirectory().getAbsolutePath();
        this.f4327c.initialize(this.f4328d);
        this.f4327c.setDeviceParams(context.getResources().getDisplayMetrics().densityDpi);
        this.f4327c.registerFont(readerEnv.getSystemFontFileZh().getAbsolutePath(), readerEnv.getSystemFontFileZh().getAbsolutePath());
        this.f4327c.registerFont(readerEnv.getSystemFontFileEn().getAbsolutePath(), readerEnv.getSystemFontFileEn().getAbsolutePath());
    }

    /* renamed from: a */
    public DkPdfLib m6075a() {
        if (f4325a || this.f4327c != null) {
            return this.f4327c;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public String m6076b() {
        return this.f4328d;
    }

    /* renamed from: a */
    public static void m6073a(Context context, ReaderEnv readerEnv) {
        if (f4325a || f4326b == null) {
            f4326b = new C0915o(context, readerEnv);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static C0915o m6074c() {
        if (f4325a || f4326b != null) {
            return f4326b;
        }
        throw new AssertionError();
    }
}
