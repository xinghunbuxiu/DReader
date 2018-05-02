package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.cloud.a */
public class C0840a {
    /* renamed from: a */
    private final String f3638a;
    /* renamed from: b */
    private final ArrayList<C0840a> f3639b = new ArrayList();
    /* renamed from: c */
    private final LinkedList<DkCloudBook> f3640c = new LinkedList();
    /* renamed from: d */
    private DkCloudBook[] f3641d = null;

    public C0840a(String str) {
        this.f3638a = str;
    }

    /* renamed from: a */
    public String m5258a() {
        return this.f3638a;
    }

    /* renamed from: b */
    public int m5261b() {
        return this.f3639b.size();
    }

    /* renamed from: c */
    public C0840a[] m5265c() {
        return (C0840a[]) this.f3639b.toArray(new C0840a[0]);
    }

    /* renamed from: a */
    public C0840a m5256a(int i) {
        return (C0840a) this.f3639b.get(i);
    }

    /* renamed from: a */
    public C0840a m5257a(String str) {
        Iterator it = this.f3639b.iterator();
        while (it.hasNext()) {
            C0840a c0840a = (C0840a) it.next();
            if (c0840a.m5258a().equals(str)) {
                return c0840a;
            }
        }
        return null;
    }

    /* renamed from: d */
    public int m5266d() {
        return this.f3640c.size();
    }

    /* renamed from: b */
    public DkCloudBook m5262b(int i) {
        return m5255e()[i];
    }

    /* renamed from: a */
    public void m5259a(Collator collator) {
        m5260a(new C0841b(this, collator));
    }

    /* renamed from: a */
    public void m5260a(Comparator<C0840a> comparator) {
        Collections.sort(this.f3639b, comparator);
        Iterator it = this.f3639b.iterator();
        while (it.hasNext()) {
            ((C0840a) it.next()).m5260a((Comparator) comparator);
        }
    }

    /* renamed from: b */
    public void m5263b(Collator collator) {
        m5264b(new C0842c(this, collator));
    }

    /* renamed from: b */
    public void m5264b(Comparator<DkCloudBook> comparator) {
        Collections.sort(this.f3640c, comparator);
        this.f3641d = null;
        Iterator it = this.f3639b.iterator();
        while (it.hasNext()) {
            ((C0840a) it.next()).m5264b((Comparator) comparator);
        }
    }

    /* renamed from: a */
    public static C0840a m5251a(List<DkCloudStoreBook> list) {
        C0840a c0840a = new C0840a("");
        LinkedList linkedList = new LinkedList();
        for (DkCloudBook dkCloudBook : list) {
            C0840a b;
            if (dkCloudBook instanceof DkCloudPurchasedFiction) {
                b = c0840a.m5254b("原创");
            } else {
                b = c0840a.m5254b("图书");
            }
            b.m5252a(dkCloudBook);
            String[][] labels = dkCloudBook.getLabels();
            if (labels != null) {
                int i = 0;
                for (int i2 = 0; i2 < labels.length; i2++) {
                    String[] strArr = labels[i2];
                    if (strArr != null) {
                        String[] strArr2;
                        int i3;
                        C0840a c0840a2;
                        if (!C0840a.m5253a(strArr)) {
                            if (i2 >= labels.length - 1 && i == 0) {
                                if (!TextUtils.isEmpty(strArr[0])) {
                                    strArr2 = new String[]{strArr[0], strArr[0]};
                                    i3 = i + 1;
                                    c0840a2 = b;
                                    for (String b2 : strArr2) {
                                        c0840a2 = c0840a2.m5254b(b2);
                                        if (!linkedList.contains(c0840a2)) {
                                            c0840a2.m5252a(dkCloudBook);
                                            linkedList.add(c0840a2);
                                        }
                                    }
                                    i = i3;
                                }
                            }
                        }
                        strArr2 = strArr;
                        i3 = i + 1;
                        c0840a2 = b;
                        while (i < strArr2.length) {
                            c0840a2 = c0840a2.m5254b(b2);
                            if (!linkedList.contains(c0840a2)) {
                                c0840a2.m5252a(dkCloudBook);
                                linkedList.add(c0840a2);
                            }
                        }
                        i = i3;
                    }
                }
                linkedList.clear();
            }
        }
        return c0840a;
    }

    /* renamed from: a */
    private static boolean m5253a(String[] strArr) {
        for (CharSequence isEmpty : strArr) {
            if (TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private C0840a m5254b(String str) {
        C0840a a = m5257a(str);
        if (a != null) {
            return a;
        }
        a = new C0840a(str);
        this.f3639b.add(a);
        return a;
    }

    /* renamed from: a */
    private void m5252a(DkCloudBook dkCloudBook) {
        this.f3640c.add(dkCloudBook);
        this.f3641d = null;
    }

    /* renamed from: e */
    private DkCloudBook[] m5255e() {
        if (this.f3641d == null) {
            this.f3641d = (DkCloudBook[]) this.f3640c.toArray(new DkCloudBook[0]);
        }
        return this.f3641d;
    }
}
