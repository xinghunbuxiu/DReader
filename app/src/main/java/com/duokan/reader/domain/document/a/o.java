package com.duokan.reader.domain.document.a;

import android.content.Context;

import com.duokan.kernel.pdflib.DkPdfLib;
import com.duokan.reader.ReaderEnv;

public class o {
    static final /* synthetic */ boolean a = (!o.class.desiredAssertionStatus());
    private static o b = null;
    private final DkPdfLib c = new DkPdfLib();
    private final String d;

    protected o(Context context, ReaderEnv readerEnv) {
        this.d = readerEnv.getKernelDirectory().getAbsolutePath();
        this.c.initialize(this.d);
        this.c.setDeviceParams(context.getResources().getDisplayMetrics().densityDpi);
        this.c.registerFont(readerEnv.getSystemFontFileZh().getAbsolutePath(), readerEnv.getSystemFontFileZh().getAbsolutePath());
        this.c.registerFont(readerEnv.getSystemFontFileEn().getAbsolutePath(), readerEnv.getSystemFontFileEn().getAbsolutePath());
    }

    public DkPdfLib a() {
        if (a || this.c != null) {
            return this.c;
        }
        throw new AssertionError();
    }

    public String b() {
        return this.d;
    }

    public static void a(Context context, ReaderEnv readerEnv) {
        if (a || b == null) {
            b = new o(context, readerEnv);
            return;
        }
        throw new AssertionError();
    }

    public static o c() {
        if (a || b != null) {
            return b;
        }
        throw new AssertionError();
    }
}
