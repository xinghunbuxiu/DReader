package com.duokan.core.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.duokan.core.app.AppManage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class cj {
    /* renamed from: a */
    private static final LinkedList<WeakReference<cj>> f1077a = new LinkedList();
    /* renamed from: b */
    private final Activity f1078b;
    /* renamed from: c */
    private final cl f1079c;
    /* renamed from: d */
    private final Rect f1080d = new Rect();
    /* renamed from: e */
    private final CopyOnWriteArrayList<cm> f1081e = new CopyOnWriteArrayList();

    private cj(Activity activity) {
        this.f1078b = AppManage.getCurrentActivity((Context) activity);
        this.f1079c = new cl(this, this.f1078b);
        m1767c();
    }

    /* renamed from: a */
    public boolean m1775a() {
        return !this.f1080d.isEmpty();
    }

    /* renamed from: b */
    public Rect m1776b() {
        return this.f1080d;
    }

    /* renamed from: a */
    public void m1774a(cm cmVar) {
        this.f1081e.add(cmVar);
    }

    /* renamed from: b */
    public void m1777b(cm cmVar) {
        this.f1081e.remove(cmVar);
    }

    /* renamed from: a */
    public static cj m1764a(Context context) {
        cj cjVar;
        Activity a = AppManage.getCurrentActivity(context);
        ListIterator listIterator = f1077a.listIterator();
        while (listIterator.hasNext()) {
            cjVar = (cj) ((WeakReference) listIterator.next()).get();
            if (cjVar == null) {
                listIterator.remove();
            } else if (cjVar.f1078b == a) {
                return cjVar;
            }
        }
        cjVar = new cj(a);
        f1077a.add(new WeakReference(cjVar));
        return cjVar;
    }

    /* renamed from: c */
    private void m1767c() {
        dv.m1921a(this.f1078b.getWindow().getDecorView(), new ck(this));
        this.f1078b.getWindow().getDecorView().requestLayout();
    }

    /* renamed from: d */
    private void m1768d() {
        Iterator it = this.f1081e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).mo518a(this.f1080d);
        }
    }

    /* renamed from: e */
    private void m1770e() {
        Iterator it = this.f1081e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).mo517a();
        }
    }

    /* renamed from: f */
    private void m1772f() {
        Iterator it = this.f1081e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).mo519b(this.f1080d);
        }
    }
}
