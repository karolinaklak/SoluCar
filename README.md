# SoluCar - Advanced Automotive Diagnostic and Management Solution

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

SoluCar is an innovative Java application that transforms your computer into a professional automotive diagnostic tool. It connects to your vehicle's OBD-II interface to read real-time data, analyze error codes, customize ECU settings, and manage different performance stages.

## Key Features

* **Real-Time OBD-II Diagnostics:** Monitor your vehicle's vital parameters (speed, RPM, temperature, etc.) live.
* **Read and Clear Error Codes:** Identify and resolve potential issues with your vehicle.
* **Customizable ECU Mapping:** Optimize your engine's performance by adjusting ECU parameters (stage 1, 2, etc.).
* **Intuitive User Interface:** Easily navigate between different features with a clear and customizable graphical interface.
* **Data Logging and Analysis:** Record the history of diagnostics and modifications for accurate tracking of your vehicle's condition.

## Technologies Used

* **Java:** Main programming language.
* **JavaFX:** Framework for creating the graphical user interface.
* **[OBD Library]:** For communication with the OBD-II interface (replace with the chosen library).
* **[Persistence Library]:** For data management (replace with the chosen library).
* **Hexagonal Architecture:** For better organization and testability of the code.
* **Clean Code:** Development principles for clean and maintainable code.

## Installation and Usage

1. **Prerequisites:**
   * Java [17] (or higher) installed.
   * An OBD-II interface compatible with your vehicle.
2. **Installation:**
   * Clone this repository: `git clone https://github.com/karolinaklak/SoluCar.git`
   * Compile the project: `mvn clean install` (or use your IDE).
   * Run the application: `java -jar SoluCar.jar`
3. **Usage:**
   * Connect the OBD-II interface to your vehicle and your computer.
   * Launch SoluCar and follow the on-screen instructions.

## Contributing

Contributions are welcome! Feel free to submit issues or pull requests.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.