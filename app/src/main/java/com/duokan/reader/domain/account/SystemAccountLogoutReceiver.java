package com.duokan.reader.domain.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class SystemAccountLogoutReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getIntExtra("extra_update_type", -1) == 1 && C0709k.m3476a() != null) {
                PersonalAccount personalAccount = (PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class);
                if (personalAccount != null && !personalAccount.mo839i() && personalAccount.mo835e().equals(AccountType.XIAO_MI) && TextUtils.isEmpty(((bd) personalAccount.mo836f()).f2401a)) {
                    personalAccount.mo830a(new ce(this));
                }
            }
        } catch (Throwable th) {
        }
    }
}
