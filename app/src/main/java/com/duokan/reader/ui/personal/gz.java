package com.duokan.reader.ui.personal;

import android.view.View;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.reader.ReaderFeature;

class gz implements OnScrollListener {
    boolean a = false;
    final /* synthetic */ View b;
    final /* synthetic */ fl c;

    gz(fl flVar, View view) {
        this.c = flVar;
        this.b = view;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        boolean z2 = false;
        if (z && this.b.getHeight() != 0) {
            int max = Math.max(this.b.getHeight() - Math.max(0, (scrollable.getViewportBounds().top + this.b.getHeight()) - this.c.d.getHeight()), 0);
            if (this.c.z != max) {
                this.c.z = max;
                this.b.invalidate();
            }
            this.c.d.invalidate();
            if ((this.c.z < this.c.y && !this.a) || (this.c.z == this.c.y && this.a)) {
                if (!this.a) {
                    z2 = true;
                }
                this.a = z2;
                ((ReaderFeature) this.c.getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
            }
        }
    }
}
