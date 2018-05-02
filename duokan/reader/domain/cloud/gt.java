package com.duokan.reader.domain.cloud;

import android.util.Pair;

import com.duokan.reader.domain.cloud.PersonalPrefs.UserTab;

import java.util.Comparator;

class gt implements Comparator {
    final /* synthetic */ PersonalPrefs a;

    gt(PersonalPrefs personalPrefs) {
        this.a = personalPrefs;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Pair) obj, (Pair) obj2);
    }

    public int a(Pair pair, Pair pair2) {
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
