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
    /* renamed from: a */
    final /* synthetic */ az f4573a;
    /* renamed from: b */
    private final Rect f4574b;
    /* renamed from: c */
    private DkeInteractiveGifImage f4575c;
    /* renamed from: d */
    private boolean f4576d;

    private bm(az azVar, DkeInteractiveGifImage dkeInteractiveGifImage) {
        this.f4573a = azVar;
        this.f4576d = true;
        this.f4575c = dkeInteractiveGifImage;
        this.f4574b = dkeInteractiveGifImage.getBoundingBox().toRect();
    }

    /* renamed from: e */
    public int mo1390e() {
        return this.f4575c.getWidth();
    }

    /* renamed from: f */
    public int mo1391f() {
        return this.f4575c.getHeight();
    }

    /* renamed from: g */
    public float mo1392g() {
        return 1.0f;
    }

    /* renamed from: h */
    public float mo1393h() {
        return 1.0f;
    }

    /* renamed from: i */
    public float mo1394i() {
        return 0.0f;
    }

    /* renamed from: j */
    public boolean mo1395j() {
        return this.f4576d;
    }

    /* renamed from: k */
    public ag mo1396k() {
        return new bn(this);
    }

    /* renamed from: l */
    public Rect mo1397l() {
        return null;
    }

    /* renamed from: a */
    public Future<Bitmap> mo1383a(com.duokan.core.sys.ag<Bitmap> agVar) {
        Runnable futureTask = new FutureTask(new bo(this, agVar));
        ah.m871b(futureTask);
        return futureTask;
    }

    /* renamed from: b */
    public Future<Bitmap> mo1387b(com.duokan.core.sys.ag<Bitmap> agVar) {
        return null;
    }

    /* renamed from: a */
    public int mo1398a() {
        return this.f4575c.getFrameCount();
    }

    /* renamed from: a */
    public int mo1399a(int i) {
        return this.f4575c.getDuration(i);
    }

    /* renamed from: a */
    public void mo1400a(int i, Bitmap bitmap) {
        DkAtomRenderOption dkAtomRenderOption = new DkAtomRenderOption();
        dkAtomRenderOption.mWidth = mo1390e();
        dkAtomRenderOption.mHeight = mo1391f();
        dkAtomRenderOption.mBitmap = bitmap;
        dkAtomRenderOption.mScale = Math.min((((float) bitmap.getWidth()) * 1.0f) / ((float) mo1390e()), (((float) bitmap.getHeight()) * 1.0f) / ((float) mo1391f()));
        this.f4575c.render(i, dkAtomRenderOption);
    }

    /* renamed from: b */
    public void m6708b() {
        this.f4576d = false;
    }
}
