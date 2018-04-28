package com.duokan.reader.ui.account;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.BookCoverView;
import java.util.ArrayList;
import java.util.List;

public class ay extends bd {
    /* renamed from: a */
    private final Handler f5850a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private List<DkShareBook> f5851b = new ArrayList();

    public ay(Activity activity, String str, List<DkShareBook> list, bu buVar) {
        super(activity, str, null, buVar);
        this.f5851b = list;
        m8908b();
    }

    /* renamed from: a */
    protected void mo1574a(View view) {
        LayoutInflater.from(getContext()).inflate(C0256h.share__share_book_to_weibo_dialog_view, (FrameLayout) view.findViewById(C0255g.account__third_share_view__share_content), true);
        BookCoverView bookCoverView = (BookCoverView) findViewById(C0255g.share__share_book_to_weibo_dialog_view__book_cover);
        TextView textView = (TextView) findViewById(C0255g.share__share_book_to_weibo_dialog_view__book_name);
        TextView textView2 = (TextView) findViewById(C0255g.share__share_book_to_weibo_dialog_view__book_summary);
        TextView textView3 = (TextView) findViewById(C0255g.share__share_book_to_weibo_dialog_view__book_author);
        this.g = (EditText) findViewById(C0255g.share__share_book_to_weibo_dialog_view__share_reason_edit);
        bookCoverView.m9919a();
        bookCoverView.setOnlineCoverUri(((DkShareBook) this.f5851b.get(0)).getCoverUri());
        if (this.f5851b.size() > 1) {
            textView.setText(String.format(getContext().getResources().getString(C0258j.share__book_to_weibo_multi_title), new Object[]{((DkShareBook) this.f5851b.get(0)).getTitle(), Integer.valueOf(this.f5851b.size())}));
        } else {
            textView.setText(((DkShareBook) this.f5851b.get(0)).getTitle());
        }
        textView2.setText(((DkShareBook) this.f5851b.get(0)).getIntro());
        textView3.setText(((DkShareBook) this.f5851b.get(0)).getAuthor());
        this.g.setHint(getContext().getString(C0258j.share_reason_hint));
        this.d.setOnClickListener(new az(this));
    }

    /* renamed from: a */
    protected void mo1575a(bt btVar) {
        CharSequence string;
        aa axVar;
        List list = this.f5851b;
        CharSequence valueOf = this.g != null ? String.valueOf(this.g.getText()) : "";
        if (TextUtils.isEmpty(valueOf)) {
            string = getContext().getString(C0258j.share_reason_default);
        } else {
            string = valueOf;
        }
        if (list.size() == 1) {
            axVar = new ax(getContext(), (DkShareBook) list.get(0));
        } else {
            axVar = new aw(getContext(), list);
        }
        axVar.getReasonView().setText(string);
        axVar.setLayoutParams(new LayoutParams(-2, -2));
        axVar.measure(MeasureSpec.makeMeasureSpec(1080, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        axVar.layout(0, 0, axVar.getMeasuredWidth(), axVar.getMeasuredHeight());
        try {
            Bitmap c = C0544a.m2447c(axVar.getMeasuredWidth(), axVar.getMeasuredHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(c);
            long currentTimeMillis = System.currentTimeMillis();
            this.f = true;
            if (!this.e.isShowing()) {
                this.e.open(new ba(this));
            }
            this.f5850a.post(new bb(this, axVar, canvas, currentTimeMillis, btVar, c));
        } catch (Throwable th) {
            this.f5850a.post(new bc(this, btVar));
        }
    }

    /* renamed from: a */
    protected String mo1581a() {
        List list = this.f5851b;
        if (list.size() > 1) {
            return String.format(getContext().getString(C0258j.share__book_template3_multi), new Object[]{Integer.valueOf(list.size())});
        } else if (list.size() != 1) {
            return "";
        } else {
            return String.format(getContext().getString(C0258j.share__book_template3), new Object[]{((DkShareBook) list.get(0)).getTitle(), ((DkShareBook) list.get(0)).getIntro()});
        }
    }

    /* renamed from: a */
    protected void mo1576a(String str) {
        for (DkShareBook dkShareBook : this.f5851b) {
            C1167a.m8671d().m8679a(dkShareBook.getBookUuid(), dkShareBook.getTraceId(), str);
        }
    }
}
