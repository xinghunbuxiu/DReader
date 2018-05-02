package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class gh implements OnClickListener {
    final /* synthetic */ gf a;

    gh(gf gfVar) {
        this.a = gfVar;
    }

    public void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.a((String) view.getTag());
        }
    }
}
