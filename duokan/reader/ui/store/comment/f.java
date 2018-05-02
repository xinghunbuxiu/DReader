package com.duokan.reader.ui.store.comment;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;

import org.json.JSONException;
import org.json.JSONObject;

public class f extends af {
    private final EditText a;
    private final EditText b;
    private final DkCommentScoreView c;
    private final TextView d;
    private final ag e;
    private final ag f;
    private boolean g = false;

    public f(Context context, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, String str7, int i2, String str8, boolean z3, ag agVar, ag agVar2) {
        super(context);
        this.e = agVar;
        this.f = agVar2;
        setContentView(h.store_comment__publish_comment_view);
        setContentBackgroundColor(getContext().getResources().getColor(d.general__shared__ffffff));
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(g.store_comment__publish_comment_view__header);
        pageHeaderView.a(str5, str7, (OnClickListener) new g(this, z2, z, i2, str8, z3), str6, new h(this));
        if (DkApp.get().forHd()) {
            pageHeaderView.setBackgroundColor(0);
        }
        this.c = (DkCommentScoreView) findViewById(g.store_comment__publish_comment_view__rating);
        this.a = (EditText) findViewById(g.store_comment__publish_comment_view__title);
        this.b = (EditText) findViewById(g.store_comment__publish_comment_view__content);
        this.d = (TextView) findViewById(g.store_comment__publish_comment_view__length_reminder);
        this.b.addTextChangedListener(new i(this, i2));
        if (!TextUtils.isEmpty(str3)) {
            this.b.setText(str3);
        } else if (!TextUtils.isEmpty(str4)) {
            this.b.setHint(str4);
        }
        if (i2 > 0) {
            this.d.setVisibility(0);
            this.d.setText(String.format(getContext().getString(j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(i2)}));
        }
        if (!z) {
            findViewById(g.store_comment__publish_comment_view__title_container).setVisibility(8);
        } else if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
        } else if (!TextUtils.isEmpty(str2)) {
            this.a.setHint(str2);
        }
        if (z2) {
            this.c.setScore(i);
        } else {
            findViewById(g.store_comment__publish_comment_view__rating_container).setVisibility(8);
        }
        this.b.requestFocus();
        ((BoxView) findViewById(g.store_comment__publish_comment_view__content_box)).setResizeLayoutForSoftInput(true);
    }

    protected void initHdContent(FrameLayout frameLayout, LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int b = (displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels) - UTools.getMinimumHeight(getActivity(), 30.0f);
        layoutParams.width = (b * 4) / 5;
        layoutParams.height = b;
        layoutParams.gravity = 17;
    }

    public void dismiss() {
        b();
        if (!this.g) {
            this.f.a(a());
        }
        super.dismiss();
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("operation", this.g);
            jSONObject.put("score", (int) this.c.getScore());
            jSONObject.put("title", this.a.getEditableText().toString());
            jSONObject.put("content", this.b.getEditableText().toString());
            return jSONObject;
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    private void b() {
        ReaderUi.a(getContext(), this.a);
        ReaderUi.a(getContext(), this.b);
    }
}
