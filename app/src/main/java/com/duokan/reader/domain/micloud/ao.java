package com.duokan.reader.domain.micloud;

import java.util.HashMap;

public class ao implements ae {
    /* renamed from: a */
    private static final ao f5194a = new ao();
    /* renamed from: b */
    private final HashMap<String, HashMap<String, aq>> f5195b = new HashMap();

    private ao() {
    }

    /* renamed from: a */
    public static ao m8071a() {
        return f5194a;
    }

    /* renamed from: a */
    public synchronized ad mo1479a(String str, String str2) {
        ad adVar;
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) this.f5195b.get(str);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            this.f5195b.put(str, hashMap2);
            hashMap = hashMap2;
        } else {
            hashMap = hashMap2;
        }
        adVar = (aq) hashMap.get(str2);
        if (adVar == null) {
            adVar = new aq(str, str2);
            hashMap.put(str2, adVar);
        }
        return adVar;
    }
}
