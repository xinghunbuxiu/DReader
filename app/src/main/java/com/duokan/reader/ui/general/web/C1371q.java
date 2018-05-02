package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.UmengManager;

/* renamed from: com.duokan.reader.ui.general.web.q */
class C1371q implements an {
    /* renamed from: a */
    final /* synthetic */ SearchController f8171a;

    C1371q(SearchController searchController) {
        this.f8171a = searchController;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        this.f8171a.mHitWord = (String) this.f8171a.mSearchHintView.getAdapter().mo509d(i);
        this.f8171a.mEditText.setText(this.f8171a.mHitWord);
        this.f8171a.mEditText.setSelection(this.f8171a.mHitWord.length());
        String str = "";
        if (this.f8171a.hasHint()) {
            str = "hint";
        } else if (i < this.f8171a.mHistory.size()) {
            str = "history";
        } else if (i < this.f8171a.mHotWord.size() + this.f8171a.mHistory.size()) {
            str = "hot";
        }
        if (!TextUtils.isEmpty(str)) {
            UmengManager.get().onEvent("SEARCH_FROM_V1", str);
        }
    }
}
