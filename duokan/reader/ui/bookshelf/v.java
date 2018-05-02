package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.general.ho;

class v implements OnClickListener {
    final /* synthetic */ g a;

    v(g gVar) {
        this.a = gVar;
    }

    public void onClick(View view) {
        ((ho) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ho.class)).a("", "", "");
    }
}
