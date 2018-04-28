package com.duokan.reader.ui.bookshelf;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class eg implements OnEditorActionListener {
    /* renamed from: a */
    final /* synthetic */ ec f6381a;

    eg(ec ecVar) {
        this.f6381a = ecVar;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.f6381a.requestFocus();
        }
        return true;
    }
}
