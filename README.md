
# **Design Patterns in Test Automation**

This repository contains implementations of key design patterns tailored for test automation frameworks. The patterns showcased include **Factory**, **Builder**, **Object Pool**, and **Decorator**. Each pattern is accompanied by use cases, code examples, and a summary of its impact on real-world projects.

---

## **Design Patterns Overview**

| **Pattern**           | **What It Is**                                                                 | **Use Cases in Projects**                                                                                                     | **Code Logic (Simplified)**                                                                                     | **Benefits/Impact**                                                                                      |
|------------------------|-------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| **Factory Pattern**    | A creational pattern used to create objects without specifying their exact class.                           | 1. Generating WebDriver instances for different browsers (Chrome, Firefox).<br>2. Creating API client objects for REST or GraphQL. | Define a factory class with a method that returns objects based on input parameters (e.g., `getDriver(String browser)`). | - Simplifies object creation.<br>- Promotes loose coupling.<br>- Centralized object instantiation.       |
| **Builder Pattern**    | A creational pattern for constructing complex objects step by step. Separates construction logic from representation. | 1. Chaining multiple Selenium Actions (drag-and-drop, double-click).<br>2. Creating configurable Page Objects for different workflows. | Create a `Builder` class with methods to set optional parameters. Call `build()` to return the constructed object. Example: `PageBuilder.buildLoginPage()`. | - Enhances readability and maintainability.<br>- Supports fluent API design.<br>- Ensures valid object creation. |
| **Object Pool Pattern**| A creational pattern that manages a pool of reusable objects to reduce the cost of object creation.          | 1. Reusing WebDriver instances with unique capabilities for parallel tests.<br>2. Managing a pool of database connections in load testing. | Define a pool manager class with methods to `getObject()` and `releaseObject()`. Example: `WebDriverPool.getDriver()`. | - Improves performance.<br>- Optimizes resource usage.<br>- Ensures object reuse in high-demand scenarios. |
| **Decorator Pattern**  | A structural pattern that dynamically adds new behavior to objects by wrapping them in decorator classes.    | 1. Adding logging or screenshot-taking functionality to WebDriver actions.<br>2. Extending retry logic dynamically for flaky environments. | Create individual decorator classes that wrap the base class. Stack multiple decorators for combined behaviors. Example: `new SnapshotDecorator(new LoggingDecorator(driver))`. | - Provides flexibility in adding features.<br>- Promotes composition over inheritance.<br>- Reuses common behaviors. |



## **Getting Started**

### **Prerequisites**
- Java 8 or higher.
- Maven for dependency management.
- Selenium WebDriver library (for WebDriver examples).

### **How to Run**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/design-patterns-test-automation.git
   cd design-patterns-test-automation
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the examples:
   ```bash
   mvn exec:java -Dexec.mainClass="patterns.factory.FactoryExample"
   ```

---

## **Examples**

### **Factory Pattern Example**
```java
WebDriver driver = WebDriverFactory.getDriver("chrome");
driver.get("https://example.com");
```

### **Builder Pattern Example**
```java
Actions actions = new ActionsBuilder()
                    .moveToElement(element)
                    .click()
                    .sendKeys("Test")
                    .build();
actions.perform();
```

### **Object Pool Pattern Example**
```java
WebDriver driver = WebDriverPool.getDriver();
driver.get("https://example.com");
WebDriverPool.releaseDriver(driver);
```

### **Decorator Pattern Example**
```java
WebDriverAction action = new SnapshotDecorator(
                            new LoggingDecorator(
                                new BasicWebDriverAction()));
action.click("SubmitButton");
```

---

## **Benefits of Using These Patterns**
- **Factory**: Simplifies and centralizes object creation, making it easy to add new object types.  
- **Builder**: Improves code readability and supports constructing complex objects step by step.  
- **Object Pool**: Reduces resource overhead by reusing objects in high-demand scenarios.  
- **Decorator**: Dynamically adds functionality, keeping code modular and flexible.

---

## **Contributions**
Contributions are welcome! Please fork this repository and submit a pull request for improvements or new pattern implementations.

---

## **License**
This project is licensed under the MIT License.
