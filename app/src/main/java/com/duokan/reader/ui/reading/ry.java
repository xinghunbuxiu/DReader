package com.duokan.reader.ui.reading;

import android.os.Build.VERSION;

import com.duokan.c.e;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.r;

class ry implements r {
    final /* synthetic */ rx a;

    ry(rx rxVar) {
        this.a = rxVar;
    }

    public int getPageHeaderHeight() {
        if (getPageHeaderPaddingTop() == 0) {
            return this.a.c.getResources().getDimensionPixelSize(e.general__shared__page_header_height) - dv.b(this.a.c.getContext(), 15.0f);
        }
        return this.a.c.getResources().getDimensionPixelSize(e.general__shared__page_header_height);
    }

    public int getPageHeaderPaddingTop() {
        if (!this.a.an() || VERSION.SDK_INT < 19) {
            return 0;
        }
        int identifier = this.a.c.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.a.c.getResources().getDimensionPixelSize(identifier);
        }
        return dv.b(this.a.c.getContext(), 20.0f);
    }

    public int getHeaderPaddingTop() {
        return this.a.an() ? ((ReaderFeature) this.a.c.getContext().queryFeature(ReaderFeature.class)).getTheme().getHeaderPaddingTop() : 0;
    }

    public int getPagePaddingBottom() {
        return 0;
    }
}
