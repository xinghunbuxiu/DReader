package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a {
    private final String a;
    private final ArrayList b = new ArrayList();
    private final LinkedList c = new LinkedList();
    private DkCloudBook[] d = null;

    public a(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b.size();
    }

    public a[] c() {
        return (a[]) this.b.toArray(new a[0]);
    }

    public a a(int i) {
        return (a) this.b.get(i);
    }

    public a a(String str) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public int d() {
        return this.c.size();
    }

    public DkCloudBook b(int i) {
        return e()[i];
    }

    public void a(Collator collator) {
        a(new b(this, collator));
    }

    public void a(Comparator comparator) {
        Collections.sort(this.b, comparator);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(comparator);
        }
    }

    public void b(Collator collator) {
        b(new c(this, collator));
    }

    public void b(Comparator comparator) {
        Collections.sort(this.c, comparator);
        this.d = null;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(comparator);
        }
    }

    public static a a(List list) {
        a aVar = new a("");
        LinkedList linkedList = new LinkedList();
        for (DkCloudBook dkCloudBook : list) {
            a b;
            if (dkCloudBook instanceof DkCloudPurchasedFiction) {
                b = aVar.b("原创");
            } else {
                b = aVar.b("图书");
            }
            b.a(dkCloudBook);
            String[][] labels = dkCloudBook.getLabels();
            if (labels != null) {
                int i = 0;
                for (int i2 = 0; i2 < labels.length; i2++) {
                    String[] strArr = labels[i2];
                    if (strArr != null) {
                        String[] strArr2;
                        int i3;
                        a aVar2;
                        if (!a(strArr)) {
                            if (i2 >= labels.length - 1 && i == 0) {
                                if (!TextUtils.isEmpty(strArr[0])) {
                                    strArr2 = new String[]{strArr[0], strArr[0]};
                                    i3 = i + 1;
                                    aVar2 = b;
                                    for (String b2 : strArr2) {
                                        aVar2 = aVar2.b(b2);
                                        if (!linkedList.contains(aVar2)) {
                                            aVar2.a(dkCloudBook);
                                            linkedList.add(aVar2);
                                        }
                                    }
                                    i = i3;
                                }
                            }
                        }
                        strArr2 = strArr;
                        i3 = i + 1;
                        aVar2 = b;
                        while (i < strArr2.length) {
                            aVar2 = aVar2.b(b2);
                            if (!linkedList.contains(aVar2)) {
                                aVar2.a(dkCloudBook);
                                linkedList.add(aVar2);
                            }
                        }
                        i = i3;
                    }
                }
                linkedList.clear();
            }
        }
        return aVar;
    }

    private static boolean a(String[] strArr) {
        for (CharSequence isEmpty : strArr) {
            if (TextUtils.isEmpty(isEmpty)) {
                return false;
            }
        }
        return true;
    }

    private a b(String str) {
        a a = a(str);
        if (a != null) {
            return a;
        }
        a = new a(str);
        this.b.add(a);
        return a;
    }

    private void a(DkCloudBook dkCloudBook) {
        this.c.add(dkCloudBook);
        this.d = null;
    }

    private DkCloudBook[] e() {
        if (this.d == null) {
            this.d = (DkCloudBook[]) this.c.toArray(new DkCloudBook[0]);
        }
        return this.d;
    }
}
