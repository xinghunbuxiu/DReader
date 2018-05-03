package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.AnimUtils;

class aem implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ adz f9586a;

    aem(adz adz) {
        this.f9586a = adz;
    }

    public void onClick(View view) {
        if (this.f9586a.m13449e() && this.f9586a.f9551k == null) {
            this.f9586a.f9551k = new afd(this.f9586a.getContext());
            this.f9586a.f9543c.addView(this.f9586a.f9551k.getContentView(), new LayoutParams(-1, -1));
            AnimUtils.showAnimation(this.f9586a.f9551k.getContentView(), null);
            this.f9586a.f9546f.setVisibility(4);
            AnimUtils.hideAnimation(this.f9586a.f9546f, null);
            this.f9586a.addSubController(this.f9586a.f9551k);
            this.f9586a.activate(this.f9586a.f9551k);
        }
    }
}
