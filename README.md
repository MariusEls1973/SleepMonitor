# Sleep Monitor

Privacy-focused Android sleep tracking app.

## Features

- **Overnight tracking** using microphone + accelerometer
- **Sleep stage estimation** (Awake / Light / Deep) every 30 seconds
- **Snore detection** (heuristic spectral proxy)
- **Sleep quality score** (0–100) based on efficiency, deep sleep, awakenings, snoring and movement
- **Daily hypnogram**
- **Weekly / monthly trend charts** (score & duration)
- **Best sleep window recommendation** from your highest-quality nights
- **100% on-device** — no internet permission required for core functionality

## Requirements

- Android Studio Ladybug (2024.2+) or newer
- JDK 17
- Android device or emulator with microphone (API 26+)

## How to build & run

1. Open the `SleepMonitor` folder in Android Studio.
2. Let Gradle sync (it will download dependencies).
3. Connect a physical phone (recommended) or start an emulator.
4. Click **Run**.

On first launch the app will request:
- Microphone
- Notifications (Android 13+)
- Activity recognition (optional)

## How to use

1. Open the app → **Tonight** tab.
2. Place the phone on the mattress (face-down is good) or on the nightstand close to your pillow.
3. Tap the big **Start Tracking** button.
4. Go to sleep. Keep the phone plugged in if possible.
5. In the morning tap **Stop & Analyze**.
6. View the quality score, history, trends and your personal best bedtime window.

## Project structure

```
app/src/main/java/com/sleepmonitor/app/
├── data/          # Room entities, DAO, database
├── service/       # SleepTrackingService (AudioRecord + accelerometer)
├── util/          # SleepAnalyzer (classification + scoring + best windows)
├── viewmodel/     # SleepViewModel
└── ui/
    ├── screens/   # Home, History, Trends, BestTimes
    ├── components/# HypnogramChart, SimpleBarChart
    └── theme/
```

## Notes & limitations

- Stage classification and snore detection are **heuristic**. They work reasonably well for personal use but are not medical-grade.
- Accuracy improves when the phone is on the mattress (better movement signal).
- For production you would replace the simple RMS/ZCR heuristics with a small on-device model (e.g. TFLite or the Rust DSP approach used by DeltaSleep).
- Launcher icons are placeholders — replace the files in `res/mipmap-*` with real icons.

## License

MIT — free to use, modify and redistribute.
