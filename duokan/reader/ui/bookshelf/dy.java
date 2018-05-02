package com.duokan.reader.ui.bookshelf;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class dy implements OnEditorActionListener {
    final /* synthetic */ du a;

    dy(du duVar) {
        this.a = duVar;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.a.requestFocus();
        }
        return true;
    }
}
