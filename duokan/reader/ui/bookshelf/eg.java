package com.duokan.reader.ui.bookshelf;

import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.aa;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class eg implements Comparator {
    final /* synthetic */ ec a;

    eg(ec ecVar) {
        this.a = ecVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((aa) obj, (aa) obj2);
    }

    public int a(aa aaVar, aa aaVar2) {
        String string = this.a.getResources().getString(j.general__shared__bookshelf);
        if (aaVar.k().equals(string)) {
            return -1;
        }
        if (aaVar2.k().equals(string)) {
            return 1;
        }
        int compare = Collator.getInstance(Locale.CHINESE).compare(aaVar.k(), aaVar2.k());
        if (compare < 0) {
            return -1;
        }
        if (compare > 0) {
            return 1;
        }
        if (aaVar.aH() == aaVar2.aH()) {
            return 0;
        }
        if (aaVar.aH() >= aaVar2.aH()) {
            return 1;
        }
        return -1;
    }
}
