package com.duokan.reader.domain.cloud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ch {
    /* renamed from: a */
    private boolean f3812a = false;
    /* renamed from: b */
    private boolean f3813b = false;
    /* renamed from: c */
    private final ConcurrentHashMap<String, DkCloudPurchasedBook> f3814c = new ConcurrentHashMap();

    public ch(ch chVar) {
        this.f3814c.putAll(chVar.f3814c);
        this.f3812a = chVar.f3812a;
        this.f3813b = chVar.f3813b;
    }

    /* renamed from: a */
    public DkCloudPurchasedBook m5395a(String str) {
        return (DkCloudPurchasedBook) this.f3814c.get(str);
    }

    /* renamed from: b */
    public DkCloudPurchasedBook m5399b(String str) {
        DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.f3814c.get(str);
        if (dkCloudPurchasedBook != null && dkCloudPurchasedBook.hasFullData()) {
            return dkCloudPurchasedBook;
        }
        try {
            cj cjVar = new cj(DkUserPurchasedBooksManager.m5051h());
            cjVar.m5406a();
            return (DkCloudPurchasedBook) cjVar.queryItem(str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    public List<DkCloudPurchasedBook> m5396a() {
        List arrayList = new ArrayList(this.f3814c.size());
        for (DkCloudPurchasedBook dkCloudPurchasedBook : this.f3814c.values()) {
            if (!dkCloudPurchasedBook.isHidden()) {
                arrayList.add(dkCloudPurchasedBook);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public List<DkCloudPurchasedBook> m5400b() {
        List arrayList = new ArrayList(this.f3814c.size());
        for (DkCloudPurchasedBook dkCloudPurchasedBook : this.f3814c.values()) {
            if (dkCloudPurchasedBook.isHidden()) {
                arrayList.add(dkCloudPurchasedBook);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public List<DkCloudPurchasedBook> m5401c() {
        List<DkCloudPurchasedBook> arrayList = new ArrayList(this.f3814c.values());
        Collections.sort(arrayList, new ci(this));
        return arrayList;
    }

    /* renamed from: c */
    public boolean m5402c(String str) {
        DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.f3814c.get(str);
        if (dkCloudPurchasedBook == null) {
            return false;
        }
        return dkCloudPurchasedBook.isHidden();
    }

    /* renamed from: d */
    public boolean m5403d() {
        return this.f3814c.isEmpty();
    }

    /* renamed from: a */
    public void m5397a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.f3814c.put(dkCloudPurchasedBook.getBookUuid(), dkCloudPurchasedBook);
    }

    /* renamed from: a */
    public void m5398a(List<DkCloudPurchasedBook> list) {
        for (DkCloudPurchasedBook dkCloudPurchasedBook : list) {
            this.f3814c.put(dkCloudPurchasedBook.getBookUuid(), dkCloudPurchasedBook);
        }
    }
}
