package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;

abstract class hf extends WebSession {
    final /* synthetic */ PersonalPrefs f;

    public hf(PersonalPrefs personalPrefs) {
        this.f = personalPrefs;
        super(hf.class.getName());
    }
}
