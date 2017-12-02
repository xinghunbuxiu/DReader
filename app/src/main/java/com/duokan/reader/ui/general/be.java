package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.ui.BoxView;

public class be extends Toast {
    private final Context a;
    private final TextView b;

    public be(Context context, int i) {
        super(context);
        this.a = context;
        BoxView boxView = (BoxView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(g.general__dktoast_view, null);
        this.b = (TextView) boxView.findViewById(f.general__dktoast_view__textview);
        setView(boxView);
        int c = i.c(context);
        setGravity(17, 0, i == 0 ? (c / 2) - (c / 3) : c / 3);
    }

    public be(Context context) {
        this(context, 0);
    }

    public void setText(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void setText(int i) {
        setText(this.a.getString(i));
    }

    public static Toast a(Context context, CharSequence charSequence, int i) {
        Toast beVar = new be(context);
        beVar.setText(charSequence);
        beVar.setDuration(i);
        return beVar;
    }

    public static Toast a(Context context, int i, int i2) {
        return a(context, context.getString(i), i2);
    }
}
