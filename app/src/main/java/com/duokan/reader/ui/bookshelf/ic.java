package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;

class ic implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SignInBookshelfView f6587a;

    ic(SignInBookshelfView signInBookshelfView) {
        this.f6587a = signInBookshelfView;
    }

    public void onClick(View view) {
        ((ReaderFeature) AppContext.getAppContext(this.f6587a.getContext()).queryFeature(ReaderFeature.class)).pushPageSmoothly(new ie(AppContext.getAppContext(this.f6587a.getContext())), null);
        this.f6587a.m9093c();
    }
}
