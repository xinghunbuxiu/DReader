package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderFeature;

class jo implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8787a;

    jo(jg jgVar) {
        this.f8787a = jgVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8787a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new C1393c(this.f8787a.getContext()), null);
    }
}
