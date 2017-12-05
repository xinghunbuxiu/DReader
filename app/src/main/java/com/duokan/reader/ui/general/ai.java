package com.duokan.reader.ui.general;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.IWindowRecord;
import com.duokan.reader.ui.ITheme;

class ai implements IWindowRecord {
    final /* synthetic */ ah a;

    ai(ah ahVar) {
        this.a = ahVar;
    }

    public int getPageHeaderHeight() {
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(this.a.a).queryFeature(ITheme.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getPageHeaderHeight();
    }

    public int getPageHeaderPaddingTop() {
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(this.a.a).queryFeature(ITheme.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getPageHeaderPaddingTop();
    }

    public int getHeaderPaddingTop() {
        if (ReaderEnv.get().forHd()) {
            return 0;
        }
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(this.a.a).queryFeature(ITheme.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getHeaderPaddingTop();
    }

    public int getPagePaddingBottom() {
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(this.a.a).queryFeature(ITheme.class);
        if (sVar == null) {
            return 0;
        }
        return sVar.getTheme().getPagePaddingBottom();
    }
}
