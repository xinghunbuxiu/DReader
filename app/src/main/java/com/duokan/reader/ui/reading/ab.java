package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.domain.audio.AudioPlayer;

public class ab extends e {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final View b = LayoutInflater.from(getContext()).inflate(g.reading__audio_settings_view, null);
    private final com.duokan.reader.domain.audio.e c;
    private Runnable d = null;

    public ab(y yVar) {
        super(yVar);
        setContentView(this.b);
        this.b.setOnClickListener(new ac(this));
        findViewById(f.reading__audio_settings_view__pause).setOnClickListener(new ad(this));
        boolean aT = this.a.aT();
        findViewById(f.reading__audio_settings_view__rollback).setOnClickListener(new ae(this));
        View findViewById = findViewById(f.reading__audio_settings_view__synchronous);
        findViewById.setOnClickListener(new ag(this));
        findViewById.setSelected(aT);
        this.c = new ah(this);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.a.aU();
        AudioPlayer.a().a(this.c);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        AudioPlayer.a().b(this.c);
        this.a.aV();
        if (this.d != null) {
            this.d.run();
            this.d = null;
        }
    }

    private void a(Runnable runnable) {
        this.d = runnable;
        requestHideMenu();
    }
}
