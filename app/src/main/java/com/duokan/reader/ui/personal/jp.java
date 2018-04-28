package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class jp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8788a;

    jp(jg jgVar) {
        this.f8788a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8788a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1403k(this.f8788a.getContext()), null);
    }
}
