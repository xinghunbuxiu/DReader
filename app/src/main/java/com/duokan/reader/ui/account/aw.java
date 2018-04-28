package com.duokan.reader.ui.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.BookCoverView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class aw extends aa {
    /* renamed from: a */
    private final TextView f5838a = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__share_reason));
    /* renamed from: b */
    private final TextView f5839b = ((TextView) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__share_time));
    /* renamed from: c */
    private final LinearLayout f5840c = ((LinearLayout) findViewById(C0255g.share__share_book_to_weibo_bitmap_view__books_container));
    /* renamed from: d */
    private final List<DkShareBook> f5841d;

    public aw(Context context, List<DkShareBook> list) {
        super(context);
        this.f5841d = list;
        LayoutInflater.from(context).inflate(C0256h.share__share_book_to_weibo_bitmap_view__multi, this, true);
        m8917b();
    }

    /* renamed from: b */
    private void m8917b() {
        this.f5839b.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
        for (DkShareBook bookContentData : this.f5841d) {
            setBookContentData(bookContentData);
        }
    }

    /* renamed from: a */
    public final boolean mo1579a() {
        boolean z = false;
        for (int i = 0; i < this.f5840c.getChildCount(); i++) {
            if (this.f5840c.getChildAt(i) instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) this.f5840c.getChildAt(i);
                boolean z2 = z;
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    if (linearLayout.getChildAt(i2) instanceof BookCoverView) {
                        BookCoverView bookCoverView = (BookCoverView) linearLayout.getChildAt(i2);
                        if (z2 || bookCoverView.m9920b()) {
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
        return this.f5838a;
    }

    private void setBookContentData(DkShareBook dkShareBook) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0256h.share__share_book_to_weibo_bitmap_view__book_content, null, false);
        BookCoverView bookCoverView = (BookCoverView) linearLayout.findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_cover);
        TextView textView = (TextView) linearLayout.findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_name);
        TextView textView2 = (TextView) linearLayout.findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_intro);
        TextView textView3 = (TextView) linearLayout.findViewById(C0255g.share__share_book_to_weibo_bitmap_view__book_author);
        bookCoverView.m9919a();
        bookCoverView.setOnlineCoverUri(dkShareBook.getCoverUri());
        textView.setText(String.format(getResources().getString(C0258j.general__shared__book_title_marks), new Object[]{dkShareBook.getTitle()}));
        textView2.setText(dkShareBook.getIntro());
        textView3.setText(dkShareBook.getAuthor());
        this.f5840c.addView(linearLayout);
    }
}
