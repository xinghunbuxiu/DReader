package com.duokan.reader.ui.personal;

import android.graphics.Color;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.PageHeaderView;

import org.apache.http.HttpStatus;

class ib implements cg {
    final /* synthetic */ PageHeaderView a;
    final /* synthetic */ hw b;

    ib(hw hwVar, PageHeaderView pageHeaderView) {
        this.b = hwVar;
        this.a = pageHeaderView;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        if (this.a != null && this.a.getHeight() != 0 && z) {
            int i = this.b.d.getViewportBounds().top;
            if (this.b.d.getContentHeight() - this.a.getHeight() <= UTools.getHeightPixels(this.b.getContext())) {
                i = 0;
            } else {
                i = (int) (UTools.addAnimation(((((float) i) - ((float) this.a.getHeight())) / ((float) this.a.getHeight())) + 1.0f) * 255.0f);
            }
            this.a.setBackgroundColor(Color.argb(i, 248, 248, 248));
            this.a.setBottomLineColor(Color.argb(i, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT));
            this.a.getCenterTitleView().setTextColor(Color.argb(i, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING));
        }
    }
}
