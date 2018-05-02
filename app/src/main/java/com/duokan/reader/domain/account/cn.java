package com.duokan.reader.domain.account;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserType;

public class cn {
    /* renamed from: a */
    public static boolean m3451a() {
        return PersonalPrefs.m5175a().m5210b() == UserType.PUBLICATIONS.ordinal() + 1;
    }

    /* renamed from: b */
    public static boolean m3452b() {
        return ReaderEnv.get().isFreshInstall() && PersonalPrefs.m5175a().m5229g() == -1;
    }
}
