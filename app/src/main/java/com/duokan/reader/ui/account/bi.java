package com.duokan.reader.ui.account;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

public class bi extends bd {
    /* renamed from: a */
    private final String f5832a;
    /* renamed from: b */
    private ImageView f5833b;

    public bi(Activity activity, String str, String str2, String str3, bu buVar) {
        super(activity, str, str2, buVar);
        this.f5832a = str3;
        m8908b();
    }

    /* renamed from: a */
    protected void mo1574a(View view) {
        LayoutInflater.from(getContext()).inflate(C0256h.share__share_event_to_weibo_dialog_view, (FrameLayout) view.findViewById(C0255g.account__third_share_view__share_content), true);
        this.g = (EditText) findViewById(C0255g.share__share_book_to_weibo_dialog_view__share_reason_edit);
        this.f5833b = (ImageView) findViewById(C0255g.share__share_book_to_weibo_dialog_view__image);
        this.g.setText(this.f5832a);
        this.d.setOnClickListener(new bj(this));
    }

    /* renamed from: a */
    protected void mo1575a(bt btVar) {
        if (!this.e.isShowing()) {
            this.e.open(new bk(this));
        }
        btVar.mo1573a(null, false);
    }

    public void show() {
        super.show();
        mo1577a(this.f5833b);
    }

    /* renamed from: a */
    protected void mo1576a(String str) {
    }

    /* renamed from: a */
    protected void mo1577a(ImageView imageView) {
        Glide.with(getContext().getApplicationContext()).load(this.h).into(imageView);
    }
}
