package com.duokan.reader.ui.reading;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.List;

class afu implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f9652a;
    /* renamed from: b */
    final /* synthetic */ afn f9653b;

    afu(afn afn, Runnable runnable) {
        this.f9653b = afn;
        this.f9652a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        C0342j a = ja.m10832a(this.f9653b.getContext(), "", this.f9653b.getResources().getString(C0258j.reading__tts_setting_view__deleting), true, true);
        List j = this.f9653b.getAdapter().m9788j();
        Object arrayList = new ArrayList();
        for (Object next : j) {
            if (next instanceof TtsSpeaker) {
                arrayList.add((TtsSpeaker) next);
            }
        }
        if (TtsManager.get().removeSpeakers(arrayList)) {
            this.f9653b.f9641a.f9640c.removeAll(arrayList);
            this.f9653b.f9641a.f9639b.removeAll(arrayList);
            this.f9653b.mo1901a(false);
            be.m10287a(this.f9653b.getContext(), String.format(this.f9653b.getResources().getString(C0258j.reading__tts_setting_view__succeed), new Object[]{Integer.valueOf(arrayList.size())}), 0).show();
        } else {
            be.m10287a(this.f9653b.getContext(), this.f9653b.getResources().getString(C0258j.reading__tts_setting_view__fail), 0).show();
        }
        a.dismiss();
        if (this.f9652a != null) {
            this.f9652a.run();
        }
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
