package com.duokan.reader.domain.micloud;

import android.text.TextUtils;

import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class aq implements ad {
    private final String a;
    private final String b;
    private d c;

    public aq(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public synchronized bj a() {
        b();
        return ((au) this.c.queryInfo()).c;
    }

    public synchronized void a(bj bjVar) {
        b();
        au auVar = (au) this.c.queryInfo();
        auVar.c = bjVar;
        this.c.updateInfo(auVar);
    }

    public synchronized bi a(String str) {
        b();
        return (bi) this.c.queryItem(new File(str).getAbsolutePath());
    }

    public synchronized Collection b(String str) {
        b();
        return this.c.queryItems(new ar(this, new File(str).getAbsolutePath()), null, null);
    }

    public synchronized void a(bi biVar) {
        b();
        bi a = a(biVar.l());
        if (biVar.g()) {
            if (a == null) {
                biVar.p();
                this.c.insertItem(biVar);
            } else if (!a.g()) {
                this.c.deleteItem(a);
                biVar.p();
                this.c.insertItem(biVar);
            } else if (a.d().equals(biVar.d())) {
                if (a.i() != biVar.i()) {
                    biVar.p();
                } else if (a.n()) {
                    biVar.o();
                }
                this.c.updateItem(biVar);
            } else {
                a(Arrays.asList(new bi[]{a}));
                biVar.p();
                this.c.insertItem(biVar);
            }
        } else if (a == null) {
            this.c.insertItem(biVar);
        } else if (a.g()) {
            a(Arrays.asList(new bi[]{a}));
            this.c.insertItem(biVar);
        } else {
            this.c.updateItem(biVar);
        }
    }

    public synchronized void a(String str, Collection collection) {
        bi biVar;
        b();
        Collection<bi> b = b(str);
        Collection arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (bi biVar2 : b) {
            if (biVar2.g()) {
                arrayList2.add(biVar2);
            } else {
                arrayList.add(biVar2);
            }
        }
        Collection arrayList3 = new ArrayList();
        Collection arrayList4 = new ArrayList();
        for (bi biVar22 : collection) {
            if (biVar22.g()) {
                arrayList4.add(biVar22);
            } else {
                arrayList3.add(biVar22);
            }
        }
        Collection arrayList5 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            biVar22 = (bi) it.next();
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                bi biVar3 = (bi) it2.next();
                if (biVar22.d().equals(biVar3.d()) && biVar22.e().equalsIgnoreCase(biVar3.e())) {
                    Object obj = null;
                    break;
                }
            }
            int i = 1;
            if (obj != null) {
                arrayList5.add(biVar22);
            }
        }
        a(arrayList5);
        a(arrayList);
        this.c.insertItems(arrayList3);
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            biVar22 = (bi) it3.next();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                biVar3 = (bi) it4.next();
                if (biVar3.d().equals(biVar22.d()) && biVar3.e().equalsIgnoreCase(biVar22.e())) {
                    break;
                }
            }
            biVar3 = null;
            if (biVar3 == null) {
                biVar22.p();
            } else if (!biVar3.n()) {
                biVar22.p();
            } else if (biVar3.i() != biVar22.i()) {
                biVar22.p();
            } else {
                biVar22.o();
            }
        }
        this.c.insertItems(arrayList4);
    }

    public synchronized void c(String str) {
        b();
        a(b(str));
    }

    public synchronized void a(Collection collection) {
        b();
        for (bi biVar : collection) {
            if (biVar.g()) {
                c(biVar.l());
            }
        }
        this.c.deleteItems(collection);
    }

    private void b() {
        if (this.c == null) {
            this.c = new d("MiCloudDirectoryStructCacheKey_" + this.a + "_" + this.b, j.a, new at(), new as(), 0);
            au auVar = (au) this.c.queryInfo();
            if (TextUtils.isEmpty(auVar.a)) {
                auVar.a = this.a;
                auVar.b = this.b;
                auVar.c = null;
                this.c.updateInfo(auVar);
            }
        }
    }
}
