package com.duokan.reader.ui.personal;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;
import com.duokan.reader.ui.general.DkSmallFaceView;
import com.duokan.reader.ui.general.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

class bq extends bo {
    final /* synthetic */ bo a;

    bq(bo boVar) {
        this.a = boVar;
    }

    protected void b() {
        this.a.b.clear();
    }

    protected void e(int i) {
        this.a.a(0);
    }

    public int c() {
        return this.a.b.size();
    }

    public Object d(int i) {
        return this.a.b.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__feedback_thread_reply_view, null);
        }
        DkFeedbackReply dkFeedbackReply = (DkFeedbackReply) d(i);
        if (TextUtils.isEmpty(this.a.g)) {
            this.a.g = dkFeedbackReply.mUserId;
        }
        DkSmallFaceView dkSmallFaceView = (DkSmallFaceView) view.findViewById(g.personal__feedback_thread_reply_view__face);
        if (dkFeedbackReply.mUserId.equals(this.a.g)) {
            dkSmallFaceView.setUser(i.f().h());
        } else {
            dkSmallFaceView.setBackgroundDrawable(this.a.getDrawable(f.general__shared__dkuser_icon_small));
        }
        ((TextView) view.findViewById(g.personal__feedback_thread_reply_view__nickname)).setText(dkFeedbackReply.mUserId.equals(this.a.g) ? i.f().c().f().a() : this.a.getString(j.personal__feedback_thread_view__official));
        ((TextView) view.findViewById(g.personal__feedback_thread_reply_view__time)).setText(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(dkFeedbackReply.mDateLine * 1000)));
        ((TextView) view.findViewById(g.personal__feedback_thread_reply_view__reply)).setText(dkFeedbackReply.mMessage);
        view.setOnClickListener(new br(this, dkFeedbackReply));
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from(this.a.getContext()).inflate(h.personal__feedback_thread_empty_view, null);
        }
        return view;
    }

    public View c(int i, View view, ViewGroup viewGroup) {
        if (c() == 0) {
            return null;
        }
        View view2 = new View(this.a.getContext());
        view2.setBackgroundColor(Color.parseColor("#cccccc"));
        view2.setLayoutParams(new LayoutParams(-1, 1));
        return view2;
    }
}
