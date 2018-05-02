package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.common.b.e;

class di implements OnClickListener {
    final /* synthetic */ MiAccountProfileSettingsController a;

    di(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.a = miAccountProfileSettingsController;
    }

    public void onClick(View view) {
        e.a(this.a.getContext()).a(this.a.getActivity());
    }
}
