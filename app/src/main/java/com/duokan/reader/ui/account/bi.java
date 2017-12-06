package com.duokan.reader.ui.account;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.c.j;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.store.DkShareBook;

import java.util.ArrayList;
import java.util.List;

public class bi extends bn {
    private final ao e;
    private final Handler f = new Handler(Looper.getMainLooper());
    private List g = new ArrayList();

    public bi(Activity activity, String str, List list, ce ceVar) {
        super(activity, str, null, ceVar);
        this.g = list;
        this.e = new ao(getContext(), this.g);
        b();
    }

    public void show() {
        super.show();
        UTools.PostTask(this.e.getReasonEditView());
    }

    protected void a(View view) {
        ((FrameLayout) view.findViewById(g.account__third_share_view__share_content)).addView(this.e, new LayoutParams(-1, -2));
        this.b.setOnClickListener(new bj(this));
    }

    protected void a(cd cdVar) {
        CharSequence string;
        an bhVar;
        List list = this.g;
        CharSequence valueOf = String.valueOf(this.e.getReasonEditView().getText());
        if (TextUtils.isEmpty(valueOf)) {
            string = getContext().getString(j.share_reason_default);
        } else {
            string = valueOf;
        }
        if (list.size() == 1) {
            bhVar = new bh(getContext(), (DkShareBook) list.get(0));
        } else {
            bhVar = new bg(getContext(), list);
        }
        bhVar.getReasonView().setText(string);
        bhVar.setLayoutParams(new LayoutParams(-2, -2));
        bhVar.measure(MeasureSpec.makeMeasureSpec(1080, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        bhVar.layout(0, 0, bhVar.getMeasuredWidth(), bhVar.getMeasuredHeight());
        try {
            Bitmap c = a.c(bhVar.getMeasuredWidth(), bhVar.getMeasuredHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(c);
            long currentTimeMillis = System.currentTimeMillis();
            this.d = true;
            if (!this.c.isShowing()) {
                this.c.open(new bk(this));
            }
            this.f.post(new bl(this, bhVar, canvas, currentTimeMillis, cdVar, c));
        } catch (Throwable th) {
            this.f.post(new bm(this, cdVar));
        }
    }

    protected String a() {
        List list = this.g;
        if (list.size() > 1) {
            return String.format(getContext().getString(j.share__book_template3_multi), new Object[]{Integer.valueOf(list.size())});
        } else if (list.size() != 1) {
            return "";
        } else {
            return String.format(getContext().getString(j.share__book_template3), new Object[]{((DkShareBook) list.get(0)).getTitle(), ((DkShareBook) list.get(0)).getIntro()});
        }
    }

    protected void a(String str) {
        for (DkShareBook dkShareBook : this.g) {
            com.duokan.reader.domain.statistics.dailystats.a.d().a(dkShareBook.getBookUuid(), dkShareBook.getTraceId(), str);
        }
    }
}
