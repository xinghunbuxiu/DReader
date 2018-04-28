package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ag implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ab f9696a;

    ag(ab abVar) {
        this.f9696a = abVar;
    }

    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        UmengManager.get().onEvent("V2_READING_PRONOUNCE", view.isSelected() ? "Sync" : "Async");
        this.f9696a.f9370a.mo2162k(view.isSelected());
    }
}
