package com.duokan.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.duokan.reader.DkApp;

public class DkEditorView extends EditText {
    public DkEditorView(Context context) {
        super(DkApp.get().noDensityScaleContext(context));
    }

    public DkEditorView(Context context, AttributeSet attributeSet) {
        super(DkApp.get().noDensityScaleContext(context), attributeSet);
    }
}
