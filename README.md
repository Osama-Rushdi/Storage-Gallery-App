# 📸 Photo Gallery App

A simple Android application to display a list of curated photos using the [Pexels API](https://www.pexels.com/api/).  
Built with Kotlin, MVVM, Retrofit, Glide, and Paging.

---

## 🚀 Features

- Fetches and displays curated photos from Pexels API.
- Supports pagination (infinite scroll).
- Shimmer loading effect while images load.
- Light/Dark mode switch with animation.
- Swipe to refresh.
- Error handling with fallback message.

---

## 📱 Screenshots

### 🔹 Home Screen
![screen1](screenshots/screen1.jpg)

### 🔹 Loading with Shimmer
![screen2](screenshots/screen2.jpg)

### 🔹 Dark Mode
![screen3](screenshots/screen3.jpg)

### 🔹 Grid View
![screen4](screenshots/screen4.jpg)

### 🔹 App Logo
![img](screenshots/img.png)

---

## 🎬 Demo Video

Find demo video inside the [`screenshots/`](screenshots/) folder:  
`vid.mp4`

> 🔔 For better preview, upload the video to [YouTube](https://youtube.com) or [Google Drive](https://drive.google.com) and link it here.

---

## 🛠️ Tech Stack

- Kotlin
- MVVM Architecture
- Retrofit & OkHttp
- Glide
- Paging (Manual)
- Material Components
- Shimmer Layout
- Hilt (Dependency Injection)

---

## 🧪 API Used

[Pexels API – Curated Photos](https://www.pexels.com/api/documentation/)

```http
GET https://api.pexels.com/v1/curated?page=1&per_page=20
