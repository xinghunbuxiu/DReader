package com.duokan.reader.ui.general;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;


public class CustomGlideUrl {
    
    private final String id;
    
    private final String safeUrl;

    public CustomGlideUrl(C0800c c0800c, String str) {
        this.id = c0800c == null ? "" : c0800c.getId();
        this.safeUrl = str;
    }

    
    public String getId() {
        if (TextUtils.isEmpty(this.id)) {
            return this.safeUrl;
        }
        return this.id;
    }

    
    public String getSafeUrl() {
        return this.safeUrl;
    }
}
