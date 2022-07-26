package model.Device;

public class Device
{
  public static final String CHROMEBOOK = "Chromebook";
  public static final String LIBRARY_COMPUTER = "BIB";
  //TODO Fix these with proper names!
  public static final String TYPE_3 = "Type 3";
  public static final String TYPE_4 = "Type 4";

  private String serialNumber;
  private String purchaseDate;
  private DeviceType deviceType;
  private int deviceID;

  public Device(String type, String serialNumber, String purchaseDate)
  {
    setType(type);
    setSerialNumber(serialNumber);
    setPurchaseDate(purchaseDate);
    deviceID = -1;
  }

  private void setPurchaseDate(String purchaseDate)
  {
    if (purchaseDate.isBlank())
    {
      throw new IllegalArgumentException("Purchase Date should not be null!");
    }

    this.purchaseDate = purchaseDate;
  }

  private void setSerialNumber(String serialNumber)
  {
    if (serialNumber.isBlank())
    {
      throw new IllegalArgumentException("Serial Number should not be null!");
    }

    this.serialNumber = serialNumber;
  }

  private void setType(String type)
  {
    if (type.isBlank())
    {
      throw new IllegalArgumentException("Device type should not be null!");
    }

    switch (type)
    {
      case CHROMEBOOK: this.deviceType = DeviceType.CHROMEBOOK; break;
      case LIBRARY_COMPUTER: this.deviceType = DeviceType.BIB; break;
        //TODO Fix these with proper names!
      case TYPE_3: this.deviceType = DeviceType.TYPE3; break;
      case TYPE_4: this.deviceType = DeviceType.TYPE4; break;
      default: throw new IllegalArgumentException("Unknown Device Type!");
    }
  }

  public String getSerialNumber()
  {
    return serialNumber;
  }

  public String getPurchaseDate()
  {
    return purchaseDate;
  }

  public DeviceType getDeviceType()
  {
    return deviceType;
  }

  public void setDeviceID(int deviceID)
  {
    this.deviceID = deviceID;
  }

  public int getDeviceID()
  {
    return deviceID;
  }

  //DEBUG

  @Override public String toString()
  {
    return "Device{" + "serialNumber='" + serialNumber + '\''
        + ", purchaseDate='" + purchaseDate + '\'' + ", deviceType="
        + deviceType + ", deviceID=" + deviceID + '}';
  }
}
