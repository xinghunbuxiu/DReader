package com.duokan.reader.ui.personal;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import java.text.SimpleDateFormat;
import java.util.Date;

class bd extends bo {
    /* renamed from: a */
    final /* synthetic */ bc f8310a;

    bd(bc bcVar) {
        this.f8310a = bcVar;
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8310a.f8307c.clear();
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8310a.m11437b();
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8310a.f8307c.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f8310a.f8307c.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8310a.getContext()).inflate(C0256h.personal__feedback_list_view, null);
        }
        DkFeedbackThreadInfo dkFeedbackThreadInfo = (DkFeedbackThreadInfo) mo509d(i);
        ((TextView) view.findViewById(C0255g.personal__feedback_list_view__title)).setText(dkFeedbackThreadInfo.mSubject);
        ((TextView) view.findViewById(C0255g.personal__feedback_list_view__date)).setText(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(dkFeedbackThreadInfo.mDateLine * 1000)));
        View view2 = (ImageView) view.findViewById(C0255g.personal__feedback_list_view__unread);
        int max = this.f8310a.f8306b.containsKey(dkFeedbackThreadInfo.mThreadId) ? Math.max(dkFeedbackThreadInfo.mReplyCount - ((Integer) this.f8310a.f8306b.get(dkFeedbackThreadInfo.mThreadId)).intValue(), 0) : 0;
        if (max == 0) {
            view2.setVisibility(4);
        } else {
            view2.setVisibility(0);
        }
        ReaderUi.m10167c(view2, max);
        view.setOnClickListener(new be(this, dkFeedbackThreadInfo, i));
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from(this.f8310a.getContext()).inflate(C0256h.personal__feedback_list_empty_view, null);
        }
        return view;
    }

    /* renamed from: c */
    public View mo507c(int i, View view, ViewGroup viewGroup) {
        if (mo506c() == 0) {
            return null;
        }
        View view2 = new View(this.f8310a.getContext());
        view2.setBackgroundColor(Color.parseColor("#cccccc"));
        view2.setLayoutParams(new LayoutParams(-1, 1));
        return view2;
    }
}
