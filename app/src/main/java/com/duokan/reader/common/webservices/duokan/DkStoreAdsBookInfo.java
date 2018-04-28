package com.duokan.reader.common.webservices.duokan;

import org.apache.http.HttpStatus;

public class DkStoreAdsBookInfo extends DkStoreItemInfo {
    public static final String KEYWORD_BOOK_DEPARTMENT = "v2_b_department";
    public static final String KEYWORD_BOOK_LIST = "v3_b_r_l";
    public static final String KEYWORD_BOOK_RANKING_TITLE = "v2_b_ranking_title";
    public static final String KEYWORD_BOOK_RECOMMEND = "v2_b_recommend";
    public static final String KEYWORD_BOOK_SHELF = "v2_s_broadcast";
    public static final String KEYWORD_BOOK_SPECIAL = "v2_b_special";
    public static final String KEYWORD_DF_CHOICE_RECOMMEND_BOY = "df_choice_recommend_boy";
    public static final String KEYWORD_DF_CHOICE_RECOMMEND_FINISHED = "df_choice_recommend_finished";
    public static final String KEYWORD_DF_CHOICE_RECOMMEND_GIRL = "df_choice_recommend_girl";
    public static final String KEYWORD_DF_CHOICE_RECOMMEND_LIST = "df_choice_recommend_list";
    public static final String KEYWORD_DF_CHOICE_RECOMMEND_LIST_MORE = "df_choice_recommend_list_more";
    public static final String KEYWORD_DF_CHOICE_RECOMMEND_TOP = "df_choice_recommend_top";
    public static final String KEYWORD_FICTION_BOY = "v2_f_boy";
    public static final String KEYWORD_FICTION_DEPARTMENT = "v2_f_department";
    public static final String KEYWORD_FICTION_GIRL = "v2_f_girl";
    public static final String KEYWORD_FICTION_RANKING_TITLE = "v2_f_ranking_title";
    public static final String KEYWORD_FICTION_RECOMMEND = "v2_f_recommend";
    public static final String KEYWORD_HD_BOOK_LIST = "v3_b_r_l_hd";
    public static final String KEYWORD_HD_BOOK_SHELF = "dkhd_shelf_broadcast";
    public static final String KEYWORD_HD_RECOMMEND_ADS = "dkhd_book_recommend_ads";
    public static final String KEYWORD_HD_RECOMMEND_GALLERY = "dkhd_book_recommend_gallery";
    public static final String KEYWORD_HD_SALES_ADS = "dkhd_book_special_ads";
    public static final String KEYWORD_HD_SPECIAL_GALLERY = "dkhd_book_special_gallery";
    public String mBookUuid = null;
    public String mCoverUri = null;
    public String mDescription = null;
    public int mHeight;
    public String mKeyWord = null;
    public int mPriority;
    public long mSize;
    public String mTitle = null;
    public AdsType mType;
    public boolean mUseAdsTitle = true;
    public int mWidth;

    public enum AdsType {
        CLIENT_DEFINE(0),
        BOOK_INFO(1),
        BOOK_TOPIC(2),
        WEBSIZE(3),
        PUBLISHER(4),
        FICTION_INFO(100),
        FICTION_TOPIC(HttpStatus.SC_SWITCHING_PROTOCOLS);
        
        private int mTypeValue;

        private AdsType(int i) {
            this.mTypeValue = i;
        }

        public static AdsType valueOf(int i) {
            switch (i) {
                case 1:
                    return BOOK_INFO;
                case 2:
                    return BOOK_TOPIC;
                case 3:
                    return WEBSIZE;
                case 4:
                    return PUBLISHER;
                case HttpStatus.SC_CONTINUE /*100*/:
                    return FICTION_INFO;
                case HttpStatus.SC_SWITCHING_PROTOCOLS /*101*/:
                    return FICTION_TOPIC;
                default:
                    return CLIENT_DEFINE;
            }
        }

        public int value() {
            return this.mTypeValue;
        }
    }
}
