package com.duokan.reader.ui.store.comment;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.ui.store.comment.f */
public class C1482f extends af {
    /* renamed from: a */
    private final EditText f11404a;
    /* renamed from: b */
    private final EditText f11405b;
    /* renamed from: c */
    private final DkCommentScoreView f11406c;
    /* renamed from: d */
    private final TextView f11407d;
    /* renamed from: e */
    private final ag<JSONObject> f11408e;
    /* renamed from: f */
    private final ag<JSONObject> f11409f;
    /* renamed from: g */
    private boolean f11410g = false;

    public C1482f(Context context, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, String str7, int i2, String str8, boolean z3, ag<JSONObject> agVar, ag<JSONObject> agVar2) {
        super(context);
        this.f11408e = agVar;
        this.f11409f = agVar2;
        setContentView(C0256h.store_comment__publish_comment_view);
        setContentBackgroundColor(getContext().getResources().getColor(C0252d.general__shared__ffffff));
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.store_comment__publish_comment_view__header);
        pageHeaderView.m10150a(str5, str7, (OnClickListener) new C1483g(this, z2, z, i2, str8, z3), str6, new C1484h(this));
        if (DkApp.get().forHd()) {
            pageHeaderView.setBackgroundColor(0);
        }
        this.f11406c = (DkCommentScoreView) findViewById(C0255g.store_comment__publish_comment_view__rating);
        this.f11404a = (EditText) findViewById(C0255g.store_comment__publish_comment_view__title);
        this.f11405b = (EditText) findViewById(C0255g.store_comment__publish_comment_view__content);
        this.f11407d = (TextView) findViewById(C0255g.store_comment__publish_comment_view__length_reminder);
        this.f11405b.addTextChangedListener(new C1485i(this, i2));
        if (!TextUtils.isEmpty(str3)) {
            this.f11405b.setText(str3);
        } else if (!TextUtils.isEmpty(str4)) {
            this.f11405b.setHint(str4);
        }
        if (i2 > 0) {
            this.f11407d.setVisibility(0);
            this.f11407d.setText(String.format(getContext().getString(C0258j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(i2)}));
        }
        if (!z) {
            findViewById(C0255g.store_comment__publish_comment_view__title_container).setVisibility(8);
        } else if (!TextUtils.isEmpty(str)) {
            this.f11404a.setText(str);
        } else if (!TextUtils.isEmpty(str2)) {
            this.f11404a.setHint(str2);
        }
        if (z2) {
            this.f11406c.setScore(i);
        } else {
            findViewById(C0255g.store_comment__publish_comment_view__rating_container).setVisibility(8);
        }
        this.f11405b.requestFocus();
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
        m15374b();
        if (!this.f11410g) {
            this.f11409f.run(m15371a());
        }
        super.dismiss();
    }

    /* renamed from: a */
    private JSONObject m15371a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", this.f11410g);
            jSONObject.put("score", (int) this.f11406c.getScore());
            jSONObject.put("title", this.f11404a.getEditableText().toString());
            jSONObject.put("content", this.f11405b.getEditableText().toString());
            return jSONObject;
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    /* renamed from: b */
    private void m15374b() {
        ReaderUi.m10161a(getContext(), this.f11404a);
        ReaderUi.m10161a(getContext(), this.f11405b);
    }
}
