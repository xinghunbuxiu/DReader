package com.duokan.reader.domain.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class SystemAccountLogoutReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getIntExtra("extra_update_type", -1) == 1 && i.f() != null) {
                PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
                if (personalAccount != null && !personalAccount.i() && personalAccount.e().equals(AccountType.XIAO_MI) && TextUtils.isEmpty(((bh) personalAccount.f()).a)) {
                    personalAccount.a(new cd(this));
                }
            }
        } catch (Throwable th) {
        }
    }
}
