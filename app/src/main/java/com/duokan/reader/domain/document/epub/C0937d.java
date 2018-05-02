package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.epublib.DkeComicsFrame;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C0932e;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.document.epub.d */
public class C0937d extends C0932e {
    /* renamed from: a */
    static final /* synthetic */ boolean f4665a = (!C0937d.class.desiredAssertionStatus());
    /* renamed from: b */
    private final DkeBook f4666b;
    /* renamed from: c */
    private final int f4667c;
    /* renamed from: d */
    private final long f4668d;
    /* renamed from: e */
    private final String f4669e;
    /* renamed from: f */
    private final Rect f4670f;

    /* renamed from: a */
    public /* synthetic */ av mo1429a() {
        return m6823d();
    }

    protected C0937d(DkeBook dkeBook, int i) {
        this.f4666b = dkeBook;
        this.f4667c = i;
        this.f4668d = this.f4666b.getChapterIndexOfFrame((long) i);
        DkeComicsFrame comicsFrame = this.f4666b.getComicsFrame((long) this.f4667c);
        if (f4665a || comicsFrame != null) {
            this.f4669e = comicsFrame.getComicsImagePath();
            this.f4670f = comicsFrame.getFrameBoundaryOnImage().toRect();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public C0936c m6823d() {
        return new C0936c(this.f4668d, 0, 0);
    }

    /* renamed from: b */
    public int mo1430b() {
        return this.f4670f.width();
    }

    /* renamed from: c */
    public int mo1431c() {
        return this.f4670f.height();
    }

    /* renamed from: a */
    public Bitmap mo1428a(int i, int i2) {
        Bitmap c = C0544a.m2447c(i, i2, Config.RGB_565);
        c.eraseColor(-1);
        DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
        dkFlowRenderOption.mBitmap = c;
        this.f4666b.renderImage(this.f4669e, dkFlowRenderOption, new DkBox((float) this.f4670f.left, (float) this.f4670f.top, (float) this.f4670f.right, (float) this.f4670f.bottom), new DkBox(0.0f, 0.0f, (float) i, (float) i2), 0, 0);
        return c;
    }
}
