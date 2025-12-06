# 🤖 Java Command-Line Assistant

A robust, object-oriented command-line assistant built in Java! This application provides an interactive CLI experience with features like user authentication, command history, multithreaded processing, and a variety of utility commands. Perfect for demonstrating core Java concepts such as OOP, exception handling, collections, concurrency, and file I/O.

## ✨ Features

- **🔐 Secure Login**: Simple username-based authentication to start the session.
- **📝 Command History**: Tracks and limits command history (configurable via properties).
- **⚡ Multithreaded Execution**: Uses `BlockingQueue` and `ExecutorService` for non-blocking command processing.
- **📊 Logging**: Comprehensive logging of actions, errors, and user events to `assistant.log`.
- **🛠️ Extensible Commands**: Modular command system with aliases (e.g., `calc` for `calculate`).
- **⏰ Reminders**: Scheduled reminders using a dedicated thread and scheduler.
- **🚀 Utility Commands**:
  - Greetings and basic interactions.
  - Time and date queries.
  - Basic calculator for arithmetic operations.
  - File operations (create, read, delete).
  - System commands (e.g., clear screen, exit).
  - App opening (platform-specific).
  - Help and history viewing.

The app emphasizes clean code, error handling, and best practices for a production-like CLI tool.

## 🏗️ Project Structure

```
javaproject3rd/
├── README.md                  # This file
├── TODO.md                    # Pending tasks
├── assistant.log              # Runtime logs
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── assistant/ # Source files
│                   ├── Main.java          # Entry point
│                   ├── Command.java       # Abstract base for commands
│                   ├── Logger.java        # Logging utility
│                   ├── Config.java        # Configuration properties
│                   ├── InvalidCommandException.java # Custom exception
│                   └── [Command classes]  # e.g., CalculatorCommand.java, ReminderCommand.java
└── com/                       # Compiled .class files
    └── assistant/
        └── [Command].class    # Compiled outputs
```

Built with standard Java (no external dependencies beyond core JDK). Compatible with Java 8+.

## 🚀 Installation & Setup

1. **Prerequisites**:
   - Java Development Kit (JDK) 8 or higher.
   - An IDE like IntelliJ IDEA, Eclipse, or VS Code with Java extensions (optional).

2. **Clone or Download**:
   ```
   git clone https://github.com/yourusername/javaproject3rd.git
   cd javaproject3rd
   ```

3. **Compile** (if not pre-compiled):
   ```
   # From project root
   javac -d com src/main/java/com/assistant/*.java
   ```
   This generates `.class` files in the `com/` directory.

4. **Run**:
   ```
   java -cp . com.assistant.Main
   ```
   - Login with username: `ankit94` (hardcoded for demo; update in `Main.java` for production).
   - Enter commands interactively.

## 💻 Usage

1. Launch the app: It prompts for login.
2. After successful login (e.g., `ankit94`), you'll see: `Type 'help' for commands or 'exit' to quit.`
3. Input commands like:
   - `hello` → Greets the user.
   - `time` or `clock` → Shows current time.
   - `calculate 5 + 3` → Performs arithmetic.
   - `reminder 10 "Meeting at 3 PM"` → Sets a 10-second reminder.
   - `history` → Lists recent commands.
   - `exit` → Gracefully shuts down (stops threads, logs shutdown).

**Example Session**:
```
Welcome to the Assistant!
Enter username to login: ankit94
Logged in as: ankit94
Type 'help' for commands or 'exit' to quit.
Enter command: hello
Hello, ankit94! How can I assist you today?
Enter command: time
Current time: 14:30:25
Enter command: exit
Goodbye!
```

## 📋 Available Commands

| Command | Aliases | Description | Example |
|---------|---------|-------------|---------|
| `hello` | - | Greets the user. | `hello` |
| `time` | `clock` | Displays current time. | `time` |
| `date` | `today` | Shows current date. | `date` |
| `calculate` | `calc` | Basic calculator (add, subtract, multiply, divide). | `calculate 10 * 2` |
| `reminder` | - | Sets a timed reminder. | `reminder 30 "Take a break"` |
| `help` | - | Lists all commands. | `help` |
| `history` | - | Shows command history (last 10 by default). | `history` |
| `open` | - | Opens an application (e.g., notepad). | `open notepad` |
| `file` | - | File operations (create/read/delete). | `file create test.txt "Hello"` |
| `system` | - | System utilities (e.g., clear, info). | `system clear` |

For full details, run `help` in the app.

## 🔧 Technical Highlights

- **OOP Design**: Commands implement an abstract `Command` interface for polymorphism.
- **Concurrency**: `LinkedBlockingQueue` for thread-safe command queuing; `ExecutorService` for processing; `ScheduledExecutorService` for reminders.
- **Configuration**: Properties loaded from `Config.java` (e.g., `history.size=10`).
- **Error Handling**: Custom `InvalidCommandException`; try-catch for interruptions and I/O.
- **Logging**: `Logger` class for INFO-level logs to console and file.

## 🤝 Contributing

1. Fork the repo.
2. Create a feature branch (`git checkout -b feature/amazing-feature`).
3. Commit changes (`git commit -m 'Add amazing feature'`).
4. Push to branch (`git push origin feature/amazing-feature`).
5. Open a Pull Request.

Suggestions welcome! Add new commands or enhance existing ones.

## 📄 License

This project is open-source under the MIT License. See [LICENSE](LICENSE) for details (create one if needed).

## 🙌 Acknowledgments

Built as a learning project to showcase Java best practices. Thanks to the Java community!

---

*⭐ Star this repo if it helps you! 🚀*
