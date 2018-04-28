package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class jq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8789a;

    jq(jg jgVar) {
        this.f8789a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8789a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new az(this.f8789a.getContext(), false), null);
    }
}
