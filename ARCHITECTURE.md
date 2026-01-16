# 🏛️ Architecture Guide

Welcome to the engine room! This document explains how Demos is built. We use **Kotlin Multiplatform (KMP)**, which allows us to write the business logic once and share it across Android, iOS, Desktop, and the Web.

### High-Level Overview

We follow a "Clean Architecture" approach. This keeps our code organized and makes it easier to test.

1.  **The UI Layer (Presentation):**
    * **Android:** Jetpack Compose.
    * **iOS:** SwiftUI (wrapping shared ViewModels).
    * This layer only cares about *showing* data to the user.

2.  **The Shared Layer (Business Logic):**
    * *This is where the magic happens.*
    * **ViewModels:** Handle the state of the screens.
    * **Interactors/UseCases:** Specific actions like `CastVote` or `AnalyzeSentiment`.
    * **Repositories:** Decide where data comes from (is it cached on the phone, or do we need to fetch it from the internet?).

3.  **The Data Layer:**
    * **Local Storage:** SQLDelight or Realm (for saving data on the device).
    * **Networking:** Ktor (for talking to news APIs and the Blockchain).

### Key Technologies

* **Coroutines & Flow:** We use these for "asynchronous" programming. It means the app won't freeze while it's loading data from the internet.
* **ML Kit / ONNX:** We run AI models directly on the user's device to analyze text sentiment. This enhances privacy since data doesn't always need to be sent to a cloud server for analysis.

### Directory Structure

* `/androidApp`: Android-specific code.
* `/iosApp`: iOS-specific code.
* `/shared`: The common code used by both platforms (Networking, Database, Logic).
