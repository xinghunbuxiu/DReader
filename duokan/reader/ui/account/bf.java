package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.duokan.c.g;
import com.duokan.c.h;

public class bf extends FrameLayout {
    private final ImageView a = ((ImageView) findViewById(g.share__share_book_to_weibo_dialog_view__image));
    private final EditText b = ((EditText) findViewById(g.share__share_book_to_weibo_dialog_view__share_reason_edit));

    public bf(Context context, String str, String str2) {
        super(context);
        setBackgroundColor(Color.rgb(254, 250, 248));
        LayoutInflater.from(context).inflate(h.share__share_event_to_weibo_dialog_view, this, true);
        Glide.with(getContext().getApplicationContext()).load(str).into(this.a);
        this.b.setText(str2);
    }

    public EditText getReasonEditView() {
        return this.b;
    }
}
