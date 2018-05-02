package com.duokan.reader.ui.welcome;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class m implements OnKeyListener {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        this.a.e.a(false);
        return false;
    }
}
