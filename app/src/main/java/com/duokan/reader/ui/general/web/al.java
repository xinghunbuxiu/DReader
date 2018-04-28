package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.util.List;
import org.json.JSONArray;

public class al extends ci {
    /* renamed from: a */
    final /* synthetic */ SearchController f7582a;

    protected al(SearchController searchController) {
        this.f7582a = searchController;
        super(searchController);
    }

    @JavascriptInterface
    public void setHotWords(String str) {
        m11020b(new am(this, str));
    }

    @JavascriptInterface
    public void editSearchHistory(String str) {
        m11020b(new ao(this, str));
    }

    /* renamed from: a */
    private void m11022a(List<String> list, JSONArray jSONArray) {
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
        m11020b(new aq(this, str));
    }
}
