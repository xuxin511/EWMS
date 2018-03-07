package xx.com.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

import xx.com.lib_common.Common_Model.Model.Base_Model;
import xx.com.lib_common.Common_Model.Model.Material.OutBarCodeInfo;

/**
 * Created by GHOST on 2018/3/6.
 */

public class InStockDetailInfo extends Base_Model implements Parcelable {
    private int InStockID;
    private String RowNo;
    private String MaterialNo;
    private String MaterialDesc;
    private Float InStockQty;
    private Float ReceiveQty;
    private String Unit;
    private String StorageLoc;
    private String Plant;
    private String PlantName;
    private Float QualityQty;
    private Float UnQualityQty;
    private String QualityType;
    private String QualityUserNo;
    private Date QualityDate;
    private String UnitName;
    /// <summary>
    /// 剩余收货数量
    /// </summary>
    private Float RemainQty;
    private Float ScanQty;
    private String SaleName;
    private String VoucherNo;
    private Date ArrivalDate;
    private String SaleCode;
    private String SupplierNo;
    private String SupplierName;
    private String BatchNo;
    /// <summary>
    /// 1-批次 2-序列号
    /// </summary>
    private int IsSerial;
    private String PartNo;
    private List<OutBarCodeInfo> lstBarCode;
    private String DeliverySup;
    private Date ShipmentDate;
    private Date ArrStockDate;
    private String Stationname;
    //已经打印数量
    private Float Hasprint;
    private Float OutPackNum;
    private Float CenterPackNum;
    private Float InnerPackNum;
    //存储条件
    private String StoreCondition;
    //特殊要求
    private String SpecialRequire;
    private String ProtectWay;
    //采购子分类名称
    private String ERPVoucherDesc;
    private int lasttime;
    private String RowNoDel;
    private String MainTypeCode;
    private Date SupPrdDate;
    private String StrSupPrdDate;
    private String SupPrdBatch;
    /// <summary>
    /// 收货仓库
    /// </summary>
    private String ReceiveWareHouseNo;
    /// <summary>
    /// 收货库位
    /// </summary>
    private String ReceiveAreaNo;
    /// <summary>
    /// 收货人
    /// </summary>
    private String ReceiveUserNo;
    private Date ProductDate;
    private String ProductBatch;
    private String ReasonCode;
    private int IsQuality;
    private String IsSpcBatch;
    private String FromBatchNo;
    private String FromErpAreaNo;
    private String FromErpWarehouse;
    private String ToBatchno;
    private String ToErpAreaNo;
    private String ToErpWarehouse;
    private String QcCode;
    private String QcDesc;
    private String PostUser;
    private String productno;
    private String ProRowNo;
    private String ProRowNoDel;
    private Boolean ischeck;
    private int WareHouseID;
    private int HouseID;
    private int AreaID;

    public int getInStockID() {
        return InStockID;
    }

    public void setInStockID(int inStockID) {
        InStockID = inStockID;
    }

    public String getRowNo() {
        return RowNo;
    }

    public void setRowNo(String rowNo) {
        RowNo = rowNo;
    }

    public String getMaterialNo() {
        return MaterialNo;
    }

    public void setMaterialNo(String materialNo) {
        MaterialNo = materialNo;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }

    public Float getInStockQty() {
        return InStockQty;
    }

    public void setInStockQty(Float inStockQty) {
        InStockQty = inStockQty;
    }

    public Float getReceiveQty() {
        return ReceiveQty;
    }

    public void setReceiveQty(Float receiveQty) {
        ReceiveQty = receiveQty;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getStorageLoc() {
        return StorageLoc;
    }

    public void setStorageLoc(String storageLoc) {
        StorageLoc = storageLoc;
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

    public Float getQualityQty() {
        return QualityQty;
    }

    public void setQualityQty(Float qualityQty) {
        QualityQty = qualityQty;
    }

    public Float getUnQualityQty() {
        return UnQualityQty;
    }

    public void setUnQualityQty(Float unQualityQty) {
        UnQualityQty = unQualityQty;
    }

    public String getQualityType() {
        return QualityType;
    }

    public void setQualityType(String qualityType) {
        QualityType = qualityType;
    }

    public String getQualityUserNo() {
        return QualityUserNo;
    }

    public void setQualityUserNo(String qualityUserNo) {
        QualityUserNo = qualityUserNo;
    }

    public Date getQualityDate() {
        return QualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        QualityDate = qualityDate;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public Float getRemainQty() {
        return RemainQty;
    }

    public void setRemainQty(Float remainQty) {
        RemainQty = remainQty;
    }

    public Float getScanQty() {
        return ScanQty;
    }

    public void setScanQty(Float scanQty) {
        ScanQty = scanQty;
    }

    public String getSaleName() {
        return SaleName;
    }

    public void setSaleName(String saleName) {
        SaleName = saleName;
    }

    public String getVoucherNo() {
        return VoucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        VoucherNo = voucherNo;
    }

    public Date getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public String getSaleCode() {
        return SaleCode;
    }

    public void setSaleCode(String saleCode) {
        SaleCode = saleCode;
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

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    public int getIsSerial() {
        return IsSerial;
    }

    public void setIsSerial(int isSerial) {
        IsSerial = isSerial;
    }

    public String getPartNo() {
        return PartNo;
    }

    public void setPartNo(String partNo) {
        PartNo = partNo;
    }

    public List<OutBarCodeInfo> getLstBarCode() {
        return lstBarCode;
    }

    public void setLstBarCode(List<OutBarCodeInfo> lstBarCode) {
        this.lstBarCode = lstBarCode;
    }

    public String getDeliverySup() {
        return DeliverySup;
    }

    public void setDeliverySup(String deliverySup) {
        DeliverySup = deliverySup;
    }

    public Date getShipmentDate() {
        return ShipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        ShipmentDate = shipmentDate;
    }

    public Date getArrStockDate() {
        return ArrStockDate;
    }

    public void setArrStockDate(Date arrStockDate) {
        ArrStockDate = arrStockDate;
    }

    public String getStationname() {
        return Stationname;
    }

    public void setStationname(String stationname) {
        Stationname = stationname;
    }

    public Float getHasprint() {
        return Hasprint;
    }

    public void setHasprint(Float hasprint) {
        Hasprint = hasprint;
    }

    public Float getOutPackNum() {
        return OutPackNum;
    }

    public void setOutPackNum(Float outPackNum) {
        OutPackNum = outPackNum;
    }

    public Float getCenterPackNum() {
        return CenterPackNum;
    }

    public void setCenterPackNum(Float centerPackNum) {
        CenterPackNum = centerPackNum;
    }

    public Float getInnerPackNum() {
        return InnerPackNum;
    }

    public void setInnerPackNum(Float innerPackNum) {
        InnerPackNum = innerPackNum;
    }

    public String getStoreCondition() {
        return StoreCondition;
    }

    public void setStoreCondition(String storeCondition) {
        StoreCondition = storeCondition;
    }

    public String getSpecialRequire() {
        return SpecialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        SpecialRequire = specialRequire;
    }

    public String getProtectWay() {
        return ProtectWay;
    }

    public void setProtectWay(String protectWay) {
        ProtectWay = protectWay;
    }

    public String getERPVoucherDesc() {
        return ERPVoucherDesc;
    }

    public void setERPVoucherDesc(String ERPVoucherDesc) {
        this.ERPVoucherDesc = ERPVoucherDesc;
    }

    public int getLasttime() {
        return lasttime;
    }

    public void setLasttime(int lasttime) {
        this.lasttime = lasttime;
    }

    public String getRowNoDel() {
        return RowNoDel;
    }

    public void setRowNoDel(String rowNoDel) {
        RowNoDel = rowNoDel;
    }

    public String getMainTypeCode() {
        return MainTypeCode;
    }

    public void setMainTypeCode(String mainTypeCode) {
        MainTypeCode = mainTypeCode;
    }

    public Date getSupPrdDate() {
        return SupPrdDate;
    }

    public void setSupPrdDate(Date supPrdDate) {
        SupPrdDate = supPrdDate;
    }

    public String getStrSupPrdDate() {
        return StrSupPrdDate;
    }

    public void setStrSupPrdDate(String strSupPrdDate) {
        StrSupPrdDate = strSupPrdDate;
    }

    public String getSupPrdBatch() {
        return SupPrdBatch;
    }

    public void setSupPrdBatch(String supPrdBatch) {
        SupPrdBatch = supPrdBatch;
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

    public String getReceiveUserNo() {
        return ReceiveUserNo;
    }

    public void setReceiveUserNo(String receiveUserNo) {
        ReceiveUserNo = receiveUserNo;
    }

    public Date getProductDate() {
        return ProductDate;
    }

    public void setProductDate(Date productDate) {
        ProductDate = productDate;
    }

    public String getProductBatch() {
        return ProductBatch;
    }

    public void setProductBatch(String productBatch) {
        ProductBatch = productBatch;
    }

    public String getReasonCode() {
        return ReasonCode;
    }

    public void setReasonCode(String reasonCode) {
        ReasonCode = reasonCode;
    }

    public int getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(int isQuality) {
        IsQuality = isQuality;
    }

    public String getIsSpcBatch() {
        return IsSpcBatch;
    }

    public void setIsSpcBatch(String isSpcBatch) {
        IsSpcBatch = isSpcBatch;
    }

    public String getFromBatchNo() {
        return FromBatchNo;
    }

    public void setFromBatchNo(String fromBatchNo) {
        FromBatchNo = fromBatchNo;
    }

    public String getFromErpAreaNo() {
        return FromErpAreaNo;
    }

    public void setFromErpAreaNo(String fromErpAreaNo) {
        FromErpAreaNo = fromErpAreaNo;
    }

    public String getFromErpWarehouse() {
        return FromErpWarehouse;
    }

    public void setFromErpWarehouse(String fromErpWarehouse) {
        FromErpWarehouse = fromErpWarehouse;
    }

    public String getToBatchno() {
        return ToBatchno;
    }

    public void setToBatchno(String toBatchno) {
        ToBatchno = toBatchno;
    }

    public String getToErpAreaNo() {
        return ToErpAreaNo;
    }

    public void setToErpAreaNo(String toErpAreaNo) {
        ToErpAreaNo = toErpAreaNo;
    }

    public String getToErpWarehouse() {
        return ToErpWarehouse;
    }

    public void setToErpWarehouse(String toErpWarehouse) {
        ToErpWarehouse = toErpWarehouse;
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

    public String getPostUser() {
        return PostUser;
    }

    public void setPostUser(String postUser) {
        PostUser = postUser;
    }

    public String getProductno() {
        return productno;
    }

    public void setProductno(String productno) {
        this.productno = productno;
    }

    public String getProRowNo() {
        return ProRowNo;
    }

    public void setProRowNo(String proRowNo) {
        ProRowNo = proRowNo;
    }

    public String getProRowNoDel() {
        return ProRowNoDel;
    }

    public void setProRowNoDel(String proRowNoDel) {
        ProRowNoDel = proRowNoDel;
    }

    public Boolean getIscheck() {
        return ischeck;
    }

    public void setIscheck(Boolean ischeck) {
        this.ischeck = ischeck;
    }

    public int getWareHouseID() {
        return WareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        WareHouseID = wareHouseID;
    }

    public int getHouseID() {
        return HouseID;
    }

    public void setHouseID(int houseID) {
        HouseID = houseID;
    }

    public int getAreaID() {
        return AreaID;
    }

    public void setAreaID(int areaID) {
        AreaID = areaID;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.InStockID);
        dest.writeString(this.RowNo);
        dest.writeString(this.MaterialNo);
        dest.writeString(this.MaterialDesc);
        dest.writeValue(this.InStockQty);
        dest.writeValue(this.ReceiveQty);
        dest.writeString(this.Unit);
        dest.writeString(this.StorageLoc);
        dest.writeString(this.Plant);
        dest.writeString(this.PlantName);
        dest.writeValue(this.QualityQty);
        dest.writeValue(this.UnQualityQty);
        dest.writeString(this.QualityType);
        dest.writeString(this.QualityUserNo);
        dest.writeLong(this.QualityDate != null ? this.QualityDate.getTime() : -1);
        dest.writeString(this.UnitName);
        dest.writeValue(this.RemainQty);
        dest.writeValue(this.ScanQty);
        dest.writeString(this.SaleName);
        dest.writeString(this.VoucherNo);
        dest.writeLong(this.ArrivalDate != null ? this.ArrivalDate.getTime() : -1);
        dest.writeString(this.SaleCode);
        dest.writeString(this.SupplierNo);
        dest.writeString(this.SupplierName);
        dest.writeString(this.BatchNo);
        dest.writeInt(this.IsSerial);
        dest.writeString(this.PartNo);
        dest.writeTypedList(this.lstBarCode);
        dest.writeString(this.DeliverySup);
        dest.writeLong(this.ShipmentDate != null ? this.ShipmentDate.getTime() : -1);
        dest.writeLong(this.ArrStockDate != null ? this.ArrStockDate.getTime() : -1);
        dest.writeString(this.Stationname);
        dest.writeValue(this.Hasprint);
        dest.writeValue(this.OutPackNum);
        dest.writeValue(this.CenterPackNum);
        dest.writeValue(this.InnerPackNum);
        dest.writeString(this.StoreCondition);
        dest.writeString(this.SpecialRequire);
        dest.writeString(this.ProtectWay);
        dest.writeString(this.ERPVoucherDesc);
        dest.writeInt(this.lasttime);
        dest.writeString(this.RowNoDel);
        dest.writeString(this.MainTypeCode);
        dest.writeLong(this.SupPrdDate != null ? this.SupPrdDate.getTime() : -1);
        dest.writeString(this.StrSupPrdDate);
        dest.writeString(this.SupPrdBatch);
        dest.writeString(this.ReceiveWareHouseNo);
        dest.writeString(this.ReceiveAreaNo);
        dest.writeString(this.ReceiveUserNo);
        dest.writeLong(this.ProductDate != null ? this.ProductDate.getTime() : -1);
        dest.writeString(this.ProductBatch);
        dest.writeString(this.ReasonCode);
        dest.writeInt(this.IsQuality);
        dest.writeString(this.IsSpcBatch);
        dest.writeString(this.FromBatchNo);
        dest.writeString(this.FromErpAreaNo);
        dest.writeString(this.FromErpWarehouse);
        dest.writeString(this.ToBatchno);
        dest.writeString(this.ToErpAreaNo);
        dest.writeString(this.ToErpWarehouse);
        dest.writeString(this.QcCode);
        dest.writeString(this.QcDesc);
        dest.writeString(this.PostUser);
        dest.writeString(this.productno);
        dest.writeString(this.ProRowNo);
        dest.writeString(this.ProRowNoDel);
        dest.writeValue(this.ischeck);
        dest.writeInt(this.WareHouseID);
        dest.writeInt(this.HouseID);
        dest.writeInt(this.AreaID);
    }

    public InStockDetailInfo() {
    }

    protected InStockDetailInfo(Parcel in) {
        super(in);
        this.InStockID = in.readInt();
        this.RowNo = in.readString();
        this.MaterialNo = in.readString();
        this.MaterialDesc = in.readString();
        this.InStockQty = (Float) in.readValue(Float.class.getClassLoader());
        this.ReceiveQty = (Float) in.readValue(Float.class.getClassLoader());
        this.Unit = in.readString();
        this.StorageLoc = in.readString();
        this.Plant = in.readString();
        this.PlantName = in.readString();
        this.QualityQty = (Float) in.readValue(Float.class.getClassLoader());
        this.UnQualityQty = (Float) in.readValue(Float.class.getClassLoader());
        this.QualityType = in.readString();
        this.QualityUserNo = in.readString();
        long tmpQualityDate = in.readLong();
        this.QualityDate = tmpQualityDate == -1 ? null : new Date(tmpQualityDate);
        this.UnitName = in.readString();
        this.RemainQty = (Float) in.readValue(Float.class.getClassLoader());
        this.ScanQty = (Float) in.readValue(Float.class.getClassLoader());
        this.SaleName = in.readString();
        this.VoucherNo = in.readString();
        long tmpArrivalDate = in.readLong();
        this.ArrivalDate = tmpArrivalDate == -1 ? null : new Date(tmpArrivalDate);
        this.SaleCode = in.readString();
        this.SupplierNo = in.readString();
        this.SupplierName = in.readString();
        this.BatchNo = in.readString();
        this.IsSerial = in.readInt();
        this.PartNo = in.readString();
        this.lstBarCode = in.createTypedArrayList(OutBarCodeInfo.CREATOR);
        this.DeliverySup = in.readString();
        long tmpShipmentDate = in.readLong();
        this.ShipmentDate = tmpShipmentDate == -1 ? null : new Date(tmpShipmentDate);
        long tmpArrStockDate = in.readLong();
        this.ArrStockDate = tmpArrStockDate == -1 ? null : new Date(tmpArrStockDate);
        this.Stationname = in.readString();
        this.Hasprint = (Float) in.readValue(Float.class.getClassLoader());
        this.OutPackNum = (Float) in.readValue(Float.class.getClassLoader());
        this.CenterPackNum = (Float) in.readValue(Float.class.getClassLoader());
        this.InnerPackNum = (Float) in.readValue(Float.class.getClassLoader());
        this.StoreCondition = in.readString();
        this.SpecialRequire = in.readString();
        this.ProtectWay = in.readString();
        this.ERPVoucherDesc = in.readString();
        this.lasttime = in.readInt();
        this.RowNoDel = in.readString();
        this.MainTypeCode = in.readString();
        long tmpSupPrdDate = in.readLong();
        this.SupPrdDate = tmpSupPrdDate == -1 ? null : new Date(tmpSupPrdDate);
        this.StrSupPrdDate = in.readString();
        this.SupPrdBatch = in.readString();
        this.ReceiveWareHouseNo = in.readString();
        this.ReceiveAreaNo = in.readString();
        this.ReceiveUserNo = in.readString();
        long tmpProductDate = in.readLong();
        this.ProductDate = tmpProductDate == -1 ? null : new Date(tmpProductDate);
        this.ProductBatch = in.readString();
        this.ReasonCode = in.readString();
        this.IsQuality = in.readInt();
        this.IsSpcBatch = in.readString();
        this.FromBatchNo = in.readString();
        this.FromErpAreaNo = in.readString();
        this.FromErpWarehouse = in.readString();
        this.ToBatchno = in.readString();
        this.ToErpAreaNo = in.readString();
        this.ToErpWarehouse = in.readString();
        this.QcCode = in.readString();
        this.QcDesc = in.readString();
        this.PostUser = in.readString();
        this.productno = in.readString();
        this.ProRowNo = in.readString();
        this.ProRowNoDel = in.readString();
        this.ischeck = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.WareHouseID = in.readInt();
        this.HouseID = in.readInt();
        this.AreaID = in.readInt();
    }

    public static final Creator<InStockDetailInfo> CREATOR = new Creator<InStockDetailInfo>() {
        @Override
        public InStockDetailInfo createFromParcel(Parcel source) {
            return new InStockDetailInfo(source);
        }

        @Override
        public InStockDetailInfo[] newArray(int size) {
            return new InStockDetailInfo[size];
        }
    };
}
