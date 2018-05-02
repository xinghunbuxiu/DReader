package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ah implements OnEditorActionListener {
    final /* synthetic */ SearchController a;

    ah(SearchController searchController) {
        this.a = searchController;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        Object obj = this.a.mEditText.getText().toString();
        this.a.search(obj, TextUtils.equals(obj, this.a.mDefaultSearchWord) ? "default" : "user");
        return true;
    }
}
