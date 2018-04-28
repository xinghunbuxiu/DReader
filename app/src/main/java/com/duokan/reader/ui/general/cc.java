package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class cc {
    /* renamed from: a */
    private final View f7022a;

    public cc(Context context) {
        this.f7022a = LayoutInflater.from(context).inflate(C0245g.general__empty_view, null);
    }

    /* renamed from: a */
    public View m10333a() {
        return this.f7022a;
    }

    /* renamed from: a */
    public void m10334a(int i) {
        ((ImageView) this.f7022a.findViewById(C0244f.general__emtpy_view__image)).setImageResource(i);
    }

    /* renamed from: b */
    public void m10335b(int i) {
        TextView textView = (TextView) this.f7022a.findViewById(C0244f.general__emtpy_view__line_1);
        textView.setText(i);
        if (i == 0) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: c */
    public void m10336c(int i) {
        TextView textView = (TextView) this.f7022a.findViewById(C0244f.general__emtpy_view__line_2);
        textView.setText(i);
        if (i == 0) {
            textView.setVisibility(8);
        }
    }
}
