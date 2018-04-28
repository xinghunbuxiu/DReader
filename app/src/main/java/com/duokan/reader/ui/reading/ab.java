package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.C0774e;

public class ab extends ActivatedController {
    /* renamed from: a */
    private final su f9370a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final View f9371b = LayoutInflater.from(getContext()).inflate(C0245g.reading__audio_settings_view, null);
    /* renamed from: c */
    private final C0774e f9372c;
    /* renamed from: d */
    private Runnable f9373d = null;

    public ab(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f9371b);
        this.f9371b.setOnClickListener(new ac(this));
        findViewById(C0244f.reading__audio_settings_view__pause).setOnClickListener(new ad(this));
        boolean aT = this.f9370a.aT();
        findViewById(C0244f.reading__audio_settings_view__rollback).setOnClickListener(new ae(this));
        View findViewById = findViewById(C0244f.reading__audio_settings_view__synchronous);
        findViewById.setOnClickListener(new ag(this));
        findViewById.setSelected(aT);
        this.f9372c = new ah(this);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f9370a.aU();
        AudioPlayer.m3613a().m3637a(this.f9372c);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        AudioPlayer.m3613a().m3640b(this.f9372c);
        this.f9370a.aV();
        if (this.f9373d != null) {
            this.f9373d.run();
            this.f9373d = null;
        }
    }

    /* renamed from: a */
    private void m13198a(Runnable runnable) {
        this.f9373d = runnable;
        requestHideMenu();
    }
}
