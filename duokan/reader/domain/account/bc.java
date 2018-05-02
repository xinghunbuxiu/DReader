package com.duokan.reader.domain.account;

import com.duokan.reader.common.webservices.WebSession;

abstract class bc extends WebSession {
    private static final String a = bc.class.getName();

    public bc() {
        super(a);
    }

    public void open() {
        open(CacheStrategy.DISABLE_CACHE);
    }

    public void open(long j) {
        open(CacheStrategy.DISABLE_CACHE, j);
    }
}
