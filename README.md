🍲 Recipe App V2
A modern, reactive Android application built with a focus on performance and clean code. The app fetches real-time culinary data from TheMealDB API and provides a smooth user experience for exploring food categories and detailed cooking instructions.

🛠️ Technical Stack
Built using the latest Android development standards:

Language: Kotlin 2.0.21 (K2 Compiler)

UI Framework: Jetpack Compose — Fully declarative UI with no XML.

Networking: Retrofit — Type-safe HTTP client for API consumption.

Data Parsing: Gson — Seamless JSON serialization/deserialization.

Image Loading: Coil — Coroutine-based, asynchronous image loading.

Architecture: MVVM — Model-View-ViewModel for a robust separation of concerns.

Navigation: Compose Navigation — Type-safe screen transitions using NavHost and Parcelable objects.

🏗️ Key Architecture Details
The app is structured into a clean MVVM pattern to ensure maintainability:

UI Layer: Composable functions that observe state from the ViewModel. Includes a dynamic LazyVerticalGrid for categories.

State Management: Utilizes mutableStateOf within the ViewModel to handle Loading, Success, and Error states reactively.

Data Layer: Retrofit-powered API interface fetching data from a REST endpoint.

Navigation: Implements savedStateHandle to pass complex Category objects between the list and detail views efficiently.

✨ Features
Reactive UI: Real-time data fetching with a loading state indicator.

Grid Layout: Optimized category browsing using a 2-column grid.

Detailed View: Deep-dive into meal categories with justifications and high-resolution images.

Modern Theming: Full support for Dark Mode and Light Mode using Material 3 color schemes.

Robust Networking: Global try-catch error handling to manage network connectivity issues gracefully.

📸 Screen Previews
<table style="width:100%">
  <tr>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/cb1c6da0-60e2-414b-958f-231dc6156841" width="300px" /><br/>
      <b>Category List (Light)</b>
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/8f63221e-3587-462e-8906-b6251dbf522f" width="300px" /><br/>
      <b>Category List (Dark)</b>
    </td>
  </tr>
  <tr>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/71506a91-9511-4baf-b11a-6ac6640ffd5a" width="300px" /><br/>
      <b>Detail View</b>
    </td>
    <td align="center" width="50%">
      <img src="https://github.com/user-attachments/assets/5afdf77a-4f3a-493a-ab57-d19fd079c70f" width="300px" /><br/>
      <b>Scrollable Description</b>
    </td>
  </tr>
</table>
