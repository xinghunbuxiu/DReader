package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.duokan.core.sys.UThread;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

final class abq {
    /* renamed from: a */
    static final /* synthetic */ boolean f9409a = (!abe.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ abe f9410b;
    /* renamed from: c */
    private final Queue<abu> f9411c;
    /* renamed from: d */
    private final Map<as, abt> f9412d;
    /* renamed from: e */
    private final Queue<abt> f9413e;
    /* renamed from: f */
    private final Object f9414f;
    /* renamed from: g */
    private abt f9415g;

    private abq(abe abe) {
        this.f9410b = abe;
        this.f9411c = new LinkedList();
        this.f9412d = new HashMap();
        this.f9413e = new LinkedList();
        this.f9414f = new Object();
        this.f9415g = null;
    }

    /* renamed from: a */
    private boolean m13250a(as asVar, abt abt) {
        if (f9409a || UThread.isCurrentThread()) {
            View[] pageViews = this.f9410b.m13220f().getPageViews();
            for (View view : pageViews) {
                gx gxVar = (gx) view;
                if (gxVar != null) {
                    as pageDrawable = gxVar.getPageDrawable();
                    if (!pageDrawable.mo1284G()) {
                        continue;
                    } else if (this.f9410b.f9379a.mo2167o()) {
                        C0941i c0941i = (C0941i) pageDrawable;
                        int width = gxVar.getWidth() / 2;
                        Canvas canvas;
                        if (c0941i.mo1305b() == asVar) {
                            if (abt.f9421a == null) {
                                abt.f9421a = C0544a.m2447c(width, gxVar.getHeight(), Config.RGB_565);
                            }
                            if (this.f9410b.f9379a.al()) {
                                canvas = new Canvas(abt.f9421a);
                                canvas.save();
                                canvas.translate((float) (-width), 0.0f);
                                gxVar.draw(canvas);
                                canvas.restore();
                            } else {
                                gxVar.draw(new Canvas(abt.f9421a));
                            }
                            return true;
                        } else if (c0941i.mo1434c() == asVar) {
                            if (abt.f9421a == null) {
                                abt.f9421a = C0544a.m2447c(width, gxVar.getHeight(), Config.RGB_565);
                            }
                            if (this.f9410b.f9379a.al()) {
                                gxVar.draw(new Canvas(abt.f9421a));
                            } else {
                                canvas = new Canvas(abt.f9421a);
                                canvas.save();
                                canvas.translate((float) (-width), 0.0f);
                                gxVar.draw(canvas);
                                canvas.restore();
                            }
                            return true;
                        }
                    } else if (pageDrawable == asVar) {
                        if (abt.f9421a == null) {
                            abt.f9421a = C0544a.m2447c(gxVar.getWidth(), gxVar.getHeight(), Config.RGB_565);
                        }
                        gxVar.draw(new Canvas(abt.f9421a));
                        return true;
                    }
                } else if (!f9409a) {
                    throw new AssertionError();
                }
            }
            return false;
        }
        throw new AssertionError();
    }

    /* renamed from: e */
    private void m13252e() {
        synchronized (this.f9414f) {
            m13248a(this.f9415g);
        }
    }

    /* renamed from: a */
    private void m13248a(abt abt) {
        if (abt != null && abt.f9421a != null && !abt.f9421a.isRecycled()) {
            if (abt.f9422b) {
                m13249a(new abr(this, abt));
                return;
            }
            abt.f9421a.recycle();
            abt.f9421a = null;
        }
    }

    /* renamed from: f */
    private void m13253f() {
        if (f9409a || UThread.isCurrentThread()) {
            int size = this.f9411c.size();
            for (int i = 0; i < size; i++) {
                ((abu) this.f9411c.poll()).run();
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m13249a(abu abu) {
        m13253f();
        this.f9411c.offer(abu);
    }

    /* renamed from: a */
    public abt m13255a() {
        if (f9409a || this.f9415g != null) {
            this.f9415g.f9422b = true;
            return this.f9415g;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m13257a(Bitmap bitmap) {
        if (f9409a || bitmap != null) {
            synchronized (this.f9414f) {
                m13248a(this.f9415g);
                abt abt = new abt(this.f9410b);
                abt.f9421a = bitmap;
                this.f9415g = abt;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m13256a(int i) {
        List<as> b = m13251b(i);
        synchronized (this.f9412d) {
            Iterator it = this.f9412d.entrySet().iterator();
            while (it.hasNext()) {
                abt abt = (abt) ((Entry) it.next()).getValue();
                if (!abt.f9422b) {
                    this.f9413e.offer(abt);
                    it.remove();
                }
            }
            for (as asVar : b) {
                abt abt2;
                if (this.f9413e.size() > 0) {
                    abt2 = (abt) this.f9413e.peek();
                } else {
                    abt2 = new abt(this.f9410b);
                }
                if (m13250a(asVar, abt2)) {
                    this.f9412d.put(asVar, abt2);
                    if (this.f9413e.contains(abt2)) {
                        this.f9413e.remove();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private List<as> m13251b(int i) {
        return (List) UThread.m1035a(new abs(this, i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public android.graphics.Bitmap m13254a(com.duokan.reader.domain.document.as r5) {
        /*
        r4 = this;
        r2 = r4.f9412d;
        monitor-enter(r2);
        r0 = r4.f9412d;	 Catch:{ all -> 0x0043 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0043 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0043 }
    L_0x000d:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x002e;
    L_0x0013:
        r0 = r3.next();	 Catch:{ all -> 0x0043 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0043 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0043 }
        r1 = (com.duokan.reader.domain.document.as) r1;	 Catch:{ all -> 0x0043 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0043 }
        r0 = (com.duokan.reader.ui.reading.abt) r0;	 Catch:{ all -> 0x0043 }
        if (r1 != r5) goto L_0x000d;
    L_0x0027:
        r1 = 1;
        r0.f9422b = r1;	 Catch:{ all -> 0x0043 }
        r0 = r0.f9421a;	 Catch:{ all -> 0x0043 }
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
    L_0x002d:
        return r0;
    L_0x002e:
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
        r1 = r4.f9414f;
        monitor-enter(r1);
        r0 = f9409a;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x0046;
    L_0x0036:
        r0 = r4.f9415g;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x0046;
    L_0x003a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0040 }
        r0.<init>();	 Catch:{ all -> 0x0040 }
        throw r0;	 Catch:{ all -> 0x0040 }
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        throw r0;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
        throw r0;
    L_0x0046:
        r0 = r4.f9415g;	 Catch:{ all -> 0x0040 }
        r2 = 1;
        r0.f9422b = r2;	 Catch:{ all -> 0x0040 }
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        r0 = r4.f9415g;
        r0 = r0.f9421a;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.reading.abq.a(com.duokan.reader.domain.document.as):android.graphics.Bitmap");
    }

    /* renamed from: b */
    public void m13258b() {
        synchronized (this.f9414f) {
            this.f9415g.f9422b = false;
        }
        synchronized (this.f9412d) {
            for (Entry value : this.f9412d.entrySet()) {
                ((abt) value.getValue()).f9422b = false;
            }
        }
    }

    /* renamed from: c */
    public void m13259c() {
        synchronized (this.f9412d) {
            for (Entry value : this.f9412d.entrySet()) {
                m13248a((abt) value.getValue());
            }
            this.f9412d.clear();
            for (abt a : this.f9413e) {
                m13248a(a);
            }
            this.f9413e.clear();
        }
        m13253f();
    }

    /* renamed from: d */
    public void m13260d() {
        m13252e();
        m13259c();
    }
}
