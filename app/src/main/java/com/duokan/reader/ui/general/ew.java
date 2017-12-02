package com.duokan.reader.ui.general;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duokan.b.i;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;

public class ew extends e implements dl {
    private final HeaderView a = ((HeaderView) findViewById(f.general__multiline_input_view__header));
    private final DkLabelView b;
    private final View c;
    private final TextView d;
    private final EditText e;
    private final DkNumView f;
    private final fc g;

    public ew(y yVar) {
        super(yVar);
        setContentView(g.general__multiline_input_view);
        this.a.setHasBackButton(true);
        this.a.setOnBackListener(new ex(this));
        this.b = (DkLabelView) findViewById(f.general__multiline_input_view__description);
        this.e = (EditText) findViewById(f.general__multiline_input_view__editor);
        this.f = (DkNumView) findViewById(f.general__multiline_input_view__remained_length);
        View findViewById = findViewById(f.general__multiline_input_view__save);
        if (ReaderEnv.get().forHd()) {
            findViewById.setVisibility(0);
            this.c = findViewById;
            this.d = (DkLabelView) findViewById(f.general__multiline_input_view__save_text);
        } else {
            findViewById.setVisibility(8);
            this.d = this.a.b(getContext().getString(i.general__shared__confirm));
            this.c = this.d;
        }
        this.g = new fc(getContext(), new ey(this));
    }

    public void a(int i) {
        this.a.setLeftTitle(i);
    }

    public void b(int i) {
        this.g.b(i);
    }

    public void a(String str) {
        this.g.c(str);
    }

    public void a(dn dnVar) {
        this.g.a(dnVar);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.g.a();
            this.e.postDelayed(new ez(this), 400);
        }
    }

    protected void onDeactive() {
        ReaderUi.a(getContext(), this.e);
        super.onDeactive();
    }

    protected boolean onBack() {
        this.e.clearFocus();
        return super.onBack();
    }
}
