package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class fa extends af implements dl {
    private final TextView a = ((TextView) findViewById(f.general__multiline_input_dialog__title));
    private final DkLabelView b = null;
    private final TextView c = ((TextView) findViewById(f.general__multiline_input_dialog__save));
    private final TextView d = ((TextView) findViewById(f.general__multiline_input_dialog__cancel));
    private final EditText e = ((EditText) findViewById(f.general__multiline_input_dialog__editor));
    private final DkNumView f = null;
    private final fc g = new fc(getContext(), new fb(this));

    public fa(Context context) {
        super(context);
        setContentView(g.general__multiline_input_dialog);
    }

    protected void initHdContent(FrameLayout frameLayout, LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int round = Math.round(((float) displayMetrics.heightPixels) * 0.5f);
        layoutParams.width = Math.round(displayMetrics.widthPixels < displayMetrics.heightPixels ? ((float) round) * 0.8f : ((float) round) / 0.8f);
        layoutParams.height = round;
        layoutParams.gravity = 17;
    }

    public void a(int i) {
        this.a.setText(i);
    }

    public void a(String str) {
        this.a.setText(str);
    }

    public void b(String str) {
        this.g.a(str);
    }

    public void b(int i) {
        this.g.a(i);
    }

    public void c(String str) {
        this.g.b(str);
    }

    public void d(String str) {
        this.g.c(str);
    }

    public void a(dn dnVar) {
        this.g.a(dnVar);
    }

    public void a(dm dmVar) {
        this.g.a(dmVar);
    }

    public void show() {
        this.g.a();
        super.show();
    }

    protected void onCancel() {
        super.onCancel();
        this.g.c();
    }
}
