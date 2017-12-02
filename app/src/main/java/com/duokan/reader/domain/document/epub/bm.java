package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.duokan.core.sys.ah;
import com.duokan.kernel.DkAtomRenderOption;
import com.duokan.kernel.epublib.DkeInteractiveGifImage;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ag;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class bm implements ad {
    final /* synthetic */ az a;
    private final Rect b;
    private DkeInteractiveGifImage c;
    private boolean d;

    private bm(az azVar, DkeInteractiveGifImage dkeInteractiveGifImage) {
        this.a = azVar;
        this.d = true;
        this.c = dkeInteractiveGifImage;
        this.b = dkeInteractiveGifImage.getBoundingBox().toRect();
    }

    public int e() {
        return this.c.getWidth();
    }

    public int f() {
        return this.c.getHeight();
    }

    public float g() {
        return 1.0f;
    }

    public float h() {
        return 1.0f;
    }

    public float i() {
        return 0.0f;
    }

    public boolean j() {
        return this.d;
    }

    public ag k() {
        return new bn(this);
    }

    public Rect l() {
        return null;
    }

    public Future a(com.duokan.core.sys.ag agVar) {
        Runnable futureTask = new FutureTask(new bo(this, agVar));
        ah.b(futureTask);
        return futureTask;
    }

    public Future b(com.duokan.core.sys.ag agVar) {
        return null;
    }

    public int a() {
        return this.c.getFrameCount();
    }

    public int a(int i) {
        return this.c.getDuration(i);
    }

    public void a(int i, Bitmap bitmap) {
        DkAtomRenderOption dkAtomRenderOption = new DkAtomRenderOption();
        dkAtomRenderOption.mWidth = e();
        dkAtomRenderOption.mHeight = f();
        dkAtomRenderOption.mBitmap = bitmap;
        dkAtomRenderOption.mScale = Math.min((((float) bitmap.getWidth()) * 1.0f) / ((float) e()), (((float) bitmap.getHeight()) * 1.0f) / ((float) f()));
        this.c.render(i, dkAtomRenderOption);
    }

    public void b() {
        this.d = false;
    }
}
