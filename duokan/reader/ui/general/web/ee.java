package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import java.util.Arrays;
import java.util.LinkedHashMap;

class ee implements as {
    final /* synthetic */ LinkedHashMap a;
    final /* synthetic */ int b;
    final /* synthetic */ ec c;

    ee(ec ecVar, LinkedHashMap linkedHashMap, int i) {
        this.c = ecVar;
        this.a = linkedHashMap;
        this.b = i;
    }

    public void a() {
        if (!Arrays.asList(this.c.b.pageController.mTabsTitle.keySet().toArray()).equals(Arrays.asList(this.a.keySet().toArray()))) {
            this.c.b.pageController.mTabsTitle.clear();
            this.c.b.pageController.mHasTabsTitleChange = true;
        }
        this.c.b.pageController.mTabsTitle.putAll(this.a);
        this.c.b.pageController.mSurfingBarOffset = this.b;
    }
}
