package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.cmread.CmBookManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class eg {
    private boolean a = false;
    private boolean b = false;
    private final ConcurrentHashMap c = new ConcurrentHashMap();

    public eg(eg egVar) {
        this.c.putAll(egVar.c);
        this.a = egVar.a;
        this.b = egVar.b;
    }

    public DkCloudPurchasedFiction a(String str) {
        return (DkCloudPurchasedFiction) this.c.get(str);
    }

    public DkCloudPurchasedFiction b(String str) {
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) this.c.get(str);
        if (dkCloudPurchasedFiction != null && dkCloudPurchasedFiction.isFullData()) {
            return dkCloudPurchasedFiction;
        }
        if (new y(str).b() == 1) {
            DkCloudPurchasedFictionInfo purchaseInfo = CmBookManager.get().getPurchaseInfo(str);
            return purchaseInfo == null ? null : new DkCloudPurchasedFiction(purchaseInfo, false);
        } else {
            try {
                ei eiVar = new ei(DkUserPurchasedFictionsManager.g());
                eiVar.a();
                return (DkCloudPurchasedFiction) eiVar.queryItem(str);
            } catch (Throwable th) {
                return null;
            }
        }
    }

    public List a() {
        List arrayList = new ArrayList(this.c.size());
        for (DkCloudPurchasedFiction dkCloudPurchasedFiction : this.c.values()) {
            if (!dkCloudPurchasedFiction.isHidden()) {
                arrayList.add(dkCloudPurchasedFiction);
            }
        }
        return arrayList;
    }

    public List b() {
        List arrayList = new ArrayList(this.c.size());
        for (DkCloudPurchasedFiction dkCloudPurchasedFiction : this.c.values()) {
            if (dkCloudPurchasedFiction.isHidden()) {
                arrayList.add(dkCloudPurchasedFiction);
            }
        }
        return arrayList;
    }

    public List c() {
        List arrayList = new ArrayList(this.c.values());
        Collections.sort(arrayList, new eh(this));
        return arrayList;
    }

    public boolean c(String str) {
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) this.c.get(str);
        if (dkCloudPurchasedFiction == null) {
            return false;
        }
        return dkCloudPurchasedFiction.isHidden();
    }

    public boolean d() {
        return this.c.isEmpty();
    }

    public void a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        this.c.put(dkCloudPurchasedFiction.getBookUuid(), dkCloudPurchasedFiction);
    }

    public void a(List list) {
        for (DkCloudPurchasedFiction dkCloudPurchasedFiction : list) {
            this.c.put(dkCloudPurchasedFiction.getBookUuid(), dkCloudPurchasedFiction);
        }
    }
}
