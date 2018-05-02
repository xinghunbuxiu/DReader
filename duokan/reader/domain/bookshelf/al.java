package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.WebSession;

public abstract class al extends WebSession {
    private static final String a = al.class.getName();

    public al() {
        super(a);
    }

    public void open() {
        open(CacheStrategy.DO_NOT_USE_CACHE);
    }

    public void open(long j) {
        open(CacheStrategy.DO_NOT_USE_CACHE, j);
    }
}
