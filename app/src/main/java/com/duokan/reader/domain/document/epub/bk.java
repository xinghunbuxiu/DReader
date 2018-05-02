package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.epublib.DkeGallery;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ag;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.bb;
import java.util.concurrent.Future;

class bk extends ac {
    /* renamed from: a */
    final /* synthetic */ az f4563a;
    /* renamed from: b */
    private final DkeGallery f4564b;
    /* renamed from: c */
    private final Rect f4565c;
    /* renamed from: d */
    private final Rect f4566d;
    /* renamed from: e */
    private final bu[] f4567e;
    /* renamed from: f */
    private final Rect[] f4568f;
    /* renamed from: g */
    private final Bitmap[] f4569g;
    /* renamed from: h */
    private final Drawable f4570h;

    private bk(az azVar, DkeGallery dkeGallery) {
        this.f4563a = azVar;
        this.f4564b = dkeGallery;
        this.f4565c = this.f4564b.getBoundary().toRect();
        this.f4566d = this.f4564b.getImageBoundaryInGallery().toRect();
        DkeHitTestInfo[] interactiveImages = this.f4564b.getInteractiveImages();
        this.f4567e = new bu[interactiveImages.length];
        for (int i = 0; i < this.f4567e.length; i++) {
            this.f4567e[i] = new bu(azVar, interactiveImages[i]);
            this.f4567e[i].f4586c.offset(-this.f4565c.left, -this.f4565c.top);
        }
        this.f4568f = new Rect[this.f4564b.getTitleCount()];
        this.f4569g = new Bitmap[this.f4564b.getTitleCount()];
        m6682m();
        this.f4570h = new bl(this, azVar);
    }

    /* renamed from: e */
    public int mo1390e() {
        return this.f4565c.width();
    }

    /* renamed from: f */
    public int mo1391f() {
        return this.f4565c.height();
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

    /* renamed from: a */
    public int mo1381a() {
        WebLog.init().w(this.f4563a.m6108M());
        return this.f4564b.getCurActiveCell();
    }

    /* renamed from: a */
    public void mo1384a(int i) {
        WebLog.init().w(this.f4563a.m6108M());
        if (mo1381a() != i) {
            this.f4564b.setCurActiveCell(i);
            m6682m();
        }
    }

    /* renamed from: b */
    public Rect mo1385b() {
        WebLog.init().w(this.f4563a.m6108M());
        return this.f4566d;
    }

    /* renamed from: c */
    public Drawable mo1388c() {
        WebLog.init().w(this.f4563a.m6108M());
        return this.f4570h;
    }

    /* renamed from: d */
    public int mo1389d() {
        WebLog.init().w(this.f4563a.m6108M());
        return this.f4567e.length;
    }

    /* renamed from: b */
    public au mo1386b(int i) {
        WebLog.init().w(this.f4563a.m6108M());
        return this.f4567e[i];
    }

    /* renamed from: a */
    public bb mo1382a(Point point, Point point2) {
        WebLog.init().w(this.f4563a.m6108M());
        if (!this.f4563a.mo1284G() || this.f4563a.f4525f.m5817f()) {
            return new ce();
        }
        DkPos dkPos = new DkPos();
        dkPos.mX = (float) point.x;
        dkPos.mY = (float) point.y;
        DkPos dkPos2 = new DkPos();
        dkPos2.mX = (float) point2.x;
        dkPos2.mY = (float) point2.y;
        DkFlowPosition[] selectionRange = this.f4564b.getSelectionRange(dkPos, dkPos2);
        if (selectionRange.length < 2) {
            return new ce();
        }
        return ai.m6509a(ai.m6508a(selectionRange[0].mChapterIndex, selectionRange[0].mParaIndex, selectionRange[0].mAtomIndex), ai.m6508a(selectionRange[1].mChapterIndex, selectionRange[1].mParaIndex, selectionRange[1].mAtomIndex));
    }

    /* renamed from: m */
    private void m6682m() {
        DkFlowRenderOption dkFlowRenderOption;
        if (this.f4564b.getTitleCount() > 0) {
            this.f4568f[0] = this.f4564b.getFirstTitleBoundaryInGallery().toRect();
            if (this.f4569g[0] == null) {
                this.f4569g[0] = C0544a.m2447c(this.f4568f[0].width(), this.f4568f[0].height(), Config.ARGB_8888);
            } else {
                this.f4569g[0].eraseColor(0);
            }
            dkFlowRenderOption = new DkFlowRenderOption();
            this.f4563a.m6547a(dkFlowRenderOption, this.f4569g[0], this.f4563a.f4526g);
            if (this.f4563a.f4526g != null) {
                dkFlowRenderOption.mOptimizeForDarkBackground = this.f4563a.f4526g.j;
                dkFlowRenderOption.mOptimizeForNight = this.f4563a.f4526g.i;
            }
            this.f4564b.renderCellFirstTitle(mo1381a(), dkFlowRenderOption);
        }
        if (this.f4564b.getTitleCount() > 1) {
            this.f4568f[1] = this.f4564b.getSecondTitleBoundaryInGallery().toRect();
            if (this.f4569g[1] == null) {
                this.f4569g[1] = C0544a.m2447c(this.f4568f[1].width(), this.f4568f[1].height(), Config.ARGB_8888);
            } else {
                this.f4569g[1].eraseColor(0);
            }
            dkFlowRenderOption = new DkFlowRenderOption();
            this.f4563a.m6547a(dkFlowRenderOption, this.f4569g[1], this.f4563a.f4526g);
            if (this.f4563a.f4526g != null) {
                dkFlowRenderOption.mOptimizeForDarkBackground = this.f4563a.f4526g.j;
                dkFlowRenderOption.mOptimizeForNight = this.f4563a.f4526g.i;
            }
            this.f4564b.renderCellSecondTitle(mo1381a(), dkFlowRenderOption);
        }
    }

    /* renamed from: n */
    private void m6683n() {
        int i = 0;
        this.f4564b.recycle();
        for (bu b : this.f4567e) {
            b.mo1417b();
        }
        Bitmap[] bitmapArr = this.f4569g;
        int length = bitmapArr.length;
        while (i < length) {
            Bitmap bitmap = bitmapArr[i];
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            i++;
        }
    }

    /* renamed from: a */
    private boolean m6675a(bb bbVar) {
        ce ceVar = (ce) bbVar;
        DkFlowPosition beginPosition = this.f4564b.getBeginPosition();
        DkFlowPosition endPosition = this.f4564b.getEndPosition();
        return ai.m6513a(ceVar.m6813j().m6774b(this.f4563a.m6544Y()), beginPosition, endPosition) && ai.m6513a(ceVar.m6814k().m6774b(this.f4563a.m6544Y()), beginPosition, endPosition);
    }

    /* renamed from: j */
    public boolean mo1395j() {
        return true;
    }

    /* renamed from: k */
    public ag mo1396k() {
        return mo1386b(mo1381a()).mo1396k();
    }

    /* renamed from: l */
    public Rect mo1397l() {
        return mo1385b();
    }

    /* renamed from: a */
    public Future<Bitmap> mo1383a(com.duokan.core.sys.ag<Bitmap> agVar) {
        return mo1386b(mo1381a()).mo1383a(agVar);
    }

    /* renamed from: b */
    public Future<Bitmap> mo1387b(com.duokan.core.sys.ag<Bitmap> agVar) {
        return mo1386b(mo1381a()).mo1387b(agVar);
    }
}
