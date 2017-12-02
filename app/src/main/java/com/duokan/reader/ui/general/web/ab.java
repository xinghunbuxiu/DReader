package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.duokan.reader.ui.general.bo;

class ab extends bo {
    final /* synthetic */ ImageView a;
    final /* synthetic */ SearchController c;

    ab(SearchController searchController, ImageView imageView) {
        this.c = searchController;
        this.a = imageView;
    }

    protected void b() {
    }

    protected void e(int i) {
    }

    public int c() {
        if (this.c.mSearchPresenter.a() <= (this.c.mLocalSearchLoadTime + 1) * this.c.mLocalHintSize || this.c.mLocalSearchLoadTime >= 5) {
            this.a.setVisibility(8);
            return this.c.mSearchPresenter.a();
        }
        this.a.setVisibility(0);
        return (this.c.mLocalSearchLoadTime + 1) * this.c.mLocalHintSize;
    }

    public Object d(int i) {
        return null;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        return this.c.mSearchPresenter.a(i, view, viewGroup);
    }
}
