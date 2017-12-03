package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.eg;

class yq implements OnClickListener {
    final /* synthetic */ yo a;

    yq(yo yoVar) {
        this.a = yoVar;
    }

    public void onClick(View view) {
        int i;
        this.a.D.put("Action1", "MARK");
        this.a.E.c();
        this.a.d.setVisibility(8);
        this.a.d.removeAllViews();
        this.a.e.setVisibility(0);
        this.a.e.addView(this.a.z);
        if (this.a.z.getToolCount() == 0) {
            this.a.z.a(this.a.s);
            this.a.z.a(this.a.q);
            this.a.z.a(this.a.m);
            this.a.z.a(this.a.t);
            this.a.z.a(this.a.n);
            this.a.z.a(this.a.l);
            if (this.a.g()) {
                this.a.z.a(this.a.k);
            }
            for (i = 0; i < this.a.z.getToolCount(); i++) {
                this.a.z.a(i).setPadding(0, 0, UTools.closeAnimation(this.a.getContext(), 20.0f), 0);
            }
            this.a.z.a(UTools.closeAnimation(this.a.getContext(), 10.0f), 0, UTools.closeAnimation(this.a.getContext(), 10.0f), 0);
        }
        this.a.d();
        this.a.y.leftMargin = UTools.closeAnimation(this.a.getContext(), -25.0f);
        for (i = 1; i < this.a.s.getChildCount(); i++) {
            this.a.s.getChildAt(i).setLayoutParams(this.a.y);
        }
        LayoutParams layoutParams = this.a.s.getLayoutParams();
        layoutParams.width = -2;
        this.a.s.setLayoutParams(layoutParams);
        this.a.B = false;
        this.a.u.setClickable(false);
        this.a.v.setClickable(false);
        this.a.w.setClickable(false);
        this.a.x.setClickable(false);
        this.a.a(eg.a().c(eg.a().b()));
        this.a.b();
    }
}
