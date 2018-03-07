package xx.com.lib_common.Common_Model.Model.User;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GHOST on 2017/2/6.
 */

public class UserGroupInfo implements Parcelable {
    private String UserGroupNo;
    private String UserGroupName;
    private String UserGroupAbbname;
    private int UserGroupType;
    private int UserGroupStatus;
    private String Description;
    private Float IsDel;
    private String StrUserGroupType;
    private String StrUserGroupStatus;
    private boolean BIsChecked;

    public boolean isBIsChecked() {
        return BIsChecked;
    }

    public void setBIsChecked(boolean BIsChecked) {
        this.BIsChecked = BIsChecked;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Float getIsDel() {
        return IsDel;
    }

    public void setIsDel(Float isDel) {
        IsDel = isDel;
    }

    public String getStrUserGroupStatus() {
        return StrUserGroupStatus;
    }

    public void setStrUserGroupStatus(String strUserGroupStatus) {
        StrUserGroupStatus = strUserGroupStatus;
    }

    public String getStrUserGroupType() {
        return StrUserGroupType;
    }

    public void setStrUserGroupType(String strUserGroupType) {
        StrUserGroupType = strUserGroupType;
    }

    public String getUserGroupAbbname() {
        return UserGroupAbbname;
    }

    public void setUserGroupAbbname(String userGroupAbbname) {
        UserGroupAbbname = userGroupAbbname;
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        UserGroupName = userGroupName;
    }

    public String getUserGroupNo() {
        return UserGroupNo;
    }

    public void setUserGroupNo(String userGroupNo) {
        UserGroupNo = userGroupNo;
    }

    public int getUserGroupStatus() {
        return UserGroupStatus;
    }

    public void setUserGroupStatus(int userGroupStatus) {
        UserGroupStatus = userGroupStatus;
    }

    public int getUserGroupType() {
        return UserGroupType;
    }

    public void setUserGroupType(int userGroupType) {
        UserGroupType = userGroupType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.UserGroupNo);
        dest.writeString(this.UserGroupName);
        dest.writeString(this.UserGroupAbbname);
        dest.writeInt(this.UserGroupType);
        dest.writeInt(this.UserGroupStatus);
        dest.writeString(this.Description);
        dest.writeValue(this.IsDel);
        dest.writeString(this.StrUserGroupType);
        dest.writeString(this.StrUserGroupStatus);
        dest.writeByte(this.BIsChecked ? (byte) 1 : (byte) 0);
    }

    public UserGroupInfo() {
    }

    protected UserGroupInfo(Parcel in) {
        this.UserGroupNo = in.readString();
        this.UserGroupName = in.readString();
        this.UserGroupAbbname = in.readString();
        this.UserGroupType = in.readInt();
        this.UserGroupStatus = in.readInt();
        this.Description = in.readString();
        this.IsDel = (Float) in.readValue(Float.class.getClassLoader());
        this.StrUserGroupType = in.readString();
        this.StrUserGroupStatus = in.readString();
        this.BIsChecked = in.readByte() != 0;
    }

    public static final Creator<UserGroupInfo> CREATOR = new Creator<UserGroupInfo>() {
        @Override
        public UserGroupInfo createFromParcel(Parcel source) {
            return new UserGroupInfo(source);
        }

        @Override
        public UserGroupInfo[] newArray(int size) {
            return new UserGroupInfo[size];
        }
    };
}
