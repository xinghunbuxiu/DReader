package com.duokan.reader.ui.reading;

import android.media.AudioManager;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.tts.SpeakingListener;
import com.duokan.reader.domain.tts.TtsEngineIflytek;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;
import java.util.ArrayList;
import java.util.List;

class aee implements SpeakingListener {
    /* renamed from: a */
    final /* synthetic */ afc f9571a;
    /* renamed from: b */
    final /* synthetic */ afa f9572b;
    /* renamed from: c */
    final /* synthetic */ ag f9573c;
    /* renamed from: d */
    final /* synthetic */ adz f9574d;
    /* renamed from: e */
    private boolean f9575e = false;

    aee(adz adz, afc afc, afa afa, ag agVar) {
        this.f9574d = adz;
        this.f9571a = afc;
        this.f9572b = afa;
        this.f9573c = agVar;
    }

    public void onSpeakingStart(String str) {
        UThread.postDelayed(new aef(this), 60000);
        this.f9574d.f9541a.setActiveColorText(this.f9571a.f9622b);
        if (!this.f9574d.f9541a.bi()) {
            if (this.f9574d.f9541a.mo2004U() == PageAnimationMode.VSCROLL || this.f9571a.f9623c <= 0) {
                this.f9574d.f9541a.mo2131d(this.f9571a.f9622b);
            }
        }
    }

    public void onSpeakingPaused(String str) {
        this.f9575e = true;
        if (!this.f9574d.m13449e()) {
            return;
        }
        if (!((AudioManager) this.f9574d.getContext().getSystemService("audio")).isMusicActive()) {
            this.f9574d.f9548h.resumeSpeaking();
        } else if (this.f9574d.f9549i != null && !this.f9574d.f9549i.f9616e) {
            this.f9574d.f9549i.f9616e = true;
            if (this.f9574d.f9550j != null) {
                this.f9574d.f9550j.m13490d();
            }
            if (this.f9574d.f9556p != null) {
                this.f9574d.f9556p.m13497b();
            }
        }
    }

    public void onSpeakingResumed(String str) {
        this.f9574d.m13436i();
    }

    public void onSpeakingProgress(String str, int i, int i2, int i3) {
        if (!this.f9574d.f9541a.bi() && this.f9574d.f9541a.mo2004U() != PageAnimationMode.VSCROLL && this.f9571a.f9623c > 0 && Math.round(((float) this.f9571a.f9621a.length()) * (((float) i) / 100.0f)) > this.f9571a.f9623c) {
            this.f9574d.f9541a.mo2131d(this.f9571a.f9622b);
        }
        this.f9574d.m13407a(this.f9572b, this.f9571a.f9621a.length() - Math.round(((float) this.f9571a.f9621a.length()) * (((float) i) / 100.0f)));
    }

    public void onSpeakingEnd(String str) {
        this.f9575e = true;
        this.f9574d.f9541a.setActiveColorText(null);
        this.f9572b.f9613b.clear();
        this.f9574d.m13425b(this.f9572b, this.f9573c);
    }

    public void onSpeakingCancel(String str) {
        this.f9575e = true;
        this.f9574d.f9541a.setActiveColorText(null);
        ((AudioManager) DkApp.get().getSystemService("audio")).abandonAudioFocus(null);
    }

    public void onSpeakingError(int i, String str) {
        this.f9575e = true;
        this.f9574d.f9541a.setActiveColorText(null);
        C0328a.m757c().m752c(LogLevel.ERROR, "tts", String.format("errorCode: %d, errorDesc: %s", new Object[]{Integer.valueOf(i), str}));
        UmengManager.get().onEvent("TTS_SPEAKING_ERROR_V2", String.format("%d, %s", new Object[]{Integer.valueOf(i), str}));
        ((AudioManager) DkApp.get().getSystemService("audio")).abandonAudioFocus(null);
        ap apVar;
        if (i == TtsEngineIflytek.ERROR_AUTH_EXPIRED) {
            this.f9574d.m13446b();
            apVar = new ap(this.f9574d.getContext());
            apVar.setPrompt(C0258j.reading__tts_view__expire);
            apVar.setOkLabelResid(C0258j.reading__tts_view__expire_ok);
            apVar.setNoLabel(C0258j.reading__tts_view__expire_no);
            apVar.open(new aeg(this));
        } else if (this.f9574d.m13426b(i)) {
            this.f9574d.m13446b();
            apVar = new ap(this.f9574d.getContext());
            apVar.setPrompt(C0258j.reading__tts_view__no_network);
            apVar.setOkLabelResid(C0258j.reading__tts_view__change_speaker);
            apVar.setNoLabel(C0258j.reading__tts_view__cancel);
            apVar.open(new aeh(this));
        } else if (i == TtsEngineIflytek.ERROR_LOCAL_ENGINE_ERROR) {
            List arrayList = new ArrayList();
            arrayList.add(this.f9574d.f9547g.getCurrentSpeaker());
            this.f9574d.f9547g.removeSpeakers(arrayList);
            this.f9574d.m13446b();
            apVar = new ap(this.f9574d.getContext());
            apVar.setPrompt(C0258j.reading__tts_view__local_file_missed);
            apVar.setOkLabelResid(C0258j.reading__tts_view__go_download);
            apVar.setNoLabel(C0258j.reading__tts_view__expire_no);
            apVar.open(new aei(this));
        } else {
            be.m10287a(this.f9574d.getContext(), String.format(this.f9574d.getString(C0258j.reading__tts_view__engine_error), new Object[]{Integer.valueOf(i)}), 0).show();
            this.f9574d.m13446b();
        }
    }
}
