TaskMaster - Android Mini Project

App Description:
  This is a task management application developed using Kotlin for Android. It demonstrates the fundamental concepts of Android development, including UI components, data persistence, and state management.

Key Features:
Add Tasks: 
  Users can enter a task title and a detailed description.
View Tasks: 
  All saved tasks are displayed in a responsive RecyclerView.
Delete Tasks: 
  Users can remove tasks from the list with a single click.
Persistence: 
  Tasks are saved locally and remain available even after closing the app.
  
Design & Architecture Choices:
Multi-Screen Navigation: 
  Used Intents to navigate between the main task list and the 'Add Task' screen, providing a cleaner user experience.
State Management: 
  Implemented ViewModel and LiveData to ensure data integrity during configuration changes (like screen rotation).
Data Persistence: 
  Integrated SharedPreferences combined with Gson for lightweight JSON-based local storage.
UI Components: 
  Used FloatingActionButton (FAB) for primary actions and CardView within RecyclerView for a modern look.
  
Secure Coding Practices:
Input Validation: 
  Implemented strict trimming and empty-check validation on the 'Add Task' screen to prevent null or empty data entry.
Data Encapsulation: 
  Logic for data handling is separated into a TaskService class, following the principle of separation of concerns.
Context Handling: 
  Used Application Context and private mode for SharedPreferences to ensure data privacy within the app.
  
How to Run:
Clone or extract the project.
Open in Android Studio (Ladybug or later).
Build and run on an emulator or physical device with API 26 (Android 8.0) or higher.
Developed as part of the Mobile Application Development Assignment.
