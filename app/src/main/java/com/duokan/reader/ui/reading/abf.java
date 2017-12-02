package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.i;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

class abf implements Callable {
    final /* synthetic */ int a;
    final /* synthetic */ abd b;

    abf(abd com_duokan_reader_ui_reading_abd, int i) {
        this.b = com_duokan_reader_ui_reading_abd;
        this.a = i;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public List a() {
        List linkedList = new LinkedList();
        gn X = this.b.b.a.X();
        gn e = this.b.b.a.e(this.a);
        if (X.h() instanceof i) {
            i iVar = (i) X.h();
            linkedList.add(iVar.b());
            linkedList.add(iVar.c());
            if (e == null) {
                return linkedList;
            }
            if (this.b.b.a.d(X.g()) && this.a == -1) {
                return linkedList;
            }
            if (this.b.b.a.e(X.g()) && this.a == 1) {
                return linkedList;
            }
            iVar = (i) e.h();
            linkedList.add(iVar.b());
            linkedList.add(iVar.c());
        } else if (e == null) {
            return linkedList;
        } else {
            if (this.b.b.a.d(X.g()) && this.a == -1) {
                return linkedList;
            }
            if (this.b.b.a.e(X.g()) && this.a == 1) {
                return linkedList;
            }
            linkedList.add(X.h());
            linkedList.add(e.h());
        }
        return linkedList;
    }
}
