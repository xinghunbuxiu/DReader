package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class jx {
    /* renamed from: a */
    private final ArrayList<DkCloudPurchasedBook> f3421a = new ArrayList();
    /* renamed from: b */
    private final ArrayList<DkCloudPurchasedBook> f3422b = new ArrayList();
    /* renamed from: c */
    private final ArrayList<DkCloudPurchasedFiction> f3423c = new ArrayList();
    /* renamed from: d */
    private final ArrayList<DkCloudPurchasedFiction> f3424d = new ArrayList();
    /* renamed from: e */
    private final ArrayList<is> f3425e = new ArrayList();
    /* renamed from: f */
    private final HashMap<String, DkCloudPurchasedBook> f3426f = new HashMap();
    /* renamed from: g */
    private final HashMap<String, DkCloudPurchasedBook> f3427g = new HashMap();
    /* renamed from: h */
    private final HashMap<String, DkCloudPurchasedFiction> f3428h = new HashMap();
    /* renamed from: i */
    private final HashMap<String, DkCloudPurchasedFiction> f3429i = new HashMap();
    /* renamed from: j */
    private final HashMap<String, is> f3430j = new HashMap();

    /* renamed from: a */
    public void m4783a() {
        this.f3421a.addAll(DkUserPurchasedBooksManager.m5029a().m5063b());
        this.f3422b.addAll(DkUserPurchasedBooksManager.m5029a().m5068c());
        this.f3423c.addAll(DkUserPurchasedFictionsManager.m5072a().m5102b());
        this.f3424d.addAll(DkUserPurchasedFictionsManager.m5072a().m5107c());
        this.f3425e.addAll(it.m4692a().m4730c());
    }

    /* renamed from: b */
    public void m4787b() {
        Iterator it = this.f3421a.iterator();
        while (it.hasNext()) {
            DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) it.next();
            this.f3426f.put(ae.m3784a(dkCloudPurchasedBook), dkCloudPurchasedBook);
        }
        it = this.f3422b.iterator();
        while (it.hasNext()) {
            dkCloudPurchasedBook = (DkCloudPurchasedBook) it.next();
            this.f3427g.put(ae.m3784a(dkCloudPurchasedBook), dkCloudPurchasedBook);
        }
        it = this.f3423c.iterator();
        while (it.hasNext()) {
            DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) it.next();
            this.f3428h.put(ae.m3785a(dkCloudPurchasedFiction), dkCloudPurchasedFiction);
        }
        it = this.f3424d.iterator();
        while (it.hasNext()) {
            dkCloudPurchasedFiction = (DkCloudPurchasedFiction) it.next();
            this.f3429i.put(ae.m3785a(dkCloudPurchasedFiction), dkCloudPurchasedFiction);
        }
        it = this.f3425e.iterator();
        while (it.hasNext()) {
            is isVar = (is) it.next();
            this.f3430j.put(isVar.m4686f(), isVar);
        }
    }

    /* renamed from: a */
    public DkCloudPurchasedBook m4782a(String str) {
        DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.f3426f.get(str);
        if (dkCloudPurchasedBook != null) {
            return dkCloudPurchasedBook;
        }
        return (DkCloudPurchasedBook) this.f3427g.get(str);
    }

    /* renamed from: b */
    public DkCloudPurchasedFiction m4786b(String str) {
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) this.f3428h.get(str);
        if (dkCloudPurchasedFiction != null) {
            return dkCloudPurchasedFiction;
        }
        return (DkCloudPurchasedFiction) this.f3428h.get(str);
    }

    /* renamed from: c */
    public is m4790c(String str) {
        return (is) this.f3430j.get(str);
    }

    /* renamed from: c */
    public List<is> m4791c() {
        return this.f3425e;
    }

    /* renamed from: a */
    public boolean m4785a(C0800c c0800c) {
        return m4784a(c0800c.aq(), c0800c.ar());
    }

    /* renamed from: a */
    public boolean m4784a(int i, String str) {
        if (i == -1) {
            return false;
        }
        if (i == 0 && (this.f3426f.containsKey(str) || this.f3427g.containsKey(str))) {
            return true;
        }
        if (i == 1 && (this.f3428h.containsKey(str) || this.f3429i.containsKey(str))) {
            return true;
        }
        if (i == 3 && this.f3430j.containsKey(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m4789b(C0800c c0800c) {
        return m4788b(c0800c.aq(), c0800c.ar());
    }

    /* renamed from: b */
    public boolean m4788b(int i, String str) {
        boolean z = true;
        if (i == -1) {
            return false;
        }
        if (i == 0) {
            return ((DkCloudPurchasedBook) this.f3426f.get(str)) != null;
        } else if (i == 1 && this.f3428h.containsKey(str)) {
            if (((DkCloudPurchasedFiction) this.f3428h.get(str)) == null) {
                z = false;
            }
            return z;
        } else if (i == 3 && this.f3430j.containsKey(str)) {
            return true;
        } else {
            return false;
        }
    }
}
