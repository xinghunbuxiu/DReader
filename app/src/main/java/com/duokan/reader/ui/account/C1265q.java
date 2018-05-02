package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.personal.ac;

/* renamed from: com.duokan.reader.ui.account.q */
class C1265q implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1261m f5972a;

    C1265q(C1261m c1261m) {
        this.f5972a = c1261m;
    }

    public void onClick(View view) {
        ((ReaderFeature) AppContext.getAppContext(this.f5972a.getContext()).queryFeature(ReaderFeature.class)).pushHalfPage(new ac(this.f5972a.getContext()));
    }
}
