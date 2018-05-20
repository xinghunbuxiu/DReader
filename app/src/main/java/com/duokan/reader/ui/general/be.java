package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;
import com.duokan.common.CommonUtils;
import com.duokan.core.ui.BoxView;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class be extends Toast {
    /* renamed from: a */
    private final Context f6994a;
    /* renamed from: b */
    private final TextView f6995b;

    public be(Context context, int i) {
        super(context);
        this.f6994a = context;
        BoxView boxView = (BoxView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0245g.general__dktoast_view, null);
        this.f6995b = (TextView) boxView.findViewById(C0244f.general__dktoast_view__textview);
        setView(boxView);
        int c = CommonUtils.m609c(context);
        setGravity(17, 0, i == 0 ? (c / 2) - (c / 3) : c / 3);
    }

    public be(Context context) {
        this(context, 0);
    }

    public void setText(CharSequence charSequence) {
        this.f6995b.setText(charSequence);
    }

    public void setText(int i) {
        setText(this.f6994a.getString(i));
    }

    /* renamed from: a */
    public static Toast m10287a(Context context, CharSequence charSequence, int i) {
        Toast beVar = new be(context);
        beVar.setText(charSequence);
        beVar.setDuration(i);
        return beVar;
    }

    /* renamed from: a */
    public static Toast m10286a(Context context, int i, int i2) {
        return m10287a(context, context.getString(i), i2);
    }
}
