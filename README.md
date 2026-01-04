# StoxLK - Colombo Stock Exchange (CSE) App

StoxLK is a modern Android application built with Jetpack Compose, designed to provide comprehensive market data, portfolio management, and stock analysis for the Colombo Stock Exchange (CSE).

## 📱 Features

*   **Secure Login**: Simple and secure email-based authentication flow.
*   **Home Dashboard**: 
    *   Real-time market status (Open/Closed).
    *   Total Equity summary with daily gain/loss.
    *   Quick view of major indices (ASPI, S&P SL20).
    *   Market Movers snapshot.
*   **Portfolio Management**: 
    *   Track your Net Worth.
    *   View detailed lists of current holdings.
    *   Monitor individual stock performance (Gain/Loss).
*   **Market Overview**: 
    *   Detailed breakdown of market indices.
    *   Top Gainers, Losers, and Active stocks.
    *   Sector performance overview.
    *   Live share prices with filtering options.
*   **Stock Search**: 
    *   Quick stock lookup by symbol or name.
    *   Trending searches and top results.
*   **Stock Profile**: 
    *   Interactive charts (Time ranges: 1D, 1W, 1M, etc.).
    *   Key statistics (Prev Close, Open, Volume, Market Cap).
    *   Company information and latest announcements.
*   **Settings**: 
    *   Profile management.
    *   App preferences (Currency, Alerts, News).
    *   Support and Info sections.

## 🛠 Tech Stack

*   **Language**: [Kotlin](https://kotlinlang.org/)
*   **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material Design 3)
*   **Architecture**: MVVM (Model-View-ViewModel)
*   **Navigation**: [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
*   **Dependency Injection**: [Hilt](https://dagger.dev/hilt/)
*   **Asynchronous Programming**: [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)

## 📂 Project Structure

The project follows a clean separation of concerns, organized primarily by feature within the `presentation` layer:

```
com.example.stoxlk
├── di              # Dependency Injection modules
├── domain          # Domain models and business logic (UseCases)
├── data            # Data layer (Repositories, API sources)
├── presentation    # UI Layer (Screens & ViewModels)
│   ├── home        # Dashboard screen & shared components
│   ├── portfolio   # Portfolio screen
│   ├── market      # Market overview screen
│   ├── search      # Search screen
│   ├── stock       # Stock details screen
│   ├── settings    # Settings screen
│   ├── intro       # Login/Intro screen
│   └── theme       # App theme (Type, Color, Shape)
└── MainActivity.kt # Single Activity entry point & Navigation Host
```

## 🚀 Setup Instructions

1.  **Prerequisites**:
    *   Android Studio Ladybug (2024.2.1) or newer.
    *   JDK 11 or newer.

2.  **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/stoxlk.git
    cd stoxlk
    ```

3.  **Open in Android Studio**:
    *   Launch Android Studio.
    *   Select **Open** and navigate to the cloned directory.

4.  **Sync Gradle**:
    *   Let Android Studio sync the project dependencies. This may take a few minutes.

5.  **Run the App**:
    *   Connect an Android device or start an Emulator.
    *   Click the **Run** button (green play icon) in the toolbar.

## 🤝 Contribution

Contributions are welcome! Please create a new branch for your feature or bug fix and submit a pull request.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
