package com.duokan.reader.common.webservices.duokan;

import com.duokan.reader.domain.account.User;

import java.io.Serializable;

public class FavBookListInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String mBookCover = "";
    public String mBookListId = "";
    public int mCommentCount = 0;
    public String mCover = "";
    public long mCreateTime = 0;
    public String mCreator = "";
    public String mCreatorName = "";
    public String mCreatorPic = "";
    public int mFavCount = 0;
    public long mFavTime = 0;
    public String mSummary = "";
    public String mTitle = "";
    public User mUser = new User();
}
