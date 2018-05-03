package com.duokan.reader.ui.bookshelf;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

class je extends ActivatedController {
    /* renamed from: a */
    final /* synthetic */ ie f6652a;
    /* renamed from: b */
    private final TextView f6653b = ((TextView) findViewById(C0255g.bookshelf__sign_in_result_view__first_line));
    /* renamed from: c */
    private final LinearLayout f6654c = ((LinearLayout) findViewById(C0255g.bookshelf__sign_in_result_view__second_line));
    /* renamed from: d */
    private final TextView f6655d = ((TextView) findViewById(C0255g.bookshelf__sign_in_result_view__third_line));
    /* renamed from: e */
    private final TextView f6656e = ((TextView) findViewById(C0255g.bookshelf__sign_in_result_view__ok));

    public je(ie ieVar, IFeature mFeature) {
        this.f6652a = ieVar;
        super(mFeature);
        setContentView(LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__sign_in_result_view, null, false));
        findViewById(C0255g.bookshelf__sign_in_result_view__cancel).setOnClickListener(new jf(this, ieVar));
        findViewById(C0255g.bookshelf__sign_in_result_view__background).setOnClickListener(new jg(this, ieVar));
    }

    /* renamed from: a */
    public void m9856a(String str, int i) {
        this.f6653b.setText(str);
        this.f6653b.setTextColor(i);
    }

    /* renamed from: a */
    public void m9857a(String str, int i, String str2, int i2) {
        m9855a(this.f6653b, str, i, str2, i2);
    }

    /* renamed from: b */
    public void m9859b(String str, int i) {
        View textView = new TextView(getContext());
        textView.setTextSize(13.0f);
        textView.setIncludeFontPadding(false);
        textView.setPadding(AnimUtils.m1932b(getContext(), 6.0f), 0, AnimUtils.m1932b(getContext(), 6.0f), 0);
        textView.setText(str);
        textView.setTextColor(i);
        this.f6654c.addView(textView);
    }

    /* renamed from: b */
    public void m9860b(String str, int i, String str2, int i2) {
        View textView = new TextView(getContext());
        textView.setTextSize(13.0f);
        textView.setIncludeFontPadding(false);
        textView.setPadding(AnimUtils.m1932b(getContext(), 6.0f), 0, AnimUtils.m1932b(getContext(), 6.0f), 0);
        m9855a(textView, str, i, str2, i2);
        this.f6654c.addView(textView);
    }

    /* renamed from: c */
    public void m9861c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            this.f6655d.setVisibility(4);
            return;
        }
        this.f6655d.setVisibility(0);
        this.f6655d.setTextColor(i);
        this.f6655d.setText(str);
    }

    /* renamed from: a */
    public void m9858a(String str, OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f6656e.setVisibility(8);
            return;
        }
        this.f6656e.setVisibility(0);
        this.f6656e.setText(str);
        this.f6656e.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private void m9855a(TextView textView, String str, int i, String str2, int i2) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(str + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), str.length(), spannableStringBuilder.length(), 33);
        textView.setText(spannableStringBuilder);
    }
}
