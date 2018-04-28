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

public class wt extends wx {
    /* renamed from: a */
    private final su f11124a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final ViewGroup f11125b = ((ViewGroup) LayoutInflater.from(getContext()).inflate(C0245g.reading__reading_options_view_slide_show, null));
    /* renamed from: c */
    private final View f11126c;
    /* renamed from: d */
    private final SeekBar f11127d;

    public wt(IFeature mFeature) {
        super(mFeature);
        this.f11125b.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.m1932b(getContext(), 400.0f) : -1, -2));
        setContentView(this.f11125b);
        this.f11127d = (SeekBar) findViewById(C0244f.reading__reading_options_view__seek_brightness);
        if (ReaderEnv.get().forHd()) {
            this.f11127d.setProgressDrawable(getDrawable(C0243e.general__shared__seek_bar_dark));
        }
        this.f11126c = findViewById(C0244f.reading__reading_options_view__slide_show_anim);
        this.f11126c.setOnClickListener(new wu(this));
        this.f11127d.setOnSeekBarChangeListener(new wv(this));
        findViewById(C0244f.reading__reading_options_view__auto_brightness).setOnClickListener(new ww(this));
        m15061a();
    }

    /* renamed from: a */
    private final void m15061a() {
        this.f11126c.setSelected(this.f11124a.mo2005V() == SlideShowEffect.SIMPLE);
        if (this.f11124a.mo1990E() == BrightnessMode.MANUAL) {
            this.f11127d.setProgressDrawable(getDrawable(C0243e.reading__reading_options_view__seek_brightness_normal));
        } else {
            this.f11127d.setProgressDrawable(getDrawable(C0243e.reading__reading_options_view__seek_brightness_disabled));
        }
        float[] D = this.f11124a.mo1989D();
        this.f11127d.setProgress(Math.round(((this.f11124a.mo1991F() - D[0]) / (D[1] - D[0])) * 1000.0f));
    }
}
