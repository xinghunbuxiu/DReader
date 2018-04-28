package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.bookshelf.eb;

class zd implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ zb f11263a;

    zd(zb zbVar) {
        this.f11263a = zbVar;
    }

    public void onClick(View view) {
        int i;
        this.f11263a.D.put("Action1", "MARK");
        this.f11263a.f11261E.mo2210c();
        this.f11263a.d.setVisibility(8);
        this.f11263a.d.removeAllViews();
        this.f11263a.e.setVisibility(0);
        this.f11263a.e.addView(this.f11263a.z);
        if (this.f11263a.z.getToolCount() == 0) {
            this.f11263a.z.m10809a(this.f11263a.s);
            this.f11263a.z.m10809a(this.f11263a.q);
            this.f11263a.z.m10809a(this.f11263a.m);
            this.f11263a.z.m10809a(this.f11263a.t);
            this.f11263a.z.m10809a(this.f11263a.n);
            this.f11263a.z.m10809a(this.f11263a.l);
            if (this.f11263a.m15215g()) {
                this.f11263a.z.m10809a(this.f11263a.k);
            }
            for (i = 0; i < this.f11263a.z.getToolCount(); i++) {
                this.f11263a.z.m10807a(i).setPadding(0, 0, dv.m1932b(this.f11263a.getContext(), 20.0f), 0);
            }
            this.f11263a.z.m10808a(dv.m1932b(this.f11263a.getContext(), 10.0f), 0, dv.m1932b(this.f11263a.getContext(), 10.0f), 0);
        }
        this.f11263a.m15212d();
        this.f11263a.y.leftMargin = dv.m1932b(this.f11263a.getContext(), -25.0f);
        for (i = 1; i < this.f11263a.s.getChildCount(); i++) {
            this.f11263a.s.getChildAt(i).setLayoutParams(this.f11263a.y);
        }
        LayoutParams layoutParams = this.f11263a.s.getLayoutParams();
        layoutParams.width = -2;
        this.f11263a.s.setLayoutParams(layoutParams);
        this.f11263a.B = false;
        this.f11263a.u.setClickable(false);
        this.f11263a.v.setClickable(false);
        this.f11263a.w.setClickable(false);
        this.f11263a.x.setClickable(false);
        this.f11263a.m15228a(eb.m4386a().m4391c(eb.m4386a().m4389b()));
        this.f11263a.m15207b();
    }
}
