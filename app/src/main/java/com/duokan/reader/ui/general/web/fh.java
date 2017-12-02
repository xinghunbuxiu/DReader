package com.duokan.reader.ui.general.web;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

import com.duokan.core.ui.cj;
import com.duokan.core.ui.dv;

class fh implements OnTouchListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ ff b;

    fh(ff ffVar, EditText editText) {
        this.b = ffVar;
        this.a = editText;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0 || !this.a.hasFocus() || !cj.a(this.b.g.b.b.getContext()).a()) {
            return false;
        }
        dv.a(this.b.g.b.b.getContext());
        return true;
    }
}
