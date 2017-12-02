package com.duokan.reader.ui.personal;

import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudStorage;

class mi implements an {
    final /* synthetic */ mh a;

    mi(mh mhVar) {
        this.a = mhVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        DkCloudNoteBookInfo c = this.a.d.c(i);
        this.a.b.pushHalfPageSmoothly(new lt(this.a.getContext(), c, DkCloudStorage.a().a(c.getBookUuid())), null);
    }
}
