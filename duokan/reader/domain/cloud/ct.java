package com.duokan.reader.domain.cloud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ct {
    private boolean a = false;
    private boolean b = false;
    private final ConcurrentHashMap c = new ConcurrentHashMap();

    public ct(ct ctVar) {
        this.c.putAll(ctVar.c);
        this.a = ctVar.a;
        this.b = ctVar.b;
    }

    public DkCloudPurchasedBook a(String str) {
        return (DkCloudPurchasedBook) this.c.get(str);
    }

    public DkCloudPurchasedBook b(String str) {
        DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.c.get(str);
        if (dkCloudPurchasedBook != null && dkCloudPurchasedBook.hasFullData()) {
            return dkCloudPurchasedBook;
        }
        try {
            cv cvVar = new cv(DkUserPurchasedBooksManager.h());
            cvVar.a();
            return (DkCloudPurchasedBook) cvVar.queryItem(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public List a() {
        List arrayList = new ArrayList(this.c.size());
        for (DkCloudPurchasedBook dkCloudPurchasedBook : this.c.values()) {
            if (!dkCloudPurchasedBook.isHidden()) {
                arrayList.add(dkCloudPurchasedBook);
            }
        }
        return arrayList;
    }

    public List b() {
        List arrayList = new ArrayList(this.c.size());
        for (DkCloudPurchasedBook dkCloudPurchasedBook : this.c.values()) {
            if (dkCloudPurchasedBook.isHidden()) {
                arrayList.add(dkCloudPurchasedBook);
            }
        }
        return arrayList;
    }

    public List c() {
        List arrayList = new ArrayList(this.c.values());
        Collections.sort(arrayList, new cu(this));
        return arrayList;
    }

    public boolean c(String str) {
        DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.c.get(str);
        if (dkCloudPurchasedBook == null) {
            return false;
        }
        return dkCloudPurchasedBook.isHidden();
    }

    public boolean d() {
        return this.c.isEmpty();
    }

    public void a(DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.c.put(dkCloudPurchasedBook.getBookUuid(), dkCloudPurchasedBook);
    }

    public void a(List list) {
        for (DkCloudPurchasedBook dkCloudPurchasedBook : list) {
            this.c.put(dkCloudPurchasedBook.getBookUuid(), dkCloudPurchasedBook);
        }
    }
}
