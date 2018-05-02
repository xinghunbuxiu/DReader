package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

class iv implements OnScrollListener {
    final /* synthetic */ iu a;

    iv(iu iuVar) {
        this.a = iuVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.a.b != null) {
            this.a.b.a(scrollable, scrollState, scrollState2);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        int i = 0;
        if (z && this.a.a != null) {
            Integer[] visiableViewIndex = this.a.getVisiableViewIndex();
            if (visiableViewIndex.length > 0) {
                i = visiableViewIndex[0].intValue();
                int left = (this.a.getChildAt(i).getLeft() + this.a.getChildAt(i).getRight()) / 2;
                int intValue = visiableViewIndex[visiableViewIndex.length - 1].intValue();
                if (Math.abs(left - this.a.getViewportBounds().centerX()) >= Math.abs(((this.a.getChildAt(intValue).getLeft() + this.a.getChildAt(intValue).getRight()) / 2) - this.a.getViewportBounds().centerX())) {
                    i = intValue;
                }
            }
            this.a.a.a((((float) this.a.getViewportBounds().centerX()) * 1.0f) / ((float) this.a.getContentWidth()), i);
        }
        if (this.a.b != null) {
            this.a.b.a(scrollable, z);
        }
    }
}
