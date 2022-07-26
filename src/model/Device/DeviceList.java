package model.Device;

import java.util.ArrayList;

public class DeviceList
{
  private ArrayList<Device> deviceList;

  public DeviceList()
  {
    deviceList= new ArrayList<>();
  }

  public void addDevice(Device device)
  {
    if (contains(device))
    {
      throw new IllegalArgumentException("Device of identical Serial No and Type already present!");
    }

    deviceList.add(device);
  }

  public void removeDevice(Device device)
  {
    if (!contains(device))
    {
      throw new IllegalArgumentException("Device not found!");
    }
    deviceList.remove(device);
  }

  public boolean contains(Device device)
  {
    for (Device d : deviceList)
    {
      if (d.getDeviceType().equals(device.getDeviceType()))
      {
        if (d.getSerialNumber().equals(device.getSerialNumber()))
        {
          return true;
        }
      }
    }

    return false;
  }

  public ArrayList<Device> getAllDevices()
  {
    return deviceList;
  }

  public ArrayList<Device> getDevicesByType(DeviceType deviceType)
  {
    ArrayList<Device> devicesByType = new ArrayList<>();

    for (Device d : deviceList)
    {
      if (d.getDeviceType().equals(deviceType))
      {
        devicesByType.add(d);
      }
    }

    return devicesByType;
  }

  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("List of devices: \n");
    for (Device d : deviceList)
    {
      sb.append(d + "\n");
    }
    return sb.toString();
  }
}
