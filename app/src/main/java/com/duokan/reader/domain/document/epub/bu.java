package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.ag;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class bu implements at {
    /* renamed from: b */
    protected final boolean f4585b;
    /* renamed from: c */
    protected final Rect f4586c;
    /* renamed from: d */
    protected final float f4587d;
    /* renamed from: e */
    protected final float f4588e;
    /* renamed from: f */
    protected final float f4589f;
    /* renamed from: g */
    protected final br f4590g;
    /* renamed from: h */
    protected final Rect f4591h;
    /* renamed from: i */
    protected final av f4592i;
    /* renamed from: j */
    protected final av f4593j;
    /* renamed from: k */
    protected boolean f4594k;
    /* renamed from: l */
    final /* synthetic */ az f4595l;

    private bu(az azVar, DkeHitTestInfo dkeHitTestInfo) {
        this.f4595l = azVar;
        this.f4594k = false;
        this.f4585b = dkeHitTestInfo.mObjType == 5;
        this.f4586c = dkeHitTestInfo.mBoundingBox.toRect();
        this.f4587d = (float) Math.sqrt(Math.pow((double) dkeHitTestInfo.mPageMatrix.mM11, 2.0d) + Math.pow((double) dkeHitTestInfo.mPageMatrix.mM12, 2.0d));
        this.f4588e = (float) Math.sqrt(Math.pow((double) dkeHitTestInfo.mPageMatrix.mM21, 2.0d) + Math.pow((double) dkeHitTestInfo.mPageMatrix.mM22, 2.0d));
        this.f4589f = (float) (-((57.29577951308232d * Math.atan2((double) dkeHitTestInfo.mPageMatrix.mM22, (double) dkeHitTestInfo.mPageMatrix.mM21)) - 90.0d));
        this.f4591h = dkeHitTestInfo.mClipBox.toRect();
        this.f4590g = new br(azVar, dkeHitTestInfo);
        this.f4592i = azVar.f4524e.mo1368a(this.f4590g.f4598b, false);
        this.f4593j = azVar.f4524e.mo1368a(this.f4590g.f4598b, true);
    }

    /* renamed from: b */
    public void mo1417b() {
        if (!this.f4594k) {
            this.f4594k = true;
        }
    }

    /* renamed from: e */
    public int mo1390e() {
        return this.f4586c.width();
    }

    /* renamed from: f */
    public int mo1391f() {
        return this.f4586c.height();
    }

    /* renamed from: g */
    public float mo1392g() {
        return this.f4587d;
    }

    /* renamed from: h */
    public float mo1393h() {
        return this.f4588e;
    }

    /* renamed from: i */
    public float mo1394i() {
        return this.f4589f;
    }

    /* renamed from: j */
    public boolean mo1395j() {
        return this.f4585b;
    }

    /* renamed from: l */
    public Rect mo1397l() {
        return this.f4591h;
    }

    /* renamed from: k */
    public ag mo1396k() {
        return this.f4590g;
    }

    /* renamed from: a */
    public Future<Bitmap> mo1383a(com.duokan.core.sys.ag<Bitmap> agVar) {
        Runnable futureTask = new FutureTask(new bv(this, agVar));
        if (this.f4594k) {
            futureTask.cancel(false);
            if (agVar != null) {
                agVar.run(null);
            }
        } else {
            this.f4595l.f4524e.m5841b((Object) this.f4595l);
            ah.m866a(futureTask, az.f4515d);
        }
        return futureTask;
    }

    /* renamed from: b */
    public Future<Bitmap> mo1387b(com.duokan.core.sys.ag<Bitmap> agVar) {
        Runnable futureTask = new FutureTask(new bx(this, agVar));
        if (this.f4594k) {
            futureTask.cancel(false);
            if (agVar != null) {
                agVar.run(null);
            }
        } else {
            this.f4595l.f4524e.m5841b((Object) this.f4595l);
            ah.m866a(futureTask, az.f4515d);
        }
        return futureTask;
    }

    /* renamed from: a */
    public av mo1409a(boolean z) {
        return z ? this.f4593j : this.f4592i;
    }

    /* renamed from: a */
    private Bitmap m6726a(int i, int i2, int i3, int i4, int i5, int i6) {
        Bitmap c = C0544a.m2447c(i5, i6, Config.RGB_565);
        c.eraseColor(-1);
        DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
        this.f4595l.m6547a(dkFlowRenderOption, c, this.f4595l.f4526g);
        DkBox dkBox = new DkBox((float) i, (float) i2, (float) (i + i3), (float) (i2 + i4));
        DkBox dkBox2 = new DkBox(0.0f, 0.0f, (float) c.getWidth(), (float) c.getHeight());
        this.f4595l.f4524e.mo1370f();
        if (this.f4595l.m6544Y().renderImage(this.f4590g.f4598b, dkFlowRenderOption, dkBox, dkBox2, this.f4590g.f4599c, this.f4590g.f4600d) == 0) {
            return c;
        }
        c.recycle();
        return null;
    }
}
