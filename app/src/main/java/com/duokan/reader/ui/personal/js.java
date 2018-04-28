package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class js implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8791a;

    js(jg jgVar) {
        this.f8791a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8791a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1391a(this.f8791a.getContext()), null);
    }
}
