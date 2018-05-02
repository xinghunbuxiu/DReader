package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.b.e;

class er implements as {
    final /* synthetic */ PageController a;

    er(PageController cgVar) {
        this.a = cgVar;
    }

    public void a() {
        e.a(this.a.pageController.getContext()).a(this.a.pageController.getActivity());
    }
}
