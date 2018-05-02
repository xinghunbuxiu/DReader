package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.epublib.DkeGallery;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ag;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.bb;

import java.util.concurrent.Future;

class bk extends ac {
    final /* synthetic */ az a;
    private final DkeGallery b;
    private final Rect c;
    private final Rect d;
    private final bu[] e;
    private final Rect[] f;
    private final Bitmap[] g;
    private final Drawable h;

    private bk(az azVar, DkeGallery dkeGallery) {
        this.a = azVar;
        this.b = dkeGallery;
        this.c = this.b.getBoundary().toRect();
        this.d = this.b.getImageBoundaryInGallery().toRect();
        DkeHitTestInfo[] interactiveImages = this.b.getInteractiveImages();
        this.e = new bu[interactiveImages.length];
        for (int i = 0; i < this.e.length; i++) {
            this.e[i] = new bu(azVar, interactiveImages[i]);
            this.e[i].c.offset(-this.c.left, -this.c.top);
        }
        this.f = new Rect[this.b.getTitleCount()];
        this.g = new Bitmap[this.b.getTitleCount()];
        m();
        this.h = new bl(this, azVar);
    }

    public int e() {
        return this.c.width();
    }

    public int f() {
        return this.c.height();
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

    public int a() {
        a.c().b(this.a.N());
        return this.b.getCurActiveCell();
    }

    public void a(int i) {
        a.c().b(this.a.N());
        if (a() != i) {
            this.b.setCurActiveCell(i);
            m();
        }
    }

    public Rect b() {
        a.c().b(this.a.N());
        return this.d;
    }

    public Drawable c() {
        a.c().b(this.a.N());
        return this.h;
    }

    public int d() {
        a.c().b(this.a.N());
        return this.e.length;
    }

    public au b(int i) {
        a.c().b(this.a.N());
        return this.e[i];
    }

    public bb a(Point point, Point point2) {
        a.c().b(this.a.N());
        if (!this.a.G() || this.a.f.f()) {
            return new ce();
        }
        DkPos dkPos = new DkPos();
        dkPos.mX = (float) point.x;
        dkPos.mY = (float) point.y;
        DkPos dkPos2 = new DkPos();
        dkPos2.mX = (float) point2.x;
        dkPos2.mY = (float) point2.y;
        DkFlowPosition[] selectionRange = this.b.getSelectionRange(dkPos, dkPos2);
        if (selectionRange.length < 2) {
            return new ce();
        }
        return ai.a(ai.a(selectionRange[0].mChapterIndex, selectionRange[0].mParaIndex, selectionRange[0].mAtomIndex), ai.a(selectionRange[1].mChapterIndex, selectionRange[1].mParaIndex, selectionRange[1].mAtomIndex));
    }

    private void m() {
        DkFlowRenderOption dkFlowRenderOption;
        if (this.b.getTitleCount() > 0) {
            this.f[0] = this.b.getFirstTitleBoundaryInGallery().toRect();
            if (this.g[0] == null) {
                this.g[0] = com.duokan.reader.common.bitmap.a.c(this.f[0].width(), this.f[0].height(), Config.ARGB_8888);
            } else {
                this.g[0].eraseColor(0);
            }
            dkFlowRenderOption = new DkFlowRenderOption();
            this.a.a(dkFlowRenderOption, this.g[0], this.a.g);
            if (this.a.g != null) {
                dkFlowRenderOption.mOptimizeForDarkBackground = this.a.g.j;
                dkFlowRenderOption.mOptimizeForNight = this.a.g.i;
            }
            this.b.renderCellFirstTitle(a(), dkFlowRenderOption);
        }
        if (this.b.getTitleCount() > 1) {
            this.f[1] = this.b.getSecondTitleBoundaryInGallery().toRect();
            if (this.g[1] == null) {
                this.g[1] = com.duokan.reader.common.bitmap.a.c(this.f[1].width(), this.f[1].height(), Config.ARGB_8888);
            } else {
                this.g[1].eraseColor(0);
            }
            dkFlowRenderOption = new DkFlowRenderOption();
            this.a.a(dkFlowRenderOption, this.g[1], this.a.g);
            if (this.a.g != null) {
                dkFlowRenderOption.mOptimizeForDarkBackground = this.a.g.j;
                dkFlowRenderOption.mOptimizeForNight = this.a.g.i;
            }
            this.b.renderCellSecondTitle(a(), dkFlowRenderOption);
        }
    }

    private void n() {
        int i = 0;
        this.b.recycle();
        for (bu b : this.e) {
            b.b();
        }
        Bitmap[] bitmapArr = this.g;
        int length = bitmapArr.length;
        while (i < length) {
            Bitmap bitmap = bitmapArr[i];
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            i++;
        }
    }

    private boolean a(bb bbVar) {
        ce ceVar = (ce) bbVar;
        DkFlowPosition beginPosition = this.b.getBeginPosition();
        DkFlowPosition endPosition = this.b.getEndPosition();
        return ai.a(ceVar.j().b(this.a.Z()), beginPosition, endPosition) && ai.a(ceVar.k().b(this.a.Z()), beginPosition, endPosition);
    }

    public boolean j() {
        return true;
    }

    public ag k() {
        return b(a()).k();
    }

    public Rect l() {
        return b();
    }

    public Future a(com.duokan.core.sys.ag agVar) {
        return b(a()).a(agVar);
    }

    public Future b(com.duokan.core.sys.ag agVar) {
        return b(a()).b(agVar);
    }
}
