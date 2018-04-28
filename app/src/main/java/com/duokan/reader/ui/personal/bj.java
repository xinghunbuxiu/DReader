package com.duokan.reader.ui.personal;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.general.DkSmallFaceView;
import com.duokan.reader.ui.general.bo;
import java.text.SimpleDateFormat;
import java.util.Date;

class bj extends bo {
    /* renamed from: a */
    final /* synthetic */ bh f8328a;

    bj(bh bhVar) {
        this.f8328a = bhVar;
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8328a.f8321b.clear();
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8328a.m11456a(0);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8328a.f8321b.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f8328a.f8321b.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8328a.getContext()).inflate(C0256h.personal__feedback_thread_reply_view, null);
        }
        DkFeedbackReply dkFeedbackReply = (DkFeedbackReply) mo509d(i);
        if (TextUtils.isEmpty(this.f8328a.f8326g)) {
            this.f8328a.f8326g = dkFeedbackReply.mUserId;
        }
        DkSmallFaceView dkSmallFaceView = (DkSmallFaceView) view.findViewById(C0255g.personal__feedback_thread_reply_view__face);
        if (dkFeedbackReply.mUserId.equals(this.f8328a.f8326g)) {
            dkSmallFaceView.setUser(C0709k.m3476a().m3513h());
        } else {
            dkSmallFaceView.setBackgroundDrawable(this.f8328a.getDrawable(C0254f.general__shared__dkuser_icon_small));
        }
        ((TextView) view.findViewById(C0255g.personal__feedback_thread_reply_view__nickname)).setText(dkFeedbackReply.mUserId.equals(this.f8328a.f8326g) ? C0709k.m3476a().m3508d().mo836f().mo871a() : this.f8328a.getString(C0258j.personal__feedback_thread_view__official));
        ((TextView) view.findViewById(C0255g.personal__feedback_thread_reply_view__time)).setText(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(dkFeedbackReply.mDateLine * 1000)));
        ((TextView) view.findViewById(C0255g.personal__feedback_thread_reply_view__reply)).setText(dkFeedbackReply.mMessage);
        view.setOnClickListener(new bk(this, dkFeedbackReply));
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from(this.f8328a.getContext()).inflate(C0256h.personal__feedback_thread_empty_view, null);
        }
        return view;
    }

    /* renamed from: c */
    public View mo507c(int i, View view, ViewGroup viewGroup) {
        if (mo506c() == 0) {
            return null;
        }
        View view2 = new View(this.f8328a.getContext());
        view2.setBackgroundColor(Color.parseColor("#cccccc"));
        view2.setLayoutParams(new LayoutParams(-1, 1));
        return view2;
    }
}
