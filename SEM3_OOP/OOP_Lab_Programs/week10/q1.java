import java.util.Scanner;

interface WiFiEnabled {
    void connectToWiFi(String networkName);
}

interface BluetoothEnabled {
    void connectToBluetooth(String deviceName);
}

class SmartSpeaker implements WiFiEnabled, BluetoothEnabled {
    
    public void connectToWiFi(String networkName) {
        System.out.println("Connected to WiFi network: " + networkName);
    }
    
    public void connectToBluetooth(String deviceName) {
        System.out.println("Connected to Bluetooth device: " + deviceName);
    }
    
    public void playMusic(String songName) {
        System.out.println("Playing song: " + songName);
    }
}

public class q1 {
    public static void main(String[] args) {
        SmartSpeaker speaker = new SmartSpeaker();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter WiFi Network Name: ");
        String wifiNetworkName = sc.nextLine();

        System.out.print("Enter Bluetooth Device Name: ");
        String bluetoothDeviceName = sc.nextLine();

        System.out.print("Enter Song Name: ");
        String songName = sc.nextLine();

        speaker.connectToWiFi(wifiNetworkName);
        speaker.connectToBluetooth(bluetoothDeviceName);
        speaker.playMusic(songName);

        sc.close();
    }
}
