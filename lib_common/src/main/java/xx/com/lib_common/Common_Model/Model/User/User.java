package xx.com.lib_common.Common_Model.Model.User;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.Date;

/**
 * Created by GHOST on 201/3/5.
 */

public class User implements Parcelable {
    private int ID;
    private String UserNo;
    private String UserName;
    private String PassWord;
    private int UserType;
    private String PinYin;
    private String Duty;
    private String Tel;
    private String Mobile;
    private String Email;
    private int Sex;
    private int IsPick;
    private int IsReceive;
    private int IsQuality;
    private int UserStatus;
    private String Address;
    private String GroupCode;
    private int WarehouseID;
    private String WarehouseCode;
    private String Description;
    private String LoginIP;
    private Date LoginTime;
    private Float IsDel;
    private String LoginDevice;
    private String Deviceversion;
    private String StrIsPick;
    private String StrIsReceive;
    private String GroupName;
    private int ReceiveHouseID;
    private int ReceiveAreaID;
    private int PickHouseID;
    private int PickAreaID;
    private int IsPickLeader;
    private String StrIsPickLeader;
    private Boolean PickLeader;
    private int PickWareHouseID;
    private String PDAPrintIP;

    public  Boolean CheckUserAndPass(){
        if(TextUtils.isEmpty(UserNo) || TextUtils.isEmpty(PassWord)){
            return false;
        }
        return true;
    }

    public int getPickWareHouseID() {
        return PickWareHouseID;
    }

    public void setPickWareHouseID(int pickWareHouseID) {
        PickWareHouseID = pickWareHouseID;
    }

    public String getPDAPrintIP() {
        return PDAPrintIP;
    }

    public void setPDAPrintIP(String PDAPrintIP) {
        this.PDAPrintIP = PDAPrintIP;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIsPickLeader() {
        return IsPickLeader;
    }

    public void setIsPickLeader(int isPickLeader) {
        IsPickLeader = isPickLeader;
    }

    public String getStrIsPickLeader() {
        return StrIsPickLeader;
    }

    public void setStrIsPickLeader(String strIsPickLeader) {
        StrIsPickLeader = strIsPickLeader;
    }

    public Boolean getPickLeader() {
        return PickLeader;
    }

    public void setPickLeader(Boolean pickLeader) {
        PickLeader = pickLeader;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        WarehouseID = warehouseID;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDeviceversion() {
        return Deviceversion;
    }

    public void setDeviceversion(String deviceversion) {
        Deviceversion = deviceversion;
    }

    public String getDuty() {
        return Duty;
    }

    public void setDuty(String duty) {
        Duty = duty;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String groupCode) {
        GroupCode = groupCode;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public Float getIsDel() {
        return IsDel;
    }

    public void setIsDel(Float isDel) {
        IsDel = isDel;
    }

    public int getIsPick() {
        return IsPick;
    }

    public void setIsPick(int isPick) {
        IsPick = isPick;
    }

    public int getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(int isQuality) {
        IsQuality = isQuality;
    }

    public int getIsReceive() {
        return IsReceive;
    }

    public void setIsReceive(int isReceive) {
        IsReceive = isReceive;
    }

    public String getLoginDevice() {
        return LoginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        LoginDevice = loginDevice;
    }

    public String getLoginIP() {
        return LoginIP;
    }

    public void setLoginIP(String loginIP) {
        LoginIP = loginIP;
    }

    public Date getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Date loginTime) {
        LoginTime = loginTime;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPinYin() {
        return PinYin;
    }

    public void setPinYin(String pinYin) {
        PinYin = pinYin;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public String getStrIsPick() {
        return StrIsPick;
    }

    public void setStrIsPick(String strIsPick) {
        StrIsPick = strIsPick;
    }

    public String getStrIsReceive() {
        return StrIsReceive;
    }

    public void setStrIsReceive(String strIsReceive) {
        StrIsReceive = strIsReceive;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserNo() {
        return UserNo;
    }

    public void setUserNo(String userNo) {
        UserNo = userNo;
    }

    public int getUserStatus() {
        return UserStatus;
    }

    public void setUserStatus(int userStatus) {
        UserStatus = userStatus;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int userType) {
        UserType = userType;
    }

    public String getWarehouseCode() {
        return WarehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        WarehouseCode = warehouseCode;
    }

    public int getPickAreaID() {
        return PickAreaID;
    }

    public void setPickAreaID(int pickAreaID) {
        PickAreaID = pickAreaID;
    }

    public int getPickHouseID() {
        return PickHouseID;
    }

    public void setPickHouseID(int pickHouseID) {
        PickHouseID = pickHouseID;
    }

    public int getReceiveAreaID() {
        return ReceiveAreaID;
    }

    public void setReceiveAreaID(int receiveAreaID) {
        ReceiveAreaID = receiveAreaID;
    }

    public int getReceiveHouseID() {
        return ReceiveHouseID;
    }

    public void setReceiveHouseID(int receiveHouseID) {
        ReceiveHouseID = receiveHouseID;
    }


    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeString(this.UserNo);
        dest.writeString(this.UserName);
        dest.writeString(this.PassWord);
        dest.writeInt(this.UserType);
        dest.writeString(this.PinYin);
        dest.writeString(this.Duty);
        dest.writeString(this.Tel);
        dest.writeString(this.Mobile);
        dest.writeString(this.Email);
        dest.writeInt(this.Sex);
        dest.writeInt(this.IsPick);
        dest.writeInt(this.IsReceive);
        dest.writeInt(this.IsQuality);
        dest.writeInt(this.UserStatus);
        dest.writeString(this.Address);
        dest.writeString(this.GroupCode);
        dest.writeInt(this.WarehouseID);
        dest.writeString(this.WarehouseCode);
        dest.writeString(this.Description);
        dest.writeString(this.LoginIP);
        dest.writeLong(this.LoginTime != null ? this.LoginTime.getTime() : -1);
        dest.writeValue(this.IsDel);
        dest.writeString(this.LoginDevice);
        dest.writeString(this.Deviceversion);
        dest.writeString(this.StrIsPick);
        dest.writeString(this.StrIsReceive);
        dest.writeString(this.GroupName);
        dest.writeInt(this.ReceiveHouseID);
        dest.writeInt(this.ReceiveAreaID);
        dest.writeInt(this.PickHouseID);
        dest.writeInt(this.PickAreaID);
        dest.writeInt(this.IsPickLeader);
        dest.writeString(this.StrIsPickLeader);
        dest.writeValue(this.PickLeader);
        dest.writeInt(this.PickWareHouseID);
        dest.writeString(this.PDAPrintIP);
    }

    protected User(Parcel in) {
        this.ID = in.readInt();
        this.UserNo = in.readString();
        this.UserName = in.readString();
        this.PassWord = in.readString();
        this.UserType = in.readInt();
        this.PinYin = in.readString();
        this.Duty = in.readString();
        this.Tel = in.readString();
        this.Mobile = in.readString();
        this.Email = in.readString();
        this.Sex = in.readInt();
        this.IsPick = in.readInt();
        this.IsReceive = in.readInt();
        this.IsQuality = in.readInt();
        this.UserStatus = in.readInt();
        this.Address = in.readString();
        this.GroupCode = in.readString();
        this.WarehouseID = in.readInt();
        this.WarehouseCode = in.readString();
        this.Description = in.readString();
        this.LoginIP = in.readString();
        long tmpLoginTime = in.readLong();
        this.LoginTime = tmpLoginTime == -1 ? null : new Date(tmpLoginTime);
        this.IsDel = (Float) in.readValue(Float.class.getClassLoader());
        this.LoginDevice = in.readString();
        this.Deviceversion = in.readString();
        this.StrIsPick = in.readString();
        this.StrIsReceive = in.readString();
        this.GroupName = in.readString();
        this.ReceiveHouseID = in.readInt();
        this.ReceiveAreaID = in.readInt();
        this.PickHouseID = in.readInt();
        this.PickAreaID = in.readInt();
        this.IsPickLeader = in.readInt();
        this.StrIsPickLeader = in.readString();
        this.PickLeader = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.PickWareHouseID = in.readInt();
        this.PDAPrintIP = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
