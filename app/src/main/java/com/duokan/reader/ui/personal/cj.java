package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.social.message.ax;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.general.expandable.ViewMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class cj implements ax {
    final /* synthetic */ boolean a;
    final /* synthetic */ cd b;

    cj(cd cdVar, boolean z) {
        this.b = cdVar;
        this.a = z;
    }

    public void a(k[] kVarArr, boolean z) {
        if (this.a) {
            this.b.a.clear();
        }
        a(kVarArr);
        this.b.getAdapter().a(z);
    }

    public void a(k[] kVarArr, String str) {
        if (kVarArr.length > 0) {
            if (this.a) {
                this.b.a.clear();
            }
            a(kVarArr);
            this.b.getAdapter().a(false);
            return;
        }
        this.b.getAdapter().m();
    }

    private void a(k[] kVarArr) {
        Collection arrayList = new ArrayList(kVarArr.length);
        arrayList.addAll(Arrays.asList(kVarArr));
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            k kVar = (k) arrayList.get(size);
            if (kVar.d()) {
                Iterator it = this.b.a.iterator();
                while (it.hasNext()) {
                    if (((k) it.next()).b.equals(kVar.b)) {
                        arrayList.remove(size);
                        break;
                    }
                }
            }
            arrayList.remove(size);
        }
        this.b.a.addAll(arrayList);
        if (this.b.getViewMode() == ViewMode.Edit && this.b.j != null) {
            this.b.j.c();
        }
    }
}
