package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import org.json.JSONArray;

import java.util.List;

public class aj extends cg {
    final /* synthetic */ SearchController a;

    protected aj(SearchController searchController) {
        this.a = searchController;
        super(searchController);
    }

    @JavascriptInterface
    public void setHotWords(String str) {
        b(new ak(this, str));
    }

    @JavascriptInterface
    public void editSearchHistory(String str) {
        b(new am(this, str));
    }

    private void a(List list, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                CharSequence optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    list.add(optString);
                }
            }
        }
    }

    @JavascriptInterface
    public void getSearchHistory(String str) {
        b(new ao(this, str));
    }
}
