package com.duokan.reader.ui.personal;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudStorage;

class mw implements an {
    /* renamed from: a */
    final /* synthetic */ mv f8972a;

    mw(mv mvVar) {
        this.f8972a = mvVar;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        DkCloudNoteBookInfo c = this.f8972a.f8971d.mo1556c(i);
        this.f8972a.b.pushHalfPageSmoothly(new mh(this.f8972a.getContext(), c, DkCloudStorage.m4994a().m5009a(c.getBookUuid())), null);
    }
}
