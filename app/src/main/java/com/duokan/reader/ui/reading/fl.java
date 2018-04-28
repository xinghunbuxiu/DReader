package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.app.ActivatedController;

class fl implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ fh f10152a;

    fl(fh fhVar) {
        this.f10152a = fhVar;
    }

    public boolean onLongClick(View view) {
        this.f10152a.f10141a.mo2040a(1, 0);
        this.f10152a.f10141a.mo2031a(ReadingTheme.CUSTOM);
        for (int i = 0; i < this.f10152a.f10142b.getChildCount(); i++) {
            this.f10152a.f10142b.getChildAt(i).setVisibility(8);
        }
        this.f10152a.f10142b.setPadding(0, 0, 0, 0);
        ActivatedController feVar = new fe(this.f10152a.getContext());
        this.f10152a.f10142b.addView(feVar.getContentView(), new LayoutParams(-1, -2));
        this.f10152a.addSubController(feVar);
        this.f10152a.activate(feVar);
        return true;
    }
}
