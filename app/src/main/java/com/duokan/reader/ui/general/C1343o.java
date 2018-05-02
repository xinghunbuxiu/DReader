package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.BookCoverView.CoverSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.duokan.reader.ui.general.o */
public class C1343o implements go {
    /* renamed from: a */
    private String f7537a;
    /* renamed from: b */
    private String f7538b = null;
    /* renamed from: c */
    private String f7539c = null;
    /* renamed from: d */
    private String f7540d = null;
    /* renamed from: e */
    private String f7541e = null;
    /* renamed from: f */
    private gl f7542f = null;
    /* renamed from: g */
    private CoverSource f7543g = CoverSource.NONE;
    /* renamed from: h */
    private C1334v f7544h = null;
    /* renamed from: i */
    private C0800c f7545i = null;
    /* renamed from: j */
    private C1381x f7546j = null;

    public C1343o() {
        this.f7537a = ReaderEnv.get().forHd() ? "!m" : "!e";
    }

    /* renamed from: a */
    public C1343o m10956a(C1334v c1334v) {
        this.f7544h = c1334v;
        return this;
    }

    /* renamed from: a */
    public C1343o m10955a(C0800c c0800c) {
        String str = null;
        this.f7545i = c0800c;
        this.f7543g = CoverSource.NONE;
        this.f7539c = c0800c.ay();
        if (m10946a()) {
            if (c0800c.m4222e() != null) {
                str = c0800c.m4225f();
            }
            this.f7538b = str;
            this.f7540d = c0800c.m4231h();
            this.f7541e = c0800c.m4228g();
        } else {
            this.f7538b = null;
            this.f7540d = null;
            this.f7541e = null;
        }
        return this;
    }

    /* renamed from: a */
    public C1343o m10957a(C1381x c1381x) {
        this.f7546j = c1381x;
        return this;
    }

    /* renamed from: a */
    public C1343o m10958a(String str) {
        this.f7540d = str;
        return this;
    }

    /* renamed from: a */
    private boolean m10946a() {
        return !((this.f7545i == null || ((this.f7545i.m4233i() == BookState.CLOUD_ONLY || this.f7545i.m4233i() == BookState.PULLING) && !this.f7545i.ak())) && TextUtils.isEmpty(this.f7538b) && TextUtils.isEmpty(this.f7540d) && TextUtils.isEmpty(this.f7541e)) && (this.f7545i == null || !(this.f7545i == null || this.f7545i.mo1039q() == BookFormat.TXT));
    }

    /* renamed from: a */
    public void m10960a(gl glVar) {
        this.f7542f = glVar;
        this.f7542f.m10713a(C0243e.general__book_cover_view__duokan_cover);
        if (this.f7544h != null) {
            if (m10946a()) {
                this.f7544h.mo1793a(false);
            } else {
                this.f7544h.mo1793a(true);
            }
        }
        this.f7543g = CoverSource.NONE;
        glVar.m10718a((go) this);
        m10948b();
    }

    /* renamed from: b */
    private void m10948b() {
        for (int ordinal = this.f7543g.ordinal() + 1; ordinal < CoverSource.values().length; ordinal++) {
            this.f7543g = CoverSource.values()[ordinal];
            switch (C1341m.f7534b[this.f7543g.ordinal()]) {
                case 1:
                    if (TextUtils.isEmpty(this.f7540d)) {
                        break;
                    }
                    this.f7542f.m10719a(new C1342n(this.f7545i, this.f7540d));
                    return;
                case 2:
                    if (TextUtils.isEmpty(this.f7541e)) {
                        break;
                    }
                    this.f7542f.m10719a(new C1342n(this.f7545i, this.f7541e));
                    return;
                case 3:
                    if (!(TextUtils.isEmpty(this.f7538b) || this.f7546j == null || !TextUtils.isEmpty(this.f7541e))) {
                        m10945a(new C1344p(this));
                        return;
                    }
                default:
                    if (TextUtils.isEmpty(this.f7539c)) {
                        this.f7542f.m10720a("");
                        return;
                    } else {
                        this.f7544h.mo1793a(true);
                        return;
                    }
            }
        }
    }

    /* renamed from: a */
    public void mo1789a(Bitmap bitmap) {
        if (this.f7543g != CoverSource.COVER && !TextUtils.isEmpty(this.f7540d)) {
            if (this.f7543g != CoverSource.BOOK || TextUtils.isEmpty(this.f7541e)) {
                File file = new File(Uri.parse(this.f7540d).getPath());
                if (!file.exists() && bitmap != null) {
                    m10945a(new C1347r(this, file, bitmap));
                }
            }
        }
    }

    /* renamed from: b */
    public void mo1790b(gl glVar) {
        m10948b();
    }

    /* renamed from: a */
    private void m10944a(File file, Bitmap bitmap, C1345w c1345w) {
        InputStream byteArrayInputStream;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream = null;
        if (file != null) {
            ByteArrayOutputStream byteArrayOutputStream2;
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream2);
                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream2.toByteArray());
                } catch (Exception e2) {
                    e = e2;
                    byteArrayInputStream = null;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        e.printStackTrace();
                        if (c1345w != null) {
                            UThread.runOnThread(new C1348s(this, c1345w));
                        }
                        try {
                            byteArrayOutputStream.close();
                            byteArrayInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        inputStream = byteArrayInputStream;
                        try {
                            byteArrayOutputStream2.close();
                            inputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2.close();
                    inputStream.close();
                    throw th;
                }
                try {
                    FileUtil.m785b(byteArrayInputStream, file);
                    try {
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                    } catch (Exception e32) {
                        e32.printStackTrace();
                    }
                    if (c1345w != null) {
                        UThread.runOnThread(new C1349t(this, c1345w));
                    }
                } catch (Exception e5) {
                    e32 = e5;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    e32.printStackTrace();
                    if (c1345w != null) {
                        UThread.runOnThread(new C1348s(this, c1345w));
                    }
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = byteArrayInputStream;
                    byteArrayOutputStream2.close();
                    inputStream.close();
                    throw th;
                }
            } catch (Exception e6) {
                e32 = e6;
                byteArrayInputStream = null;
                e32.printStackTrace();
                if (c1345w != null) {
                    UThread.runOnThread(new C1348s(this, c1345w));
                }
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream2 = null;
                byteArrayOutputStream2.close();
                inputStream.close();
                throw th;
            }
        } else if (c1345w != null) {
            UThread.runOnThread(new C1350u(this, c1345w));
        }
    }

    /* renamed from: a */
    private void m10945a(Runnable runnable) {
        ah.m868a(runnable, C1340l.f7530a, 0);
    }

    /* renamed from: b */
    public C1343o m10961b(String str) {
        if (!TextUtils.equals(this.f7541e, str)) {
            this.f7541e = str;
            this.f7543g = CoverSource.NONE;
        }
        if (this.f7544h != null) {
            this.f7544h.mo1793a(false);
        }
        return this;
    }
}
