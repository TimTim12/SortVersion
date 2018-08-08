import java.util.*;

public class SortVersion {

    public static void main (String[] args) {
        // Set the Device list with the given args or a default one.
        List<Device> Devices;
        if (args.length == 0)
            Devices = createDeviceListByVersion("1.0","18.3","4.8.9.1",null,"2.0.1","3.0.0.1","1.0.0.1");
        else
            Devices = createDeviceListByVersion(args);


        Devices = sortbyVersion(Devices);
        for (Device Device : Devices) {
            System.out.println(Device.getDevice());
        }
        System.out.println("The End");
    }


    // Sort a list of Devices by version in ascenading order.
    // If a device is null or containing a empty version, it is removed.
    public static List<Device> sortbyVersion(List <Device> devices) {
        int base;
        if (devices.isEmpty() || devices.size() == 1)
            return devices;

        for (int last = devices.size() - 1; last > 0; last--) {
            base = 0;
            for (int i = 0; i <= last - 1; i++) {
                while (devices.get(base) == null ||devices.get(base).getVersion() == null || devices.get(base).getVersion() == "") {
                    devices.remove(base);
                    last --;
                }
                while (devices.get(i + 1) == null ||devices.get(i + 1).getVersion() == null || devices.get(i + 1).getVersion() == "") {
                    devices.remove(i + 1);
                    last --;
                }

                if (base >= devices.size() || base + 1 > devices.size())
                    break;

                String[] a = devices.get(base).getVersion().split("\\.");
                String[] b = devices.get(i + 1).getVersion().split("\\.");

                if (!isGreaterDevices(a, b)) {
                    base = i + 1;
                }
            }
            swap(devices, base, last);
        }
        return devices;
    }

    // swap two element of a given list.
    public static void swap(List <Device> list, int index1, int index2) {
        Device temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    // compare two string en return true if the first one is greater than the other
    public static boolean isGreaterDevices(String[] a, String[] b) {
        int length;

        if (a.length < b.length) {
            length = a.length;
        } else {
            length = b.length;
        }
        for (int j = 0; j < length; j++) {
            if (Integer.parseInt(a[j]) > Integer.parseInt(b[j]))
                return true;
            if (Integer.parseInt(a[j]) < Integer.parseInt(b[j]))
                return false;
        }
        if (a.length < b.length)
            return false;
        return true;
    }

    // Create a Device list from a String.
    public static List<Device> createDeviceListByVersion(String ... versions) {
        List<Device> Devices = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < versions.length; i++) {
            if (versions[i] == null)
                continue;
            Device element = new Device("Device" + (j + 1), versions[i]);
            Devices.add(j, element);
            j++;
        }
        return Devices;
    }
}
