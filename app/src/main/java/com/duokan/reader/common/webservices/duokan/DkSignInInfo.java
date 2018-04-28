package com.duokan.reader.common.webservices.duokan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DkSignInInfo implements Serializable {
    public boolean mHasPhysical = false;
    public boolean mLottery = false;
    public List<DkSignInReward> mReward = new ArrayList();
    public boolean[] mSignStatus = new boolean[]{false, false, false, false, false, false, false};
    public int mToday = 1;
}
