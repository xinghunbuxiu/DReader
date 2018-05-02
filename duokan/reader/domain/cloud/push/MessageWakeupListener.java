package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;

public interface MessageWakeupListener {

    public enum MessageSubType {
        MESSAGE_LOOPER,
        BBS_FEEDBACK,
        USER_TASK,
        FICTION_UPDATE,
        RESIGN_SUCCEED,
        RECHARGE_SUCCEED;

        static MessageSubType value(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.equals(str, "20")) {
                return MESSAGE_LOOPER;
            }
            if (TextUtils.equals(str, "21")) {
                return BBS_FEEDBACK;
            }
            if (TextUtils.equals(str, "22")) {
                return USER_TASK;
            }
            if (TextUtils.equals(str, "23")) {
                return RESIGN_SUCCEED;
            }
            if (TextUtils.equals(str, "24")) {
                return RECHARGE_SUCCEED;
            }
            return null;
        }
    }

    void a(MessageSubType messageSubType, Object obj, boolean z);
}
