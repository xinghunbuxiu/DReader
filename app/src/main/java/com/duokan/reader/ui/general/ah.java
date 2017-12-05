package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.core.app.QueryFeatureWrapper;
import com.duokan.reader.ui.IWindowRecord;

class ah extends QueryFeatureWrapper {
    private final Context a;
    private final IWindowRecord b = new ai(this);

    public ah(Context context) {
        super(context);
        this.a = context;
        addFirstLocalFeature(new aj(this));
    }
}
