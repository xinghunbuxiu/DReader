package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.UmengManager;

class ai implements an {
    final /* synthetic */ SearchController a;

    ai(SearchController searchController) {
        this.a = searchController;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        this.a.mHitWord = (String) this.a.mSearchHintView.getAdapter().d(i);
        this.a.mEditText.setText(this.a.mHitWord);
        this.a.mEditText.setSelection(this.a.mHitWord.length());
        String str = "";
        if (this.a.hasHint()) {
            str = "hint";
        } else if (i < this.a.mHistory.size()) {
            str = "history";
        } else if (i < this.a.mHotWord.size() + this.a.mHistory.size()) {
            str = "hot";
        }
        if (!TextUtils.isEmpty(str)) {
            UmengManager.get().onEvent("SEARCH_FROM_V1", str);
        }
    }
}
