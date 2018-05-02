package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.util.DisplayMetrics;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class kq {
    private static kq a;
    private int b = 0;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final ks[] i;
    private final int[] j;
    private int k = 0;
    private int l = 0;

    private kq(int i, int i2, int i3, int i4, int i5) {
        int i6 = 4;
        this.c = i;
        this.d = i2;
        if (i3 / i2 >= 8) {
            this.e = this.d * 8;
        } else if (i3 / i2 >= 4) {
            this.e = this.d * 4;
            i6 = 3;
        } else {
            this.e = this.d * 2;
            i6 = 2;
        }
        this.h = i6;
        this.i = new ks[this.h];
        this.j = new int[this.h];
        int i7 = 1;
        for (int i8 = 0; i8 < i6; i8++) {
            this.j[i8] = i7;
            this.i[i8] = new ks(this, this.d * i7);
            i7 *= 2;
        }
        this.f = ((int) Math.ceil(((double) i4) / ((double) this.e))) * this.e;
        this.g = ((int) Math.ceil(((double) i5) / ((double) this.e))) * this.e;
        this.k = 0;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public void d() {
        this.l++;
    }

    public void a(Context context, Rect rect, int i, List list) {
        int i2;
        int i3;
        if (this.k == 0) {
            int i4 = this.e;
            LinkedList linkedList = this.i[this.h - 1].b;
            for (i2 = this.f; i2 > 0; i2 -= i4) {
                this.b++;
                a(linkedList, a(context, i4, this.h - 1, this.b));
            }
        }
        i2 = rect.width() / this.c;
        if (this.c * i2 != rect.width()) {
            i3 = i2 + 1;
        } else {
            i3 = i2;
        }
        int i5 = this.h - 1;
        int height = rect.height();
        while (height > 0) {
            while (i5 >= 0) {
                if (this.i[i5].a <= height || this.i[i5].a == i) {
                    break;
                }
                i5--;
            }
            i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                a(context, rect.left + (this.c * i6), (rect.top + rect.height()) - height, i5, i, list);
            }
            height -= this.i[i5].a;
        }
    }

    private boolean a(Context context, int i, int i2, int i3, int i4, List list) {
        boolean z = false;
        int i5 = 1;
        int i6 = i2;
        while (i3 >= 0) {
            int i7 = 0;
            int i8 = this.i[i3].a;
            do {
                kr a = a(i3);
                if (a == null && (this.k == 0 || i8 == i4)) {
                    this.b++;
                    a(this.i[this.h - 1].b, a(context, this.e, this.h - 1, this.b));
                    z = true;
                    a = a(i3);
                }
                if (a == null) {
                    break;
                }
                a.j = true;
                a.k.left = i;
                a.k.top = i6;
                a.k.right = this.c + i;
                a.k.bottom = i6 + i8;
                a.l.left = 0;
                a.l.top = a.c;
                a.l.right = 0;
                a.l.bottom = a.c;
                i6 += i8;
                list.add(a);
                i7++;
            } while (i7 < i5);
            if (i7 == i5) {
                break;
            }
            i3--;
            i5 = (i5 - i7) * 2;
        }
        return z;
    }

    private kr a(int i) {
        LinkedList linkedList = this.i[i].b;
        if (linkedList.size() == 0) {
            b(i + 1);
        }
        if (linkedList.size() <= 0) {
            return null;
        }
        kr krVar = (kr) linkedList.getFirst();
        b(linkedList, krVar);
        return krVar;
    }

    private void b(int i) {
        if (i > 0 && i < this.h) {
            LinkedList linkedList = this.i[i].b;
            LinkedList linkedList2 = this.i[i - 1].b;
            if (linkedList.size() == 0 && i + 1 < this.h) {
                b(i + 1);
            }
            if (linkedList.size() > 0) {
                kr krVar = (kr) linkedList.get(0);
                b(linkedList, krVar);
                kr a = krVar.a();
                a(linkedList2, krVar);
                a(linkedList2, a);
            }
        }
    }

    private kr a(Context context, int i, int i2, int i3) {
        kr krVar = new kr(this, a.c(this.c, i, Config.ARGB_8888), i3, 0, i, i2);
        krVar.g.drawColor(0, Mode.CLEAR);
        return krVar;
    }

    public void a(List list) {
        for (kr krVar : list) {
            krVar.j = false;
            krVar.g.drawColor(0, Mode.CLEAR);
            krVar.k.left = 0;
            krVar.k.top = 0;
            krVar.k.right = 0;
            krVar.k.bottom = 0;
            krVar.l.left = 0;
            krVar.l.top = krVar.c;
            krVar.l.right = 0;
            krVar.l.bottom = krVar.c;
            a(krVar);
        }
        if (this.l == 0) {
            h();
        }
    }

    private void a(kr krVar) {
        LinkedList linkedList = this.i[krVar.e].b;
        if (krVar.h != null && krVar.h.a(krVar)) {
            b(linkedList, krVar.h);
            a(krVar.h.b(krVar));
        } else if (krVar.i == null || !krVar.a(krVar.i)) {
            a(linkedList, krVar);
        } else {
            b(linkedList, krVar.i);
            a(krVar.b(krVar.i));
        }
    }

    private void a(LinkedList linkedList, kr krVar) {
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            kr krVar2 = (kr) listIterator.next();
            if (krVar2.b > krVar.b || (krVar2.b == krVar.b && krVar2.c > krVar.c)) {
                break;
            }
        }
        listIterator.add(krVar);
        this.k += krVar.d;
    }

    private void b(LinkedList linkedList, kr krVar) {
        linkedList.remove(krVar);
        this.k -= krVar.d;
    }

    public void e() {
        this.l--;
        if (this.l == 0) {
            h();
        }
    }

    private void h() {
        LinkedList linkedList = this.i[this.h - 1].b;
        while (this.k > this.g && linkedList.size() > 0) {
            b(linkedList, (kr) linkedList.getFirst());
        }
    }

    public void f() {
        List list;
        if (deprecatedDkTextView.f == null || !(deprecatedDkTextView.f.E instanceof km)) {
            list = null;
        } else {
            list = ((km) deprecatedDkTextView.f.E).e();
        }
        for (ks ksVar : this.i) {
            ListIterator listIterator = ksVar.b.listIterator();
            while (listIterator.hasNext()) {
                kr krVar = (kr) listIterator.next();
                if (list == null || !list.contains(krVar.a)) {
                    krVar.a.recycle();
                    listIterator.remove();
                    this.k -= krVar.d;
                }
            }
        }
    }

    public static void a(Context context) {
        if (a == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int min = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 2;
            a = new kq(min, 80, Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels), (displayMetrics.heightPixels * displayMetrics.widthPixels) / min, (((displayMetrics.heightPixels * displayMetrics.widthPixels) * 5) / 2) / min);
        }
    }

    public static kq g() {
        return a;
    }
}
