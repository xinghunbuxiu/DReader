package com.duokan.reader.ui.general;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.r;
import com.duokan.reader.ui.s;

class ai implements r {
    final /* synthetic */ ah a;

    ai(ah ahVar) {
        this.a = ahVar;
    }

    public int getPageHeaderHeight() {
        s sVar = (s) MyContextWrapper.getFeature(this.a.a).queryFeature(s.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getPageHeaderHeight();
    }

    public int getPageHeaderPaddingTop() {
        s sVar = (s) MyContextWrapper.getFeature(this.a.a).queryFeature(s.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getPageHeaderPaddingTop();
    }

    public int getHeaderPaddingTop() {
        if (ReaderEnv.get().forHd()) {
            return 0;
        }
        s sVar = (s) MyContextWrapper.getFeature(this.a.a).queryFeature(s.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getHeaderPaddingTop();
    }

    public int getPagePaddingBottom() {
        s sVar = (s) MyContextWrapper.getFeature(this.a.a).queryFeature(s.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getPagePaddingBottom();
    }
}
