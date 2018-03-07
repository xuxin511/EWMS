package xx.com.lib_common.Common_Model.Model.User;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by GHOST on 2018/3/5.
 */

public class UserModel extends User implements Parcelable{
    private boolean BIsAdmin;
    private String StrIsAdmin;
    private int IsOnline;
    private boolean BIsOnline;
    private String WarehouseName;
    private String StrUserType;
    private String StrUserStatus;
    private String StrSex;
    private String ReceiveWareHouseNo;
    private String ReceiveAreaNo;
    private String ToSampWareHouseNo;
    private String ToSampAreaNo;
    private String PickWareHouseNo ;
    private String ErpVoucherNo;



    public String getErpVoucherNo() {
        return ErpVoucherNo;
    }

    public void setErpVoucherNo(String erpVoucherNo) {
        ErpVoucherNo = erpVoucherNo;
    }

    public String getQuanUserName() {
        return QuanUserName;
    }

    public void setQuanUserName(String quanUserName) {
        QuanUserName = quanUserName;
    }

    private String PickAreaNo;
    private String QuanUserName;

    private List<UserGroupInfo> lstUserGroup;
    private List<MenuInfo> lstMenu;
    private List<WareHouseInfo> lstWarehouse;
    private List<QuanUserModel> lstQuanUser;
    /// <summary>
    /// 取样人编号
    /// </summary>
    private String QuanUserNo;

    public String getPickWareHouseNo() {
        return PickWareHouseNo;
    }

    public void setPickWareHouseNo(String pickWareHouseNo) {
        PickWareHouseNo = pickWareHouseNo;
    }

    public String getPickAreaNo() {
        return PickAreaNo;
    }

    public void setPickAreaNo(String pickAreaNo) {
        PickAreaNo = pickAreaNo;
    }

    public String getToSampWareHouseNo() {
        return ToSampWareHouseNo;
    }

    public void setToSampWareHouseNo(String toSampWareHouseNo) {
        ToSampWareHouseNo = toSampWareHouseNo;
    }

    public List<QuanUserModel> getLstQuanUser() {
        return lstQuanUser;
    }

    public void setLstQuanUser(List<QuanUserModel> lstQuanUser) {
        this.lstQuanUser = lstQuanUser;
    }

    public String getToSampAreaNo() {
        return ToSampAreaNo;
    }

    public void setToSampAreaNo(String toSampAreaNo) {
        ToSampAreaNo = toSampAreaNo;
    }

    public String getQuanUserNo() {
        return QuanUserNo;
    }

    public void setQuanUserNo(String quanUserNo) {
        QuanUserNo = quanUserNo;
    }

    public String getReceiveWareHouseNo() {
        return ReceiveWareHouseNo;
    }

    public void setReceiveWareHouseNo(String receiveWareHouseNo) {
        ReceiveWareHouseNo = receiveWareHouseNo;
    }

    public String getReceiveAreaNo() {
        return ReceiveAreaNo;
    }

    public void setReceiveAreaNo(String receiveAreaNo) {
        ReceiveAreaNo = receiveAreaNo;
    }

    public boolean isBIsAdmin() {
        return BIsAdmin;
    }

    public void setBIsAdmin(boolean BIsAdmin) {
        this.BIsAdmin = BIsAdmin;
    }

    public boolean isBIsOnline() {
        return BIsOnline;
    }

    public void setBIsOnline(boolean BIsOnline) {
        this.BIsOnline = BIsOnline;
    }

    public int getIsOnline() {
        return IsOnline;
    }

    public void setIsOnline(int isOnline) {
        IsOnline = isOnline;
    }

    public List<MenuInfo> getLstMenu() {
        return lstMenu;
    }

    public void setLstMenu(List<MenuInfo> lstMenu) {
        this.lstMenu = lstMenu;
    }

    public List<UserGroupInfo> getLstUserGroup() {
        return lstUserGroup;
    }

    public void setLstUserGroup(List<UserGroupInfo> lstUserGroup) {
        this.lstUserGroup = lstUserGroup;
    }

    public List<WareHouseInfo> getLstWarehouse() {
        return lstWarehouse;
    }

    public void setLstWarehouse(List<WareHouseInfo> lstWarehouse) {
        this.lstWarehouse = lstWarehouse;
    }

    public String getStrIsAdmin() {
        return StrIsAdmin;
    }

    public void setStrIsAdmin(String strIsAdmin) {
        StrIsAdmin = strIsAdmin;
    }

    public String getStrSex() {
        return StrSex;
    }

    public void setStrSex(String strSex) {
        StrSex = strSex;
    }

    public String getStrUserStatus() {
        return StrUserStatus;
    }

    public void setStrUserStatus(String strUserStatus) {
        StrUserStatus = strUserStatus;
    }

    public String getStrUserType() {
        return StrUserType;
    }

    public void setStrUserType(String strUserType) {
        StrUserType = strUserType;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        WarehouseName = warehouseName;
    }


    public UserModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeByte(this.BIsAdmin ? (byte) 1 : (byte) 0);
        dest.writeString(this.StrIsAdmin);
        dest.writeInt(this.IsOnline);
        dest.writeByte(this.BIsOnline ? (byte) 1 : (byte) 0);
        dest.writeString(this.WarehouseName);
        dest.writeString(this.StrUserType);
        dest.writeString(this.StrUserStatus);
        dest.writeString(this.StrSex);
        dest.writeString(this.ReceiveWareHouseNo);
        dest.writeString(this.ReceiveAreaNo);
        dest.writeString(this.ToSampWareHouseNo);
        dest.writeString(this.ToSampAreaNo);
        dest.writeString(this.PickWareHouseNo);
        dest.writeString(this.ErpVoucherNo);
        dest.writeString(this.PickAreaNo);
        dest.writeString(this.QuanUserName);
        dest.writeTypedList(this.lstUserGroup);
        dest.writeTypedList(this.lstMenu);
        dest.writeTypedList(this.lstWarehouse);
        dest.writeTypedList(this.lstQuanUser);
        dest.writeString(this.QuanUserNo);
    }

    protected UserModel(Parcel in) {
        super(in);
        this.BIsAdmin = in.readByte() != 0;
        this.StrIsAdmin = in.readString();
        this.IsOnline = in.readInt();
        this.BIsOnline = in.readByte() != 0;
        this.WarehouseName = in.readString();
        this.StrUserType = in.readString();
        this.StrUserStatus = in.readString();
        this.StrSex = in.readString();
        this.ReceiveWareHouseNo = in.readString();
        this.ReceiveAreaNo = in.readString();
        this.ToSampWareHouseNo = in.readString();
        this.ToSampAreaNo = in.readString();
        this.PickWareHouseNo = in.readString();
        this.ErpVoucherNo = in.readString();
        this.PickAreaNo = in.readString();
        this.QuanUserName = in.readString();
        this.lstUserGroup = in.createTypedArrayList(UserGroupInfo.CREATOR);
        this.lstMenu = in.createTypedArrayList(MenuInfo.CREATOR);
        this.lstWarehouse = in.createTypedArrayList(WareHouseInfo.CREATOR);
        this.lstQuanUser = in.createTypedArrayList(QuanUserModel.CREATOR);
        this.QuanUserNo = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
