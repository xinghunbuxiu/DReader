package com.duokan.reader.domain.document.epub;

import android.content.Context;
import android.util.DisplayMetrics;

import com.duokan.core.app.ai;
import com.duokan.kernel.epublib.DkEpubLib;
import com.duokan.reader.ReaderEnv;

public class ah implements com.duokan.core.app.ah {
    static final /* synthetic */ boolean a = (!ah.class.desiredAssertionStatus());
    private static ah b = null;
    private static final ai c = new ai();
    private final DkEpubLib d = new DkEpubLib();
    private final String e;
    private final String f;

    protected ah(Context context, ReaderEnv readerEnv) {
        this.e = readerEnv.getKernelDirectory().getAbsolutePath();
        this.f = readerEnv.getTempDirectory().getPath();
        this.d.initialize(this.e);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.d.setDeviceParams(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels), 65535, displayMetrics.densityDpi);
    }

    public String a() {
        return d().getKernelVersion();
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public DkEpubLib d() {
        if (a || this.d != null) {
            return this.d;
        }
        throw new AssertionError();
    }

    public static void a(Context context, ReaderEnv readerEnv) {
        c.a(new ah(context, readerEnv));
    }

    public static ah e() {
        return (ah) c.a();
    }
}
