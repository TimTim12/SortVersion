import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class SortVersionTest{

    @Test
    void sortbyVersionTest() {
        List<Device> Devices = new ArrayList<>();
        Devices.add(0, new Device("Device1", "1.2.3"));
        Devices.add(1, new Device("Device2", "18.3"));
        Devices.add(2, new Device("Device Null", null));
        Devices.add(3, new Device("Device3", "1"));
        Devices.add(4, new Device("Device Empty", ""));
        Devices.add(5, new Device("Device4", "1.3.5"));
        Devices.add(6, null);
        Devices.add(7, new Device("Device5", "4.5.6"));

        List<Device> Result = new ArrayList<>();
        Result.add(0, new Device("Device1", "1"));
        Result.add(1, new Device("Device2", "1.2.3"));
        Result.add(2, new Device("Device3", "1.3.5"));
        Result.add(3, new Device("Device4", "4.5.6"));
        Result.add(4, new Device("Device5", "18.3"));

        Devices = SortVersion.sortbyVersion(Devices);
        for (int i = 0; i < Devices.size(); i++) {
            Assertions.assertEquals(Devices.get(i).getVersion(), Result.get(i).getVersion());
        }
    }

    @Test
    void swapTest() {
        List<Device> Devices = new ArrayList<>();
        Devices.add(0, new Device("Device1", "1.2.3"));
        Devices.add(1, new Device("Device2", "4.5.6"));
        String result1 = "4.5.6";
        String result2 = "1.2.3";
        SortVersion.swap(Devices,0,1);
        Assertions.assertEquals(Devices.get(0).getVersion(), result1);
        Assertions.assertEquals(Devices.get(1).getVersion(), result2);
    }

    @Test
    void isGreaterDevicesTest() {
        String[] a = {"12","3","5"};
        String[] b = {"1","2"};
        Assertions.assertTrue(SortVersion.isGreaterDevices(a,b));
    }
}