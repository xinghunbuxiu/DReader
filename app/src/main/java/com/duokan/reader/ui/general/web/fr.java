package com.duokan.reader.ui.general.web;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.duokan.core.ui.cj;
import com.duokan.core.ui.dv;

class fr implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ EditText f7855a;
    /* renamed from: b */
    final /* synthetic */ fp f7856b;

    fr(fp fpVar, EditText editText) {
        this.f7856b = fpVar;
        this.f7855a = editText;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0 || !this.f7855a.hasFocus() || !cj.m1764a(this.f7856b.f7852g.f7845b.f7581b.getContext()).m1775a()) {
            return false;
        }
        dv.m1909a(this.f7856b.f7852g.f7845b.f7581b.getContext());
        return true;
    }
}
