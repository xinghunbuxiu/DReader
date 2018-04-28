package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ai implements OnEditorActionListener {
    /* renamed from: a */
    final /* synthetic */ SearchController f7577a;

    ai(SearchController searchController) {
        this.f7577a = searchController;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        Object obj = this.f7577a.mEditText.getText().toString();
        this.f7577a.search(obj, TextUtils.equals(obj, this.f7577a.mDefaultSearchWord) ? "default" : "user");
        return true;
    }
}
