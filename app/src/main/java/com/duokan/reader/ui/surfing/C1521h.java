package com.duokan.reader.ui.surfing;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

/* renamed from: com.duokan.reader.ui.surfing.h */
class C1521h extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ C1514a f11525a;
    /* renamed from: b */
    private final CheckBox f11526b = ((CheckBox) findViewById(C0255g.general__choose_user_channel_view__checkbox));

    public C1521h(C1514a c1514a, Context context, int i, String str, String str2) {
        this.f11525a = c1514a;
        super(context);
        LayoutInflater.from(getContext()).inflate(C0256h.general__choose_user_channel_view, this, true);
        ImageView imageView = (ImageView) findViewById(C0255g.general__choose_user_channel_view__image);
        TextView textView = (TextView) findViewById(C0255g.general__choose_user_channel_view__title);
        TextView textView2 = (TextView) findViewById(C0255g.general__choose_user_channel_view__description);
        imageView.setImageResource(i);
        textView.setText(str);
        textView2.setText(str2);
        setContentDescription(str);
    }

    /* renamed from: a */
    public void m15477a(String str, String str2) {
        this.f11526b.setChecked(!this.f11526b.isChecked());
        if (this.f11526b.isChecked()) {
            m15476a(str, str2, true);
        } else {
            m15476a(str, str2, false);
        }
        this.f11525a.m15451a(this.f11525a.f11497g, false);
    }

    /* renamed from: a */
    private void m15476a(String str, String str2, boolean z) {
        if (z) {
            this.f11525a.f11497g.add(str);
            this.f11525a.f11498h = this.f11525a.f11498h + str2;
            return;
        }
        this.f11525a.f11497g.remove(str);
    }
}
