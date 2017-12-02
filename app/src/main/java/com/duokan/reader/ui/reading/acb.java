package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.core.sys.o;
import com.duokan.reader.domain.document.ah;

import java.io.File;

public class acb {
    static final /* synthetic */ boolean b = (!acb.class.desiredAssertionStatus());
    private static acb c;
    long a;
    private final int d = 3;
    private ace e;
    private ah f;
    private File g;
    private String h;
    private acd i;

    public static acb a() {
        if (c == null) {
            c = new acb();
        }
        return c;
    }

    public void a(long j, ah ahVar, Context context, ace com_duokan_reader_ui_reading_ace) {
        this.f = ahVar;
        this.a = j;
        this.e = com_duokan_reader_ui_reading_ace;
        a(context);
    }

    public String b() {
        return this.g.getAbsolutePath();
    }

    public void c() {
        if (this.i != null) {
            this.i.cancel(true);
        }
    }

    private void a(Context context) {
        if (!b && this.f == null) {
            throw new AssertionError();
        } else if (b || this.e != null) {
            this.h = context.getCacheDir().getAbsolutePath();
            this.g = new File(context.getCacheDir(), o.b(this.a + this.f.b()[0].c, "md5"));
            if (this.g.exists()) {
                this.e.l();
                return;
            }
            this.i = new acd();
            this.i.execute(new Void[0]);
        } else {
            throw new AssertionError();
        }
    }

    private void d() {
        synchronized (this.g) {
            if (this.g.exists()) {
                this.g.delete();
            }
        }
    }

    private void e() {
        if (!TextUtils.isEmpty(this.h)) {
            File[] listFiles = new File(this.h).listFiles(new acc(this));
            if (listFiles.length >= 3) {
                File file = listFiles[0];
                for (int i = 1; i < listFiles.length; i++) {
                    if (file.lastModified() > listFiles[i].lastModified()) {
                        file = listFiles[i];
                    }
                }
                file.delete();
            }
        }
    }
}
