package com.duokan.reader.domain.document.txt;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.kernel.txtlib.DkTxtLib;
import com.duokan.reader.ReaderEnv;

public class aa implements ah {
    static final /* synthetic */ boolean a = (!aa.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final DkTxtLib c = new DkTxtLib();
    private final String d;

    protected aa(Context context, ReaderEnv readerEnv) {
        this.d = readerEnv.getKernelDirectory().getAbsolutePath();
        this.c.initialize(this.d);
    }

    public DkTxtLib a() {
        if (a || this.c != null) {
            return this.c;
        }
        throw new AssertionError();
    }

    public String b() {
        return this.d;
    }

    public static void a(Context context, ReaderEnv readerEnv) {
        b.a(new aa(context, readerEnv));
    }

    public static aa c() {
        return (aa) b.a();
    }
}
