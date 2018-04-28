package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;

class hz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SignInBookshelfView f6580a;

    hz(SignInBookshelfView signInBookshelfView) {
        this.f6580a = signInBookshelfView;
    }

    public void onClick(View view) {
        ActivatedController ieVar = new ie(AppContext.getAppContext(this.f6580a.getContext()));
        ((ReaderFeature) AppContext.getAppContext(this.f6580a.getContext()).queryFeature(ReaderFeature.class)).pushPageSmoothly(ieVar, new ia(this, ieVar));
        this.f6580a.m9093c();
    }
}
