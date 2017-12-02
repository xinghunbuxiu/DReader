package com.duokan.core.sys;

import java.util.Comparator;

class ab implements Comparator {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((ae) obj, (ae) obj2);
    }

    public int a(ae aeVar, ae aeVar2) {
        if (aeVar.b < aeVar2.b) {
            return 1;
        }
        if (aeVar.b > aeVar2.b) {
            return -1;
        }
        return 0;
    }
}
