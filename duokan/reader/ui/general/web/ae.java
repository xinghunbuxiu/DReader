package com.duokan.reader.ui.general.web;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class ae implements TextWatcher {
    final /* synthetic */ SearchController a;

    ae(SearchController searchController) {
        this.a = searchController;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Object obj = editable.toString();
        this.a.mLocalSearchLoadTime = 0;
        this.a.mClearView.setVisibility(TextUtils.isEmpty(obj) ? 4 : 0);
        if (!this.a.mSearchOnTextChange) {
            this.a.mSearchOnTextChange = true;
        } else if (TextUtils.equals(this.a.mHitWord, obj)) {
            this.a.search(obj, "hint");
        } else {
            this.a.mHitWord = null;
            if (TextUtils.isEmpty(obj)) {
                this.a.mSearchHint.clear();
                this.a.mLocalSearchResultView.setVisibility(8);
                this.a.mSearchHintView.getAdapter().d();
                this.a.mSearchHintView.scrollTo(0, 0);
                this.a.updateAllViews();
                return;
            }
            a(obj, new af(this));
        }
    }

    private void a(String str, Runnable runnable) {
        this.a.refreshView();
        this.a.querySearchHint(str, new ag(this, str, runnable));
    }
}
