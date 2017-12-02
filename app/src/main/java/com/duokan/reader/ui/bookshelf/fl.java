package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;

class fl implements OnClickListener {
    final /* synthetic */ fh a;

    fl(fh fhVar) {
        this.a = fhVar;
    }

    public void onClick(View view) {
        ((ff) x.a(this.a.getContext()).queryFeature(ff.class)).a();
    }
}
