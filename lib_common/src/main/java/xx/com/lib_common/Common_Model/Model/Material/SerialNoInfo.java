package xx.com.lib_common.Common_Model.Model.Material;

import android.os.Parcel;
import android.os.Parcelable;

import xx.com.lib_common.Common_Model.Model.Base_Model;

/**
 * Created by GHOST on 2018/3/12.
 */

public class SerialNoInfo extends Base_Model implements Parcelable{
    private String FacMaterialNo;
    private String SerialNo;
    private String ERPVoucherNo;
    private Float SerialQty;
    /// <summary>
    /// 客户端提交的SerialNo包含@信息，先赋值给SerialNoWMS，再对SerialNo通过@符号解析，提交给ERP
    /// </summary>
    private String SerialNoWMS;
    private String MaterialDesc;
    private String VoucherNo;
    /// <summary>
    /// 是否自动分配，EXCEL导入1-未分配 2-已分配
    /// </summary>
    private int IsDis;
    private String RowNo;
    private String AreaNo;

    public String getFacMaterialNo() {
        return FacMaterialNo;
    }

    public void setFacMaterialNo(String facMaterialNo) {
        FacMaterialNo = facMaterialNo;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    public String getERPVoucherNo() {
        return ERPVoucherNo;
    }

    public void setERPVoucherNo(String ERPVoucherNo) {
        this.ERPVoucherNo = ERPVoucherNo;
    }

    public Float getSerialQty() {
        return SerialQty;
    }

    public void setSerialQty(Float serialQty) {
        SerialQty = serialQty;
    }

    public String getSerialNoWMS() {
        return SerialNoWMS;
    }

    public void setSerialNoWMS(String serialNoWMS) {
        SerialNoWMS = serialNoWMS;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }

    public String getVoucherNo() {
        return VoucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        VoucherNo = voucherNo;
    }

    public int getIsDis() {
        return IsDis;
    }

    public void setIsDis(int isDis) {
        IsDis = isDis;
    }

    public String getRowNo() {
        return RowNo;
    }

    public void setRowNo(String rowNo) {
        RowNo = rowNo;
    }

    public String getAreaNo() {
        return AreaNo;
    }

    public void setAreaNo(String areaNo) {
        AreaNo = areaNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.FacMaterialNo);
        dest.writeString(this.SerialNo);
        dest.writeString(this.ERPVoucherNo);
        dest.writeValue(this.SerialQty);
        dest.writeString(this.SerialNoWMS);
        dest.writeString(this.MaterialDesc);
        dest.writeString(this.VoucherNo);
        dest.writeInt(this.IsDis);
        dest.writeString(this.RowNo);
        dest.writeString(this.AreaNo);
    }

    public SerialNoInfo() {
    }

    protected SerialNoInfo(Parcel in) {
        super(in);
        this.FacMaterialNo = in.readString();
        this.SerialNo = in.readString();
        this.ERPVoucherNo = in.readString();
        this.SerialQty = (Float) in.readValue(Float.class.getClassLoader());
        this.SerialNoWMS = in.readString();
        this.MaterialDesc = in.readString();
        this.VoucherNo = in.readString();
        this.IsDis = in.readInt();
        this.RowNo = in.readString();
        this.AreaNo = in.readString();
    }

    public static final Creator<SerialNoInfo> CREATOR = new Creator<SerialNoInfo>() {
        @Override
        public SerialNoInfo createFromParcel(Parcel source) {
            return new SerialNoInfo(source);
        }

        @Override
        public SerialNoInfo[] newArray(int size) {
            return new SerialNoInfo[size];
        }
    };
}
