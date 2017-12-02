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

public class wg extends wk {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final ViewGroup b = ((ViewGroup) LayoutInflater.from(getContext()).inflate(g.reading__reading_options_view_slide_show, null));
    private final View c;
    private final SeekBar d;

    public wg(y yVar) {
        super(yVar);
        this.b.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.b(getContext(), 400.0f) : -1, -2));
        setContentView(this.b);
        this.d = (SeekBar) findViewById(f.reading__reading_options_view__seek_brightness);
        if (ReaderEnv.get().forHd()) {
            this.d.setProgressDrawable(getDrawable(e.general__shared__seek_bar_dark));
        }
        this.c = findViewById(f.reading__reading_options_view__slide_show_anim);
        this.c.setOnClickListener(new wh(this));
        this.d.setOnSeekBarChangeListener(new wi(this));
        findViewById(f.reading__reading_options_view__auto_brightness).setOnClickListener(new wj(this));
        a();
    }

    private final void a() {
        this.c.setSelected(this.a.V() == SlideShowEffect.SIMPLE);
        if (this.a.E() == BrightnessMode.MANUAL) {
            this.d.setProgressDrawable(getDrawable(e.reading__reading_options_view__seek_brightness_normal));
        } else {
            this.d.setProgressDrawable(getDrawable(e.reading__reading_options_view__seek_brightness_disabled));
        }
        float[] D = this.a.D();
        this.d.setProgress(Math.round(((this.a.F() - D[0]) / (D[1] - D[0])) * 1000.0f));
    }
}
