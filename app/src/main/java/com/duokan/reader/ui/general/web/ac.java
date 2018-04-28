package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.duokan.reader.ui.general.bo;

class ac extends bo {
    /* renamed from: a */
    final /* synthetic */ ImageView f7568a;
    /* renamed from: c */
    final /* synthetic */ SearchController f7569c;

    ac(SearchController searchController, ImageView imageView) {
        this.f7569c = searchController;
        this.f7568a = imageView;
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }

    /* renamed from: c */
    public int mo506c() {
        if (this.f7569c.mSearchPresenter.mo1716a() <= (this.f7569c.mLocalSearchLoadTime + 1) * this.f7569c.mLocalHintSize || this.f7569c.mLocalSearchLoadTime >= 5) {
            this.f7568a.setVisibility(8);
            return this.f7569c.mSearchPresenter.mo1716a();
        }
        this.f7568a.setVisibility(0);
        return (this.f7569c.mLocalSearchLoadTime + 1) * this.f7569c.mLocalHintSize;
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return null;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        return this.f7569c.mSearchPresenter.mo1717a(i, view, viewGroup);
    }
}
