package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class an extends FrameLayout {
    public abstract boolean a();

    public abstract TextView getReasonView();

    public an(Context context) {
        super(context);
        setBackgroundColor(Color.rgb(250, 247, 242));
    }
}
