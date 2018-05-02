package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.epublib.DkeComicsFrame;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.e;

public class d extends e {
    static final /* synthetic */ boolean a = (!d.class.desiredAssertionStatus());
    private final DkeBook b;
    private final int c;
    private final long d;
    private final String e;
    private final Rect f;

    public /* synthetic */ av a() {
        return d();
    }

    protected d(DkeBook dkeBook, int i) {
        this.b = dkeBook;
        this.c = i;
        this.d = this.b.getChapterIndexOfFrame((long) i);
        DkeComicsFrame comicsFrame = this.b.getComicsFrame((long) this.c);
        if (a || comicsFrame != null) {
            this.e = comicsFrame.getComicsImagePath();
            this.f = comicsFrame.getFrameBoundaryOnImage().toRect();
            return;
        }
        throw new AssertionError();
    }

    public c d() {
        return new c(this.d, 0, 0);
    }

    public int b() {
        return this.f.width();
    }

    public int c() {
        return this.f.height();
    }

    public Bitmap a(int i, int i2) {
        Bitmap c = a.c(i, i2, Config.RGB_565);
        c.eraseColor(-1);
        DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
        dkFlowRenderOption.mBitmap = c;
        this.b.renderImage(this.e, dkFlowRenderOption, new DkBox((float) this.f.left, (float) this.f.top, (float) this.f.right, (float) this.f.bottom), new DkBox(0.0f, 0.0f, (float) i, (float) i2), 0, 0);
        return c;
    }
}
