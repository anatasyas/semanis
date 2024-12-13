# Simanis - Daily Sugar Intake Tracker

Simanis is a mobile application designed to help users track their daily sugar intake. The app allows users to manually input their sugar consumption and sets alerts when intake limits are approached or exceeded. It integrates with a backend API built using FastAPI for secure data management and provides machine learning tools to analyze health data.

## Features

- **Track Daily Sugar Intake:** Users can manually enter their daily sugar intake.
- **Alerts:** Notifications when sugar intake exceeds the set limit.
- **API Integration:** Secure data management using a FastAPI backend.
- **Machine Learning Analysis:** The app uses machine learning to analyze sugar intake patterns and make predictions.
- **Data Access & Visualization:** Detailed tracking with easy-to-read visualizations and reports.

## Project Structure

- **Mobile App (Android)**
  - Built with Android Studio using Kotlin.
  - Includes features for entering, tracking, and analyzing daily sugar intake.
  - Integrates with the FastAPI backend for secure data management.
  
- **Backend API**
  - Built using FastAPI.
  - Handles user authentication, data storage, and secure data management.

### 1. **POST /add-sugar-intake**
   - **Description:** Adds a new entry for daily sugar intake.

### 2. **GET /get-sugar-intake**
   - **Description:** Retrieves all sugar intake records for a user.
  
### 3. **POST /set-alert-limit**
   - **Description:** Sets a sugar intake limit for daily alerts.

## Setup Instructions

### Prerequisites

- **Python** for running FastAPI backend.
- **Android Studio** for building the mobile app.
- **FastAPI** for the backend API.
- **SQLite** database for backend storage.
