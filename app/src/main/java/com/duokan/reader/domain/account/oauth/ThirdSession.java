package com.duokan.reader.domain.account.oauth;

import com.duokan.reader.common.webservices.WebSession;

public abstract class ThirdSession extends WebSession {
    private static final String PRIVATE_SEQ_QUEUE = ThirdSession.class.getName();

    public ThirdSession() {
        super(PRIVATE_SEQ_QUEUE);
    }
}
