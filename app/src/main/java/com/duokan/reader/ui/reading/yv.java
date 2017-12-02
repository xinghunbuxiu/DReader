package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

import com.duokan.core.ui.dv;

class yv implements OnClickListener {
    final /* synthetic */ yr a;

    yv(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        if (!this.a.B) {
            int toolCount;
            Rect[] rectArr = new Rect[this.a.z.getToolCount()];
            for (toolCount = this.a.z.getToolCount() - 1; toolCount > 0; toolCount--) {
                rectArr[toolCount] = dv.a(new Rect(), this.a.z.a(toolCount), null);
            }
            LayoutParams layoutParams = this.a.s.getLayoutParams();
            layoutParams.width = dv.b(this.a.getContext(), 200.0f);
            this.a.s.setLayoutParams(layoutParams);
            this.a.y.leftMargin = dv.b(this.a.getContext(), 15.0f);
            for (toolCount = 1; toolCount < this.a.s.getChildCount(); toolCount++) {
                this.a.s.getChildAt(toolCount).setLayoutParams(this.a.y);
            }
            dv.a(this.a.s, new yw(this, rectArr));
            this.a.u.setClickable(true);
            this.a.v.setClickable(true);
            this.a.w.setClickable(true);
            this.a.x.setClickable(true);
            this.a.b(this.a.C);
            this.a.B = true;
        }
    }
}
