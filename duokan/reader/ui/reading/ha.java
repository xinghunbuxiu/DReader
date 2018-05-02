package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.sys.af;

class ha implements OnClickListener {
    final /* synthetic */ gz a;

    ha(gz gzVar) {
        this.a = gzVar;
    }

    public void onClick(View view) {
        if (!this.a.a.U()) {
            this.a.a.b(new af(Boolean.valueOf(false)));
        }
    }
}
