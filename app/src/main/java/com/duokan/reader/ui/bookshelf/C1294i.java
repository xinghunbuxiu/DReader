package com.duokan.reader.ui.bookshelf;

import android.view.View;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.bookshelf.i */
class C1294i implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ View f6581a;
    /* renamed from: b */
    final /* synthetic */ View f6582b;
    /* renamed from: c */
    final /* synthetic */ C1290g f6583c;

    C1294i(C1290g c1290g, View view, View view2) {
        this.f6583c = c1290g;
        this.f6581a = view;
        this.f6582b = view2;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.f6583c.f6489i.getVisibility() != 8) {
            int i = scrollable.getViewportBounds().top;
            if (scrollState2 != ScrollState.IDLE) {
                return;
            }
            if (i <= 0 || i >= this.f6583c.f6489i.getHeight()) {
                this.f6583c.f6496p = false;
            } else if (!this.f6583c.f6496p || i > this.f6583c.f6489i.getHeight() / 2) {
                scrollable.mo434a(0, this.f6583c.f6489i.getHeight(), HttpStatus.SC_MULTIPLE_CHOICES, null, null);
            } else {
                scrollable.mo434a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
            }
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (this.f6583c.f6489i.getVisibility() == 8) {
            this.f6581a.setTranslationY(0.0f);
            return;
        }
        int i = scrollable.getViewportBounds().top;
        if (i < this.f6583c.f6489i.getHeight()) {
            this.f6581a.setTranslationY((float) i);
        } else {
            this.f6581a.setTranslationY((float) this.f6583c.f6489i.getHeight());
        }
        this.f6582b.invalidate();
    }
}
