package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class jt implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8792a;

    jt(jg jgVar) {
        this.f8792a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8792a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new nh(this.f8792a.getContext()), null);
    }
}
