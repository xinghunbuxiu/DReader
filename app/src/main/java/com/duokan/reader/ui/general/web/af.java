package com.duokan.reader.ui.general.web;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import com.duokan.reader.common.C0616o;

class af implements TextWatcher {
    /* renamed from: a */
    final /* synthetic */ SearchController f7572a;

    af(SearchController searchController) {
        this.f7572a = searchController;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Object obj = editable.toString();
        this.f7572a.mLocalSearchLoadTime = 0;
        this.f7572a.mClearView.setVisibility(TextUtils.isEmpty(obj) ? 8 : 0);
        if (C0616o.m2804a().m2814d()) {
            int i;
            View access$600 = this.f7572a.mXiaoAiInputView;
            if (TextUtils.isEmpty(obj)) {
                i = 0;
            } else {
                i = 8;
            }
            access$600.setVisibility(i);
        }
        if (!this.f7572a.mSearchOnTextChange) {
            this.f7572a.mSearchOnTextChange = true;
        } else if (TextUtils.equals(this.f7572a.mHitWord, obj)) {
            this.f7572a.search(obj, "hint");
        } else {
            this.f7572a.mHitWord = null;
            if (TextUtils.isEmpty(obj)) {
                this.f7572a.mSearchHint.clear();
                this.f7572a.mLocalSearchResultView.setVisibility(8);
                this.f7572a.mSearchHintView.getAdapter().mo1691d();
                this.f7572a.mSearchHintView.scrollTo(0, 0);
                this.f7572a.updateAllViews();
                return;
            }
            m11003a(obj, new ag(this));
        }
    }

    /* renamed from: a */
    private void m11003a(String str, Runnable runnable) {
        this.f7572a.refreshView();
        this.f7572a.querySearchHint(str, new ah(this, str, runnable));
    }
}
