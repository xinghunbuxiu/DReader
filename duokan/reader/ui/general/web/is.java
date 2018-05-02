package com.duokan.reader.ui.general.web;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.ITheme;

import java.util.concurrent.Callable;

class is implements Callable {
    final /* synthetic */ PageController a;

    is(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        int round;
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(this.a.pageController.getContext()).queryFeature(ITheme.class);
        if (sVar != null) {
            round = Math.round(UTools.closeAnimation(this.a.pageController.getContext(), sVar.getTheme().getPageHeaderHeight()));
        } else {
            round = 0;
        }
        return Integer.valueOf(round);
    }
}
