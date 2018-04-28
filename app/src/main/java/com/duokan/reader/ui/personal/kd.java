package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class kd implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8804a;

    kd(jg jgVar) {
        this.f8804a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8804a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1408p(this.f8804a.getContext()), null);
    }
}
