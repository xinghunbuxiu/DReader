package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.common.bitmap.C0544a;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpStatus;

public abstract class as extends Drawable {
    /* renamed from: b */
    static final /* synthetic */ boolean f4343b = (!as.class.desiredAssertionStatus());
    /* renamed from: c */
    private static Handler f4344c = new Handler(Looper.getMainLooper());
    /* renamed from: d */
    private static WeakReference<Drawable> f4345d = new WeakReference(null);
    /* renamed from: e */
    private static Bitmap f4346e = null;
    /* renamed from: a */
    protected final Paint f4347a = new Paint();
    /* renamed from: f */
    private int f4348f = 0;
    /* renamed from: g */
    private int f4349g = 0;
    /* renamed from: h */
    private Rect f4350h = new Rect();
    /* renamed from: i */
    private int f4351i = 0;
    /* renamed from: j */
    private boolean f4352j = false;

    /* renamed from: A */
    public abstract Rect mo1280A();

    /* renamed from: B */
    public abstract int mo1281B();

    /* renamed from: E */
    public abstract boolean mo1282E();

    /* renamed from: F */
    public abstract boolean mo1283F();

    /* renamed from: G */
    public abstract boolean mo1284G();

    /* renamed from: H */
    public abstract void mo1285H();

    /* renamed from: I */
    public abstract String mo1286I();

    /* renamed from: J */
    public abstract String mo1287J();

    /* renamed from: N */
    protected abstract void mo1288N();

    /* renamed from: a */
    public abstract int mo1289a(Point point, int i);

    /* renamed from: a */
    public abstract int mo1290a(bb bbVar);

    /* renamed from: a */
    public abstract Rect mo1291a(au auVar);

    /* renamed from: a */
    public abstract ae mo1292a(Point point);

    /* renamed from: a */
    public abstract bb mo1293a(Point point, Point point2);

    /* renamed from: a */
    public abstract void mo1296a(C0923m c0923m);

    /* renamed from: a */
    public abstract void mo1297a(Runnable runnable, Runnable runnable2);

    /* renamed from: a */
    public abstract void mo1298a(boolean z);

    /* renamed from: b */
    protected abstract int mo1300b(Canvas canvas, long j);

    /* renamed from: b */
    public abstract Rect mo1301b(Rect rect);

    /* renamed from: b */
    public abstract bb mo1302b(Point point);

    /* renamed from: b */
    public abstract String mo1303b(bb bbVar);

    /* renamed from: c */
    public abstract int mo1306c(Point point);

    /* renamed from: c */
    public abstract Rect mo1307c(Rect rect);

    /* renamed from: c */
    public abstract af mo1308c(int i);

    /* renamed from: c */
    public abstract String mo1309c(bb bbVar);

    /* renamed from: d */
    public abstract int mo1310d(Point point);

    /* renamed from: d */
    public abstract Rect mo1311d(bb bbVar);

    /* renamed from: d */
    public abstract aw mo1312d(int i);

    /* renamed from: e */
    public abstract int mo1314e(Point point);

    /* renamed from: e */
    public abstract ab mo1315e(int i);

    /* renamed from: e */
    public abstract Rect[] mo1316e(bb bbVar);

    /* renamed from: f */
    public abstract int mo1317f(Point point);

    /* renamed from: f */
    public abstract Point mo1318f(bb bbVar);

    /* renamed from: f */
    public abstract ah mo1319f(int i);

    /* renamed from: g */
    public abstract int mo1320g(Point point);

    /* renamed from: g */
    public abstract Point mo1321g(bb bbVar);

    /* renamed from: g */
    public abstract Rect mo1322g(int i);

    /* renamed from: h */
    public abstract Rect mo1325h(int i);

    /* renamed from: i */
    public abstract Rect mo1326i(int i);

    /* renamed from: j */
    public abstract long mo1327j();

    /* renamed from: j */
    public abstract Rect mo1328j(int i);

    /* renamed from: k */
    public abstract ac mo1329k(int i);

    /* renamed from: k */
    public abstract boolean mo1330k();

    /* renamed from: l */
    public abstract Rect mo1331l(int i);

    /* renamed from: l */
    public abstract ak mo1332l();

    /* renamed from: m */
    public abstract Rect mo1333m(int i);

    /* renamed from: m */
    public abstract bb mo1334m();

    /* renamed from: n */
    public abstract aj mo1335n(int i);

    /* renamed from: n */
    public abstract C0897d[] mo1336n();

    /* renamed from: o */
    public abstract Rect mo1337o(int i);

    /* renamed from: o */
    public abstract CharSequence mo1338o();

    /* renamed from: p */
    public abstract Rect mo1339p(int i);

    /* renamed from: p */
    public abstract C0917k mo1340p();

    /* renamed from: q */
    public abstract ad mo1341q(int i);

    /* renamed from: q */
    public abstract C0923m mo1342q();

    /* renamed from: r */
    public abstract int mo1343r();

    /* renamed from: r */
    public abstract Rect mo1344r(int i);

    /* renamed from: s */
    public abstract int mo1345s();

    /* renamed from: s */
    public abstract ax mo1346s(int i);

    /* renamed from: t */
    public abstract int mo1347t();

    /* renamed from: t */
    public abstract Rect mo1348t(int i);

    /* renamed from: u */
    public abstract int mo1349u();

    /* renamed from: u */
    public abstract Rect mo1350u(int i);

    /* renamed from: v */
    public abstract int mo1351v();

    /* renamed from: v */
    public abstract int mo1352v(int i);

    /* renamed from: w */
    public abstract int mo1353w();

    /* renamed from: x */
    public abstract int mo1354x();

    /* renamed from: y */
    public abstract int mo1355y();

    /* renamed from: z */
    public abstract Rect mo1356z();

    /* renamed from: f */
    public int m6141f() {
        return this.f4348f;
    }

    /* renamed from: a */
    public void m6115a(int i) {
        this.f4348f = i;
    }

    /* renamed from: g */
    public int m6145g() {
        return this.f4349g;
    }

    /* renamed from: b */
    public void m6129b(int i) {
        this.f4349g = i;
    }

    /* renamed from: h */
    public Rect m6149h() {
        return this.f4350h;
    }

    /* renamed from: a */
    public void m6120a(Rect rect) {
        this.f4350h.set(rect);
        mo1313d(this.f4350h);
    }

    /* renamed from: i */
    public int m6151i() {
        return this.f4351i;
    }

    /* renamed from: C */
    public final boolean m6098C() {
        return this.f4352j;
    }

    /* renamed from: D */
    public List<String> mo1456D() {
        return Collections.emptyList();
    }

    /* renamed from: a */
    public final void m6117a(Canvas canvas, long j) {
        this.f4351i = 0;
        this.f4352j = false;
        if (!mo1283F() && !mo1342q().f4367o) {
            canvas.save();
            canvas.clipRect(getBounds());
            canvas.translate((float) getBounds().left, (float) getBounds().top);
            C0923m q = mo1342q();
            this.f4347a.setColor(q.f4357e == 0 ? Color.rgb(HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING) : q.f4357e);
            this.f4347a.setSubpixelText(true);
            this.f4347a.setAntiAlias(true);
            this.f4351i = mo1300b(canvas, j);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return mo1340p().f4330a;
    }

    public int getIntrinsicHeight() {
        return mo1340p().f4331b;
    }

    public final void draw(Canvas canvas) {
        m6117a(canvas, 0);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f4352j = true;
    }

    /* renamed from: d */
    protected void mo1313d(Rect rect) {
    }

    /* renamed from: a */
    protected void mo1376a(Canvas canvas) {
        WebLog.init().w(m6108M());
        int i = mo1340p().f4330a;
        int i2 = mo1340p().f4331b;
        Drawable drawable = mo1342q().f4353a;
        if (mo1340p().mo1274c()) {
            canvas.drawColor(-1);
        } else if (mo1340p().f4334e) {
            canvas.drawColor(0);
        } else if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
        } else {
            canvas.drawColor(0);
        }
        this.f4351i = 2;
        invalidateSelf();
    }

    /* renamed from: K */
    protected Bitmap m6106K() {
        return f4346e;
    }

    /* renamed from: L */
    protected boolean m6107L() {
        WebLog.init().w(m6108M());
        Drawable drawable = (Drawable) f4345d.get();
        if (mo1340p().mo1274c()) {
            if (drawable == null && f4346e == null) {
                return false;
            }
            if (f4346e != null) {
                synchronized (f4346e) {
                    mo1305b();
                }
            } else {
                mo1305b();
            }
            return true;
        } else if (!mo1342q().f4368p) {
            int i = mo1340p().f4330a;
            int i2 = mo1340p().f4331b;
            if (drawable == mo1342q().f4353a && f4346e != null && f4346e.getWidth() == i && f4346e.getHeight() == i2) {
                return false;
            }
            if (f4346e != null) {
                synchronized (f4346e) {
                    mo1299a();
                }
            } else {
                mo1299a();
            }
            return true;
        } else if (drawable == null && f4346e == null) {
            return false;
        } else {
            if (f4346e != null) {
                synchronized (f4346e) {
                    mo1305b();
                }
            } else {
                mo1305b();
            }
            return true;
        }
    }

    /* renamed from: a */
    private void mo1299a() {
        if (f4343b || f4346e == null || Thread.holdsLock(f4346e)) {
            mo1305b();
            int i = mo1340p().f4330a;
            int i2 = mo1340p().f4331b;
            Drawable drawable = mo1342q().f4353a;
            if (drawable != null) {
                Bitmap c = C0544a.m2447c(i, i2, Config.RGB_565);
                Canvas canvas = new Canvas(c);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                f4345d = new WeakReference(drawable);
                f4346e = c;
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private void mo1305b() {
        if (f4343b || f4346e == null || Thread.holdsLock(f4346e)) {
            if (f4346e != null) {
                f4346e.recycle();
                f4346e = null;
            }
            f4345d = new WeakReference(null);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m6118a(Canvas canvas, String str, int i, int i2, Paint paint) {
        C0917k p = mo1340p();
        RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
        if (i == 3) {
            rectF.set((float) p.f4332c.left, 0.0f, (float) Math.min(getBounds().width() - p.f4332c.right, p.f4332c.left + i2), (float) p.f4332c.top);
        } else {
            rectF.set((float) Math.max((getBounds().width() - p.f4332c.right) - i2, p.f4332c.left), 0.0f, (float) (getBounds().width() - p.f4332c.right), (float) p.f4332c.top);
        }
        AnimUtils.m1914a(canvas, str, rectF, i | 80, paint);
        AnimUtils.f1199h.clearAnimation(rectF);
    }

    /* renamed from: a */
    protected void m6119a(Canvas canvas, String str, int i, Paint paint) {
        C0917k p = mo1340p();
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(p.f4332c.left, getBounds().height() - p.f4332c.bottom, getBounds().width() - p.f4332c.right, (getBounds().height() - p.f4332c.bottom) + mo1342q().f4358f);
        AnimUtils.m1913a(canvas, str, rect, i | 16, paint);
        AnimUtils.f1198g.clearAnimation(rect);
    }

    /* renamed from: a */
    protected void m6122a(Runnable runnable) {
        f4344c.post(runnable);
    }

    /* renamed from: M */
    protected boolean m6108M() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
