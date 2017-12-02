package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookContent;

public class ty extends wk {
    private final sh a;
    private final TextView b;
    private final View c;

    public ty(y yVar) {
        super(yVar);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(g.reading__reading_mode_view, null);
        viewGroup.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.b(getContext(), 400.0f) : -1, -2));
        setContentView((View) viewGroup);
        this.a = (sh) getContext().queryFeature(sh.class);
        this.b = (TextView) findViewById(f.reading__reading_mode_view__tts);
        this.c = findViewById(f.reading__reading_mode_view__auto_pagedown);
        this.b.setOnClickListener(new tz(this));
        this.c.setOnClickListener(new ub(this));
    }

    protected void onAttachToStub() {
        int i = 8;
        this.b.setVisibility(this.a.w().c() > 0 ? 8 : 0);
        if (this.a.G().r() == BookContent.AUDIO_TEXT) {
            boolean z;
            this.b.setText(i.reading__reading_mode_view__audio);
            TextView textView = this.b;
            if ((this.a.aT() || this.a.k() == null) && !this.a.j()) {
                z = false;
            } else {
                z = true;
            }
            textView.setEnabled(z);
        }
        View view = this.c;
        if (!this.a.al()) {
            i = 0;
        }
        view.setVisibility(i);
    }
}
