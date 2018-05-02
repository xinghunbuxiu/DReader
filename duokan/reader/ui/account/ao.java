package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.domain.store.DkShareBook;
import com.duokan.reader.ui.general.BookCoverView;

import java.util.List;

public class ao extends FrameLayout {
    private final BookCoverView a = ((BookCoverView) findViewById(g.share__share_book_to_weibo_dialog_view__book_cover));
    private final TextView b = ((TextView) findViewById(g.share__share_book_to_weibo_dialog_view__book_name));
    private final TextView c = ((TextView) findViewById(g.share__share_book_to_weibo_dialog_view__book_summary));
    private final TextView d = ((TextView) findViewById(g.share__share_book_to_weibo_dialog_view__book_author));
    private final EditText e = ((EditText) findViewById(g.share__share_book_to_weibo_dialog_view__share_reason_edit));
    private final List f;

    public ao(Context context, List list) {
        super(context);
        setBackgroundColor(Color.rgb(254, 250, 248));
        this.f = list;
        LayoutInflater.from(context).inflate(h.share__share_book_to_weibo_dialog_view, this, true);
        this.a.a();
        this.a.setOnlineCoverUri(((DkShareBook) this.f.get(0)).getCoverUri());
        if (this.f.size() > 1) {
            this.b.setText(String.format(getResources().getString(j.share__book_to_weibo_multi_title), new Object[]{((DkShareBook) this.f.get(0)).getTitle(), Integer.valueOf(this.f.size())}));
        } else {
            this.b.setText(((DkShareBook) this.f.get(0)).getTitle());
        }
        this.c.setText(((DkShareBook) this.f.get(0)).getIntro());
        this.d.setText(((DkShareBook) this.f.get(0)).getAuthor());
        this.e.setHint(getContext().getString(j.share_reason_hint));
    }

    public EditText getReasonEditView() {
        return this.e;
    }
}
