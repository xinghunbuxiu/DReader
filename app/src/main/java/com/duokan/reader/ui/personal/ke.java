package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class ke implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8805a;

    ke(jg jgVar) {
        this.f8805a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8805a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new nu(this.f8805a.getContext()), null);
    }
}
