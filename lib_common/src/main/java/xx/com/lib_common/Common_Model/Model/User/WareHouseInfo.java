package xx.com.lib_common.Common_Model.Model.User;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GHOST on 2017/2/6.
 */

public class WareHouseInfo implements Parcelable {
    private String WareHouseNo;
    private String WareHouseName;
    private int WareHouseType;
    private String ContactUser;
    private String ContactPhone;
    private int HouseCount;
    private int HouseUsingCount;
    private String Address;
    private String LocationDesc;
    private int WareHouseStatus;
    private Float IsDel;
    private String HouseNo;
    private String HouseName;
    private boolean BIsLock;
    private boolean BIsChecked;
    private String StrWarehouseType;
    private String StrWarehouseStatus;
    private int AreaCount;
    private int AreaUsingCount;
    private Float HouseRate;
    private Float AreaRate;
    private int PickRule;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Float getIsDel() {
        return IsDel;
    }

    public void setIsDel(Float isDel) {
        IsDel = isDel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAreaCount() {
        return AreaCount;
    }

    public void setAreaCount(int areaCount) {
        AreaCount = areaCount;
    }

    public Float getAreaRate() {
        return AreaRate;
    }

    public void setAreaRate(Float areaRate) {
        AreaRate = areaRate;
    }

    public int getAreaUsingCount() {
        return AreaUsingCount;
    }

    public void setAreaUsingCount(int areaUsingCount) {
        AreaUsingCount = areaUsingCount;
    }

    public boolean isBIsChecked() {
        return BIsChecked;
    }

    public void setBIsChecked(boolean BIsChecked) {
        this.BIsChecked = BIsChecked;
    }

    public boolean isBIsLock() {
        return BIsLock;
    }

    public void setBIsLock(boolean BIsLock) {
        this.BIsLock = BIsLock;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        ContactPhone = contactPhone;
    }

    public String getContactUser() {
        return ContactUser;
    }

    public void setContactUser(String contactUser) {
        ContactUser = contactUser;
    }

    public int getHouseCount() {
        return HouseCount;
    }

    public void setHouseCount(int houseCount) {
        HouseCount = houseCount;
    }

    public String getHouseName() {
        return HouseName;
    }

    public void setHouseName(String houseName) {
        HouseName = houseName;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String houseNo) {
        HouseNo = houseNo;
    }

    public Float getHouseRate() {
        return HouseRate;
    }

    public void setHouseRate(Float houseRate) {
        HouseRate = houseRate;
    }

    public int getHouseUsingCount() {
        return HouseUsingCount;
    }

    public void setHouseUsingCount(int houseUsingCount) {
        HouseUsingCount = houseUsingCount;
    }

    public String getLocationDesc() {
        return LocationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        LocationDesc = locationDesc;
    }

    public int getPickRule() {
        return PickRule;
    }

    public void setPickRule(int pickRule) {
        PickRule = pickRule;
    }

    public String getStrWarehouseStatus() {
        return StrWarehouseStatus;
    }

    public void setStrWarehouseStatus(String strWarehouseStatus) {
        StrWarehouseStatus = strWarehouseStatus;
    }

    public String getStrWarehouseType() {
        return StrWarehouseType;
    }

    public void setStrWarehouseType(String strWarehouseType) {
        StrWarehouseType = strWarehouseType;
    }

    public String getWareHouseName() {
        return WareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        WareHouseName = wareHouseName;
    }

    public String getWareHouseNo() {
        return WareHouseNo;
    }

    public void setWareHouseNo(String wareHouseNo) {
        WareHouseNo = wareHouseNo;
    }

    public int getWareHouseStatus() {
        return WareHouseStatus;
    }

    public void setWareHouseStatus(int wareHouseStatus) {
        WareHouseStatus = wareHouseStatus;
    }

    public int getWareHouseType() {
        return WareHouseType;
    }

    public void setWareHouseType(int wareHouseType) {
        WareHouseType = wareHouseType;
    }

    public WareHouseInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.WareHouseNo);
        dest.writeString(this.WareHouseName);
        dest.writeInt(this.WareHouseType);
        dest.writeString(this.ContactUser);
        dest.writeString(this.ContactPhone);
        dest.writeInt(this.HouseCount);
        dest.writeInt(this.HouseUsingCount);
        dest.writeString(this.Address);
        dest.writeString(this.LocationDesc);
        dest.writeInt(this.WareHouseStatus);
        dest.writeValue(this.IsDel);
        dest.writeString(this.HouseNo);
        dest.writeString(this.HouseName);
        dest.writeByte(this.BIsLock ? (byte) 1 : (byte) 0);
        dest.writeByte(this.BIsChecked ? (byte) 1 : (byte) 0);
        dest.writeString(this.StrWarehouseType);
        dest.writeString(this.StrWarehouseStatus);
        dest.writeInt(this.AreaCount);
        dest.writeInt(this.AreaUsingCount);
        dest.writeValue(this.HouseRate);
        dest.writeValue(this.AreaRate);
        dest.writeInt(this.PickRule);
        dest.writeInt(this.ID);
    }

    protected WareHouseInfo(Parcel in) {
        this.WareHouseNo = in.readString();
        this.WareHouseName = in.readString();
        this.WareHouseType = in.readInt();
        this.ContactUser = in.readString();
        this.ContactPhone = in.readString();
        this.HouseCount = in.readInt();
        this.HouseUsingCount = in.readInt();
        this.Address = in.readString();
        this.LocationDesc = in.readString();
        this.WareHouseStatus = in.readInt();
        this.IsDel = (Float) in.readValue(Float.class.getClassLoader());
        this.HouseNo = in.readString();
        this.HouseName = in.readString();
        this.BIsLock = in.readByte() != 0;
        this.BIsChecked = in.readByte() != 0;
        this.StrWarehouseType = in.readString();
        this.StrWarehouseStatus = in.readString();
        this.AreaCount = in.readInt();
        this.AreaUsingCount = in.readInt();
        this.HouseRate = (Float) in.readValue(Float.class.getClassLoader());
        this.AreaRate = (Float) in.readValue(Float.class.getClassLoader());
        this.PickRule = in.readInt();
        this.ID = in.readInt();
    }

    public static final Creator<WareHouseInfo> CREATOR = new Creator<WareHouseInfo>() {
        @Override
        public WareHouseInfo createFromParcel(Parcel source) {
            return new WareHouseInfo(source);
        }

        @Override
        public WareHouseInfo[] newArray(int size) {
            return new WareHouseInfo[size];
        }
    };
}
