package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class ag implements OnClickListener {
    final /* synthetic */ ab a;

    ag(ab abVar) {
        this.a = abVar;
    }

    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        UmengManager.get().onEvent("V2_READING_PRONOUNCE", view.isSelected() ? "Sync" : "Async");
        this.a.a.k(view.isSelected());
    }
}
