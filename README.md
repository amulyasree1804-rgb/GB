# iQOO GameBridge

Stage 1 establishes the phone-to-laptop WebSocket connection.

## Direct Bluetooth HID mode

GameBridge runs only on the Android phone. The phone registers as a standard
Bluetooth HID game controller, so Windows receives controller input without a
GameBridge server, Python process, Node.js process, or companion application.

The target phone must support Android's Bluetooth HID Device profile (Android
9/API 28 or newer). Pair the phone with the laptop from the app, then use the
controller screen to send HID input reports.

When the repository is inside OneDrive and Gradle reports an access-denied
error in `app\build`, keep build outputs outside the synced folder:

```powershell
$env:IQOO_BUILD_DIR = "$env:LOCALAPPDATA\Temp\iQOO-GameBridge-build"
.\gradlew.bat assembleDebug
```

Wi-Fi is retained in the UI but is not a direct controller transport yet.

## Android app

Open this folder in Android Studio, sync Gradle, connect an Android phone over USB/Wi-Fi debugging, and run the `app` configuration. The app follows the phone orientation by default. Use the Orientation menu to select Auto, Portrait, or Landscape for the whole application.

## Phase 2

After connecting, open Game Profiles and select FPS, Racing, or Custom. The controller adapts to the current orientation: portrait places the joystick and face buttons vertically, while landscape uses a full-width layout with shoulder and system controls in the center. Button and joystick events are sent over the existing WebSocket and translated by the laptop server through `pynput`.

## Bluetooth HID test

1. Turn on Bluetooth on the phone and laptop.
2. Launch the Android app.
3. Select `AUTO` or `BLUETOOTH` and tap `SCAN`.
4. Select the laptop from the actual Bluetooth device list and tap `CONNECT`.
5. Approve pairing if requested and confirm Windows recognizes the phone as a controller.
6. Use the controller buttons and joystick.
