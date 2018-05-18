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
    
    private static final LinkedList<WeakReference<cj>> f1077a = new LinkedList();
    
    private final Activity activity;
    
    private final cl f1079c;
    
    private final Rect f1080d = new Rect();
    
    private final CopyOnWriteArrayList<cm> f1081e = new CopyOnWriteArrayList();

    private cj(Activity activity) {
        this.activity = AppManage.getCurrentActivity(activity);
        this.f1079c = new cl(this, this.activity);
        m1767c();
    }

    
    public boolean m1775a() {
        return !this.f1080d.isEmpty();
    }

    
    public Rect m1776b() {
        return this.f1080d;
    }

    
    public void m1774a(cm cmVar) {
        this.f1081e.add(cmVar);
    }

    
    public void m1777b(cm cmVar) {
        this.f1081e.remove(cmVar);
    }

    
    public static cj m1764a(Context context) {
        cj cjVar;
        Activity a = AppManage.getCurrentActivity(context);
        ListIterator listIterator = f1077a.listIterator();
        while (listIterator.hasNext()) {
            cjVar = (cj) ((WeakReference) listIterator.next()).get();
            if (cjVar == null) {
                listIterator.remove();
            } else if (cjVar.activity == a) {
                return cjVar;
            }
        }
        cjVar = new cj(a);
        f1077a.add(new WeakReference(cjVar));
        return cjVar;
    }

    
    private void m1767c() {
        AnimUtils.m1921a(this.activity.getWindow().getDecorView(), new ck(this));
        this.activity.getWindow().getDecorView().requestLayout();
    }

    
    private void m1768d() {
        Iterator it = this.f1081e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).mo518a(this.f1080d);
        }
    }

    
    private void m1770e() {
        Iterator it = this.f1081e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).mo517a();
        }
    }

    
    private void m1772f() {
        Iterator it = this.f1081e.iterator();
        while (it.hasNext()) {
            ((cm) it.next()).mo519b(this.f1080d);
        }
    }
}
