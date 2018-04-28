package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class ey extends af implements dl {
    /* renamed from: a */
    private final TextView f7176a = ((TextView) findViewById(C0244f.general__multiline_input_dialog__title));
    /* renamed from: b */
    private final DkLabelView f7177b = null;
    /* renamed from: c */
    private final TextView f7178c = ((TextView) findViewById(C0244f.general__multiline_input_dialog__save));
    /* renamed from: d */
    private final TextView f7179d = ((TextView) findViewById(C0244f.general__multiline_input_dialog__cancel));
    /* renamed from: e */
    private final EditText f7180e = ((EditText) findViewById(C0244f.general__multiline_input_dialog__editor));
    /* renamed from: f */
    private final DkNumView f7181f = null;
    /* renamed from: g */
    private final fa f7182g = new fa(getContext(), new ez(this));

    public ey(Context context) {
        super(context);
        setContentView(C0245g.general__multiline_input_dialog);
    }

    protected void initHdContent(FrameLayout frameLayout, LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int round = Math.round(((float) displayMetrics.heightPixels) * 0.5f);
        layoutParams.width = Math.round(displayMetrics.widthPixels < displayMetrics.heightPixels ? ((float) round) * 0.8f : ((float) round) / 0.8f);
        layoutParams.height = round;
        layoutParams.gravity = 17;
    }

    /* renamed from: a */
    public void m10588a(int i) {
        this.f7176a.setText(i);
    }

    /* renamed from: a */
    public void m10591a(String str) {
        this.f7176a.setText(str);
    }

    /* renamed from: b */
    public void m10593b(String str) {
        this.f7182g.m10630a(str);
    }

    /* renamed from: b */
    public void m10592b(int i) {
        this.f7182g.m10627a(i);
    }

    /* renamed from: c */
    public void m10594c(String str) {
        this.f7182g.m10633b(str);
    }

    /* renamed from: d */
    public void m10595d(String str) {
        this.f7182g.m10635c(str);
    }

    /* renamed from: a */
    public void m10590a(dn dnVar) {
        this.f7182g.m10629a(dnVar);
    }

    /* renamed from: a */
    public void m10589a(dm dmVar) {
        this.f7182g.m10628a(dmVar);
    }

    public void show() {
        this.f7182g.m10626a();
        super.show();
    }

    protected void onCancel() {
        super.onCancel();
        this.f7182g.m10634c();
    }
}
