package com.duokan.reader.common.webservices.duokan;

import org.json.JSONArray;

public class DkStoreSpecialEventInfo extends DkStoreItemInfo {
    public long mClientTime = 0;
    public long mEndTime = 0;
    public String mEventName = null;
    public SpecialEventType mEventType = SpecialEventType.UNKNOWN;
    public long mServerTime = 0;
    public long mStartTime = 0;
    public JSONArray mStrategy = null;

    public enum SpecialEventType {
        FULL_CUT,
        UNKNOWN
    }
}
