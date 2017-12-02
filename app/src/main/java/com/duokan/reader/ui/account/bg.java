package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.BookCoverView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class bg extends an {
    private final TextView a = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__share_reason));
    private final TextView b = ((TextView) findViewById(g.share__share_book_to_weibo_bitmap_view__share_time));
    private final LinearLayout c = ((LinearLayout) findViewById(g.share__share_book_to_weibo_bitmap_view__books_container));
    private final List d;

    public bg(Context context, List list) {
        super(context);
        this.d = list;
        LayoutInflater.from(context).inflate(h.share__share_book_to_weibo_bitmap_view__multi, this, true);
        b();
    }

    private void b() {
        this.b.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
        for (DkShareBook bookContentData : this.d) {
            setBookContentData(bookContentData);
        }
    }

    public final boolean a() {
        boolean z = false;
        for (int i = 0; i < this.c.getChildCount(); i++) {
            if (this.c.getChildAt(i) instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) this.c.getChildAt(i);
                boolean z2 = z;
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    if (linearLayout.getChildAt(i2) instanceof BookCoverView) {
                        BookCoverView bookCoverView = (BookCoverView) linearLayout.getChildAt(i2);
                        if (z2 || bookCoverView.b()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = z;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public TextView getReasonView() {
        return this.a;
    }

    private void setBookContentData(DkShareBook dkShareBook) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(h.share__share_book_to_weibo_bitmap_view__book_content, null, false);
        BookCoverView bookCoverView = (BookCoverView) linearLayout.findViewById(g.share__share_book_to_weibo_bitmap_view__book_cover);
        TextView textView = (TextView) linearLayout.findViewById(g.share__share_book_to_weibo_bitmap_view__book_name);
        TextView textView2 = (TextView) linearLayout.findViewById(g.share__share_book_to_weibo_bitmap_view__book_intro);
        TextView textView3 = (TextView) linearLayout.findViewById(g.share__share_book_to_weibo_bitmap_view__book_author);
        bookCoverView.a();
        bookCoverView.setOnlineCoverUri(dkShareBook.getCoverUri());
        textView.setText(String.format(getResources().getString(j.general__shared__book_title_marks), new Object[]{dkShareBook.getTitle()}));
        textView2.setText(dkShareBook.getIntro());
        textView3.setText(dkShareBook.getAuthor());
        this.c.addView(linearLayout);
    }
}
