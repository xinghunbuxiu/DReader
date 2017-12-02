package com.duokan.reader.ui.personal;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

class bk extends bo {
    final /* synthetic */ bj a;

    bk(bj bjVar) {
        this.a = bjVar;
    }

    protected void b() {
        this.a.c.clear();
    }

    protected void e(int i) {
        this.a.b();
    }

    public int c() {
        return this.a.c.size();
    }

    public Object d(int i) {
        return this.a.c.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a.getContext()).inflate(h.personal__feedback_list_view, null);
        }
        DkFeedbackThreadInfo dkFeedbackThreadInfo = (DkFeedbackThreadInfo) d(i);
        ((TextView) view.findViewById(g.personal__feedback_list_view__title)).setText(dkFeedbackThreadInfo.mSubject);
        ((TextView) view.findViewById(g.personal__feedback_list_view__date)).setText(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(dkFeedbackThreadInfo.mDateLine * 1000)));
        View view2 = (ImageView) view.findViewById(g.personal__feedback_list_view__unread);
        int max = this.a.b.containsKey(dkFeedbackThreadInfo.mThreadId) ? Math.max(dkFeedbackThreadInfo.mReplyCount - ((Integer) this.a.b.get(dkFeedbackThreadInfo.mThreadId)).intValue(), 0) : 0;
        if (max == 0) {
            view2.setVisibility(4);
        } else {
            view2.setVisibility(0);
        }
        ReaderUi.c(view2, max);
        view.setOnClickListener(new bl(this, dkFeedbackThreadInfo, i));
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from(this.a.getContext()).inflate(h.personal__feedback_list_empty_view, null);
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
