# WebUiTestngBDD_GithubActions

This repository demonstrates a **Web UI Test Automation framework** built with **Java, TestNG, Selenium, and BDD (Cucumber)**, integrated with **GitHub Actions** for CI/CD.  
It showcases multiple ways to run automated tests using GitHub Actions — from simple manual runs to parameterized executions, secret handling, and Selenium Grid integration.

---

## 🚀 Features
- **Java + Maven + TestNG** test automation  
- **Selenium WebDriver** for browser automation  
- **BDD with Cucumber** for behavior-driven testing  
- **GitHub Actions workflows** for CI/CD integration  
- **Manual triggers with workflow_dispatch**  
- **Parameterized and secure test executions**  
- **Selenium Grid execution (Chrome only)**  

---

## ⚙️ GitHub Actions Workflows

All workflows are defined under `.github/workflows/`.

### 1. **Selenium TestNG Manual Run**
- Runs TestNG tests manually when triggered.  
- Provides a **baseline workflow** with default execution.  
- Good starting point for understanding CI/CD test integration.

---

### 2. **Selenium User Input TestNG Manual Run**
- Similar to the manual run workflow but adds **user input parameters**.  
- Inputs (e.g., headless mode, suite name) can be specified when triggering the workflow.  
- Adds flexibility for customizing test runs without editing the workflow.

---

### 3. **Selenium User Input Passing Secrets TestNG Manual Run**
- Extends the user input workflow with **GitHub Secrets support**.  
- Useful for passing sensitive values (credentials, tokens, environment configs).  
- Demonstrates secure handling of test data in CI/CD pipelines.

---

### 4. **Selenium User Input TestNG Manual Run (Grid - Chrome Only)**
- Runs tests on a **Selenium Grid**.  
- Configured for **Chrome browser execution only**.  
- Demonstrates distributed test execution setup with GitHub Actions.  
- Suitable for scaling tests across different environments.

---

## 🛠️ Running Tests Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/chopraji94/WebUiTestngBDD_GithubActions.git
   cd WebUiTestngBDD_GithubActions
   ```

2. Run tests with Maven:
   ```bash
   mvn clean test
   ```

3. Test results will be available under the `target/` directory.

---

## 📂 Repository Structure
```
WebUiTestngBDD_GithubActions/
│
├── src/                    
│   └── test/java           # Test source files (Java + BDD feature files)
│
├── pom.xml                 # Maven project configuration
│
├── .github/workflows/      # GitHub Actions workflows
│   ├── Selenium TestNG Manual Run.yml
│   ├── Selenium User Input TestNG Manual Run.yml
│   ├── Selenium User Input Passing Secrets TestNG Manual Run.yml
│   └── Selenium User Input TestNG Manual Run (Grid - Chrome Only).yml
│
└── README.md               # Project documentation
```

---

## ✅ Summary
This repository serves as a **demo automation framework** for running **Selenium + TestNG** tests with GitHub Actions.  
Each workflow showcases a different scenario:  

- **Basic Manual Execution** – simple trigger-based test run  
- **User Parameterized Runs** – pass inputs dynamically  
- **Secure Runs with Secrets** – handle sensitive values safely  
- **Grid-Based Execution** – distributed execution on Selenium Grid (Chrome only)  

---

💡 Use this project as a **template** for setting up your own Selenium + TestNG automation with GitHub Actions CI/CD pipelines.
