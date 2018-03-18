package xx.com.lib_common.Common_Model.Model.Material;

import android.os.Parcel;
import android.os.Parcelable;

import xx.com.lib_common.Common_Model.Model.Base_Model;

/**
 * Created by GHOST on 2018/3/6.
 */

public class MaterialInfo  extends Base_Model implements Parcelable{

    private String MaterialNo;
    private String MaterialDesc;
    private String MaterialDescEN;
    private int StackWareHouse;
    private int StackHouse;
    private int StackArea;
    private Float Length;
    private Float Wide;
    private Float Hight;
    private Float Volume;
    private Float Weight;
    private Float NetWeight;
    private Float PackRule;
    private Float StackRule;
    private Float DisRule;
    private String SupplierNo;
    private String SupplierName;
    private String Unit;
    private String UnitName;
    private String KeeperNo;
    private String KeeperName;
    private Float IsDangerous;
    private Float IsActivate;
    private Float IsBond;
    private Float IsQuality;
    private int IsSerial;
    private String PartNo;
    private String MainTypeCode;
    private String MainTypeName;
    private String PurchaseTypeCode;
    private String PurchaseTypeName;
    private String ProductTypeCode;
    private String ProductTypeName;
    private Float QualityDay;
    private Float QualityMon;
    private String Brand;
    private String PlaceArea;
    private String LifeCycle;
    private Float PackQty;
    private Float PalletVolume;
    private Float PalletPackQty;
    private Float PackVolume;
    private String ProtectWay;
    private String SpecialRequire;
    private String StoreCondition;
    /// <summary>
    /// 2-只查询物料表 1-查询库存表和物料表
    /// </summary>
    private int QueryStock;
    private String BatchNo;
    private String WareHouseNo;
    private String AreaNo;
    private int WareHouseID;
    private int AreaID;
    private Float StockQty;
    /// <summary>
    /// 商品69码
    /// </summary>
    private String BarCode;
    private String SerialNo;

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

    public String getMaterialDescEN() {
        return MaterialDescEN;
    }

    public void setMaterialDescEN(String materialDescEN) {
        MaterialDescEN = materialDescEN;
    }

    public int getStackWareHouse() {
        return StackWareHouse;
    }

    public void setStackWareHouse(int stackWareHouse) {
        StackWareHouse = stackWareHouse;
    }

    public int getStackHouse() {
        return StackHouse;
    }

    public void setStackHouse(int stackHouse) {
        StackHouse = stackHouse;
    }

    public int getStackArea() {
        return StackArea;
    }

    public void setStackArea(int stackArea) {
        StackArea = stackArea;
    }

    public Float getLength() {
        return Length;
    }

    public void setLength(Float length) {
        Length = length;
    }

    public Float getWide() {
        return Wide;
    }

    public void setWide(Float wide) {
        Wide = wide;
    }

    public Float getHight() {
        return Hight;
    }

    public void setHight(Float hight) {
        Hight = hight;
    }

    public Float getVolume() {
        return Volume;
    }

    public void setVolume(Float volume) {
        Volume = volume;
    }

    public Float getWeight() {
        return Weight;
    }

    public void setWeight(Float weight) {
        Weight = weight;
    }

    public Float getNetWeight() {
        return NetWeight;
    }

    public void setNetWeight(Float netWeight) {
        NetWeight = netWeight;
    }

    public Float getPackRule() {
        return PackRule;
    }

    public void setPackRule(Float packRule) {
        PackRule = packRule;
    }

    public Float getStackRule() {
        return StackRule;
    }

    public void setStackRule(Float stackRule) {
        StackRule = stackRule;
    }

    public Float getDisRule() {
        return DisRule;
    }

    public void setDisRule(Float disRule) {
        DisRule = disRule;
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

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getKeeperNo() {
        return KeeperNo;
    }

    public void setKeeperNo(String keeperNo) {
        KeeperNo = keeperNo;
    }

    public String getKeeperName() {
        return KeeperName;
    }

    public void setKeeperName(String keeperName) {
        KeeperName = keeperName;
    }

    public Float getIsDangerous() {
        return IsDangerous;
    }

    public void setIsDangerous(Float isDangerous) {
        IsDangerous = isDangerous;
    }

    public Float getIsActivate() {
        return IsActivate;
    }

    public void setIsActivate(Float isActivate) {
        IsActivate = isActivate;
    }

    public Float getIsBond() {
        return IsBond;
    }

    public void setIsBond(Float isBond) {
        IsBond = isBond;
    }

    public Float getIsQuality() {
        return IsQuality;
    }

    public void setIsQuality(Float isQuality) {
        IsQuality = isQuality;
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

    public String getMainTypeCode() {
        return MainTypeCode;
    }

    public void setMainTypeCode(String mainTypeCode) {
        MainTypeCode = mainTypeCode;
    }

    public String getMainTypeName() {
        return MainTypeName;
    }

    public void setMainTypeName(String mainTypeName) {
        MainTypeName = mainTypeName;
    }

    public String getPurchaseTypeCode() {
        return PurchaseTypeCode;
    }

    public void setPurchaseTypeCode(String purchaseTypeCode) {
        PurchaseTypeCode = purchaseTypeCode;
    }

    public String getPurchaseTypeName() {
        return PurchaseTypeName;
    }

    public void setPurchaseTypeName(String purchaseTypeName) {
        PurchaseTypeName = purchaseTypeName;
    }

    public String getProductTypeCode() {
        return ProductTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        ProductTypeCode = productTypeCode;
    }

    public String getProductTypeName() {
        return ProductTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        ProductTypeName = productTypeName;
    }

    public Float getQualityDay() {
        return QualityDay;
    }

    public void setQualityDay(Float qualityDay) {
        QualityDay = qualityDay;
    }

    public Float getQualityMon() {
        return QualityMon;
    }

    public void setQualityMon(Float qualityMon) {
        QualityMon = qualityMon;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getPlaceArea() {
        return PlaceArea;
    }

    public void setPlaceArea(String placeArea) {
        PlaceArea = placeArea;
    }

    public String getLifeCycle() {
        return LifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        LifeCycle = lifeCycle;
    }

    public Float getPackQty() {
        return PackQty;
    }

    public void setPackQty(Float packQty) {
        PackQty = packQty;
    }

    public Float getPalletVolume() {
        return PalletVolume;
    }

    public void setPalletVolume(Float palletVolume) {
        PalletVolume = palletVolume;
    }

    public Float getPalletPackQty() {
        return PalletPackQty;
    }

    public void setPalletPackQty(Float palletPackQty) {
        PalletPackQty = palletPackQty;
    }

    public Float getPackVolume() {
        return PackVolume;
    }

    public void setPackVolume(Float packVolume) {
        PackVolume = packVolume;
    }

    public String getProtectWay() {
        return ProtectWay;
    }

    public void setProtectWay(String protectWay) {
        ProtectWay = protectWay;
    }

    public String getSpecialRequire() {
        return SpecialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        SpecialRequire = specialRequire;
    }

    public String getStoreCondition() {
        return StoreCondition;
    }

    public void setStoreCondition(String storeCondition) {
        StoreCondition = storeCondition;
    }

    public int getQueryStock() {
        return QueryStock;
    }

    public void setQueryStock(int queryStock) {
        QueryStock = queryStock;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public void setBatchNo(String batchNo) {
        BatchNo = batchNo;
    }

    public String getWareHouseNo() {
        return WareHouseNo;
    }

    public void setWareHouseNo(String wareHouseNo) {
        WareHouseNo = wareHouseNo;
    }

    public String getAreaNo() {
        return AreaNo;
    }

    public void setAreaNo(String areaNo) {
        AreaNo = areaNo;
    }

    public int getWareHouseID() {
        return WareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        WareHouseID = wareHouseID;
    }

    public int getAreaID() {
        return AreaID;
    }

    public void setAreaID(int areaID) {
        AreaID = areaID;
    }

    public Float getStockQty() {
        return StockQty;
    }

    public void setStockQty(Float stockQty) {
        StockQty = stockQty;
    }

    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }


    public MaterialInfo() {
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
        dest.writeString(this.MaterialDescEN);
        dest.writeInt(this.StackWareHouse);
        dest.writeInt(this.StackHouse);
        dest.writeInt(this.StackArea);
        dest.writeValue(this.Length);
        dest.writeValue(this.Wide);
        dest.writeValue(this.Hight);
        dest.writeValue(this.Volume);
        dest.writeValue(this.Weight);
        dest.writeValue(this.NetWeight);
        dest.writeValue(this.PackRule);
        dest.writeValue(this.StackRule);
        dest.writeValue(this.DisRule);
        dest.writeString(this.SupplierNo);
        dest.writeString(this.SupplierName);
        dest.writeString(this.Unit);
        dest.writeString(this.UnitName);
        dest.writeString(this.KeeperNo);
        dest.writeString(this.KeeperName);
        dest.writeValue(this.IsDangerous);
        dest.writeValue(this.IsActivate);
        dest.writeValue(this.IsBond);
        dest.writeValue(this.IsQuality);
        dest.writeInt(this.IsSerial);
        dest.writeString(this.PartNo);
        dest.writeString(this.MainTypeCode);
        dest.writeString(this.MainTypeName);
        dest.writeString(this.PurchaseTypeCode);
        dest.writeString(this.PurchaseTypeName);
        dest.writeString(this.ProductTypeCode);
        dest.writeString(this.ProductTypeName);
        dest.writeValue(this.QualityDay);
        dest.writeValue(this.QualityMon);
        dest.writeString(this.Brand);
        dest.writeString(this.PlaceArea);
        dest.writeString(this.LifeCycle);
        dest.writeValue(this.PackQty);
        dest.writeValue(this.PalletVolume);
        dest.writeValue(this.PalletPackQty);
        dest.writeValue(this.PackVolume);
        dest.writeString(this.ProtectWay);
        dest.writeString(this.SpecialRequire);
        dest.writeString(this.StoreCondition);
        dest.writeInt(this.QueryStock);
        dest.writeString(this.BatchNo);
        dest.writeString(this.WareHouseNo);
        dest.writeString(this.AreaNo);
        dest.writeInt(this.WareHouseID);
        dest.writeInt(this.AreaID);
        dest.writeValue(this.StockQty);
        dest.writeString(this.BarCode);
        dest.writeString(this.SerialNo);
    }

    protected MaterialInfo(Parcel in) {
        super(in);
        this.MaterialNo = in.readString();
        this.MaterialDesc = in.readString();
        this.MaterialDescEN = in.readString();
        this.StackWareHouse = in.readInt();
        this.StackHouse = in.readInt();
        this.StackArea = in.readInt();
        this.Length = (Float) in.readValue(Float.class.getClassLoader());
        this.Wide = (Float) in.readValue(Float.class.getClassLoader());
        this.Hight = (Float) in.readValue(Float.class.getClassLoader());
        this.Volume = (Float) in.readValue(Float.class.getClassLoader());
        this.Weight = (Float) in.readValue(Float.class.getClassLoader());
        this.NetWeight = (Float) in.readValue(Float.class.getClassLoader());
        this.PackRule = (Float) in.readValue(Float.class.getClassLoader());
        this.StackRule = (Float) in.readValue(Float.class.getClassLoader());
        this.DisRule = (Float) in.readValue(Float.class.getClassLoader());
        this.SupplierNo = in.readString();
        this.SupplierName = in.readString();
        this.Unit = in.readString();
        this.UnitName = in.readString();
        this.KeeperNo = in.readString();
        this.KeeperName = in.readString();
        this.IsDangerous = (Float) in.readValue(Float.class.getClassLoader());
        this.IsActivate = (Float) in.readValue(Float.class.getClassLoader());
        this.IsBond = (Float) in.readValue(Float.class.getClassLoader());
        this.IsQuality = (Float) in.readValue(Float.class.getClassLoader());
        this.IsSerial = in.readInt();
        this.PartNo = in.readString();
        this.MainTypeCode = in.readString();
        this.MainTypeName = in.readString();
        this.PurchaseTypeCode = in.readString();
        this.PurchaseTypeName = in.readString();
        this.ProductTypeCode = in.readString();
        this.ProductTypeName = in.readString();
        this.QualityDay = (Float) in.readValue(Float.class.getClassLoader());
        this.QualityMon = (Float) in.readValue(Float.class.getClassLoader());
        this.Brand = in.readString();
        this.PlaceArea = in.readString();
        this.LifeCycle = in.readString();
        this.PackQty = (Float) in.readValue(Float.class.getClassLoader());
        this.PalletVolume = (Float) in.readValue(Float.class.getClassLoader());
        this.PalletPackQty = (Float) in.readValue(Float.class.getClassLoader());
        this.PackVolume = (Float) in.readValue(Float.class.getClassLoader());
        this.ProtectWay = in.readString();
        this.SpecialRequire = in.readString();
        this.StoreCondition = in.readString();
        this.QueryStock = in.readInt();
        this.BatchNo = in.readString();
        this.WareHouseNo = in.readString();
        this.AreaNo = in.readString();
        this.WareHouseID = in.readInt();
        this.AreaID = in.readInt();
        this.StockQty = (Float) in.readValue(Float.class.getClassLoader());
        this.BarCode = in.readString();
        this.SerialNo = in.readString();
    }

    public static final Creator<MaterialInfo> CREATOR = new Creator<MaterialInfo>() {
        @Override
        public MaterialInfo createFromParcel(Parcel source) {
            return new MaterialInfo(source);
        }

        @Override
        public MaterialInfo[] newArray(int size) {
            return new MaterialInfo[size];
        }
    };
}
