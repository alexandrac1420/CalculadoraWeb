# Calculator

A simple calculator developed with Spring Boot that allows performing basic operations such as addition, subtraction, multiplication, division, and clearing the accumulated result.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to install the following tools and configure their dependencies:

1. **Java** (versions 7 or 8)
    ```sh
    java -version
    ```
    Should return something like:
    ```sh
    java version "1.8.0"
    Java(TM) SE Runtime Environment (build 1.8.0-b132)
    Java HotSpot(TM) 64-Bit Server VM (build 25.0-b70, mixed mode)
    ```

2. **Maven**
    - Download Maven from [here](http://maven.apache.org/download.html)
    - Follow the installation instructions [here](http://maven.apache.org/download.html#Installation)

    Verify the installation:
    ```sh
    mvn -version
    ```
    Should return something like:
    ```sh
    Apache Maven 3.2.5 (12a6b3acb947671f09b81f49094c53f426d8cea1; 2014-12-14T12:29:23-05:00)
    Maven home: /Users/dnielben/Applications/apache-maven-3.2.5
    Java version: 1.8.0, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre
    Default locale: es_ES, platform encoding: UTF-8
    OS name: "mac os x", version: "10.10.1", arch: "x86_64", family: "mac"
    ```

3. **Git**
    - Install Git by following the instructions [here](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

    Verify the installation:
    ```sh
    git --version
    ```
    Should return something like:
    ```sh
    git version 2.2.1
    ```

### Installing

1. Clone the repository and navigate into the project directory:
    ```sh
    git clone https://github.com/alexandrac1420/CalculadoraWeb.gitgit

    cd calculadora
    ```

2. Build the project:
    ```sh
    mvn package
    ```

    Should display output similar to:
    ```sh
    [INFO] --- jar:3.3.0:jar (default-jar) @ countlines ---
    [INFO] Building jar: C:\Users\alexa\countlines\target\calculadora-1.0-SNAPSHOT.jar
    [INFO] BUILD SUCCESS
    ```
   
## How to maintain the result across requests
In the Calculator application, the  `CalculatorResult` class is implemented as a singleton, which ensures that there is only one instance of CalculatorResult throughout the application. This singleton instance is shared between the `@RequestMapping` and `@PostMapping` methods in the CalculadoraController class, allowing the result to persist across different requests.


## Deployment on AWS

Follow these steps to deploy the application on AWS:

1. **Start the virtual machine**

    Launch an EC2 instance with your preferred configuration.

    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image.png)

2. **Transfer dependencies and the JAR file**

    Upload the dependencies.zip (containing necessary dependencies) and the built JAR file to the created virtual machine.
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-1.png)
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-2.png)

3. **Execute the following command**

    Navigate to the directory where you uploaded the files and run:
    ```sh
     java -cp "./dependency/*:Calculadora-1.0-SNAPSHOT.jar" edu.escuelaing.arsw.Calculadora
    ```
    This will start the Spring service.

4. Start the Spring service

    Ensure the Spring Boot application starts without errors.
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-3.png)

5. Verify the deployment

    Check the application's availability using the public DNS of the EC2 instance on port 8080, e.g.,
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-5.png)
    ![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/image-4.png)

## Architectural Design

![alt text](https://github.com/alexandrac1420/CalculadoraWeb/blob/master/Pictures/arqui.png)
The architecture depicted and described involves a web application deployed on an AWS EC2 instance using the Spring framework.
1. User Access:

    - The user accesses the application through the public URL of the EC2 instance.
    - The user's browser makes an HTTP request to the server listening on port 8080.
      
2. Spring's DispatcherServlet:

    - The request arrives at Spring's `DispatcherServlet`.
    - The `DispatcherServlet` is responsible for receiving all incoming requests and delegating them to the appropriate controller based on URL mapping.
      
3. Controller:

    - The `DispatcherServlet` routes the request to the `CalculadoraController`.
    - The `CalculadoraController` processes the request and uses the `CalculatorService` to perform
   the mathematical operation.
    - The result is sent to the view and displayed to the user.
  
4. Additional Classes:
    - The controller uses additional classes such as `CalculatorResult`.
      
5. Deployment:

    - The application is deployed on an AWS EC2 instance.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](http://git-scm.com/) - Version Control System



## Versioning

I use [GitHub](https://github.com/) for versioning. For the versions available, see the [tags on this repository](https://github.com/alexandrac1420/LOC-Counting_Alexandra-Cortes.git).

## Authors

* **Alexandra Cortes Tovar** - [alexandrac1420](https://github.com/alexandrac1420)


## License

This project is licensed under the GNU License - see the [LICENSE.md](LICENSE.md) file for details.



