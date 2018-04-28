package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.common.C0268j;
import com.duokan.core.app.BaseActivity;

class iy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f8753a;
    /* renamed from: b */
    final /* synthetic */ iu f8754b;

    iy(iu iuVar, String str) {
        this.f8754b = iuVar;
        this.f8753a = str;
    }

    public void onClick(View view) {
        C0268j.m612a((BaseActivity) this.f8754b.getActivity(), this.f8753a);
    }
}
