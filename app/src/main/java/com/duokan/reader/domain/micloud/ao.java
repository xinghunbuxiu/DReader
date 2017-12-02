package com.duokan.reader.domain.micloud;

import java.util.HashMap;

public class ao implements ae {
    private static final ao a = new ao();
    private final HashMap b = new HashMap();

    private ao() {
    }

    public static ao a() {
        return a;
    }

    public synchronized ad a(String str, String str2) {
        ad adVar;
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) this.b.get(str);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            this.b.put(str, hashMap2);
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
