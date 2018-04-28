package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.ui.dv;

class zi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ze f11267a;

    zi(ze zeVar) {
        this.f11267a = zeVar;
    }

    public void onClick(View view) {
        if (!this.f11267a.f11220B) {
            int toolCount;
            Rect[] rectArr = new Rect[this.f11267a.f11253z.getToolCount()];
            for (toolCount = this.f11267a.f11253z.getToolCount() - 1; toolCount > 0; toolCount--) {
                rectArr[toolCount] = dv.m1904a(new Rect(), this.f11267a.f11253z.m10807a(toolCount), null);
            }
            LayoutParams layoutParams = this.f11267a.f11246s.getLayoutParams();
            layoutParams.width = dv.m1932b(this.f11267a.getContext(), 200.0f);
            this.f11267a.f11246s.setLayoutParams(layoutParams);
            this.f11267a.f11252y.leftMargin = dv.m1932b(this.f11267a.getContext(), 15.0f);
            for (toolCount = 1; toolCount < this.f11267a.f11246s.getChildCount(); toolCount++) {
                this.f11267a.f11246s.getChildAt(toolCount).setLayoutParams(this.f11267a.f11252y);
            }
            dv.m1921a(this.f11267a.f11246s, new zj(this, rectArr));
            this.f11267a.f11248u.setClickable(true);
            this.f11267a.f11249v.setClickable(true);
            this.f11267a.f11250w.setClickable(true);
            this.f11267a.f11251x.setClickable(true);
            this.f11267a.m15208b(this.f11267a.f11221C);
            this.f11267a.f11220B = true;
        }
    }
}
