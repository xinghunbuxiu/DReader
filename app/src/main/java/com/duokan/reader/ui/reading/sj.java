package com.duokan.reader.ui.reading;

import android.os.Build.VERSION;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0253e;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.C0457r;

class sj implements C0457r {
    /* renamed from: a */
    final /* synthetic */ si f10940a;

    sj(si siVar) {
        this.f10940a = siVar;
    }

    public int getPageHeaderHeight() {
        return this.f10940a.f9358c.getResources().getDimensionPixelSize(C0253e.general__shared__page_header_height) + getPageHeaderPaddingTop();
    }

    public int getPageHeaderPaddingTop() {
        if ((!this.f10940a.an() && !ReaderEnv.get().isNotchDevice()) || VERSION.SDK_INT < 19) {
            return 0;
        }
        int identifier = this.f10940a.f9358c.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f10940a.f9358c.getResources().getDimensionPixelSize(identifier);
        }
        return dv.m1932b(this.f10940a.f9358c.getContext(), 20.0f);
    }

    public int getHeaderPaddingTop() {
        return (this.f10940a.an() || ReaderEnv.get().isNotchDevice()) ? ((ReaderFeature) this.f10940a.f9358c.getContext().queryFeature(ReaderFeature.class)).getTheme().getHeaderPaddingTop() : 0;
    }

    public int getPagePaddingBottom() {
        return 0;
    }
}
