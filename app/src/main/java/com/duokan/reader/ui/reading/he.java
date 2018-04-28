package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.bookshelf.in;

public class he extends FrameLayout implements in {
    /* renamed from: a */
    private final fp f10313a = ((fp) ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).mo1992G());
    /* renamed from: b */
    private final View f10314b = LayoutInflater.from(getContext()).inflate(C0256h.reading__download_full_book_view, this, false);
    /* renamed from: c */
    private final TextView f10315c = ((TextView) this.f10314b.findViewById(C0255g.reading__download_full_book_view__name));
    /* renamed from: d */
    private final TextView f10316d = ((TextView) this.f10314b.findViewById(C0255g.reading__download_full_book_view__download));

    public he(Context context) {
        super(context);
        this.f10315c.setText(this.f10313a.ay());
        addView(this.f10314b, new LayoutParams(-1, -1));
        this.f10316d.setOnClickListener(new hf(this));
    }

    /* renamed from: a */
    public void m14309a(int i) {
        this.f10315c.setTextColor(i);
        m14308a();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ai.m3980a().m3887a((in) this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai.m3980a().m3910b((in) this);
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        if (this.f10313a == c0800c) {
            m14308a();
        }
    }

    /* renamed from: a */
    private void m14308a() {
        if (this.f10313a.m4170W()) {
            this.f10316d.setText(String.format(getResources().getString(C0258j.reading__shared__downloading), new Object[]{Float.valueOf(this.f10313a.m4240m())}));
            return;
        }
        this.f10316d.setText(getResources().getString(C0258j.reading__shared__download_full_book));
    }
}
