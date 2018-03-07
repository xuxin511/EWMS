package xx.com.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import xx.com.lib_common.Common_Model.Model.Base_Model;

/**
 * Created by GHOST on 2018/3/6.
 */

public class InStockInfo extends Base_Model implements Parcelable{

    private String VoucherNo;

    private String SupplierNo;
    private String SupplierName;
    private Float IsQuality;
    private Float IsReceivePost;
    private Float IsShelvePost;
    private String Plant;
    private String PlantName;
    private String MoveType;
    private List<InStockDetailInfo> lstDetail;
    private String Note;
    private String QcCode;
    private String QcDesc;

    public String getVoucherNo() {
        return VoucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        VoucherNo = voucherNo;
    }

    public String getSupplierNo() {
        return SupplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        SupplierNo = supplierNo;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public Float getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(Float isQuality) {
        IsQuality = isQuality;
    }

    public Float getIsReceivePost() {
        return IsReceivePost;
    }

    public void setIsReceivePost(Float isReceivePost) {
        IsReceivePost = isReceivePost;
    }

    public Float getIsShelvePost() {
        return IsShelvePost;
    }

    public void setIsShelvePost(Float isShelvePost) {
        IsShelvePost = isShelvePost;
    }

    public String getPlant() {
        return Plant;
    }

    public void setPlant(String plant) {
        Plant = plant;
    }

    public String getPlantName() {
        return PlantName;
    }

    public void setPlantName(String plantName) {
        PlantName = plantName;
    }

    public String getMoveType() {
        return MoveType;
    }

    public void setMoveType(String moveType) {
        MoveType = moveType;
    }

    public List<InStockDetailInfo> getLstDetail() {
        return lstDetail;
    }

    public void setLstDetail(List<InStockDetailInfo> lstDetail) {
        this.lstDetail = lstDetail;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getQcCode() {
        return QcCode;
    }

    public void setQcCode(String qcCode) {
        QcCode = qcCode;
    }

    public String getQcDesc() {
        return QcDesc;
    }

    public void setQcDesc(String qcDesc) {
        QcDesc = qcDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.VoucherNo);
        dest.writeString(this.SupplierNo);
        dest.writeString(this.SupplierName);
        dest.writeValue(this.IsQuality);
        dest.writeValue(this.IsReceivePost);
        dest.writeValue(this.IsShelvePost);
        dest.writeString(this.Plant);
        dest.writeString(this.PlantName);
        dest.writeString(this.MoveType);
        dest.writeTypedList(this.lstDetail);
        dest.writeString(this.Note);
        dest.writeString(this.QcCode);
        dest.writeString(this.QcDesc);
    }

    public InStockInfo() {
    }

    protected InStockInfo(Parcel in) {
        super(in);
        this.VoucherNo = in.readString();
        this.SupplierNo = in.readString();
        this.SupplierName = in.readString();
        this.IsQuality = (Float) in.readValue(Float.class.getClassLoader());
        this.IsReceivePost = (Float) in.readValue(Float.class.getClassLoader());
        this.IsShelvePost = (Float) in.readValue(Float.class.getClassLoader());
        this.Plant = in.readString();
        this.PlantName = in.readString();
        this.MoveType = in.readString();
        this.lstDetail = in.createTypedArrayList(InStockDetailInfo.CREATOR);
        this.Note = in.readString();
        this.QcCode = in.readString();
        this.QcDesc = in.readString();
    }

    public static final Creator<InStockInfo> CREATOR = new Creator<InStockInfo>() {
        @Override
        public InStockInfo createFromParcel(Parcel source) {
            return new InStockInfo(source);
        }

        @Override
        public InStockInfo[] newArray(int size) {
            return new InStockInfo[size];
        }
    };
}
