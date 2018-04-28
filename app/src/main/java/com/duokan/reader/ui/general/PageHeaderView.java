package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ReaderFeature;

public class PageHeaderView extends HeaderView {
    /* renamed from: a */
    private boolean f6877a;

    public PageHeaderView(Context context) {
        this(context, null);
    }

    public PageHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6877a = true;
        ReaderFeature readerFeature = (ReaderFeature) AppContext.getAppContext(context).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            setBackgroundDrawable(readerFeature.getHeaderBackground());
        }
    }

    public boolean getDarkTitle() {
        return this.f6877a;
    }

    public void setDarkTitle(boolean z) {
        if (this.f6877a != z) {
            this.f6877a = z;
            if (this.f6877a) {
                setBackDrawable(getResources().getDrawable(C0243e.general__shared__back));
            } else {
                setBackDrawable(getResources().getDrawable(C0243e.general__shared__back_light));
            }
        }
    }

    /* renamed from: a */
    public void m10149a(String str, int i, OnClickListener onClickListener, int i2, OnClickListener onClickListener2) {
        m10150a(str, getContext().getString(i), onClickListener, getContext().getString(i2), onClickListener2);
    }

    /* renamed from: a */
    public void m10150a(String str, String str2, OnClickListener onClickListener, String str3, OnClickListener onClickListener2) {
        setHasBackButton(false);
        setCenterTitle(str);
        setTitleTextColor(getResources().getColor(C0241c.general__shared__publish_title));
        TextView b = m10148b(str2);
        b.setTextColor(getResources().getColor(C0241c.general__shared__publish_button_confirm));
        b.setOnClickListener(onClickListener);
        b = m10144a(str3);
        b.setTextColor(getResources().getColor(C0241c.general__shared__publish_button_cancel));
        b.setOnClickListener(onClickListener2);
    }
}
