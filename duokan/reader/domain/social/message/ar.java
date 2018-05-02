package com.duokan.reader.domain.social.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ar implements ay {
    private LinkedList a = new LinkedList();

    public void a(ay ayVar) {
        if (ayVar != null && !this.a.contains(ayVar)) {
            this.a.add(ayVar);
        }
    }

    public void a(DkMessagesManager dkMessagesManager) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ay) it.next()).a(dkMessagesManager);
        }
    }

    public void a(DkMessagesManager dkMessagesManager, ArrayList arrayList, aa aaVar) {
        if (arrayList.size() == 0 || this.a.size() == 0) {
            aaVar.a(true);
            return;
        }
        int[] iArr = new int[]{0, 0};
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ay) it.next()).a(dkMessagesManager, arrayList, new as(this, iArr, aaVar));
        }
    }
}
