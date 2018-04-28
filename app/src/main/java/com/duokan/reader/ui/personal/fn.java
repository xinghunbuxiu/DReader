package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.general.ap;

class fn extends ap {
    /* renamed from: a */
    final /* synthetic */ eu f8547a;
    /* renamed from: b */
    private final ProgressBar f8548b = ((ProgressBar) findViewById(C0255g.reading__tts_progress_view__progress_bar));
    /* renamed from: c */
    private final TextView f8549c = ((TextView) findViewById(C0255g.reading__tts_progress_view__progress));

    public fn(eu euVar, Context context) {
        this.f8547a = euVar;
        super(context);
        ViewGroup viewGroup = (ViewGroup) getContentView();
        viewGroup.removeAllViews();
        setCancelOnBack(false);
        setCancelOnTouchOutside(false);
        viewGroup.addView(LayoutInflater.from(getContext()).inflate(C0256h.reading__tts_progress_view, null));
    }

    /* renamed from: a */
    private void m11792a(int i) {
        if (this.f8548b != null) {
            this.f8548b.setProgress(i);
            this.f8549c.setText(i + "%");
        }
    }
}
