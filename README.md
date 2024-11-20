# YTubeBackplay aka Deep Relax No-Sleep YouTube Player

A personalized mobile application designed to offer an uninterrupted, ad-free experience of relaxation videos from YouTube. Perfect for those moments of relaxation where you just want peace without ads or interruptions. Initially developed for personal use, this app has been revamped to showcase professional standards and development best practices.

## Features

- **Background Playback:** Play videos even when the app is minimized.
- **Ad-Free:** No interruptions. Just pure relaxation.
- **Simple UI:** Straightforward and user-friendly design.
- **Custom Video Playlist:** Fetches a custom list of YouTube video IDs from a private GitHub repository. Update the list remotely via GitHub.

---

## What's New in v3.0 ( November 2024)
- Transitioned to clean architecture for maintainability and scalability.
- Integrated Hilt for efficient dependency management.
- Fixed network and threading issues by adopting coroutines with proper Dispatchers.IO.
- Updated UI for better usability and responsiveness.
- Added robust error handling and scoped dependencies.
- Prepared for future enhancements with improved code structure.

---

## Setup

### Prerequisites
- Android Studio (version 2023.1.1 Canary 15 or higher)
- An Android device/emulator with Internet access

### Steps
1. Clone this repository: git clone https://github.com/RomanTsisyk/deep-relax-youtube-player.git
2. Open the project in Android Studio.
3. Run on your preferred device or emulator.

## Usage
Simply open the app, scroll through the video list, and play your desired relaxation video. The app will continue playing videos even when in the background.

**Note:** This app is intended for private use. Due to its background playback capability (which goes against YouTube's TOS), it isn't suitable for publishing on the Google Play Store.

## Contributing
Since this is a private app, contributions are restricted. However, if you have suggestions or feedback, please open an issue.

## License
Private use only. Not for distribution or commercial use.

## Acknowledgements
- [OkHttp](https://square.github.io/okhttp/)
- [Gson](https://github.com/google/gson)
- [android-youtube-player](https://github.com/PierfrancescoSoffritti/android-youtube-player)
