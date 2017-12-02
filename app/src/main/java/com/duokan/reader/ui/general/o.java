package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.b.e;
import com.duokan.core.io.a;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.t;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.BookCoverView.CoverSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public class o implements gz {
    private String a;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private gw f = null;
    private CoverSource g = CoverSource.NONE;
    private v h = null;
    private c i = null;
    private x j = null;

    public o() {
        this.a = ReaderEnv.get().forHd() ? "!m" : "!e";
    }

    public o a(v vVar) {
        this.h = vVar;
        return this;
    }

    public o a(c cVar) {
        String str = null;
        this.i = cVar;
        this.g = CoverSource.NONE;
        this.c = cVar.aw();
        if (a()) {
            if (cVar.e() != null) {
                str = cVar.f();
            }
            this.b = str;
            this.d = cVar.h();
            this.e = cVar.g();
        } else {
            this.b = null;
            this.d = null;
            this.e = null;
        }
        return this;
    }

    public o a(x xVar) {
        this.j = xVar;
        return this;
    }

    public o a(String str) {
        this.d = str;
        return this;
    }

    private boolean a() {
        return !((this.i == null || ((this.i.i() == BookState.CLOUD_ONLY || this.i.i() == BookState.PULLING) && !this.i.ai())) && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.e)) && (this.i == null || !(this.i == null || this.i.q() == BookFormat.TXT));
    }

    public void a(gw gwVar) {
        this.f = gwVar;
        this.f.a(e.general__book_cover_view__duokan_cover);
        if (this.h != null) {
            if (a()) {
                this.h.a(false);
            } else {
                this.h.a(true);
            }
        }
        this.g = CoverSource.NONE;
        gwVar.a((gz) this);
        b();
    }

    private void b() {
        for (int ordinal = this.g.ordinal() + 1; ordinal < CoverSource.values().length; ordinal++) {
            this.g = CoverSource.values()[ordinal];
            switch (m.b[this.g.ordinal()]) {
                case 1:
                    if (TextUtils.isEmpty(this.d)) {
                        break;
                    }
                    this.f.a(new n(this.i, this.d));
                    return;
                case 2:
                    if (TextUtils.isEmpty(this.e)) {
                        break;
                    }
                    this.f.a(new n(this.i, this.e));
                    return;
                case 3:
                    if (!(TextUtils.isEmpty(this.b) || this.j == null || !TextUtils.isEmpty(this.e))) {
                        a(new p(this));
                        return;
                    }
                default:
                    if (TextUtils.isEmpty(this.c)) {
                        this.f.a("");
                        return;
                    } else {
                        this.h.a(true);
                        return;
                    }
            }
        }
    }

    public void a(Bitmap bitmap) {
        if (this.g != CoverSource.COVER && !TextUtils.isEmpty(this.d)) {
            if (this.g != CoverSource.BOOK || TextUtils.isEmpty(this.e)) {
                File file = new File(Uri.parse(this.d).getPath());
                if (!file.exists() && bitmap != null) {
                    a(new r(this, file, bitmap));
                }
            }
        }
    }

    public void b(gw gwVar) {
        b();
    }

    private void a(File file, Bitmap bitmap, w wVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream byteArrayInputStream;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream2;
        Throwable th;
        InputStream inputStream = null;
        if (file != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        e.printStackTrace();
                        if (wVar != null) {
                            t.a(new s(this, wVar));
                        }
                        try {
                            byteArrayOutputStream2.close();
                            byteArrayInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream = byteArrayInputStream;
                        try {
                            byteArrayOutputStream.close();
                            inputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream.close();
                    inputStream.close();
                    throw th;
                }
                try {
                    a.b(byteArrayInputStream, file);
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (Exception e32) {
                        e32.printStackTrace();
                    }
                    if (wVar != null) {
                        t.a(new t(this, wVar));
                    }
                } catch (Exception e5) {
                    e32 = e5;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e32.printStackTrace();
                    if (wVar != null) {
                        t.a(new s(this, wVar));
                    }
                    byteArrayOutputStream2.close();
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = byteArrayInputStream;
                    byteArrayOutputStream.close();
                    inputStream.close();
                    throw th;
                }
            } catch (Exception e6) {
                e32 = e6;
                byteArrayInputStream = null;
                e32.printStackTrace();
                if (wVar != null) {
                    t.a(new s(this, wVar));
                }
                byteArrayOutputStream2.close();
                byteArrayInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
                byteArrayOutputStream.close();
                inputStream.close();
                throw th;
            }
        } else if (wVar != null) {
            t.a(new u(this, wVar));
        }
    }

    private void a(Runnable runnable) {
        ah.a(runnable, l.a, 0);
    }

    public o b(String str) {
        if (!TextUtils.equals(this.e, str)) {
            this.e = str;
            this.g = CoverSource.NONE;
        }
        if (this.h != null) {
            this.h.a(false);
        }
        return this;
    }
}
