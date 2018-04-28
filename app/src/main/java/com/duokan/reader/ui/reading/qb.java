package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.SeekBar;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderEnv;

public class qb extends wx {
    /* renamed from: a */
    private final su f10845a;
    /* renamed from: b */
    private final SeekBar f10846b;
    /* renamed from: c */
    private final View f10847c;
    /* renamed from: d */
    private final View f10848d;

    public qb(IFeature mFeature) {
        super(mFeature);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(C0245g.reading__reading_brightness_view, null);
        viewGroup.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.m1932b(getContext(), 400.0f) : -1, -2));
        setContentView((View) viewGroup);
        this.f10845a = (su) getContext().queryFeature(su.class);
        this.f10846b = (SeekBar) findViewById(C0244f.reading__reading_brightness_view__seek_brightness);
        this.f10847c = findViewById(C0244f.reading__reading_brightness_view__night_mode);
        this.f10848d = findViewById(C0244f.reading__reading_brightness_view__eyes_saving);
        m14924a();
        this.f10846b.setOnSeekBarChangeListener(new qc(this));
        findViewById(C0244f.reading__reading_brightness_view__auto_brightness).setOnClickListener(new qd(this));
        this.f10847c.setOnClickListener(new qe(this));
        this.f10848d.setOnClickListener(new qf(this));
    }

    /* renamed from: a */
    private final void m14924a() {
        findViewById(C0244f.reading__reading_brightness_view__auto_brightness).setSelected(this.f10845a.mo1990E() == BrightnessMode.SYSTEM);
        if (this.f10845a.mo1990E() == BrightnessMode.MANUAL) {
            this.f10846b.setProgressDrawable(getDrawable(C0243e.reading__reading_options_view__seek_brightness_normal));
        } else {
            this.f10846b.setProgressDrawable(getDrawable(C0243e.reading__reading_options_view__seek_brightness_disabled));
        }
        this.f10847c.setSelected(this.f10845a.aH());
        this.f10848d.setSelected(this.f10845a.aK());
        float[] D = this.f10845a.mo1989D();
        this.f10846b.setProgress(Math.round(((this.f10845a.mo1991F() - D[0]) / (D[1] - D[0])) * 1000.0f));
    }
}
