package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.domain.social.message.as;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class cc implements as {
    /* renamed from: a */
    final /* synthetic */ boolean f8394a;
    /* renamed from: b */
    final /* synthetic */ bw f8395b;

    cc(bw bwVar, boolean z) {
        this.f8395b = bwVar;
        this.f8394a = z;
    }

    /* renamed from: a */
    public void mo1180a(C1151k[] c1151kArr, boolean z) {
        if (this.f8394a) {
            this.f8395b.f8379a.clear();
        }
        m11571a(c1151kArr);
        this.f8395b.getAdapter().m8785a(z);
    }

    /* renamed from: a */
    public void mo1179a(C1151k[] c1151kArr, String str) {
        if (c1151kArr.length > 0) {
            if (this.f8394a) {
                this.f8395b.f8379a.clear();
            }
            m11571a(c1151kArr);
            this.f8395b.getAdapter().m8785a(false);
            return;
        }
        this.f8395b.getAdapter().m8790m();
    }

    /* renamed from: a */
    private void m11571a(C1151k[] c1151kArr) {
        Collection arrayList = new ArrayList(c1151kArr.length);
        arrayList.addAll(Arrays.asList(c1151kArr));
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C1151k c1151k = (C1151k) arrayList.get(size);
            if (c1151k.m8582d()) {
                Iterator it = this.f8395b.f8379a.iterator();
                while (it.hasNext()) {
                    if (((C1151k) it.next()).f5555b.equals(c1151k.f5555b)) {
                        arrayList.remove(size);
                        break;
                    }
                }
            }
            arrayList.remove(size);
        }
        this.f8395b.f8379a.addAll(arrayList);
        if (this.f8395b.getViewMode() == ViewMode.Edit && this.f8395b.k != null) {
            this.f8395b.k.m9875c();
        }
    }
}
