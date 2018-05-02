package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class jl {
    private final ArrayList a = new ArrayList();
    private final ArrayList b = new ArrayList();
    private final ArrayList c = new ArrayList();
    private final ArrayList d = new ArrayList();
    private final ArrayList e = new ArrayList();
    private final HashMap f = new HashMap();
    private final HashMap g = new HashMap();
    private final HashMap h = new HashMap();
    private final HashMap i = new HashMap();
    private final HashMap j = new HashMap();

    public void a() {
        this.a.addAll(DkUserPurchasedBooksManager.a().b());
        this.b.addAll(DkUserPurchasedBooksManager.a().c());
        this.c.addAll(DkUserPurchasedFictionsManager.a().b());
        this.d.addAll(DkUserPurchasedFictionsManager.a().c());
        this.e.addAll(iz.a().c());
    }

    public void b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) it.next();
            this.f.put(ae.a(dkCloudPurchasedBook), dkCloudPurchasedBook);
        }
        it = this.b.iterator();
        while (it.hasNext()) {
            dkCloudPurchasedBook = (DkCloudPurchasedBook) it.next();
            this.g.put(ae.a(dkCloudPurchasedBook), dkCloudPurchasedBook);
        }
        it = this.c.iterator();
        while (it.hasNext()) {
            DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) it.next();
            this.h.put(ae.a(dkCloudPurchasedFiction), dkCloudPurchasedFiction);
        }
        it = this.d.iterator();
        while (it.hasNext()) {
            dkCloudPurchasedFiction = (DkCloudPurchasedFiction) it.next();
            this.i.put(ae.a(dkCloudPurchasedFiction), dkCloudPurchasedFiction);
        }
        it = this.e.iterator();
        while (it.hasNext()) {
            iy iyVar = (iy) it.next();
            this.j.put(iyVar.f(), iyVar);
        }
    }

    public DkCloudPurchasedBook a(String str) {
        DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.f.get(str);
        if (dkCloudPurchasedBook != null) {
            return dkCloudPurchasedBook;
        }
        return (DkCloudPurchasedBook) this.g.get(str);
    }

    public DkCloudPurchasedFiction b(String str) {
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) this.h.get(str);
        if (dkCloudPurchasedFiction != null) {
            return dkCloudPurchasedFiction;
        }
        return (DkCloudPurchasedFiction) this.h.get(str);
    }

    public iy c(String str) {
        return (iy) this.j.get(str);
    }

    public List c() {
        return this.e;
    }

    public boolean a(c cVar) {
        return a(cVar.ao(), cVar.ap());
    }

    public boolean a(int i, String str) {
        if (i == -1) {
            return false;
        }
        if (i == 0 && (this.f.containsKey(str) || this.g.containsKey(str))) {
            return true;
        }
        if (i == 1 && (this.h.containsKey(str) || this.i.containsKey(str))) {
            return true;
        }
        if (i == 3 && this.j.containsKey(str)) {
            return true;
        }
        return false;
    }

    public boolean b(c cVar) {
        return b(cVar.ao(), cVar.ap());
    }

    public boolean b(int i, String str) {
        boolean z = true;
        if (i == -1) {
            return false;
        }
        if (i == 0) {
            return ((DkCloudPurchasedBook) this.f.get(str)) != null;
        } else if (i == 1 && this.h.containsKey(str)) {
            if (((DkCloudPurchasedFiction) this.h.get(str)) == null) {
                z = false;
            }
            return z;
        } else if (i == 3 && this.j.containsKey(str)) {
            return true;
        } else {
            return false;
        }
    }
}
