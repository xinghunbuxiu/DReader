package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.push.C0876u;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.cc;
import com.duokan.reader.ui.general.expandable.ViewMode;

class cp extends hd {
    /* renamed from: a */
    final /* synthetic */ ck f8413a;
    /* renamed from: c */
    final /* synthetic */ cm f8414c;

    cp(cm cmVar, ck ckVar) {
        this.f8414c = cmVar;
        this.f8413a = ckVar;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m11617h(i);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc(this.f8414c.getContext());
        ccVar.m10334a(C0254f.personal__no_message_icon);
        ccVar.m10335b(C0258j.personal__message_empty_view__no_notification);
        ccVar.m10336c(C0258j.personal__message_empty_view__no_notification_description);
        return ccVar.m10333a();
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8414c.getContext()).inflate(C0256h.personal__message_push_item_view, viewGroup, false);
        }
        C0876u h = m11617h(i);
        View findViewById = view.findViewById(C0255g.personal__message_push_item_view__state);
        TextView textView = (TextView) view.findViewById(C0255g.personal__message_push_item_view__pub_time);
        TextView textView2 = (TextView) view.findViewById(C0255g.personal__message_push_item_view__name);
        TextView textView3 = (TextView) view.findViewById(C0255g.personal__message_push_item_view__desc);
        if (h.f4158b != null) {
            DkCloudPushMessage dkCloudPushMessage = h.f4158b;
            if (TextUtils.isEmpty(dkCloudPushMessage.getMessageTitle())) {
                textView2.setText(C0258j.personal__message_push_item_view__name);
            } else {
                textView2.setText(dkCloudPushMessage.getMessageTitle());
            }
            if (dkCloudPushMessage.getEndTime() != 0) {
                boolean z;
                if (dkCloudPushMessage.getEndTime() > System.currentTimeMillis()) {
                    z = true;
                } else {
                    z = false;
                }
                findViewById.setEnabled(z);
            } else {
                findViewById.setEnabled(true);
            }
            textView.setText(ReaderUi.m10158a(this.f8414c.getContext(), dkCloudPushMessage.getReceivedDate().getTime()));
            textView3.setText(dkCloudPushMessage.getMessageContent());
        } else {
            textView2.setText(C0258j.personal__message_push_item_view__name);
            C1151k c1151k = h.f4157a;
            findViewById.setEnabled(true);
            textView3.setText(c1151k.f5558e);
            textView.setText(ReaderUi.m10158a(view.getContext(), c1151k.m8581c() * 1000));
        }
        CheckBox checkBox = (CheckBox) view.findViewById(C0255g.personal__message_push_item_view__checkbox);
        if (mo1714f() == ViewMode.Edit) {
            checkBox.setVisibility(0);
            checkBox.setChecked(mo1713b(0, i));
        } else {
            checkBox.setVisibility(8);
        }
        return view;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8414c.f8408a.f8402b.size();
    }

    /* renamed from: h */
    public C0876u m11617h(int i) {
        return (C0876u) this.f8414c.f8408a.f8402b.get(i);
    }

    /* renamed from: k */
    protected int mo1867k() {
        return 1;
    }

    /* renamed from: f */
    protected int mo1866f(int i) {
        return mo506c();
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f8414c.m11602a(0, 0);
        return true;
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        long j;
        int i2 = 0;
        if (this.f8414c.f8408a.f8402b.size() > 0) {
            int size = this.f8414c.f8408a.f8402b.size() - 1;
            j = 0;
            while (size >= 0) {
                int i3;
                DkCloudPushMessage dkCloudPushMessage = ((C0876u) this.f8414c.f8408a.f8402b.get(size)).f4158b;
                if (j == 0 && dkCloudPushMessage != null) {
                    j = dkCloudPushMessage.getReceivedDate().getTime();
                }
                if (((C0876u) this.f8414c.f8408a.f8402b.get(size)).f4157a != null) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                size--;
                i2 = i3;
            }
        } else {
            j = 0;
        }
        this.f8414c.m11602a(i2, j);
    }

    /* renamed from: b */
    protected void mo1555b() {
    }
}
