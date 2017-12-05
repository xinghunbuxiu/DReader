package com.duokan.reader.domain.ad;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdLifecycleManager {
    private final HashMap a = new HashMap();
    private final HashMap b = new HashMap();

    public boolean a(String str) {
        return this.a.containsKey(str);
    }

    public void a(e eVar) {
        g.a().c(eVar);
        this.a.put(eVar.r, eVar);
    }

    public void b(String str) {
        try {
            e eVar = (e) this.a.get(str);
            if (eVar != null) {
                g.a().f(eVar);
                this.a.remove(str);
            }
            for (b c : (List) this.b.get(str)) {
                c.c();
            }
        } catch (Throwable th) {
        }
    }

    public void c(String str) {
        try {
            for (b d : (List) this.b.get(str)) {
                d.d();
            }
        } catch (Throwable th) {
        }
    }

    public void d(String str) {
        try {
            e eVar = (e) this.a.get(str);
            if (eVar != null) {
                g.a().d(eVar);
            }
            for (b b : (List) this.b.get(str)) {
                b.b();
            }
        } catch (Throwable th) {
        }
    }

    public void e(String str) {
        try {
            e eVar = (e) this.a.get(str);
            if (eVar != null) {
                g.a().e(eVar);
            }
            for (b e : (List) this.b.get(str)) {
                e.e();
            }
        } catch (Throwable th) {
        }
    }

    public void a(e eVar, b bVar) {
        if (eVar != null && !TextUtils.isEmpty(eVar.r)) {
            a(eVar.r, bVar);
        }
    }

    public void a(String str, b bVar) {
        List list = (List) this.b.get(str);
        if (list == null) {
            list = new ArrayList();
            this.b.put(str, list);
        }
        list.add(bVar);
    }

    public void b(String str, b bVar) {
        if (((List) this.b.get(str)) != null) {
            this.b.remove(str);
        }
        List arrayList = new ArrayList();
        this.b.put(str, arrayList);
        arrayList.add(bVar);
    }

    public void f(String str) {
        try {
            for (b a : (List) this.b.get(str)) {
                a.a();
            }
        } catch (Throwable th) {
        }
    }

    public void g(String str) {
        try {
            if (this.b.containsKey(str)) {
                this.b.remove(str);
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, int i) {
        try {
            for (b a : (List) this.b.get(str)) {
                a.a(i);
            }
        } catch (Throwable th) {
        }
    }
}
