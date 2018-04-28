package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.store.bv;

class iv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ iu f8750a;

    iv(iu iuVar) {
        this.f8750a = iuVar;
    }

    public void onClick(View view) {
        ((ReaderFeature) this.f8750a.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(bv.m15355a(AppContext.getAppContext(this.f8750a.getContext()), String.valueOf(0), 1, this.f8750a.f8748a.getBookUuid(), "redeem_" + this.f8750a.f8748a.getBookUuid()), null);
    }
}
