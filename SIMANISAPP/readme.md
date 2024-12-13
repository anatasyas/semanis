SIMANIS
---
## System Requirements
- **Android Studio**: Arctic Fox or later.
- **Android Version**: Minimum Android 6.0 (Marshmallow).
- **Libraries**:
- Retrofit
- Room Database
- TensorFlow Lite
- Material Components

---

## Installation and Configuration

### 1. Clone Repository
``` bash
git clone https://github.com/simanis.git
cd simanis
```

### 2. Open in Android Studio
- Open Android Studio.
- Select **File > Open** and navigate to the project folder.

### 3. Add API Key
- Create a `local.properties` file if it doesn't exist.
- Add a line for API_KEY

### 4. Build and Run the App
- Make sure your internet connection is active.
- Click **Run** or use the shortcut `Shift + F10` to run the application on the emulator or physical device.

---

## User Guide

1. **Sugar Intake Recording**
- Go to the main page and click the **Add Data** button.
- Enter the amount of sugar consumed (grams) and save.

2. **Monitor Daily Consumption**
- View the graph on the dashboard to combine sugar consumption trends.
- Notifications will appear if approaching the daily limit.

3. **Analysis with Machine Learning**
- Access the analysis feature to get recommendations for healthier sugar consumption patterns.

---

## Project Structure
```
simanis/
├── app/ # Main application folder
├── data/ # Data model and database space
├── network/ # API services using Retrofit
├── ui/ # UI Components and Activities/Fragments
├── util/ #Utilities such as themes and helper functions
└── ml/ # Machine Learning Integration with TensorFlow Lite
```

---

## Technologies Used
- **Kotlin**: Main programming language.
- **Retrofit**: For API integration.
- **Database Room**: For local data storage.
- **TensorFlow Lite**: For machine learning based data analysis.
- **Material Design**: For modern UI/UX.

---

## Contributions
We welcome contributions from anyone. Please follow these steps to contribute:

1. Fork this repository.
2. Create a new branch for the feature or fix.
``` bash
git checkout -b your-feature
```
3. Commit your changes.
``` bash
git commit -m "Description of changes"
```
4. Push to your repository and create a pull request.

---
