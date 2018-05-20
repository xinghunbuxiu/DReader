package com.duokan.reader.ui.personal;

import android.graphics.Color;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ui.general.PageHeaderView;
import org.apache.http.HttpStatus;

class io implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ PageHeaderView f8738a;
    /* renamed from: b */
    final /* synthetic */ ij f8739b;

    io(ij ijVar, PageHeaderView pageHeaderView) {
        this.f8739b = ijVar;
        this.f8738a = pageHeaderView;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (this.f8738a != null && this.f8738a.getHeight() != 0 && z) {
            int i = this.f8739b.f8720d.getViewportBounds().top;
            if (this.f8739b.f8720d.getContentHeight() - this.f8738a.getHeight() <= AnimUtils.getHeightPixels(this.f8739b.getContext())) {
                i = 0;
            } else {
                i = (int) (AnimUtils.getAlpha(((((float) i) - ((float) this.f8738a.getHeight())) / ((float) this.f8738a.getHeight())) + 1.0f) * 255.0f);
            }
            this.f8738a.setBackgroundColor(Color.argb(i, 248, 248, 248));
            this.f8738a.setBottomLineColor(Color.argb(i, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT));
            this.f8738a.getCenterTitleView().setTextColor(Color.argb(i, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING));
        }
    }
}
