package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.duokan.b.c;
import com.duokan.b.e;
import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;

public class PageHeaderView extends HeaderView {
    private boolean a;

    public PageHeaderView(Context context) {
        this(context, null);
    }

    public PageHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        ReaderFeature readerFeature = (ReaderFeature) x.a(context).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            setBackgroundDrawable(readerFeature.getHeaderBackground());
        }
    }

    public boolean getDarkTitle() {
        return this.a;
    }

    public void setDarkTitle(boolean z) {
        if (this.a != z) {
            this.a = z;
            if (this.a) {
                setBackDrawable(getResources().getDrawable(e.general__shared__back));
            } else {
                setBackDrawable(getResources().getDrawable(e.general__shared__back_light));
            }
        }
    }

    public void a(String str, int i, OnClickListener onClickListener, int i2, OnClickListener onClickListener2) {
        a(str, getContext().getString(i), onClickListener, getContext().getString(i2), onClickListener2);
    }

    public void a(String str, String str2, OnClickListener onClickListener, String str3, OnClickListener onClickListener2) {
        setHasBackButton(false);
        setCenterTitle(str);
        setTitleTextColor(getResources().getColor(c.general__shared__publish_title));
        TextView b = b(str2);
        b.setTextColor(getResources().getColor(c.general__shared__publish_button_confirm));
        b.setOnClickListener(onClickListener);
        b = a(str3);
        b.setTextColor(getResources().getColor(c.general__shared__publish_button_cancel));
        b.setOnClickListener(onClickListener2);
    }
}
