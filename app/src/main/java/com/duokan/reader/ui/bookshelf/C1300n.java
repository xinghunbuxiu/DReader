package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;

/* renamed from: com.duokan.reader.ui.bookshelf.n */
class C1300n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1290g f6726a;

    C1300n(C1290g c1290g) {
        this.f6726a = c1290g;
    }

    public void onClick(View view) {
        ((ReaderFeature) AppContext.getAppContext(this.f6726a.getContext()).queryFeature(ReaderFeature.class)).navigate("duokan-reader://store", null, false, null);
    }
}
