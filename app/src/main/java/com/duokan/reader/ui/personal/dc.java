package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.common.p036b.C0542e;

class dc implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MiAccountProfileSettingsController f8445a;

    dc(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.f8445a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        C0542e.m2411a(this.f8445a.getContext()).m2393a(this.f8445a.getActivity());
    }
}
