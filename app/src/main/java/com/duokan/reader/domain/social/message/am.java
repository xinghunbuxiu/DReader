package com.duokan.reader.domain.social.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class am implements at {
    /* renamed from: a */
    private LinkedList<at> f5523a = new LinkedList();

    /* renamed from: a */
    public void m8519a(at atVar) {
        if (atVar != null && !this.f5523a.contains(atVar)) {
            this.f5523a.add(atVar);
        }
    }

    /* renamed from: a */
    public void mo1173a(DkMessagesManager dkMessagesManager) {
        Iterator it = this.f5523a.iterator();
        while (it.hasNext()) {
            ((at) it.next()).mo1173a(dkMessagesManager);
        }
    }

    /* renamed from: a */
    public void mo1174a(DkMessagesManager dkMessagesManager, ArrayList<C1151k> arrayList, C1140y c1140y) {
        if (arrayList.size() == 0 || this.f5523a.size() == 0) {
            c1140y.mo1519a(true);
            return;
        }
        int[] iArr = new int[]{0, 0};
        Iterator it = this.f5523a.iterator();
        while (it.hasNext()) {
            ((at) it.next()).mo1174a(dkMessagesManager, arrayList, new an(this, iArr, c1140y));
        }
    }
}
