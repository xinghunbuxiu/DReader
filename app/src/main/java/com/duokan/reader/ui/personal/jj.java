package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.account.C1261m;

class jj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8781a;

    jj(jg jgVar) {
        this.f8781a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8781a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1261m(this.f8781a.getContext()), null);
    }
}
