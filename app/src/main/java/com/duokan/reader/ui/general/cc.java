package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.b.f;
import com.duokan.b.g;

public class cc {
    private final View a;

    public cc(Context context) {
        this.a = LayoutInflater.from(context).inflate(g.general__empty_view, null);
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        ((ImageView) this.a.findViewById(f.general__emtpy_view__image)).setImageResource(i);
    }

    public void b(int i) {
        TextView textView = (TextView) this.a.findViewById(f.general__emtpy_view__line_1);
        textView.setText(i);
        if (i == 0) {
            textView.setVisibility(8);
        }
    }

    public void c(int i) {
        TextView textView = (TextView) this.a.findViewById(f.general__emtpy_view__line_2);
        textView.setText(i);
        if (i == 0) {
            textView.setVisibility(8);
        }
    }
}
