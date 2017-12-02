package com.duokan.core.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;

import com.duokan.core.app.b;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class cj {
    private static final LinkedList a = new LinkedList();
    private final Activity b;
    private final cl c;
    private final Rect d = new Rect();
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();

    private cj(Activity activity) {
        this.b = b.a(activity);
        this.c = new cl(this, this.b);
        c();
    }

    public boolean a() {
        return !this.d.isEmpty();
    }

    public Rect b() {
        return this.d;
    }

    public void a(cm cmVar) {
        this.e.add(cmVar);
    }

    public void b(cm cmVar) {
        this.e.remove(cmVar);
    }

    public static cj a(Context context) {
        cj cjVar;
        Activity a = b.a(context);
        ListIterator listIterator = a.listIterator();
        while (listIterator.hasNext()) {
            cjVar = (cj) ((WeakReference) listIterator.next()).get();
            if (cjVar == null) {
                listIterator.remove();
            } else if (cjVar.b == a) {
                return cjVar;
            }
        }
        cjVar = new cj(a);
        a.add(new WeakReference(cjVar));
        return cjVar;
    }

    private void c() {
        dv.a(this.b.getWindow().getDecorView(), new ck(this));
        this.b.getWindow().getDecorView().requestLayout();
    }

    private void d() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).a(this.d);
        }
    }

    private void e() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).a();
        }
    }

    private void f() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).b(this.d);
        }
    }
}
