package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.duokan.c.j;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.BookCoverView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bh extends an {
    private final BookCoverView a = ((BookCoverView) findViewById(g.share__share_book_to_weibo_bitmap_view__book_cover));
    private final TextView b = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__book_name));
    private final TextView c = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__book_intro));
    private final TextView d = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__book_author));
    private final TextView e = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__share_reason));
    private final TextView f = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__share_time));
    private final TextView g = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__summary));
    private final DkShareBook h;

    public bh(Context context, DkShareBook dkShareBook) {
        super(context);
        this.h = dkShareBook;
        LayoutInflater.from(context).inflate(h.share__share_book_to_weibo_bitmap_view__single, this, true);
        b();
    }

    private void b() {
        this.a.a();
        this.a.setOnlineCoverUri(this.h.getCoverUri());
        this.b.setText(String.format(getResources().getString(j.general__shared__book_title_marks), new Object[]{this.h.getTitle()}));
        this.c.setText(this.h.getIntro());
        this.d.setText(this.h.getAuthor());
        this.g.setText(this.h.getSummary());
        this.f.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
    }

    public final boolean a() {
        return this.a.b();
    }

    public TextView getReasonView() {
        return this.e;
    }
}
