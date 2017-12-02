package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.b.m;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class er implements Comparator {
    final /* synthetic */ en a;
    private Collator b = Collator.getInstance(Locale.CHINESE);

    er(en enVar) {
        this.a = enVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((m) obj, (m) obj2);
    }

    public int a(m mVar, m mVar2) {
        int i = 1;
        if (mVar.c() == mVar2.c()) {
            return this.b.compare(mVar.a(), mVar2.a());
        }
        if (!this.a.a) {
            if (!mVar.c()) {
                i = -1;
            }
            return i;
        } else if (mVar.c()) {
            return -1;
        } else {
            return 1;
        }
    }
}
