package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.ReaderUi;

class dr implements OnClickListener {
    final /* synthetic */ eh a;
    final /* synthetic */ de b;

    dr(de deVar, eh ehVar) {
        this.b = deVar;
        this.a = ehVar;
    }

    public void onClick(View view) {
        this.b.l.setText(this.a.d.l);
        this.b.j.setScore(this.a.e);
        ReaderUi.a(this.b.getContext(), this.b.l);
        this.b.l.selectAll();
        this.b.o.setVisibility(8);
        this.b.n.setVisibility(0);
        UTools.showAnimation(this.b.o, null);
        UTools.closeAnimation(this.b.n, null);
    }
}
