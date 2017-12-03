package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

import com.duokan.b.f;

public class DkCheckBox extends LinearLayout implements Checkable {
    private CheckBox a;
    private ay b;
    private OnClickListener c;

    public DkCheckBox(Context context) {
        super(context);
    }

    public DkCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (CheckBox) findViewById(f.general__dk_checkbox_view__checkbox);
        super.setSelected(this.a.isChecked());
        this.a.setOnClickListener(new av(this));
        this.a.setOnCheckedChangeListener(new aw(this));
        super.setOnClickListener(new ax(this));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        setChecked(z);
    }

    public void setChecked(boolean z) {
        super.setSelected(z);
        this.a.setChecked(z);
    }

    public boolean isChecked() {
        return this.a.isChecked();
    }

    public void toggle() {
        this.a.toggle();
        super.setSelected(isChecked());
    }

    public void setOnCheckedChangeListener(ay ayVar) {
        this.b = ayVar;
    }
}
