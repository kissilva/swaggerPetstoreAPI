#  API Test Automation - Petstore

This project is an **API test automation framework** for Petstore, built with **Java, Serenity BDD, Gradle, and Rest**.  
It follows the **Screenplay Pattern** to ensure modularity, reusability, and maintainability.

## Technologies Used
- **Java 11+**
- **Serenity BDD**
- **Gradle**
- **Rest**
- **Cucumber**
- **Lombok**

##  Project Structure
 src/main/java

    ┣  com.testAutomation.api
        ┣  models # Data models for API requests/responses
        ┣  questions # Questions to validate API responses
        ┣  utils # Utility classes
src/test/java 

    ┣  runners
    ┣  stepdefinitions # Cucumber step definitions
    ┣  resources
        ┣  data # JSON test data files
            ┣  schemas # JSON schemas for response validation
        ┣  features # Cucumber feature files

┣  serenity.conf # Serenity configuration 

┣  build.gradle # Gradle dependencies 

┣  README.md # Project documentation

##  Setup & Installation
### 1. **Clone the repository**

    git clone https://github.com/kissilva/SwaggerPetstoreAPI
    cd SwaggerPetstoreAPI

### 2. Configure dependencies

    ./gradlew clean build

### 3. Run tests

    ./gradlew test
### Run specific tests with tags:

    ./gradlew test -Dcucumber.filter.tags="@createPetSuccessfully"
### Serenity Reports
After execution, generate the Serenity report:

    ./gradlew aggregate
Then, open:
    
    target/site/serenity/index.html

### Implemented Features

* **User:** Create, Login, Search for a non-existent, Get User

* **Pet:** Add, Update, Delete, Get Pet

* **Store:** Place Order, Delete, Get Order
