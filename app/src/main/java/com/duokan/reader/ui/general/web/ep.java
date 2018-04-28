package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import java.util.Arrays;
import java.util.LinkedHashMap;

class ep implements as {
    /* renamed from: a */
    final /* synthetic */ LinkedHashMap f7789a;
    /* renamed from: b */
    final /* synthetic */ int f7790b;
    /* renamed from: c */
    final /* synthetic */ ek f7791c;

    ep(ek ekVar, LinkedHashMap linkedHashMap, int i) {
        this.f7791c = ekVar;
        this.f7789a = linkedHashMap;
        this.f7790b = i;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (!Arrays.asList(this.f7791c.f7780b.f7581b.mTabsTitle.keySet().toArray()).equals(Arrays.asList(this.f7789a.keySet().toArray()))) {
            this.f7791c.f7780b.f7581b.mTabsTitle.clear();
            this.f7791c.f7780b.f7581b.mHasTabsTitleChange = true;
        }
        this.f7791c.f7780b.f7581b.mTabsTitle.putAll(this.f7789a);
        this.f7791c.f7780b.f7581b.mSurfingBarOffset = this.f7790b;
    }
}
