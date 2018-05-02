package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.reader.domain.cloud.push.DkCloudPushMessage;
import com.duokan.reader.domain.cloud.push.q;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.cc;
import com.duokan.reader.ui.general.expandable.ViewMode;

class cw extends gw {
    final /* synthetic */ cr a;
    final /* synthetic */ ct c;

    cw(ct ctVar, cr crVar) {
        this.c = ctVar;
        this.a = crVar;
    }

    public /* synthetic */ Object d(int i) {
        return h(i);
    }

    public View a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc(this.c.getContext());
        ccVar.a(f.personal__no_message_icon);
        ccVar.b(j.personal__message_empty_view__no_notification);
        ccVar.c(j.personal__message_empty_view__no_notification_description);
        return ccVar.a();
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.c.getContext()).inflate(h.personal__message_push_item_view, viewGroup, false);
        }
        q h = h(i);
        View findViewById = view.findViewById(g.personal__message_push_item_view__state);
        TextView textView = (TextView) view.findViewById(g.personal__message_push_item_view__pub_time);
        TextView textView2 = (TextView) view.findViewById(g.personal__message_push_item_view__name);
        TextView textView3 = (TextView) view.findViewById(g.personal__message_push_item_view__desc);
        if (h.b != null) {
            DkCloudPushMessage dkCloudPushMessage = h.b;
            if (TextUtils.isEmpty(dkCloudPushMessage.getMessageTitle())) {
                textView2.setText(j.personal__message_push_item_view__name);
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
            textView.setText(ReaderUi.a(this.c.getContext(), dkCloudPushMessage.getReceivedDate().getTime()));
            textView3.setText(dkCloudPushMessage.getMessageContent());
        } else {
            textView2.setText(j.personal__message_push_item_view__name);
            k kVar = h.a;
            findViewById.setEnabled(true);
            textView3.setText(kVar.e);
            textView.setText(ReaderUi.a(view.getContext(), kVar.c() * 1000));
        }
        CheckBox checkBox = (CheckBox) view.findViewById(g.personal__message_push_item_view__checkbox);
        if (f() == ViewMode.Edit) {
            checkBox.setVisibility(0);
            checkBox.setChecked(b(0, i));
        } else {
            checkBox.setVisibility(8);
        }
        return view;
    }

    public int c() {
        return this.c.a.b.size();
    }

    public q h(int i) {
        return (q) this.c.a.b.get(i);
    }

    protected int k() {
        return 1;
    }

    protected int f(int i) {
        return c();
    }

    protected boolean e() {
        this.c.a(0, 0);
        return true;
    }

    protected void e(int i) {
        long j;
        int i2 = 0;
        if (this.c.a.b.size() > 0) {
            int size = this.c.a.b.size() - 1;
            j = 0;
            while (size >= 0) {
                int i3;
                DkCloudPushMessage dkCloudPushMessage = ((q) this.c.a.b.get(size)).b;
                if (j == 0 && dkCloudPushMessage != null) {
                    j = dkCloudPushMessage.getReceivedDate().getTime();
                }
                if (((q) this.c.a.b.get(size)).a != null) {
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
        this.c.a(i2, j);
    }

    protected void b() {
    }
}
