package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.m;

public class au extends m {
    public String q = null;
    public boolean r = false;

    public au(au auVar) {
        super(auVar);
        this.q = auVar.q;
        this.r = auVar.r;
    }

    public m a() {
        return new au(this);
    }
}
