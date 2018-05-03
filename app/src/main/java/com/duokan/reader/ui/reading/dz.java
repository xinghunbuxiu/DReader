package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ui.general.ReaderUi;

class dz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ el f10054a;
    /* renamed from: b */
    final /* synthetic */ dg f10055b;

    dz(dg dgVar, el elVar) {
        this.f10055b = dgVar;
        this.f10054a = elVar;
    }

    public void onClick(View view) {
        this.f10055b.f10012m.setText(this.f10054a.f10082d.f2067l);
        this.f10055b.f10010k.setScore(this.f10054a.f10083e);
        ReaderUi.m10162a(this.f10055b.getContext(), this.f10055b.f10012m);
        this.f10055b.f10012m.selectAll();
        this.f10055b.f10015p.setVisibility(8);
        this.f10055b.f10014o.setVisibility(0);
        AnimUtils.hideAnimation(this.f10055b.f10015p, null);
        AnimUtils.showAnimation(this.f10055b.f10014o, null);
    }
}
