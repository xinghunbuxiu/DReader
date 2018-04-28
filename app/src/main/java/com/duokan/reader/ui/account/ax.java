package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.BookCoverView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ax extends aa {
    /* renamed from: a */
    private final BookCoverView f5842a = ((BookCoverView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_cover));
    /* renamed from: b */
    private final TextView f5843b = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_name));
    /* renamed from: c */
    private final TextView f5844c = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_intro));
    /* renamed from: d */
    private final TextView f5845d = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_author));
    /* renamed from: e */
    private final TextView f5846e = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__share_reason));
    /* renamed from: f */
    private final TextView f5847f = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__share_time));
    /* renamed from: g */
    private final TextView f5848g = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__summary));
    /* renamed from: h */
    private final DkShareBook f5849h;

    public ax(Context context, DkShareBook dkShareBook) {
        super(context);
        this.f5849h = dkShareBook;
        LayoutInflater.from(context).inflate(C0256h.share__share_book_to_weibo_bitmap_view__single, this, true);
        m8919b();
    }

    /* renamed from: b */
    private void m8919b() {
        this.f5842a.m9919a();
        this.f5842a.setOnlineCoverUri(this.f5849h.getCoverUri());
        this.f5843b.setText(String.format(getResources().getString(C0258j.general__shared__book_title_marks), new Object[]{this.f5849h.getTitle()}));
        this.f5844c.setText(this.f5849h.getIntro());
        this.f5845d.setText(this.f5849h.getAuthor());
        this.f5848g.setText(this.f5849h.getSummary());
        this.f5847f.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
    }

    /* renamed from: a */
    public final boolean mo1579a() {
        return this.f5842a.m9920b();
    }

    public TextView getReasonView() {
        return this.f5846e;
    }
}
