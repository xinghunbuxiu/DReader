package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.i;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

final class abd {
    static final /* synthetic */ boolean a = (!aar.class.desiredAssertionStatus());
    final /* synthetic */ aar b;
    private final Queue c;
    private final Map d;
    private final Queue e;
    private final Object f;
    private abg g;

    private abd(aar com_duokan_reader_ui_reading_aar) {
        this.b = com_duokan_reader_ui_reading_aar;
        this.c = new LinkedList();
        this.d = new HashMap();
        this.e = new LinkedList();
        this.f = new Object();
        this.g = null;
    }

    private boolean a(as asVar, abg com_duokan_reader_ui_reading_abg) {
        if (a || TaskHandler.isCurrentThread()) {
            View[] pageViews = this.b.f().getPageViews();
            for (View view : pageViews) {
                gs gsVar = (gs) view;
                if (gsVar != null) {
                    as pageDrawable = gsVar.getPageDrawable();
                    if (!pageDrawable.G()) {
                        continue;
                    } else if (this.b.a.o()) {
                        i iVar = (i) pageDrawable;
                        int width = gsVar.getWidth() / 2;
                        Canvas canvas;
                        if (iVar.b() == asVar) {
                            if (com_duokan_reader_ui_reading_abg.a == null) {
                                com_duokan_reader_ui_reading_abg.a = a.c(width, gsVar.getHeight(), Config.RGB_565);
                            }
                            if (this.b.a.al()) {
                                canvas = new Canvas(com_duokan_reader_ui_reading_abg.a);
                                canvas.save();
                                canvas.translate((float) (-width), 0.0f);
                                gsVar.draw(canvas);
                                canvas.restore();
                            } else {
                                gsVar.draw(new Canvas(com_duokan_reader_ui_reading_abg.a));
                            }
                            return true;
                        } else if (iVar.c() == asVar) {
                            if (com_duokan_reader_ui_reading_abg.a == null) {
                                com_duokan_reader_ui_reading_abg.a = a.c(width, gsVar.getHeight(), Config.RGB_565);
                            }
                            if (this.b.a.al()) {
                                gsVar.draw(new Canvas(com_duokan_reader_ui_reading_abg.a));
                            } else {
                                canvas = new Canvas(com_duokan_reader_ui_reading_abg.a);
                                canvas.save();
                                canvas.translate((float) (-width), 0.0f);
                                gsVar.draw(canvas);
                                canvas.restore();
                            }
                            return true;
                        }
                    } else if (pageDrawable == asVar) {
                        if (com_duokan_reader_ui_reading_abg.a == null) {
                            com_duokan_reader_ui_reading_abg.a = a.c(gsVar.getWidth(), gsVar.getHeight(), Config.RGB_565);
                        }
                        gsVar.draw(new Canvas(com_duokan_reader_ui_reading_abg.a));
                        return true;
                    }
                } else if (!a) {
                    throw new AssertionError();
                }
            }
            return false;
        }
        throw new AssertionError();
    }

    private void e() {
        synchronized (this.f) {
            a(this.g);
        }
    }

    private void a(abg com_duokan_reader_ui_reading_abg) {
        if (com_duokan_reader_ui_reading_abg != null && com_duokan_reader_ui_reading_abg.a != null && !com_duokan_reader_ui_reading_abg.a.isRecycled()) {
            if (com_duokan_reader_ui_reading_abg.b) {
                a(new abe(this, com_duokan_reader_ui_reading_abg));
                return;
            }
            com_duokan_reader_ui_reading_abg.a.recycle();
            com_duokan_reader_ui_reading_abg.a = null;
        }
    }

    private void f() {
        if (a || TaskHandler.isCurrentThread()) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ((abh) this.c.poll()).run();
            }
            return;
        }
        throw new AssertionError();
    }

    private void a(abh com_duokan_reader_ui_reading_abh) {
        f();
        this.c.offer(com_duokan_reader_ui_reading_abh);
    }

    public abg a() {
        if (a || this.g != null) {
            this.g.b = true;
            return this.g;
        }
        throw new AssertionError();
    }

    public void a(Bitmap bitmap) {
        if (a || bitmap != null) {
            synchronized (this.f) {
                a(this.g);
                abg com_duokan_reader_ui_reading_abg = new abg(this.b);
                com_duokan_reader_ui_reading_abg.a = bitmap;
                this.g = com_duokan_reader_ui_reading_abg;
            }
            return;
        }
        throw new AssertionError();
    }

    public void a(int i) {
        List<as> b = b(i);
        synchronized (this.d) {
            Iterator it = this.d.entrySet().iterator();
            while (it.hasNext()) {
                abg com_duokan_reader_ui_reading_abg = (abg) ((Entry) it.next()).getValue();
                if (!com_duokan_reader_ui_reading_abg.b) {
                    this.e.offer(com_duokan_reader_ui_reading_abg);
                    it.remove();
                }
            }
            for (as asVar : b) {
                abg com_duokan_reader_ui_reading_abg2;
                if (this.e.size() > 0) {
                    com_duokan_reader_ui_reading_abg2 = (abg) this.e.peek();
                } else {
                    com_duokan_reader_ui_reading_abg2 = new abg(this.b);
                }
                if (a(asVar, com_duokan_reader_ui_reading_abg2)) {
                    this.d.put(asVar, com_duokan_reader_ui_reading_abg2);
                    if (this.e.contains(com_duokan_reader_ui_reading_abg2)) {
                        this.e.remove();
                    }
                }
            }
        }
    }

    private List b(int i) {
        return (List) TaskHandler.getTaskHandler(new abf(this, i));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(com.duokan.reader.domain.document.as r5) {
        /*
        r4 = this;
        r2 = r4.getTriangleEdge;
        monitor-enter(r2);
        r0 = r4.getTriangleEdge;	 Catch:{ all -> 0x0043 }
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
        r0 = (com.duokan.reader.ui.reading.abg) r0;	 Catch:{ all -> 0x0043 }
        if (r1 != r5) goto L_0x000d;
    L_0x0027:
        r1 = 1;
        r0.getVisible = r1;	 Catch:{ all -> 0x0043 }
        r0 = r0.setDrawable;	 Catch:{ all -> 0x0043 }
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
    L_0x002d:
        return r0;
    L_0x002e:
        monitor-exit(r2);	 Catch:{ all -> 0x0043 }
        r1 = r4.HttpLogger;
        monitor-enter(r1);
        r0 = setDrawable;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x0046;
    L_0x0036:
        r0 = r4.SessionTask;	 Catch:{ all -> 0x0040 }
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
        r0 = r4.SessionTask;	 Catch:{ all -> 0x0040 }
        r2 = 1;
        r0.getVisible = r2;	 Catch:{ all -> 0x0040 }
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        r0 = r4.SessionTask;
        r0 = r0.setDrawable;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.reading.abd.setDrawable(com.duokan.reader.domain.document.as):android.graphics.Bitmap");
    }

    public void b() {
        synchronized (this.f) {
            this.g.b = false;
        }
        synchronized (this.d) {
            for (Entry value : this.d.entrySet()) {
                ((abg) value.getValue()).b = false;
            }
        }
    }

    public void c() {
        synchronized (this.d) {
            for (Entry value : this.d.entrySet()) {
                a((abg) value.getValue());
            }
            this.d.clear();
            for (abg a : this.e) {
                a(a);
            }
            this.e.clear();
        }
        f();
    }

    public void d() {
        e();
        c();
    }
}
