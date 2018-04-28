package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.duokan.p023b.C0244f;

public class DkCheckBox extends LinearLayout implements Checkable {
    /* renamed from: a */
    private CheckBox f6779a;
    /* renamed from: b */
    private ay f6780b;
    /* renamed from: c */
    private OnClickListener f6781c;

    public DkCheckBox(Context context) {
        super(context);
    }

    public DkCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f6779a = (CheckBox) findViewById(C0244f.general__dk_checkbox_view__checkbox);
        super.setSelected(this.f6779a.isChecked());
        this.f6779a.setOnClickListener(new av(this));
        this.f6779a.setOnCheckedChangeListener(new aw(this));
        super.setOnClickListener(new ax(this));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f6781c = onClickListener;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        setChecked(z);
    }

    public void setChecked(boolean z) {
        super.setSelected(z);
        this.f6779a.setChecked(z);
    }

    public boolean isChecked() {
        return this.f6779a.isChecked();
    }

    public void toggle() {
        this.f6779a.toggle();
        super.setSelected(isChecked());
    }

    public void setOnCheckedChangeListener(ay ayVar) {
        this.f6780b = ayVar;
    }
}
