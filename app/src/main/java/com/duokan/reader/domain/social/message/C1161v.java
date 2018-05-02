package com.duokan.reader.domain.social.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.v */
public class C1161v implements C1137x {
    /* renamed from: a */
    private LinkedList<C1137x> f5585a = new LinkedList();

    /* renamed from: a */
    public void m8612a(C1137x c1137x) {
        if (c1137x != null && !this.f5585a.contains(c1137x)) {
            this.f5585a.add(c1137x);
        }
    }

    /* renamed from: a */
    public boolean mo1514a(C1151k c1151k) {
        Iterator it = this.f5585a.iterator();
        while (it.hasNext()) {
            if (((C1137x) it.next()).mo1514a(c1151k)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo1513a(ArrayList<C1151k> arrayList, HashMap<String, JSONObject> hashMap, C1140y c1140y) {
        if (arrayList.size() == 0 || this.f5585a.size() == 0) {
            c1140y.mo1519a(true);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        HashMap hashMap2 = new HashMap();
        Iterator it = this.f5585a.iterator();
        while (it.hasNext()) {
            C1137x c1137x = (C1137x) it.next();
            ArrayList arrayList3 = new ArrayList();
            hashMap2.put(c1137x, arrayList3);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                C1151k c1151k = (C1151k) arrayList2.get(size);
                if (c1137x.mo1514a(c1151k)) {
                    arrayList3.add(c1151k);
                    arrayList2.remove(size);
                }
            }
        }
        int[] iArr = new int[]{0, 0};
        Iterator it2 = this.f5585a.iterator();
        while (it2.hasNext()) {
            c1137x = (C1137x) it2.next();
            ArrayList arrayList4 = (ArrayList) hashMap2.get(c1137x);
            if (arrayList4.isEmpty()) {
                iArr[0] = iArr[0] + 1;
                iArr[1] = iArr[1] + 1;
                if (iArr[0] == this.f5585a.size()) {
                    c1140y.mo1519a(iArr[1] == this.f5585a.size());
                }
            } else {
                c1137x.mo1513a(arrayList4, hashMap, new C1162w(this, iArr, c1140y));
            }
        }
    }
}
