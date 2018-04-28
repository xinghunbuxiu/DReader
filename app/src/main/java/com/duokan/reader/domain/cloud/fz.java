package com.duokan.reader.domain.cloud;

import android.util.Pair;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserTab;
import java.util.Comparator;

class fz implements Comparator<Pair<UserTab, Double>> {
    /* renamed from: a */
    final /* synthetic */ PersonalPrefs f4026a;

    fz(PersonalPrefs personalPrefs) {
        this.f4026a = personalPrefs;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5588a((Pair) obj, (Pair) obj2);
    }

    /* renamed from: a */
    public int m5588a(Pair<UserTab, Double> pair, Pair<UserTab, Double> pair2) {
        if (((Double) pair.second).doubleValue() > ((Double) pair2.second).doubleValue()) {
            return -1;
        }
        if (((Double) pair.second).doubleValue() < ((Double) pair2.second).doubleValue()) {
            return 1;
        }
        if (((UserTab) pair.first).equals(UserTab.SERIAL)) {
            return -1;
        }
        if (((UserTab) pair.first).equals(UserTab.PUB) && ((UserTab) pair2.first).equals(UserTab.COMIC)) {
            return -1;
        }
        return 1;
    }
}
