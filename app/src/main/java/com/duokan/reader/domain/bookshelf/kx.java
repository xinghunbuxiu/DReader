package com.duokan.reader.domain.bookshelf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.duokan.core.io.IOUtils;
import com.duokan.core.sys.C0352r;
import com.duokan.reader.domain.document.sbk.C0824v;
import java.io.Closeable;

class kx implements C0824v {
    /* renamed from: a */
    final /* synthetic */ kh f3494a;
    /* renamed from: b */
    private final ky f3495b;

    public kx(kh khVar, ky kyVar) {
        this.f3494a = khVar;
        this.f3495b = kyVar;
    }

    /* renamed from: a */
    public boolean m4883a() {
        try {
            boolean a = this.f3494a.br().mo418a(this.f3495b.f3497b);
            return a;
        } finally {
            this.f3494a.bs();
        }
    }

    /* renamed from: c */
    public String mo1124c() {
        return this.f3495b.f3496a;
    }

    /* renamed from: d */
    public String mo1125d() {
        return "";
    }

    /* renamed from: e */
    public String mo1126e() {
        return "";
    }

    /* renamed from: b */
    public int mo1131b() {
        return this.f3495b.f3501f;
    }

    /* renamed from: f */
    public int mo1132f() {
        return this.f3495b.f3502g;
    }

    /* renamed from: g */
    public boolean m4890g() {
        return m4883a();
    }

    /* renamed from: a */
    public boolean mo1130a(Canvas canvas, Rect rect) {
        C0352r a = this.f3494a.br();
        Closeable c;
        try {
            if (m4890g()) {
                c = a.mo422c(this.f3495b.f3497b);
                Bitmap decodeStream = BitmapFactory.decodeStream(c);
                if (decodeStream != null) {
                    canvas.drawBitmap(decodeStream, rect, new Rect(0, 0, rect.width(), rect.height()), null);
                    decodeStream.recycle();
                }
                IOUtils.close(c);
                this.f3494a.bs();
                return true;
            }
            this.f3494a.bs();
            return false;
        } catch (Throwable th) {
            this.f3494a.bs();
        }
    }
}
