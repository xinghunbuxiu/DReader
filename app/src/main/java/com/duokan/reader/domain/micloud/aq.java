package com.duokan.reader.domain.micloud;

import android.text.TextUtils;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0577j;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;

class aq implements ad {
    /* renamed from: a */
    private final String f5196a;
    /* renamed from: b */
    private final String f5197b;
    /* renamed from: c */
    private C0572d<au, bi, JSONObject> f5198c;

    public aq(String str, String str2) {
        this.f5196a = str;
        this.f5197b = str2;
    }

    /* renamed from: a */
    public synchronized bj mo1481a() {
        m8073b();
        return ((au) this.f5198c.queryInfo()).f5204c;
    }

    /* renamed from: a */
    public synchronized void mo1483a(bj bjVar) {
        m8073b();
        au auVar = (au) this.f5198c.queryInfo();
        auVar.f5204c = bjVar;
        this.f5198c.updateInfo(auVar);
    }

    /* renamed from: a */
    public synchronized bi mo1480a(String str) {
        m8073b();
        return (bi) this.f5198c.queryItem(new File(str).getAbsolutePath());
    }

    /* renamed from: b */
    public synchronized Collection<bi> mo1486b(String str) {
        m8073b();
        return this.f5198c.queryItems(new ar(this, new File(str).getAbsolutePath()), null, null);
    }

    /* renamed from: a */
    public synchronized void mo1482a(bi biVar) {
        m8073b();
        bi a = mo1480a(biVar.m8162l());
        if (biVar.m8157g()) {
            if (a == null) {
                biVar.m8166p();
                this.f5198c.insertItem(biVar);
            } else if (!a.m8157g()) {
                this.f5198c.deleteItem(a);
                biVar.m8166p();
                this.f5198c.insertItem(biVar);
            } else if (a.m8154d().equals(biVar.m8154d())) {
                if (a.m8159i() != biVar.m8159i()) {
                    biVar.m8166p();
                } else if (a.m8164n()) {
                    biVar.m8165o();
                }
                this.f5198c.updateItem(biVar);
            } else {
                mo1485a(Arrays.asList(new bi[]{a}));
                biVar.m8166p();
                this.f5198c.insertItem(biVar);
            }
        } else if (a == null) {
            this.f5198c.insertItem(biVar);
        } else if (a.m8157g()) {
            mo1485a(Arrays.asList(new bi[]{a}));
            this.f5198c.insertItem(biVar);
        } else {
            this.f5198c.updateItem(biVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo1484a(String str, Collection<bi> collection) {
        m8073b();
        Collection<bi> b = mo1486b(str);
        Collection arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (bi biVar : b) {
            bi biVar2;
            if (biVar2.m8157g()) {
                arrayList2.add(biVar2);
            } else {
                arrayList.add(biVar2);
            }
        }
        Collection arrayList3 = new ArrayList();
        Collection arrayList4 = new ArrayList();
        for (bi biVar22 : collection) {
            if (biVar22.m8157g()) {
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
                if (biVar22.m8154d().equals(biVar3.m8154d()) && biVar22.m8155e().equalsIgnoreCase(biVar3.m8155e())) {
                    Object obj = null;
                    break;
                }
            }
            int obj2 = 1;
            if (obj2 != null) {
                arrayList5.add(biVar22);
            }
        }
        mo1485a(arrayList5);
        mo1485a(arrayList);
        this.f5198c.insertItems(arrayList3);
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            biVar22 = (bi) it3.next();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                biVar3 = (bi) it4.next();
                if (biVar3.m8154d().equals(biVar22.m8154d()) && biVar3.m8155e().equalsIgnoreCase(biVar22.m8155e())) {
                    break;
                }
            }
            biVar3 = null;
            if (biVar3 == null) {
                biVar22.m8166p();
            } else if (!biVar3.m8164n()) {
                biVar22.m8166p();
            } else if (biVar3.m8159i() != biVar22.m8159i()) {
                biVar22.m8166p();
            } else {
                biVar22.m8165o();
            }
        }
        this.f5198c.insertItems(arrayList4);
    }

    /* renamed from: c */
    public synchronized void mo1487c(String str) {
        m8073b();
        mo1485a(mo1486b(str));
    }

    /* renamed from: a */
    public synchronized void mo1485a(Collection<bi> collection) {
        m8073b();
        for (bi biVar : collection) {
            if (biVar.m8157g()) {
                mo1487c(biVar.m8162l());
            }
        }
        this.f5198c.deleteItems((Collection) collection);
    }

    /* renamed from: b */
    private void m8073b() {
        if (this.f5198c == null) {
            this.f5198c = new C0572d("MiCloudDirectoryStructCacheKey_" + this.f5196a + "_" + this.f5197b, C0577j.f1885a, new at(), new as(), 0);
            au auVar = (au) this.f5198c.queryInfo();
            if (TextUtils.isEmpty(auVar.f5202a)) {
                auVar.f5202a = this.f5196a;
                auVar.f5203b = this.f5197b;
                auVar.f5204c = null;
                this.f5198c.updateInfo(auVar);
            }
        }
    }
}
