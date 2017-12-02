package com.duokan.reader.ui.store.comment;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.c.d;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;

public class j extends af {
    private final EditText a;
    private final EditText b;
    private final DkCommentScoreView c;
    private final TextView d;
    private final a e;
    private boolean f = false;

    public j(Context context, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, String str7, int i2, String str8, a aVar) {
        super(context);
        this.e = aVar;
        setContentView(h.store_comment__publish_comment_view);
        setContentBackgroundColor(getContext().getResources().getColor(d.general__shared__ffffff));
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(g.store_comment__publish_comment_view__header);
        pageHeaderView.a(str5, str7, (OnClickListener) new k(this, z2, z, i2, str8), str6, new l(this));
        if (DkApp.get().forHd()) {
            pageHeaderView.setBackgroundColor(0);
        }
        this.c = (DkCommentScoreView) findViewById(g.store_comment__publish_comment_view__rating);
        this.a = (EditText) findViewById(g.store_comment__publish_comment_view__title);
        this.b = (EditText) findViewById(g.store_comment__publish_comment_view__content);
        this.d = (TextView) findViewById(g.store_comment__publish_comment_view__length_reminder);
        this.b.addTextChangedListener(new m(this, i2));
        if (!TextUtils.isEmpty(str3)) {
            this.b.setText(str3);
        } else if (!TextUtils.isEmpty(str4)) {
            this.b.setHint(str4);
        }
        if (i2 > 0) {
            this.d.setVisibility(0);
            this.d.setText(String.format(getContext().getString(com.duokan.c.j.store_comment__publish_comment_view__content_word_count_left), new Object[]{Integer.valueOf(i2)}));
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
        int b = (displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels) - dv.b(getActivity(), 30.0f);
        layoutParams.width = (b * 4) / 5;
        layoutParams.height = b;
        layoutParams.gravity = 17;
    }

    public void dismiss() {
        b();
        if (!this.f) {
            this.e.a(a());
        }
        super.dismiss();
    }

    private n a() {
        n nVar = new n();
        nVar.a = (int) this.c.getScore();
        nVar.b = this.a.getEditableText().toString();
        nVar.c = this.b.getEditableText().toString();
        nVar.d = this.f;
        return nVar;
    }

    private void b() {
        ReaderUi.a(getContext(), this.a);
        ReaderUi.a(getContext(), this.b);
    }
}
