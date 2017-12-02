package com.duokan.reader.domain.bookshelf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.duokan.core.io.d;
import com.duokan.core.sys.r;
import com.duokan.reader.domain.document.sbk.v;

import java.io.Closeable;

class kl implements v {
    final /* synthetic */ jv a;
    private final km b;

    public kl(jv jvVar, km kmVar) {
        this.a = jvVar;
        this.b = kmVar;
    }

    public boolean a() {
        try {
            boolean a = this.a.bp().a(this.b.b);
            return a;
        } finally {
            this.a.bq();
        }
    }

    public String c() {
        return this.b.a;
    }

    public String d() {
        return "";
    }

    public String e() {
        return "";
    }

    public int b() {
        return this.b.f;
    }

    public int f() {
        return this.b.g;
    }

    public boolean g() {
        return a();
    }

    public boolean a(Canvas canvas, Rect rect) {
        r a = this.a.bp();
        Closeable c;
        try {
            if (g()) {
                c = a.c(this.b.b);
                Bitmap decodeStream = BitmapFactory.decodeStream(c);
                if (decodeStream != null) {
                    canvas.drawBitmap(decodeStream, rect, new Rect(0, 0, rect.width(), rect.height()), null);
                    decodeStream.recycle();
                }
                d.a(c);
                this.a.bq();
                return true;
            }
            this.a.bq();
            return false;
        } catch (Throwable th) {
            this.a.bq();
        }
    }
}
