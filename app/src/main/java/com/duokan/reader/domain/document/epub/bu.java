package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

import com.duokan.core.sys.ah;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.domain.document.ag;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class bu implements at {
    protected final boolean b;
    protected final Rect c;
    protected final float d;
    protected final float e;
    protected final float f;
    protected final br g;
    protected final Rect h;
    protected final av i;
    protected final av j;
    protected boolean k;
    final /* synthetic */ az l;

    private bu(az azVar, DkeHitTestInfo dkeHitTestInfo) {
        this.l = azVar;
        this.k = false;
        this.b = dkeHitTestInfo.mObjType == 5;
        this.c = dkeHitTestInfo.mBoundingBox.toRect();
        this.d = (float) Math.sqrt(Math.pow((double) dkeHitTestInfo.mPageMatrix.mM11, 2.0d) + Math.pow((double) dkeHitTestInfo.mPageMatrix.mM12, 2.0d));
        this.e = (float) Math.sqrt(Math.pow((double) dkeHitTestInfo.mPageMatrix.mM21, 2.0d) + Math.pow((double) dkeHitTestInfo.mPageMatrix.mM22, 2.0d));
        this.f = (float) (-((57.29577951308232d * Math.atan2((double) dkeHitTestInfo.mPageMatrix.mM22, (double) dkeHitTestInfo.mPageMatrix.mM21)) - 90.0d));
        this.h = dkeHitTestInfo.mClipBox.toRect();
        this.g = new br(azVar, dkeHitTestInfo);
        this.i = azVar.e.a(this.g.b, false);
        this.j = azVar.e.a(this.g.b, true);
    }

    public void b() {
        if (!this.k) {
            this.k = true;
        }
    }

    public int e() {
        return this.c.width();
    }

    public int f() {
        return this.c.height();
    }

    public float g() {
        return this.d;
    }

    public float h() {
        return this.e;
    }

    public float i() {
        return this.f;
    }

    public boolean j() {
        return this.b;
    }

    public Rect l() {
        return this.h;
    }

    public ag k() {
        return this.g;
    }

    public Future a(com.duokan.core.sys.ag agVar) {
        Runnable futureTask = new FutureTask(new bv(this, agVar));
        if (this.k) {
            futureTask.cancel(false);
            if (agVar != null) {
                agVar.a(null);
            }
        } else {
            this.l.e.b((Object) this.l);
            ah.a(futureTask, az.d);
        }
        return futureTask;
    }

    public Future b(com.duokan.core.sys.ag agVar) {
        Runnable futureTask = new FutureTask(new bx(this, agVar));
        if (this.k) {
            futureTask.cancel(false);
            if (agVar != null) {
                agVar.a(null);
            }
        } else {
            this.l.e.b((Object) this.l);
            ah.a(futureTask, az.d);
        }
        return futureTask;
    }

    public av a(boolean z) {
        return z ? this.j : this.i;
    }

    private Bitmap a(int i, int i2, int i3, int i4, int i5, int i6) {
        Bitmap c = a.c(i5, i6, Config.RGB_565);
        c.eraseColor(-1);
        DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
        this.l.a(dkFlowRenderOption, c, this.l.g);
        DkBox dkBox = new DkBox((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4));
        DkBox dkBox2 = new DkBox(0.0f, 0.0f, (float) c.getWidth(), (float) c.getHeight());
        this.l.e.f();
        if (this.l.Z().renderImage(this.g.b, dkFlowRenderOption, dkBox, dkBox2, this.g.c, this.g.d) == 0) {
            return c;
        }
        c.recycle();
        return null;
    }
}
