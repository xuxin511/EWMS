package xx.com.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

import xx.com.lib_common.Common_Model.Model.Base_Model;
import xx.com.lib_common.Common_Model.Model.Material.SerialNoInfo;
import xx.com.lib_common.Common_Model.Model.Stock.StockInfo;

/**
 * Created by GHOST on 2018/3/12.
 */

public class OutStockTaskDetailsInfo extends Base_Model implements Parcelable{
    private String MaterialNo;
    private String MaterialDesc;
    private Float TaskQty;
    private Float QualityQty;
    private Float RemainQty;
    private Float ShelveQty;
    private Float IsQualitycomp;
    private String KeeperUserNo;
    private String OperatorUserNo;
    private Date CompleteDateTime;
    private int TaskID;
    private String TMaterialNo;
    private String TMaterialDesc;
    private Date OperatorDateTime;
    private Float ReviewQty;
    private Float PackCount;
    private Float ShelvePackCount;
    private String VoucherNo;
    private String RowNo;
    private String TrackNo;
    private String Unit;
    private Float UnQualityQty;
    private Float PostQty;
    private Float PostStatus;
    private String ReserveNumber;
    private String ReserveRowNo;
    private Float UnShelveQty;
    private String Requstreason;
    private String Remark;
    private String ReviewUser;
    private Date ReviewDate;
    private Float ReviewStatus;
    private String PostUser;
    private String Costcenter;
    private String Wbselem;
    private String ToStorageLoc;
    private String FromStorageLoc;
    private Float OutStockQty;
    private Float LimitStockQtySAP;
    private Float RemainsSockQtySAP;
    private Float PackFlag;
    private Float CurrentRemainStockQtySAP;
    private String MoveReasonCode;
    private String MoveReasonDesc;
    private String PoNo;
    private String PoRowNo;
    private Float IsLock;
    private Float IsSmallBatch;
    private String UnitName;
    private Float ScanQty;
    private String AreaNo;
    private String HouseNo;
    private String WareHouseNo;
    private List<SerialNoInfo> lstSerialNo;
    private String SupCusCode;
    private String SupCusName;
    private String SaleName;
    private int TaskType;
    private List<StockInfo> lstStockInfo;
    /// <summary>
    /// 1-批次 2-序列号
    /// </summary>
    private int IsSerial;
    private String OperatorUserName;
    private String PartNo;
    private String MoveType;
    private String ErpDocNo;
    /// <summary>
    /// 是否指定批次
    /// </summary>
    private String IsSpcBatch;
    /// <summary>
    /// ERP指定的发货批次
    /// </summary>
    private String FromBatchNo;
    /// <summary>
    /// ERP指定发货储位
    /// </summary>
    private String FromErpAreaNo;
    /// <summary>
    /// ERP指定发货仓库
    /// </summary>
    private String FromErpWarehouse;
    /// <summary>
    /// 给ERP指定的发货批次
    /// </summary>
    private String ToBatchNo;
    /// <summary>
    /// 给ERP指定发货储位
    /// </summary>
    private String ToErpAreaNo;
    /// <summary>
    /// 给ERP指定发货仓库
    /// </summary>
    private String ToErpWarehouse;
    private int FloorType;
    private String RowNoDel;
    private String PickLeaderUserNo;
    private String PickGroupNo;
    private Float StockQty;
    private int HeightArea;
    //可拣货数量
    private Float RePickQty;
    private int OutstockDetailID;
    private String StrIsSpcBatch;
    private String SortArea;
    private String BatchNo;

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

    public Float getTaskQty() {
        return TaskQty;
    }

    public void setTaskQty(Float taskQty) {
        TaskQty = taskQty;
    }

    public Float getQualityQty() {
        return QualityQty;
    }

    public void setQualityQty(Float qualityQty) {
        QualityQty = qualityQty;
    }

    public Float getRemainQty() {
        return RemainQty;
    }

    public void setRemainQty(Float remainQty) {
        RemainQty = remainQty;
    }

    public Float getShelveQty() {
        return ShelveQty;
    }

    public void setShelveQty(Float shelveQty) {
        ShelveQty = shelveQty;
    }

    public Float getIsQualitycomp() {
        return IsQualitycomp;
    }

    public void setIsQualitycomp(Float isQualitycomp) {
        IsQualitycomp = isQualitycomp;
    }

    public String getKeeperUserNo() {
        return KeeperUserNo;
    }

    public void setKeeperUserNo(String keeperUserNo) {
        KeeperUserNo = keeperUserNo;
    }

    public String getOperatorUserNo() {
        return OperatorUserNo;
    }

    public void setOperatorUserNo(String operatorUserNo) {
        OperatorUserNo = operatorUserNo;
    }

    public Date getCompleteDateTime() {
        return CompleteDateTime;
    }

    public void setCompleteDateTime(Date completeDateTime) {
        CompleteDateTime = completeDateTime;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
    }

    public String getTMaterialNo() {
        return TMaterialNo;
    }

    public void setTMaterialNo(String TMaterialNo) {
        this.TMaterialNo = TMaterialNo;
    }

    public String getTMaterialDesc() {
        return TMaterialDesc;
    }

    public void setTMaterialDesc(String TMaterialDesc) {
        this.TMaterialDesc = TMaterialDesc;
    }

    public Date getOperatorDateTime() {
        return OperatorDateTime;
    }

    public void setOperatorDateTime(Date operatorDateTime) {
        OperatorDateTime = operatorDateTime;
    }

    public Float getReviewQty() {
        return ReviewQty;
    }

    public void setReviewQty(Float reviewQty) {
        ReviewQty = reviewQty;
    }

    public Float getPackCount() {
        return PackCount;
    }

    public void setPackCount(Float packCount) {
        PackCount = packCount;
    }

    public Float getShelvePackCount() {
        return ShelvePackCount;
    }

    public void setShelvePackCount(Float shelvePackCount) {
        ShelvePackCount = shelvePackCount;
    }

    public String getVoucherNo() {
        return VoucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        VoucherNo = voucherNo;
    }

    public String getRowNo() {
        return RowNo;
    }

    public void setRowNo(String rowNo) {
        RowNo = rowNo;
    }

    public String getTrackNo() {
        return TrackNo;
    }

    public void setTrackNo(String trackNo) {
        TrackNo = trackNo;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Float getUnQualityQty() {
        return UnQualityQty;
    }

    public void setUnQualityQty(Float unQualityQty) {
        UnQualityQty = unQualityQty;
    }

    public Float getPostQty() {
        return PostQty;
    }

    public void setPostQty(Float postQty) {
        PostQty = postQty;
    }

    public Float getPostStatus() {
        return PostStatus;
    }

    public void setPostStatus(Float postStatus) {
        PostStatus = postStatus;
    }

    public String getReserveNumber() {
        return ReserveNumber;
    }

    public void setReserveNumber(String reserveNumber) {
        ReserveNumber = reserveNumber;
    }

    public String getReserveRowNo() {
        return ReserveRowNo;
    }

    public void setReserveRowNo(String reserveRowNo) {
        ReserveRowNo = reserveRowNo;
    }

    public Float getUnShelveQty() {
        return UnShelveQty;
    }

    public void setUnShelveQty(Float unShelveQty) {
        UnShelveQty = unShelveQty;
    }

    public String getRequstreason() {
        return Requstreason;
    }

    public void setRequstreason(String requstreason) {
        Requstreason = requstreason;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getReviewUser() {
        return ReviewUser;
    }

    public void setReviewUser(String reviewUser) {
        ReviewUser = reviewUser;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }

    public Float getReviewStatus() {
        return ReviewStatus;
    }

    public void setReviewStatus(Float reviewStatus) {
        ReviewStatus = reviewStatus;
    }

    public String getPostUser() {
        return PostUser;
    }

    public void setPostUser(String postUser) {
        PostUser = postUser;
    }

    public String getCostcenter() {
        return Costcenter;
    }

    public void setCostcenter(String costcenter) {
        Costcenter = costcenter;
    }

    public String getWbselem() {
        return Wbselem;
    }

    public void setWbselem(String wbselem) {
        Wbselem = wbselem;
    }

    public String getToStorageLoc() {
        return ToStorageLoc;
    }

    public void setToStorageLoc(String toStorageLoc) {
        ToStorageLoc = toStorageLoc;
    }

    public String getFromStorageLoc() {
        return FromStorageLoc;
    }

    public void setFromStorageLoc(String fromStorageLoc) {
        FromStorageLoc = fromStorageLoc;
    }

    public Float getOutStockQty() {
        return OutStockQty;
    }

    public void setOutStockQty(Float outStockQty) {
        OutStockQty = outStockQty;
    }

    public Float getLimitStockQtySAP() {
        return LimitStockQtySAP;
    }

    public void setLimitStockQtySAP(Float limitStockQtySAP) {
        LimitStockQtySAP = limitStockQtySAP;
    }

    public Float getRemainsSockQtySAP() {
        return RemainsSockQtySAP;
    }

    public void setRemainsSockQtySAP(Float remainsSockQtySAP) {
        RemainsSockQtySAP = remainsSockQtySAP;
    }

    public Float getPackFlag() {
        return PackFlag;
    }

    public void setPackFlag(Float packFlag) {
        PackFlag = packFlag;
    }

    public Float getCurrentRemainStockQtySAP() {
        return CurrentRemainStockQtySAP;
    }

    public void setCurrentRemainStockQtySAP(Float currentRemainStockQtySAP) {
        CurrentRemainStockQtySAP = currentRemainStockQtySAP;
    }

    public String getMoveReasonCode() {
        return MoveReasonCode;
    }

    public void setMoveReasonCode(String moveReasonCode) {
        MoveReasonCode = moveReasonCode;
    }

    public String getMoveReasonDesc() {
        return MoveReasonDesc;
    }

    public void setMoveReasonDesc(String moveReasonDesc) {
        MoveReasonDesc = moveReasonDesc;
    }

    public String getPoNo() {
        return PoNo;
    }

    public void setPoNo(String poNo) {
        PoNo = poNo;
    }

    public String getPoRowNo() {
        return PoRowNo;
    }

    public void setPoRowNo(String poRowNo) {
        PoRowNo = poRowNo;
    }

    public Float getIsLock() {
        return IsLock;
    }

    public void setIsLock(Float isLock) {
        IsLock = isLock;
    }

    public Float getIsSmallBatch() {
        return IsSmallBatch;
    }

    public void setIsSmallBatch(Float isSmallBatch) {
        IsSmallBatch = isSmallBatch;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public Float getScanQty() {
        return ScanQty;
    }

    public void setScanQty(Float scanQty) {
        ScanQty = scanQty;
    }

    public String getAreaNo() {
        return AreaNo;
    }

    public void setAreaNo(String areaNo) {
        AreaNo = areaNo;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String houseNo) {
        HouseNo = houseNo;
    }

    public String getWareHouseNo() {
        return WareHouseNo;
    }

    public void setWareHouseNo(String wareHouseNo) {
        WareHouseNo = wareHouseNo;
    }

    public List<SerialNoInfo> getLstSerialNo() {
        return lstSerialNo;
    }

    public void setLstSerialNo(List<SerialNoInfo> lstSerialNo) {
        this.lstSerialNo = lstSerialNo;
    }

    public String getSupCusCode() {
        return SupCusCode;
    }

    public void setSupCusCode(String supCusCode) {
        SupCusCode = supCusCode;
    }

    public String getSupCusName() {
        return SupCusName;
    }

    public void setSupCusName(String supCusName) {
        SupCusName = supCusName;
    }

    public String getSaleName() {
        return SaleName;
    }

    public void setSaleName(String saleName) {
        SaleName = saleName;
    }

    public int getTaskType() {
        return TaskType;
    }

    public void setTaskType(int taskType) {
        TaskType = taskType;
    }

    public List<StockInfo> getLstStockInfo() {
        return lstStockInfo;
    }

    public void setLstStockInfo(List<StockInfo> lstStockInfo) {
        this.lstStockInfo = lstStockInfo;
    }

    public int getIsSerial() {
        return IsSerial;
    }

    public void setIsSerial(int isSerial) {
        IsSerial = isSerial;
    }

    public String getOperatorUserName() {
        return OperatorUserName;
    }

    public void setOperatorUserName(String operatorUserName) {
        OperatorUserName = operatorUserName;
    }

    public String getPartNo() {
        return PartNo;
    }

    public void setPartNo(String partNo) {
        PartNo = partNo;
    }

    public String getMoveType() {
        return MoveType;
    }

    public void setMoveType(String moveType) {
        MoveType = moveType;
    }

    public String getErpDocNo() {
        return ErpDocNo;
    }

    public void setErpDocNo(String erpDocNo) {
        ErpDocNo = erpDocNo;
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

    public String getToBatchNo() {
        return ToBatchNo;
    }

    public void setToBatchNo(String toBatchNo) {
        ToBatchNo = toBatchNo;
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

    public int getFloorType() {
        return FloorType;
    }

    public void setFloorType(int floorType) {
        FloorType = floorType;
    }

    public String getRowNoDel() {
        return RowNoDel;
    }

    public void setRowNoDel(String rowNoDel) {
        RowNoDel = rowNoDel;
    }

    public String getPickLeaderUserNo() {
        return PickLeaderUserNo;
    }

    public void setPickLeaderUserNo(String pickLeaderUserNo) {
        PickLeaderUserNo = pickLeaderUserNo;
    }

    public String getPickGroupNo() {
        return PickGroupNo;
    }

    public void setPickGroupNo(String pickGroupNo) {
        PickGroupNo = pickGroupNo;
    }

    public Float getStockQty() {
        return StockQty;
    }

    public void setStockQty(Float stockQty) {
        StockQty = stockQty;
    }

    public int getHeightArea() {
        return HeightArea;
    }

    public void setHeightArea(int heightArea) {
        HeightArea = heightArea;
    }

    public Float getRePickQty() {
        return RePickQty;
    }

    public void setRePickQty(Float rePickQty) {
        RePickQty = rePickQty;
    }

    public int getOutstockDetailID() {
        return OutstockDetailID;
    }

    public void setOutstockDetailID(int outstockDetailID) {
        OutstockDetailID = outstockDetailID;
    }

    public String getStrIsSpcBatch() {
        return StrIsSpcBatch;
    }

    public void setStrIsSpcBatch(String strIsSpcBatch) {
        StrIsSpcBatch = strIsSpcBatch;
    }

    public String getSortArea() {
        return SortArea;
    }

    public void setSortArea(String sortArea) {
        SortArea = sortArea;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.MaterialNo);
        dest.writeString(this.MaterialDesc);
        dest.writeValue(this.TaskQty);
        dest.writeValue(this.QualityQty);
        dest.writeValue(this.RemainQty);
        dest.writeValue(this.ShelveQty);
        dest.writeValue(this.IsQualitycomp);
        dest.writeString(this.KeeperUserNo);
        dest.writeString(this.OperatorUserNo);
        dest.writeLong(this.CompleteDateTime != null ? this.CompleteDateTime.getTime() : -1);
        dest.writeInt(this.TaskID);
        dest.writeString(this.TMaterialNo);
        dest.writeString(this.TMaterialDesc);
        dest.writeLong(this.OperatorDateTime != null ? this.OperatorDateTime.getTime() : -1);
        dest.writeValue(this.ReviewQty);
        dest.writeValue(this.PackCount);
        dest.writeValue(this.ShelvePackCount);
        dest.writeString(this.VoucherNo);
        dest.writeString(this.RowNo);
        dest.writeString(this.TrackNo);
        dest.writeString(this.Unit);
        dest.writeValue(this.UnQualityQty);
        dest.writeValue(this.PostQty);
        dest.writeValue(this.PostStatus);
        dest.writeString(this.ReserveNumber);
        dest.writeString(this.ReserveRowNo);
        dest.writeValue(this.UnShelveQty);
        dest.writeString(this.Requstreason);
        dest.writeString(this.Remark);
        dest.writeString(this.ReviewUser);
        dest.writeLong(this.ReviewDate != null ? this.ReviewDate.getTime() : -1);
        dest.writeValue(this.ReviewStatus);
        dest.writeString(this.PostUser);
        dest.writeString(this.Costcenter);
        dest.writeString(this.Wbselem);
        dest.writeString(this.ToStorageLoc);
        dest.writeString(this.FromStorageLoc);
        dest.writeValue(this.OutStockQty);
        dest.writeValue(this.LimitStockQtySAP);
        dest.writeValue(this.RemainsSockQtySAP);
        dest.writeValue(this.PackFlag);
        dest.writeValue(this.CurrentRemainStockQtySAP);
        dest.writeString(this.MoveReasonCode);
        dest.writeString(this.MoveReasonDesc);
        dest.writeString(this.PoNo);
        dest.writeString(this.PoRowNo);
        dest.writeValue(this.IsLock);
        dest.writeValue(this.IsSmallBatch);
        dest.writeString(this.UnitName);
        dest.writeValue(this.ScanQty);
        dest.writeString(this.AreaNo);
        dest.writeString(this.HouseNo);
        dest.writeString(this.WareHouseNo);
        dest.writeTypedList(this.lstSerialNo);
        dest.writeString(this.SupCusCode);
        dest.writeString(this.SupCusName);
        dest.writeString(this.SaleName);
        dest.writeInt(this.TaskType);
        dest.writeTypedList(this.lstStockInfo);
        dest.writeInt(this.IsSerial);
        dest.writeString(this.OperatorUserName);
        dest.writeString(this.PartNo);
        dest.writeString(this.MoveType);
        dest.writeString(this.ErpDocNo);
        dest.writeString(this.IsSpcBatch);
        dest.writeString(this.FromBatchNo);
        dest.writeString(this.FromErpAreaNo);
        dest.writeString(this.FromErpWarehouse);
        dest.writeString(this.ToBatchNo);
        dest.writeString(this.ToErpAreaNo);
        dest.writeString(this.ToErpWarehouse);
        dest.writeInt(this.FloorType);
        dest.writeString(this.RowNoDel);
        dest.writeString(this.PickLeaderUserNo);
        dest.writeString(this.PickGroupNo);
        dest.writeValue(this.StockQty);
        dest.writeInt(this.HeightArea);
        dest.writeValue(this.RePickQty);
        dest.writeInt(this.OutstockDetailID);
        dest.writeString(this.StrIsSpcBatch);
        dest.writeString(this.SortArea);
        dest.writeString(this.BatchNo);
    }

    public OutStockTaskDetailsInfo() {
    }

    public OutStockTaskDetailsInfo(String BarCodeEAN) {
        this.setBarCodeEAN(BarCodeEAN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutStockTaskDetailsInfo that = (OutStockTaskDetailsInfo) o;
        return getBarCodeEAN().equals(that.getBarCodeEAN());
    }

    protected OutStockTaskDetailsInfo(Parcel in) {
        super(in);
        this.MaterialNo = in.readString();
        this.MaterialDesc = in.readString();
        this.TaskQty = (Float) in.readValue(Float.class.getClassLoader());
        this.QualityQty = (Float) in.readValue(Float.class.getClassLoader());
        this.RemainQty = (Float) in.readValue(Float.class.getClassLoader());
        this.ShelveQty = (Float) in.readValue(Float.class.getClassLoader());
        this.IsQualitycomp = (Float) in.readValue(Float.class.getClassLoader());
        this.KeeperUserNo = in.readString();
        this.OperatorUserNo = in.readString();
        long tmpCompleteDateTime = in.readLong();
        this.CompleteDateTime = tmpCompleteDateTime == -1 ? null : new Date(tmpCompleteDateTime);
        this.TaskID = in.readInt();
        this.TMaterialNo = in.readString();
        this.TMaterialDesc = in.readString();
        long tmpOperatorDateTime = in.readLong();
        this.OperatorDateTime = tmpOperatorDateTime == -1 ? null : new Date(tmpOperatorDateTime);
        this.ReviewQty = (Float) in.readValue(Float.class.getClassLoader());
        this.PackCount = (Float) in.readValue(Float.class.getClassLoader());
        this.ShelvePackCount = (Float) in.readValue(Float.class.getClassLoader());
        this.VoucherNo = in.readString();
        this.RowNo = in.readString();
        this.TrackNo = in.readString();
        this.Unit = in.readString();
        this.UnQualityQty = (Float) in.readValue(Float.class.getClassLoader());
        this.PostQty = (Float) in.readValue(Float.class.getClassLoader());
        this.PostStatus = (Float) in.readValue(Float.class.getClassLoader());
        this.ReserveNumber = in.readString();
        this.ReserveRowNo = in.readString();
        this.UnShelveQty = (Float) in.readValue(Float.class.getClassLoader());
        this.Requstreason = in.readString();
        this.Remark = in.readString();
        this.ReviewUser = in.readString();
        long tmpReviewDate = in.readLong();
        this.ReviewDate = tmpReviewDate == -1 ? null : new Date(tmpReviewDate);
        this.ReviewStatus = (Float) in.readValue(Float.class.getClassLoader());
        this.PostUser = in.readString();
        this.Costcenter = in.readString();
        this.Wbselem = in.readString();
        this.ToStorageLoc = in.readString();
        this.FromStorageLoc = in.readString();
        this.OutStockQty = (Float) in.readValue(Float.class.getClassLoader());
        this.LimitStockQtySAP = (Float) in.readValue(Float.class.getClassLoader());
        this.RemainsSockQtySAP = (Float) in.readValue(Float.class.getClassLoader());
        this.PackFlag = (Float) in.readValue(Float.class.getClassLoader());
        this.CurrentRemainStockQtySAP = (Float) in.readValue(Float.class.getClassLoader());
        this.MoveReasonCode = in.readString();
        this.MoveReasonDesc = in.readString();
        this.PoNo = in.readString();
        this.PoRowNo = in.readString();
        this.IsLock = (Float) in.readValue(Float.class.getClassLoader());
        this.IsSmallBatch = (Float) in.readValue(Float.class.getClassLoader());
        this.UnitName = in.readString();
        this.ScanQty = (Float) in.readValue(Float.class.getClassLoader());
        this.AreaNo = in.readString();
        this.HouseNo = in.readString();
        this.WareHouseNo = in.readString();
        this.lstSerialNo = in.createTypedArrayList(SerialNoInfo.CREATOR);
        this.SupCusCode = in.readString();
        this.SupCusName = in.readString();
        this.SaleName = in.readString();
        this.TaskType = in.readInt();
        this.lstStockInfo = in.createTypedArrayList(StockInfo.CREATOR);
        this.IsSerial = in.readInt();
        this.OperatorUserName = in.readString();
        this.PartNo = in.readString();
        this.MoveType = in.readString();
        this.ErpDocNo = in.readString();
        this.IsSpcBatch = in.readString();
        this.FromBatchNo = in.readString();
        this.FromErpAreaNo = in.readString();
        this.FromErpWarehouse = in.readString();
        this.ToBatchNo = in.readString();
        this.ToErpAreaNo = in.readString();
        this.ToErpWarehouse = in.readString();
        this.FloorType = in.readInt();
        this.RowNoDel = in.readString();
        this.PickLeaderUserNo = in.readString();
        this.PickGroupNo = in.readString();
        this.StockQty = (Float) in.readValue(Float.class.getClassLoader());
        this.HeightArea = in.readInt();
        this.RePickQty = (Float) in.readValue(Float.class.getClassLoader());
        this.OutstockDetailID = in.readInt();
        this.StrIsSpcBatch = in.readString();
        this.SortArea = in.readString();
        this.BatchNo = in.readString();
    }

    public static final Creator<OutStockTaskDetailsInfo> CREATOR = new Creator<OutStockTaskDetailsInfo>() {
        @Override
        public OutStockTaskDetailsInfo createFromParcel(Parcel source) {
            return new OutStockTaskDetailsInfo(source);
        }

        @Override
        public OutStockTaskDetailsInfo[] newArray(int size) {
            return new OutStockTaskDetailsInfo[size];
        }
    };
}
