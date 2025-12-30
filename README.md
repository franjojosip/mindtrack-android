# MindTrack – Modular Android Health App

MindTrack is a production-grade Android application demonstrating how to build scalable, maintainable, and testable mobile systems using modern Android best practices.

This project is designed as an **architecture and engineering showcase**, not a toy app.

---

## 🚀 What this project demonstrates

- Feature-based **multi-module architecture**
- **Clean Architecture** (domain, data, UI separation)
- **Jetpack Compose** UI with state-driven design
- **Coroutines & Flow** for async and reactive data
- **Offline-first** data layer (Room + network sync)
- Dependency injection with **Hilt / Koin**
- Error handling, loading states, and resilience
- Scalable navigation and feature isolation
- Unit-testable business logic

---

## 🧱 Module structure
- app
- domain
- data
- core-network
- core-database
- core-ui
- feature-auth
- feature-dashboard
- feature-habits
- feature-health
- feature-settings

Each feature is isolated and communicates through the domain layer, making the system easy to scale, test, and maintain.

---

## 🔀 Data flow
Compose UI
→ ViewModel
→ UseCase
→ Repository (domain)
→ Data (network/database)


This ensures:
- UI remains simple and testable  
- Business logic is independent of Android  
- Data sources can be replaced without breaking features  

---

## 📱 App features

- User authentication
- Habit & health tracking
- Mood and energy logging
- Daily dashboard
- Offline support
- Settings & preferences

(Some screens may be stubbed while features are under active development.)

---

## 🛠 Tech stack

- Kotlin  
- Jetpack Compose  
- Coroutines & Flow  
- Hilt / Koin  
- Retrofit  
- Room  
- Material 3  
- MVVM + Clean Architecture  

---

## 🎯 Why this project exists

This project reflects how I build **real production Android applications** in fintech and healthcare environments — with strong architecture, performance, and long-term maintainability in mind.

It mirrors how large teams structure Android codebases for reliability and scalability.

---

## 📌 Status

MindTrack is actively under development.  
Each feature is implemented incrementally using professional Git workflows (feature branches, pull requests, and structured commits).

---

## 👤 Author

Franjo Josip Jukic  
Senior Android / Mobile Engineer  
https://github.com/franjojosip  
https://www.linkedin.com/in/franjo-josip-jukic-3bb0131b6/
