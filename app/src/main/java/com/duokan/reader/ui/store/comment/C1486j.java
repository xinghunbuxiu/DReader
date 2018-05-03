package com.duokan.reader.ui.store.comment;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;

/* renamed from: com.duokan.reader.ui.store.comment.j */
public class C1486j extends af {
    /* renamed from: a */
    private final EditText f11420a;
    /* renamed from: b */
    private final EditText f11421b;
    /* renamed from: c */
    private final DkCommentScoreView f11422c;
    /* renamed from: d */
    private final TextView f11423d;
    /* renamed from: e */
    private final C0517a<C1490n> f11424e;
    /* renamed from: f */
    private boolean f11425f = false;

    public C1486j(Context context, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, String str7, int i2, String str8, C0517a<C1490n> c0517a) {
        super(context);
        this.f11424e = c0517a;
        setContentView(C0256h.store_comment__publish_comment_view);
        setContentBackgroundColor(getContext().getResources().getColor(C0252d.general__shared__ffffff));
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.store_comment__publish_comment_view__header);
        pageHeaderView.m10150a(str5, str7, (OnClickListener) new C1487k(this, z2, z, i2, str8), str6, new C1488l(this));
        if (DkApp.get().forHd()) {
            pageHeaderView.setBackgroundColor(0);
        }
        this.f11422c = (DkCommentScoreView) findViewById(C0255g.store_comment__publish_comment_view__rating);
        this.f11420a = (EditText) findViewById(C0255g.store_comment__publish_comment_view__title);
        this.f11421b = (EditText) findViewById(C0255g.store_comment__publish_comment_view__content);
        this.f11423d = (TextView) findViewById(C0255g.store_comment__publish_comment_view__length_reminder);
        this.f11421b.addTextChangedListener(new C1489m(this, i2));
        if (!TextUtils.isEmpty(str3)) {
            this.f11421b.setText(str3);
        } else if (!TextUtils.isEmpty(str4)) {
            this.f11421b.setHint(str4);
        }
        if (i2 > 0) {
            this.f11423d.setVisibility(0);
            this.f11423d.setText(String.format(getContext().getString(C0258j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(i2)}));
        }
        if (!z) {
            findViewById(C0255g.store_comment__publish_comment_view__title_container).setVisibility(8);
        } else if (!TextUtils.isEmpty(str)) {
            this.f11420a.setText(str);
        } else if (!TextUtils.isEmpty(str2)) {
            this.f11420a.setHint(str2);
        }
        if (z2) {
            this.f11422c.setScore(i);
        } else {
            findViewById(C0255g.store_comment__publish_comment_view__rating_container).setVisibility(8);
        }
        this.f11421b.requestFocus();
        ((BoxView) findViewById(C0255g.store_comment__publish_comment_view__content_box)).setResizeLayoutForSoftInput(true);
    }

    protected void initHdContent(FrameLayout frameLayout, LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int b = (displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels) - AnimUtils.m1932b(getActivity(), 30.0f);
        layoutParams.width = (b * 4) / 5;
        layoutParams.height = b;
        layoutParams.gravity = 17;
    }

    public void dismiss() {
        m15383b();
        if (!this.f11425f) {
            this.f11424e.mo730a(m15380a());
        }
        super.dismiss();
    }

    /* renamed from: a */
    private C1490n m15380a() {
        C1490n c1490n = new C1490n();
        c1490n.f11434a = (int) this.f11422c.getScore();
        c1490n.f11435b = this.f11420a.getEditableText().toString();
        c1490n.f11436c = this.f11421b.getEditableText().toString();
        c1490n.f11437d = this.f11425f;
        return c1490n;
    }

    /* renamed from: b */
    private void m15383b() {
        ReaderUi.m10161a(getContext(), this.f11420a);
        ReaderUi.m10161a(getContext(), this.f11421b);
    }
}
