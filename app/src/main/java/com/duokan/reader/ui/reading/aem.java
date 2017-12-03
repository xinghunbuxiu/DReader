package com.duokan.reader.ui.reading;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;

import com.duokan.b.g;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

import org.apache.http.HttpStatus;

@SuppressLint({"InflateParams"})
public class aem extends ActivatedController {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final View b = LayoutInflater.from(getContext()).inflate(g.reading__tts_menu_view, null);
    private final View c;
    private final View d;
    private final SeekBar e;
    private final SeekBar f;

    public aem(IFeature featrue) {
        super(featrue);
        setContentView(this.b);
        this.b.setOnClickListener(new aen(this));
        this.c = findViewById(f.reading__tts_menu_view__default);
        this.c.setOnClickListener(new aeo(this));
        this.d = findViewById(f.reading__tts_menu_view__other);
        this.d.setOnClickListener(new aep(this));
        findViewById(f.reading__tts_menu_view__stop).setOnClickListener(new aer(this));
        this.e = (SeekBar) findViewById(f.reading__tts_menu_view__speed_bar);
        this.e.setOnSeekBarChangeListener(new aes(this));
        this.f = (SeekBar) findViewById(f.reading__tts_menu_view__timer_bar);
        this.f.setOnSeekBarChangeListener(new aet(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.a.ba();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.a.aZ();
    }

    private void a() {
        float bc = this.a.bc();
        String be = this.a.be();
        this.c.setSelected(be.equals("xiaoyan"));
        this.d.setSelected(be.equals(""));
        if (Float.compare(bc, 0.75f) <= 0) {
            this.e.setProgress(0);
        } else if (Float.compare(bc, 1.0f) <= 0) {
            this.e.setProgress(100);
        } else if (Float.compare(bc, 1.25f) <= 0) {
            this.e.setProgress(HttpStatus.SC_OK);
        } else if (Float.compare(bc, 1.5f) <= 0) {
            this.e.setProgress(HttpStatus.SC_MULTIPLE_CHOICES);
        } else {
            this.e.setProgress(HttpStatus.SC_BAD_REQUEST);
        }
        int bd = this.a.bd();
        if (bd < Integer.MAX_VALUE) {
            this.f.setProgress(Math.round((((float) bd) / 3600000.0f) * 400.0f));
        } else {
            this.f.setProgress(0);
        }
    }
}
