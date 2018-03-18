package xx.com.lib_common.Common_Model.Model.Stock;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import xx.com.lib_common.Common_Model.Model.Base_Model;

/**
 * Created by GHOST on 2018/3/12.
 */

public class StockInfo extends Base_Model implements Parcelable{
    private String Barcode;
    private String SerialNo;
    private String MaterialNo;
    private String MaterialDesc;
    private String WarehouseNo;
    private String HouseNo;
    private String AreaNo;
    private Float Qty;
    private String TMaterialNo;
    private String TMaterialDesc;
    private String PickAreaNo;
    private String CelareaNo;
    private Float IsDel;
    private String BatchNo;
    private String SN;
    private String ReturnSupCode;
    private String ReturnReson;
    private String ReturnSupName;
    private Float OldStockID;
    private Float TaskDetailesID;
    private Float CheckID;
    private Float TransferDetailsID;
    private Float ReturnType;
    private String ReturnTypeDesc;
    private String Unit;
    private String SaleName;
    private String UnitName;
    private String PalletNo;
    private Float ReceiveStatus;
    private String ToAreaNo;
    private String FromAreaNo;
    private String FromHouseNo;
    private String FromWareHouseNo;
    private Float PalletQty;
    private int WareHouseID;
    private int HouseID;
    private int AreaID;
    private int FromAreaID;
    private int FromHouseID;
    private int FromWareHouseID;
    private String PartNo;
    private int IsLimitStock;
    private int IsQuality;
    private String SupCode;
    private String SupName;
    private Date ProductDate;
    private String SupPrdBatch;
    private Date SupPrdDate;
    /// <summary>
    /// 下架方式 1-整托 2-整箱 3-零数
    /// </summary>
    private int PickModel;
    /// <summary>
    /// 零数
    /// </summary>
    private Float AmountQty;
    /// <summary>
    /// 楼层编码
    /// </summary>
    private int FloorType;
    /// <summary>
    /// 高低库位
    /// </summary>
    private int HeightArea;
    /// <summary>
    /// 库位类型
    /// </summary>
    private int AreaType;
    private Float ScanQty;
    private String FromBatchNo;
    private String FromErpAreaNo;
    private String FromErpWarehouse;
    private String ToBatchNo;
    private String ToErpAreaNo;
    private String ToErpWarehouse;
    private String PostUser;
    private int OutstockDetailID;
    private int OutstockHeaderID;
    private Boolean OKSelect;
    private int MaterialChangeID;
    private Float OutTaskDetID;
    private String UnitTypeCode;
    private String FloatLngth;
    private String IsSpcBatch;
    private String SortArea;
    private String IsRetention;
    private String MoveType;

    public String getMoveType() {
        return MoveType;
    }

    public void setMoveType(String moveType) {
        MoveType = moveType;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
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

    public Float getQty() {
        return Qty;
    }

    public void setQty(Float qty) {
        Qty = qty;
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

    public String getPickAreaNo() {
        return PickAreaNo;
    }

    public void setPickAreaNo(String pickAreaNo) {
        PickAreaNo = pickAreaNo;
    }

    public String getCelareaNo() {
        return CelareaNo;
    }

    public void setCelareaNo(String celareaNo) {
        CelareaNo = celareaNo;
    }

    public Float getIsDel() {
        return IsDel;
    }

    public void setIsDel(Float isDel) {
        IsDel = isDel;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getReturnSupCode() {
        return ReturnSupCode;
    }

    public void setReturnSupCode(String returnSupCode) {
        ReturnSupCode = returnSupCode;
    }

    public String getReturnReson() {
        return ReturnReson;
    }

    public void setReturnReson(String returnReson) {
        ReturnReson = returnReson;
    }

    public String getReturnSupName() {
        return ReturnSupName;
    }

    public void setReturnSupName(String returnSupName) {
        ReturnSupName = returnSupName;
    }

    public Float getOldStockID() {
        return OldStockID;
    }

    public void setOldStockID(Float oldStockID) {
        OldStockID = oldStockID;
    }

    public Float getTaskDetailesID() {
        return TaskDetailesID;
    }

    public void setTaskDetailesID(Float taskDetailesID) {
        TaskDetailesID = taskDetailesID;
    }

    public Float getCheckID() {
        return CheckID;
    }

    public void setCheckID(Float checkID) {
        CheckID = checkID;
    }

    public Float getTransferDetailsID() {
        return TransferDetailsID;
    }

    public void setTransferDetailsID(Float transferDetailsID) {
        TransferDetailsID = transferDetailsID;
    }

    public Float getReturnType() {
        return ReturnType;
    }

    public void setReturnType(Float returnType) {
        ReturnType = returnType;
    }

    public String getReturnTypeDesc() {
        return ReturnTypeDesc;
    }

    public void setReturnTypeDesc(String returnTypeDesc) {
        ReturnTypeDesc = returnTypeDesc;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getSaleName() {
        return SaleName;
    }

    public void setSaleName(String saleName) {
        SaleName = saleName;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getPalletNo() {
        return PalletNo;
    }

    public void setPalletNo(String palletNo) {
        PalletNo = palletNo;
    }

    public Float getReceiveStatus() {
        return ReceiveStatus;
    }

    public void setReceiveStatus(Float receiveStatus) {
        ReceiveStatus = receiveStatus;
    }

    public String getToAreaNo() {
        return ToAreaNo;
    }

    public void setToAreaNo(String toAreaNo) {
        ToAreaNo = toAreaNo;
    }

    public String getFromAreaNo() {
        return FromAreaNo;
    }

    public void setFromAreaNo(String fromAreaNo) {
        FromAreaNo = fromAreaNo;
    }

    public String getFromHouseNo() {
        return FromHouseNo;
    }

    public void setFromHouseNo(String fromHouseNo) {
        FromHouseNo = fromHouseNo;
    }

    public String getFromWareHouseNo() {
        return FromWareHouseNo;
    }

    public void setFromWareHouseNo(String fromWareHouseNo) {
        FromWareHouseNo = fromWareHouseNo;
    }

    public Float getPalletQty() {
        return PalletQty;
    }

    public void setPalletQty(Float palletQty) {
        PalletQty = palletQty;
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

    public int getFromAreaID() {
        return FromAreaID;
    }

    public void setFromAreaID(int fromAreaID) {
        FromAreaID = fromAreaID;
    }

    public int getFromHouseID() {
        return FromHouseID;
    }

    public void setFromHouseID(int fromHouseID) {
        FromHouseID = fromHouseID;
    }

    public int getFromWareHouseID() {
        return FromWareHouseID;
    }

    public void setFromWareHouseID(int fromWareHouseID) {
        FromWareHouseID = fromWareHouseID;
    }

    public String getPartNo() {
        return PartNo;
    }

    public void setPartNo(String partNo) {
        PartNo = partNo;
    }

    public int getIsLimitStock() {
        return IsLimitStock;
    }

    public void setIsLimitStock(int isLimitStock) {
        IsLimitStock = isLimitStock;
    }

    public int getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(int isQuality) {
        IsQuality = isQuality;
    }

    public String getSupCode() {
        return SupCode;
    }

    public void setSupCode(String supCode) {
        SupCode = supCode;
    }

    public String getSupName() {
        return SupName;
    }

    public void setSupName(String supName) {
        SupName = supName;
    }

    public Date getProductDate() {
        return ProductDate;
    }

    public void setProductDate(Date productDate) {
        ProductDate = productDate;
    }

    public String getSupPrdBatch() {
        return SupPrdBatch;
    }

    public void setSupPrdBatch(String supPrdBatch) {
        SupPrdBatch = supPrdBatch;
    }

    public Date getSupPrdDate() {
        return SupPrdDate;
    }

    public void setSupPrdDate(Date supPrdDate) {
        SupPrdDate = supPrdDate;
    }

    public int getPickModel() {
        return PickModel;
    }

    public void setPickModel(int pickModel) {
        PickModel = pickModel;
    }

    public Float getAmountQty() {
        return AmountQty;
    }

    public void setAmountQty(Float amountQty) {
        AmountQty = amountQty;
    }

    public int getFloorType() {
        return FloorType;
    }

    public void setFloorType(int floorType) {
        FloorType = floorType;
    }

    public int getHeightArea() {
        return HeightArea;
    }

    public void setHeightArea(int heightArea) {
        HeightArea = heightArea;
    }

    public int getAreaType() {
        return AreaType;
    }

    public void setAreaType(int areaType) {
        AreaType = areaType;
    }

    public Float getScanQty() {
        return ScanQty;
    }

    public void setScanQty(Float scanQty) {
        ScanQty = scanQty;
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

    public String getPostUser() {
        return PostUser;
    }

    public void setPostUser(String postUser) {
        PostUser = postUser;
    }

    public int getOutstockDetailID() {
        return OutstockDetailID;
    }

    public void setOutstockDetailID(int outstockDetailID) {
        OutstockDetailID = outstockDetailID;
    }

    public int getOutstockHeaderID() {
        return OutstockHeaderID;
    }

    public void setOutstockHeaderID(int outstockHeaderID) {
        OutstockHeaderID = outstockHeaderID;
    }

    public Boolean getOKSelect() {
        return OKSelect;
    }

    public void setOKSelect(Boolean OKSelect) {
        this.OKSelect = OKSelect;
    }

    public int getMaterialChangeID() {
        return MaterialChangeID;
    }

    public void setMaterialChangeID(int materialChangeID) {
        MaterialChangeID = materialChangeID;
    }

    public Float getOutTaskDetID() {
        return OutTaskDetID;
    }

    public void setOutTaskDetID(Float outTaskDetID) {
        OutTaskDetID = outTaskDetID;
    }

    public String getUnitTypeCode() {
        return UnitTypeCode;
    }

    public void setUnitTypeCode(String unitTypeCode) {
        UnitTypeCode = unitTypeCode;
    }

    public String getFloatLngth() {
        return FloatLngth;
    }

    public void setFloatLngth(String floatLngth) {
        FloatLngth = floatLngth;
    }

    public String getIsSpcBatch() {
        return IsSpcBatch;
    }

    public void setIsSpcBatch(String isSpcBatch) {
        IsSpcBatch = isSpcBatch;
    }

    public String getSortArea() {
        return SortArea;
    }

    public void setSortArea(String sortArea) {
        SortArea = sortArea;
    }

    public String getIsRetention() {
        return IsRetention;
    }

    public void setIsRetention(String isRetention) {
        IsRetention = isRetention;
    }

    public StockInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.Barcode);
        dest.writeString(this.SerialNo);
        dest.writeString(this.MaterialNo);
        dest.writeString(this.MaterialDesc);
        dest.writeString(this.WarehouseNo);
        dest.writeString(this.HouseNo);
        dest.writeString(this.AreaNo);
        dest.writeValue(this.Qty);
        dest.writeString(this.TMaterialNo);
        dest.writeString(this.TMaterialDesc);
        dest.writeString(this.PickAreaNo);
        dest.writeString(this.CelareaNo);
        dest.writeValue(this.IsDel);
        dest.writeString(this.BatchNo);
        dest.writeString(this.SN);
        dest.writeString(this.ReturnSupCode);
        dest.writeString(this.ReturnReson);
        dest.writeString(this.ReturnSupName);
        dest.writeValue(this.OldStockID);
        dest.writeValue(this.TaskDetailesID);
        dest.writeValue(this.CheckID);
        dest.writeValue(this.TransferDetailsID);
        dest.writeValue(this.ReturnType);
        dest.writeString(this.ReturnTypeDesc);
        dest.writeString(this.Unit);
        dest.writeString(this.SaleName);
        dest.writeString(this.UnitName);
        dest.writeString(this.PalletNo);
        dest.writeValue(this.ReceiveStatus);
        dest.writeString(this.ToAreaNo);
        dest.writeString(this.FromAreaNo);
        dest.writeString(this.FromHouseNo);
        dest.writeString(this.FromWareHouseNo);
        dest.writeValue(this.PalletQty);
        dest.writeInt(this.WareHouseID);
        dest.writeInt(this.HouseID);
        dest.writeInt(this.AreaID);
        dest.writeInt(this.FromAreaID);
        dest.writeInt(this.FromHouseID);
        dest.writeInt(this.FromWareHouseID);
        dest.writeString(this.PartNo);
        dest.writeInt(this.IsLimitStock);
        dest.writeInt(this.IsQuality);
        dest.writeString(this.SupCode);
        dest.writeString(this.SupName);
        dest.writeLong(this.ProductDate != null ? this.ProductDate.getTime() : -1);
        dest.writeString(this.SupPrdBatch);
        dest.writeLong(this.SupPrdDate != null ? this.SupPrdDate.getTime() : -1);
        dest.writeInt(this.PickModel);
        dest.writeValue(this.AmountQty);
        dest.writeInt(this.FloorType);
        dest.writeInt(this.HeightArea);
        dest.writeInt(this.AreaType);
        dest.writeValue(this.ScanQty);
        dest.writeString(this.FromBatchNo);
        dest.writeString(this.FromErpAreaNo);
        dest.writeString(this.FromErpWarehouse);
        dest.writeString(this.ToBatchNo);
        dest.writeString(this.ToErpAreaNo);
        dest.writeString(this.ToErpWarehouse);
        dest.writeString(this.PostUser);
        dest.writeInt(this.OutstockDetailID);
        dest.writeInt(this.OutstockHeaderID);
        dest.writeValue(this.OKSelect);
        dest.writeInt(this.MaterialChangeID);
        dest.writeValue(this.OutTaskDetID);
        dest.writeString(this.UnitTypeCode);
        dest.writeString(this.FloatLngth);
        dest.writeString(this.IsSpcBatch);
        dest.writeString(this.SortArea);
        dest.writeString(this.IsRetention);
        dest.writeString(this.MoveType);
    }

    protected StockInfo(Parcel in) {
        super(in);
        this.Barcode = in.readString();
        this.SerialNo = in.readString();
        this.MaterialNo = in.readString();
        this.MaterialDesc = in.readString();
        this.WarehouseNo = in.readString();
        this.HouseNo = in.readString();
        this.AreaNo = in.readString();
        this.Qty = (Float) in.readValue(Float.class.getClassLoader());
        this.TMaterialNo = in.readString();
        this.TMaterialDesc = in.readString();
        this.PickAreaNo = in.readString();
        this.CelareaNo = in.readString();
        this.IsDel = (Float) in.readValue(Float.class.getClassLoader());
        this.BatchNo = in.readString();
        this.SN = in.readString();
        this.ReturnSupCode = in.readString();
        this.ReturnReson = in.readString();
        this.ReturnSupName = in.readString();
        this.OldStockID = (Float) in.readValue(Float.class.getClassLoader());
        this.TaskDetailesID = (Float) in.readValue(Float.class.getClassLoader());
        this.CheckID = (Float) in.readValue(Float.class.getClassLoader());
        this.TransferDetailsID = (Float) in.readValue(Float.class.getClassLoader());
        this.ReturnType = (Float) in.readValue(Float.class.getClassLoader());
        this.ReturnTypeDesc = in.readString();
        this.Unit = in.readString();
        this.SaleName = in.readString();
        this.UnitName = in.readString();
        this.PalletNo = in.readString();
        this.ReceiveStatus = (Float) in.readValue(Float.class.getClassLoader());
        this.ToAreaNo = in.readString();
        this.FromAreaNo = in.readString();
        this.FromHouseNo = in.readString();
        this.FromWareHouseNo = in.readString();
        this.PalletQty = (Float) in.readValue(Float.class.getClassLoader());
        this.WareHouseID = in.readInt();
        this.HouseID = in.readInt();
        this.AreaID = in.readInt();
        this.FromAreaID = in.readInt();
        this.FromHouseID = in.readInt();
        this.FromWareHouseID = in.readInt();
        this.PartNo = in.readString();
        this.IsLimitStock = in.readInt();
        this.IsQuality = in.readInt();
        this.SupCode = in.readString();
        this.SupName = in.readString();
        long tmpProductDate = in.readLong();
        this.ProductDate = tmpProductDate == -1 ? null : new Date(tmpProductDate);
        this.SupPrdBatch = in.readString();
        long tmpSupPrdDate = in.readLong();
        this.SupPrdDate = tmpSupPrdDate == -1 ? null : new Date(tmpSupPrdDate);
        this.PickModel = in.readInt();
        this.AmountQty = (Float) in.readValue(Float.class.getClassLoader());
        this.FloorType = in.readInt();
        this.HeightArea = in.readInt();
        this.AreaType = in.readInt();
        this.ScanQty = (Float) in.readValue(Float.class.getClassLoader());
        this.FromBatchNo = in.readString();
        this.FromErpAreaNo = in.readString();
        this.FromErpWarehouse = in.readString();
        this.ToBatchNo = in.readString();
        this.ToErpAreaNo = in.readString();
        this.ToErpWarehouse = in.readString();
        this.PostUser = in.readString();
        this.OutstockDetailID = in.readInt();
        this.OutstockHeaderID = in.readInt();
        this.OKSelect = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.MaterialChangeID = in.readInt();
        this.OutTaskDetID = (Float) in.readValue(Float.class.getClassLoader());
        this.UnitTypeCode = in.readString();
        this.FloatLngth = in.readString();
        this.IsSpcBatch = in.readString();
        this.SortArea = in.readString();
        this.IsRetention = in.readString();
        this.MoveType = in.readString();
    }

    public static final Creator<StockInfo> CREATOR = new Creator<StockInfo>() {
        @Override
        public StockInfo createFromParcel(Parcel source) {
            return new StockInfo(source);
        }

        @Override
        public StockInfo[] newArray(int size) {
            return new StockInfo[size];
        }
    };
}
