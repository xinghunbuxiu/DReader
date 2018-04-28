package com.duokan.reader.domain.document.epub;

import android.content.Context;
import android.util.DisplayMetrics;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.kernel.epublib.DkEpubLib;
import com.duokan.reader.ReaderEnv;

public class ah implements ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f4478a = (!ah.class.desiredAssertionStatus());
    /* renamed from: b */
    private static ah f4479b = null;
    /* renamed from: c */
    private static final aj<ah> f4480c = new aj();
    /* renamed from: d */
    private final DkEpubLib f4481d = new DkEpubLib();
    /* renamed from: e */
    private final String f4482e;
    /* renamed from: f */
    private final String f4483f;

    protected ah(Context context, ReaderEnv readerEnv) {
        this.f4482e = readerEnv.getKernelDirectory().getAbsolutePath();
        this.f4483f = readerEnv.getTempDirectory().getPath();
        this.f4481d.initialize(this.f4482e);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f4481d.setDeviceParams(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels), 65535, displayMetrics.densityDpi);
    }

    /* renamed from: a */
    public String m6501a() {
        return m6504d().getKernelVersion();
    }

    /* renamed from: b */
    public String m6502b() {
        return this.f4482e;
    }

    /* renamed from: c */
    public String m6503c() {
        return this.f4483f;
    }

    /* renamed from: d */
    public DkEpubLib m6504d() {
        if (f4478a || this.f4481d != null) {
            return this.f4481d;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static void m6499a(Context context, ReaderEnv readerEnv) {
        f4480c.m709a(new ah(context, readerEnv));
    }

    /* renamed from: e */
    public static ah m6500e() {
        return (ah) f4480c.m707a();
    }
}
