package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.social.message.h;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.ITheme;

import java.util.ArrayList;

public class cd extends nm {
    private final ArrayList a = new ArrayList();
    private final gw k = new ce(this);

    public cd(Context context, ho hoVar) {
        super(context, hoVar);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        setAdapter(this.k);
        this.e.setRowDivider(new InsetDrawable(new dk(getResources().getColor(d.general__shared__e9e9e9)), UTools.closeAnimation(getContext(), 3.0f), 0, 0, 0));
        setBackgroundColor(getContext().getResources().getColor(d.general__shared__ffffff));
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class);
        if (ReaderEnv.get().forHd()) {
            int b = UTools.closeAnimation(getContext(), 15.0f);
            this.e.a(b, 0, b, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
            return;
        }
        b = UTools.closeAnimation(getContext(), 10.0f);
        this.e.a(b, 0, b, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
    }

    public void a() {
        this.e.setPullDownRefreshEnabled(false);
    }

    public void b() {
        this.e.setPullDownRefreshEnabled(true);
    }

    public void a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.personal__message_center_view__delete_multiple);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new ch(this, runnable));
    }

    private void a(int i, boolean z) {
        int i2;
        h a = h.a();
        if (z) {
            i2 = 0;
        } else {
            i2 = this.a.size();
        }
        a.a(i2, i, true, new cj(this, z));
    }
}
