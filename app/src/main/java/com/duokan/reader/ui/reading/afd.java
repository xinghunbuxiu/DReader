package com.duokan.reader.ui.reading;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import org.apache.http.HttpStatus;

@SuppressLint({"InflateParams"})
public class afd extends ActivatedController {
    /* renamed from: a */
    private final su f9624a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final View f9625b = LayoutInflater.from(getContext()).inflate(C0245g.reading__tts_menu_view, null);
    /* renamed from: c */
    private final TextView f9626c;
    /* renamed from: d */
    private final SeekBar f9627d;
    /* renamed from: e */
    private final SeekBar f9628e;

    public afd(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f9625b);
        this.f9625b.setOnClickListener(new afe(this));
        this.f9626c = (TextView) findViewById(C0244f.reading__tts_menu_view__default);
        this.f9626c.setOnClickListener(new aff(this));
        ((TextView) findViewById(C0244f.reading__tts_menu_view__other)).setOnClickListener(new afg(this));
        findViewById(C0244f.reading__tts_menu_view__stop).setOnClickListener(new afh(this));
        this.f9627d = (SeekBar) findViewById(C0244f.reading__tts_menu_view__speed_bar);
        this.f9627d.setOnSeekBarChangeListener(new afj(this));
        this.f9628e = (SeekBar) findViewById(C0244f.reading__tts_menu_view__timer_bar);
        this.f9628e.setOnSeekBarChangeListener(new afk(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m13493a();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f9624a.ba();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f9624a.aZ();
    }

    /* renamed from: a */
    private void m13493a() {
        float bc = this.f9624a.bc();
        TtsSpeaker currentSpeaker = TtsManager.get().getCurrentSpeaker();
        if (TextUtils.isEmpty(currentSpeaker.mNickname)) {
            this.f9626c.setText(getString(C0247i.reading__tts_menu_view__default));
        } else {
            this.f9626c.setText(currentSpeaker.mNickname);
        }
        if (Float.compare(bc, 0.65f) <= 0) {
            this.f9627d.setProgress(0);
        } else if (Float.compare(bc, 0.9f) <= 0) {
            this.f9627d.setProgress(100);
        } else if (Float.compare(bc, 1.15f) <= 0) {
            this.f9627d.setProgress(HttpStatus.SC_OK);
        } else if (Float.compare(bc, 1.4f) <= 0) {
            this.f9627d.setProgress(HttpStatus.SC_MULTIPLE_CHOICES);
        } else {
            this.f9627d.setProgress(HttpStatus.SC_BAD_REQUEST);
        }
        int bd = this.f9624a.bd();
        if (bd < Integer.MAX_VALUE) {
            this.f9628e.setProgress(Math.round((((float) bd) / 3600000.0f) * 400.0f));
        } else {
            this.f9628e.setProgress(0);
        }
    }
}
