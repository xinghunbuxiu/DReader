package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.common.webservices.OpenWebSession;

public abstract class r extends OpenWebSession {
    private static final String PRIVATE_SEQ_QUEUE = r.class.getName();

    public r() {
        super(PRIVATE_SEQ_QUEUE);
    }
}
