package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.p044b.C0793n;

class rf implements C0793n {
    /* renamed from: a */
    final /* synthetic */ qr f10889a;

    rf(qr qrVar) {
        this.f10889a = qrVar;
    }

    /* renamed from: a */
    public void mo2475a() {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "reading_prompt_font", true);
        ReaderEnv.get().commitPrefs();
    }

    /* renamed from: b */
    public void mo2476b() {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "reading_prompt_font", true);
        ReaderEnv.get().commitPrefs();
    }
}
