package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookContent;

public class ul extends wx {
    /* renamed from: a */
    private final su f11013a;
    /* renamed from: b */
    private final TextView f11014b;
    /* renamed from: c */
    private final View f11015c;

    public ul(IFeature mFeature) {
        super(mFeature);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(C0245g.reading__reading_mode_view, null);
        viewGroup.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? AnimUtils.m1932b(getContext(), 400.0f) : -1, -2));
        setContentView((View) viewGroup);
        this.f11013a = (su) getContext().queryFeature(su.class);
        this.f11014b = (TextView) findViewById(C0244f.reading__reading_mode_view__tts);
        this.f11015c = findViewById(C0244f.reading__reading_mode_view__auto_pagedown);
        this.f11014b.setOnClickListener(new um(this));
        this.f11015c.setOnClickListener(new uo(this));
    }

    protected void onAttachToStub() {
        int i = 8;
        this.f11014b.setVisibility(this.f11013a.mo2181w().mo2291c() > 0 ? 8 : 0);
        if (this.f11013a.mo1992G().m4246r() == BookContent.AUDIO_TEXT) {
            boolean z;
            this.f11014b.setText(C0247i.reading__reading_mode_view__audio);
            TextView textView = this.f11014b;
            if ((this.f11013a.aT() || this.f11013a.mo2161k() == null) && !this.f11013a.mo2160j()) {
                z = false;
            } else {
                z = true;
            }
            textView.setEnabled(z);
        }
        View view = this.f11015c;
        if (!this.f11013a.al()) {
            i = 0;
        }
        view.setVisibility(i);
    }
}
