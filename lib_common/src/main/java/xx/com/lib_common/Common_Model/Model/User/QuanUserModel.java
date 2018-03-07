package xx.com.lib_common.Common_Model.Model.User;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GHOST on 2017/8/28.
 */

public class QuanUserModel implements Parcelable {

    public String QuanUserNo;

    public String QuanUserName;

    public String getQuanUserNo() {
        return QuanUserNo;
    }

    public void setQuanUserNo(String quanUserNo) {
        QuanUserNo = quanUserNo;
    }

    public String getQuanUserName() {
        return QuanUserName;
    }

    public void setQuanUserName(String quanUserName) {
        QuanUserName = quanUserName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.QuanUserNo);
        dest.writeString(this.QuanUserName);
    }

    public QuanUserModel() {
    }

    protected QuanUserModel(Parcel in) {
        this.QuanUserNo = in.readString();
        this.QuanUserName = in.readString();
    }

    public static final Creator<QuanUserModel> CREATOR = new Creator<QuanUserModel>() {
        @Override
        public QuanUserModel createFromParcel(Parcel source) {
            return new QuanUserModel(source);
        }

        @Override
        public QuanUserModel[] newArray(int size) {
            return new QuanUserModel[size];
        }
    };
}
