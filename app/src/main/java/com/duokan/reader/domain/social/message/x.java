package com.duokan.reader.domain.social.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class x implements z {
    private LinkedList a = new LinkedList();

    public void a(z zVar) {
        if (zVar != null && !this.a.contains(zVar)) {
            this.a.add(zVar);
        }
    }

    public boolean a(k kVar) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((z) it.next()).a(kVar)) {
                return true;
            }
        }
        return false;
    }

    public void a(ArrayList arrayList, HashMap hashMap, aa aaVar) {
        if (arrayList.size() == 0 || this.a.size() == 0) {
            aaVar.a(true);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        HashMap hashMap2 = new HashMap();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            ArrayList arrayList3 = new ArrayList();
            hashMap2.put(zVar, arrayList3);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                k kVar = (k) arrayList2.get(size);
                if (zVar.a(kVar)) {
                    arrayList3.add(kVar);
                    arrayList2.remove(size);
                }
            }
        }
        int[] iArr = new int[]{0, 0};
        Iterator it2 = this.a.iterator();
        while (it2.hasNext()) {
            zVar = (z) it2.next();
            ArrayList arrayList4 = (ArrayList) hashMap2.get(zVar);
            if (arrayList4.isEmpty()) {
                iArr[0] = iArr[0] + 1;
                iArr[1] = iArr[1] + 1;
                if (iArr[0] == this.a.size()) {
                    aaVar.a(iArr[1] == this.a.size());
                }
            } else {
                zVar.a(arrayList4, hashMap, new y(this, iArr, aaVar));
            }
        }
    }
}
