package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.SeekBar;

import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;

public class pr extends wk {
    private final sh a;
    private final SeekBar b;
    private final View c;
    private final View d;

    public pr(y yVar) {
        super(yVar);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(g.reading__reading_brightness_view, null);
        viewGroup.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.b(getContext(), 400.0f) : -1, -2));
        setContentView((View) viewGroup);
        this.a = (sh) getContext().queryFeature(sh.class);
        this.b = (SeekBar) findViewById(f.reading__reading_brightness_view__seek_brightness);
        this.c = findViewById(f.reading__reading_brightness_view__night_mode);
        this.d = findViewById(f.reading__reading_brightness_view__eyes_saving);
        a();
        this.b.setOnSeekBarChangeListener(new ps(this));
        findViewById(f.reading__reading_brightness_view__auto_brightness).setOnClickListener(new pt(this));
        this.c.setOnClickListener(new pu(this));
        this.d.setOnClickListener(new pv(this));
    }

    private final void a() {
        findViewById(f.reading__reading_brightness_view__auto_brightness).setSelected(this.a.E() == BrightnessMode.SYSTEM);
        if (this.a.E() == BrightnessMode.MANUAL) {
            this.b.setProgressDrawable(getDrawable(e.reading__reading_options_view__seek_brightness_normal));
        } else {
            this.b.setProgressDrawable(getDrawable(e.reading__reading_options_view__seek_brightness_disabled));
        }
        this.c.setSelected(this.a.aH());
        this.d.setSelected(this.a.aK());
        float[] D = this.a.D();
        this.b.setProgress(Math.round(((this.a.F() - D[0]) / (D[1] - D[0])) * 1000.0f));
    }
}
