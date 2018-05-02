package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;

class aft implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TtsSpeaker f9650a;
    /* renamed from: b */
    final /* synthetic */ afq f9651b;

    aft(afq afq, TtsSpeaker ttsSpeaker) {
        this.f9651b = afq;
        this.f9650a = ttsSpeaker;
    }

    public void onClick(View view) {
        TtsManager.get().setCurrentSpeaker(this.f9650a);
        this.f9651b.mo1691d();
    }
}
