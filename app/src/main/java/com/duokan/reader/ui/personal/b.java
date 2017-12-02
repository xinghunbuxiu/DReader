package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        UmengManager.get().checkUpdateManual(this.a.getContext());
    }
}
