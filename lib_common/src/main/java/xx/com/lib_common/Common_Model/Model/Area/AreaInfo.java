package xx.com.lib_common.Common_Model.Model.Area;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GHOST on 2018/3/15.
 */

public class AreaInfo implements Parcelable{

    public String WarehouseNo ;
    public String HouseNo;
    private String AreaNo;
    private String AreaName;
    private String AreaType;
    private int WarehouseID;
    private int HouseID;
    private int ID;
    private int IsQuality;

    public String getWarehouseNo() {
        return WarehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        WarehouseNo = warehouseNo;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String houseNo) {
        HouseNo = houseNo;
    }

    public String getAreaNo() {
        return AreaNo;
    }

    public void setAreaNo(String areaNo) {
        AreaNo = areaNo;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public String getAreaType() {
        return AreaType;
    }

    public void setAreaType(String areaType) {
        AreaType = areaType;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        WarehouseID = warehouseID;
    }

    public int getHouseID() {
        return HouseID;
    }

    public void setHouseID(int houseID) {
        HouseID = houseID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(int isQuality) {
        IsQuality = isQuality;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.WarehouseNo);
        dest.writeString(this.HouseNo);
        dest.writeString(this.AreaNo);
        dest.writeString(this.AreaName);
        dest.writeString(this.AreaType);
        dest.writeInt(this.WarehouseID);
        dest.writeInt(this.HouseID);
        dest.writeInt(this.ID);
        dest.writeInt(this.IsQuality);
    }

    public AreaInfo() {
    }

    protected AreaInfo(Parcel in) {
        this.WarehouseNo = in.readString();
        this.HouseNo = in.readString();
        this.AreaNo = in.readString();
        this.AreaName = in.readString();
        this.AreaType = in.readString();
        this.WarehouseID = in.readInt();
        this.HouseID = in.readInt();
        this.ID = in.readInt();
        this.IsQuality = in.readInt();
    }

    public static final Creator<AreaInfo> CREATOR = new Creator<AreaInfo>() {
        @Override
        public AreaInfo createFromParcel(Parcel source) {
            return new AreaInfo(source);
        }

        @Override
        public AreaInfo[] newArray(int size) {
            return new AreaInfo[size];
        }
    };
}
