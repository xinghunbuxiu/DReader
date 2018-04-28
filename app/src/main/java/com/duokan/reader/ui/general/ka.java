package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.duokan.reader.common.bitmap.C0544a;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class ka {
    /* renamed from: a */
    private static ka f7497a;
    /* renamed from: b */
    private int f7498b = 0;
    /* renamed from: c */
    private final int f7499c;
    /* renamed from: d */
    private final int f7500d;
    /* renamed from: e */
    private final int f7501e;
    /* renamed from: f */
    private final int f7502f;
    /* renamed from: g */
    private final int f7503g;
    /* renamed from: h */
    private final int f7504h;
    /* renamed from: i */
    private final kc[] f7505i;
    /* renamed from: j */
    private final int[] f7506j;
    /* renamed from: k */
    private int f7507k = 0;
    /* renamed from: l */
    private int f7508l = 0;

    private ka(int i, int i2, int i3, int i4, int i5) {
        int i6 = 4;
        this.f7499c = i;
        this.f7500d = i2;
        if (i3 / i2 >= 8) {
            this.f7501e = this.f7500d * 8;
        } else if (i3 / i2 >= 4) {
            this.f7501e = this.f7500d * 4;
            i6 = 3;
        } else {
            this.f7501e = this.f7500d * 2;
            i6 = 2;
        }
        this.f7504h = i6;
        this.f7505i = new kc[this.f7504h];
        this.f7506j = new int[this.f7504h];
        int i7 = 1;
        for (int i8 = 0; i8 < i6; i8++) {
            this.f7506j[i8] = i7;
            this.f7505i[i8] = new kc(this, this.f7500d * i7);
            i7 *= 2;
        }
        this.f7502f = ((int) Math.ceil(((double) i4) / ((double) this.f7501e))) * this.f7501e;
        this.f7503g = ((int) Math.ceil(((double) i5) / ((double) this.f7501e))) * this.f7501e;
        this.f7507k = 0;
    }

    /* renamed from: a */
    public int m10912a() {
        return this.f7499c;
    }

    /* renamed from: b */
    public int m10915b() {
        return this.f7500d;
    }

    /* renamed from: c */
    public int m10916c() {
        return this.f7501e;
    }

    /* renamed from: d */
    public void m10917d() {
        this.f7508l++;
    }

    /* renamed from: a */
    public void m10913a(Context context, Rect rect, int i, List<kb> list) {
        int i2;
        int i3;
        if (this.f7507k == 0) {
            int i4 = this.f7501e;
            LinkedList linkedList = this.f7505i[this.f7504h - 1].f7523b;
            for (i2 = this.f7502f; i2 > 0; i2 -= i4) {
                this.f7498b++;
                m10904a(linkedList, m10901a(context, i4, this.f7504h - 1, this.f7498b));
            }
        }
        i2 = rect.width() / this.f7499c;
        if (this.f7499c * i2 != rect.width()) {
            i3 = i2 + 1;
        } else {
            i3 = i2;
        }
        int i5 = this.f7504h - 1;
        int height = rect.height();
        while (height > 0) {
            while (i5 >= 0) {
                if (this.f7505i[i5].f7522a <= height || this.f7505i[i5].f7522a == i) {
                    break;
                }
                i5--;
            }
            i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                m10905a(context, rect.left + (this.f7499c * i6), (rect.top + rect.height()) - height, i5, i, list);
            }
            height -= this.f7505i[i5].f7522a;
        }
    }

    /* renamed from: a */
    private boolean m10905a(Context context, int i, int i2, int i3, int i4, List<kb> list) {
        boolean z = false;
        int i5 = 1;
        int i6 = i2;
        while (i3 >= 0) {
            int i7 = 0;
            int i8 = this.f7505i[i3].f7522a;
            do {
                kb a = m10900a(i3);
                if (a == null && (this.f7507k == 0 || i8 == i4)) {
                    this.f7498b++;
                    m10904a(this.f7505i[this.f7504h - 1].f7523b, m10901a(context, this.f7501e, this.f7504h - 1, this.f7498b));
                    z = true;
                    a = m10900a(i3);
                }
                if (a == null) {
                    break;
                }
                a.f7518j = true;
                a.f7519k.left = i;
                a.f7519k.top = i6;
                a.f7519k.right = this.f7499c + i;
                a.f7519k.bottom = i6 + i8;
                a.f7520l.left = 0;
                a.f7520l.top = a.f7511c;
                a.f7520l.right = 0;
                a.f7520l.bottom = a.f7511c;
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

    /* renamed from: a */
    private kb m10900a(int i) {
        LinkedList linkedList = this.f7505i[i].f7523b;
        if (linkedList.size() == 0) {
            m10907b(i + 1);
        }
        if (linkedList.size() <= 0) {
            return null;
        }
        kb kbVar = (kb) linkedList.getFirst();
        m10908b(linkedList, kbVar);
        return kbVar;
    }

    /* renamed from: b */
    private void m10907b(int i) {
        if (i > 0 && i < this.f7504h) {
            LinkedList linkedList = this.f7505i[i].f7523b;
            LinkedList linkedList2 = this.f7505i[i - 1].f7523b;
            if (linkedList.size() == 0 && i + 1 < this.f7504h) {
                m10907b(i + 1);
            }
            if (linkedList.size() > 0) {
                kb kbVar = (kb) linkedList.get(0);
                m10908b(linkedList, kbVar);
                kb a = kbVar.m10920a();
                m10904a(linkedList2, kbVar);
                m10904a(linkedList2, a);
            }
        }
    }

    /* renamed from: a */
    private kb m10901a(Context context, int i, int i2, int i3) {
        kb kbVar = new kb(this, C0544a.m2447c(this.f7499c, i, Config.ARGB_8888), i3, 0, i, i2);
        kbVar.f7515g.drawColor(0, Mode.CLEAR);
        return kbVar;
    }

    /* renamed from: a */
    public void m10914a(List<kb> list) {
        for (kb kbVar : list) {
            kbVar.f7518j = false;
            kbVar.f7515g.drawColor(0, Mode.CLEAR);
            kbVar.f7519k.left = 0;
            kbVar.f7519k.top = 0;
            kbVar.f7519k.right = 0;
            kbVar.f7519k.bottom = 0;
            kbVar.f7520l.left = 0;
            kbVar.f7520l.top = kbVar.f7511c;
            kbVar.f7520l.right = 0;
            kbVar.f7520l.bottom = kbVar.f7511c;
            m10903a(kbVar);
        }
        if (this.f7508l == 0) {
            m10911h();
        }
    }

    /* renamed from: a */
    private void m10903a(kb kbVar) {
        LinkedList linkedList = this.f7505i[kbVar.f7513e].f7523b;
        if (kbVar.f7516h != null && kbVar.f7516h.m10921a(kbVar)) {
            m10908b(linkedList, kbVar.f7516h);
            m10903a(kbVar.f7516h.m10922b(kbVar));
        } else if (kbVar.f7517i == null || !kbVar.m10921a(kbVar.f7517i)) {
            m10904a(linkedList, kbVar);
        } else {
            m10908b(linkedList, kbVar.f7517i);
            m10903a(kbVar.m10922b(kbVar.f7517i));
        }
    }

    /* renamed from: a */
    private void m10904a(LinkedList<kb> linkedList, kb kbVar) {
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            kb kbVar2 = (kb) listIterator.next();
            if (kbVar2.f7510b > kbVar.f7510b || (kbVar2.f7510b == kbVar.f7510b && kbVar2.f7511c > kbVar.f7511c)) {
                break;
            }
        }
        listIterator.add(kbVar);
        this.f7507k += kbVar.f7512d;
    }

    /* renamed from: b */
    private void m10908b(LinkedList<kb> linkedList, kb kbVar) {
        linkedList.remove(kbVar);
        this.f7507k -= kbVar.f7512d;
    }

    /* renamed from: e */
    public void m10918e() {
        this.f7508l--;
        if (this.f7508l == 0) {
            m10911h();
        }
    }

    /* renamed from: h */
    private void m10911h() {
        LinkedList linkedList = this.f7505i[this.f7504h - 1].f7523b;
        while (this.f7507k > this.f7503g && linkedList.size() > 0) {
            m10908b(linkedList, (kb) linkedList.getFirst());
        }
    }

    /* renamed from: f */
    public void m10919f() {
        List list;
        if (deprecatedDkTextView.f7064f == null || !(deprecatedDkTextView.f7064f.f7076E instanceof jw)) {
            list = null;
        } else {
            list = ((jw) deprecatedDkTextView.f7064f.f7076E).m10897e();
        }
        for (kc kcVar : this.f7505i) {
            ListIterator listIterator = kcVar.f7523b.listIterator();
            while (listIterator.hasNext()) {
                kb kbVar = (kb) listIterator.next();
                if (list == null || !list.contains(kbVar.f7509a)) {
                    kbVar.f7509a.recycle();
                    listIterator.remove();
                    this.f7507k -= kbVar.f7512d;
                }
            }
        }
    }

    /* renamed from: a */
    public static void m10902a(Context context) {
        if (f7497a == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int min = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 2;
            f7497a = new ka(min, 80, Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels), (displayMetrics.heightPixels * displayMetrics.widthPixels) / min, (((displayMetrics.heightPixels * displayMetrics.widthPixels) * 5) / 2) / min);
        }
    }

    /* renamed from: g */
    public static ka m10910g() {
        return f7497a;
    }
}
