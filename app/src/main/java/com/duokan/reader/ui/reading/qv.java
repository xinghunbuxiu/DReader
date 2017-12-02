package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.b.n;

class qv implements n {
    final /* synthetic */ qh a;

    qv(qh qhVar) {
        this.a = qhVar;
    }

    public void a() {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "reading_prompt_font", true);
        ReaderEnv.get().commitPrefs();
    }

    public void b() {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "reading_prompt_font", true);
        ReaderEnv.get().commitPrefs();
    }
}
