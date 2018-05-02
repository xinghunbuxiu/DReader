package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.kernel.DkUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.personal.fo;
import com.duokan.reader.ui.personal.nc;
import java.text.DecimalFormat;

public class SignInBookshelfView extends FrameLayout {
    /* renamed from: a */
    private final C0709k f6035a;
    /* renamed from: b */
    private final View f6036b;
    /* renamed from: c */
    private final TextView f6037c;
    /* renamed from: d */
    private final ImageView f6038d;
    /* renamed from: e */
    private final TextView f6039e;
    /* renamed from: f */
    private final TextView f6040f;
    /* renamed from: g */
    private final nc f6041g;
    /* renamed from: h */
    private final View f6042h;
    /* renamed from: i */
    private gz f6043i;
    /* renamed from: j */
    private String f6044j;
    /* renamed from: k */
    private boolean f6045k;

    public SignInBookshelfView(Context context) {
        this(context, null);
    }

    public SignInBookshelfView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6044j = "";
        this.f6045k = false;
        this.f6035a = C0709k.m3476a();
        this.f6041g = new fo();
        this.f6042h = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__sign_in_view, null, false);
        addView(this.f6042h);
        this.f6036b = findViewById(C0255g.bookshelf__sign_in_view__button);
        this.f6037c = (TextView) findViewById(C0255g.bookshelf__sign_in_view__button_text);
        this.f6038d = (ImageView) findViewById(C0255g.bookshelf__sign_in_view__button_image);
        this.f6039e = (TextView) findViewById(C0255g.bookshelf__sign_in_view__reading_time);
        this.f6040f = (TextView) findViewById(C0255g.bookshelf__sign_in_view__reading_time_tail);
        m9091a();
    }

    public void setBookshelfView(gz gzVar) {
        this.f6043i = gzVar;
    }

    /* renamed from: a */
    public boolean m9091a() {
        long c = this.f6041g.mo1907c();
        int i = (int) ((c / 60) / 60);
        if (i > 10000) {
            this.f6039e.setText(new DecimalFormat("0.##").format((double) (((float) i) / 10000.0f)));
            this.f6040f.setText(C0258j.bookshelf__sign_in_view__ten_thousand_hour);
        } else {
            this.f6039e.setText(String.valueOf((c / 60) / 60));
            this.f6040f.setText(C0258j.bookshelf__sign_in_view__hour);
        }
        return m9089a(PersonalPrefs.m5175a().m5235k(), PersonalPrefs.m5175a().m5236l(), PersonalPrefs.m5175a().m5238n());
    }

    /* renamed from: a */
    private boolean m9089a(boolean[] zArr, int i, boolean z) {
        int a = lb.m4896a().m4914a(zArr, i);
        boolean z2 = true;
        if (!this.f6035a.m3500a(PersonalAccount.class)) {
            this.f6036b.setBackgroundDrawable(getResources().getDrawable(C0254f.bookshelf__sign_in_view__sign_background));
            this.f6037c.setTextColor(Color.parseColor("#f45600"));
            this.f6037c.setText(getResources().getString(C0258j.personal__account_summary_view__login));
            this.f6038d.setVisibility(8);
            this.f6036b.setOnClickListener(new hw(this));
        } else if (zArr[i - 1]) {
            if (a > 0) {
                this.f6036b.setBackgroundDrawable(getResources().getDrawable(C0254f.bookshelf__sign_in_view__resign_background));
                this.f6037c.setTextColor(Color.parseColor("#186cde"));
                this.f6037c.setText(getResources().getString(C0258j.bookshelf__sign_in_view__resign));
                this.f6038d.setVisibility(0);
                this.f6038d.setImageResource(C0254f.bookshelf__sign_in_view__resign_pic);
                this.f6036b.setOnClickListener(new hz(this));
            } else if (i == 7 && z) {
                this.f6036b.setBackgroundDrawable(getResources().getDrawable(C0254f.bookshelf__sign_in_view__lottery_background));
                this.f6037c.setTextColor(Color.parseColor("#d90000"));
                this.f6037c.setText(getResources().getString(C0258j.bookshelf__sign_in_view__sign_big_reward));
                this.f6038d.setVisibility(0);
                this.f6038d.setImageResource(C0254f.bookshelf__sign_in_view__lottery_pic);
                this.f6036b.setOnClickListener(new ib(this));
            } else {
                this.f6036b.setBackgroundDrawable(getResources().getDrawable(C0254f.bookshelf__sign_in_view__sign_background));
                this.f6037c.setTextColor(Color.parseColor("#f45600"));
                this.f6037c.setText(getResources().getString(C0258j.bookshelf__sign_in_view__signed));
                this.f6038d.setVisibility(8);
                this.f6036b.setOnClickListener(new ic(this));
                z2 = false;
            }
        } else if (i == 7 && a == 0) {
            this.f6036b.setBackgroundDrawable(getResources().getDrawable(C0254f.bookshelf__sign_in_view__lottery_background));
            this.f6037c.setTextColor(Color.parseColor("#d90000"));
            this.f6037c.setText(getResources().getString(C0258j.bookshelf__sign_in_view__sign_big_reward));
            this.f6038d.setVisibility(0);
            this.f6038d.setImageResource(C0254f.bookshelf__sign_in_view__lottery_pic);
            this.f6036b.setOnClickListener(new hx(this));
        } else {
            this.f6036b.setBackgroundDrawable(getResources().getDrawable(C0254f.bookshelf__sign_in_view__sign_background));
            this.f6037c.setTextColor(Color.parseColor("#f45600"));
            this.f6037c.setText(getResources().getString(C0258j.bookshelf__sign_in_view__sign));
            this.f6038d.setVisibility(0);
            this.f6038d.setImageResource(C0254f.bookshelf__sign_in_view__sign_pic);
            this.f6036b.setOnClickListener(new hy(this));
        }
        m9092b();
        return z2;
    }

    /* renamed from: e */
    private void m9090e() {
        C0709k.m3476a().m3495a(new id(this));
    }

    /* renamed from: b */
    public void m9092b() {
        String charSequence = this.f6037c.getText().toString();
        if (!charSequence.equals(this.f6044j) && getVisibility() == 0 && m9094d() && this.f6043i != null && this.f6043i.getViewportBounds().top == 0) {
            this.f6044j = charSequence;
            UmengManager.get().onEvent("BOOKSHELF_CHECK_IN_EXPOSURE_V2", DkUtils.cht2chsText(charSequence));
        }
    }

    /* renamed from: c */
    public void m9093c() {
        UmengManager.get().onEvent("BOOKSHELF_CHECK_IN_CLICK_V2", DkUtils.cht2chsText(this.f6037c.getText().toString()));
    }

    /* renamed from: d */
    public boolean m9094d() {
        return this.f6045k;
    }

    public void setActive(boolean z) {
        this.f6045k = z;
    }
}
