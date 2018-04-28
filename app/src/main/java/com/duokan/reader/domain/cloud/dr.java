package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.domain.cmread.CmBookManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class dr {
    /* renamed from: a */
    private boolean f3888a = false;
    /* renamed from: b */
    private boolean f3889b = false;
    /* renamed from: c */
    private final ConcurrentHashMap<String, DkCloudPurchasedFiction> f3890c = new ConcurrentHashMap();

    public dr(dr drVar) {
        this.f3890c.putAll(drVar.f3890c);
        this.f3888a = drVar.f3888a;
        this.f3889b = drVar.f3889b;
    }

    /* renamed from: a */
    public DkCloudPurchasedFiction m5458a(String str) {
        return (DkCloudPurchasedFiction) this.f3890c.get(str);
    }

    /* renamed from: b */
    public DkCloudPurchasedFiction m5462b(String str) {
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) this.f3890c.get(str);
        if (dkCloudPurchasedFiction != null && dkCloudPurchasedFiction.isFullData()) {
            return dkCloudPurchasedFiction;
        }
        if (new C0650x(str).m3047b() == 1) {
            DkCloudPurchasedFictionInfo purchaseInfo = CmBookManager.get().getPurchaseInfo(str);
            return purchaseInfo == null ? null : new DkCloudPurchasedFiction(purchaseInfo, false);
        } else {
            try {
                dt dtVar = new dt(DkUserPurchasedFictionsManager.m5092g());
                dtVar.m5468a();
                return (DkCloudPurchasedFiction) dtVar.queryItem(str);
            } catch (Throwable th) {
                return null;
            }
        }
    }

    /* renamed from: a */
    public List<DkCloudPurchasedFiction> m5459a() {
        List arrayList = new ArrayList(this.f3890c.size());
        for (DkCloudPurchasedFiction dkCloudPurchasedFiction : this.f3890c.values()) {
            if (!dkCloudPurchasedFiction.isHidden()) {
                arrayList.add(dkCloudPurchasedFiction);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public List<DkCloudPurchasedFiction> m5463b() {
        List arrayList = new ArrayList(this.f3890c.size());
        for (DkCloudPurchasedFiction dkCloudPurchasedFiction : this.f3890c.values()) {
            if (dkCloudPurchasedFiction.isHidden()) {
                arrayList.add(dkCloudPurchasedFiction);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public List<DkCloudPurchasedFiction> m5464c() {
        List<DkCloudPurchasedFiction> arrayList = new ArrayList(this.f3890c.values());
        Collections.sort(arrayList, new ds(this));
        return arrayList;
    }

    /* renamed from: c */
    public boolean m5465c(String str) {
        DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) this.f3890c.get(str);
        if (dkCloudPurchasedFiction == null) {
            return false;
        }
        return dkCloudPurchasedFiction.isHidden();
    }

    /* renamed from: d */
    public boolean m5466d() {
        return this.f3890c.isEmpty();
    }

    /* renamed from: a */
    public void m5460a(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        this.f3890c.put(dkCloudPurchasedFiction.getBookUuid(), dkCloudPurchasedFiction);
    }

    /* renamed from: a */
    public void m5461a(List<DkCloudPurchasedFiction> list) {
        for (DkCloudPurchasedFiction dkCloudPurchasedFiction : list) {
            this.f3890c.put(dkCloudPurchasedFiction.getBookUuid(), dkCloudPurchasedFiction);
        }
    }
}
