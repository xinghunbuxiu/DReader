package com.duokan.reader.ui.reading;

import android.util.Pair;
import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ui.general.expandable.ViewMode;

class afo implements an {
    /* renamed from: a */
    final /* synthetic */ afm f9642a;
    /* renamed from: b */
    final /* synthetic */ afn f9643b;

    afo(afn afn, afm afm) {
        this.f9643b = afn;
        this.f9642a = afm;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        if (this.f9643b.getViewMode() == ViewMode.Edit) {
            Pair a = this.f9643b.m13515a(i);
            this.f9643b.m11522b(((Integer) a.first).intValue(), ((Integer) a.second).intValue());
        }
    }
}
