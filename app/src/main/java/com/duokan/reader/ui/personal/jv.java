package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class jv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8794a;

    jv(jg jgVar) {
        this.f8794a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8794a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new av(this.f8794a.getContext()), null);
    }
}
