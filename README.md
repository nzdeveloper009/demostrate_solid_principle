# Solid Principle Examples
This repository contains examples of code that demonstrate the principles of SOLID (Single Responsibility, Open-Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion). Each principle is illustrated with relevant code snippets.

## Single Responsibility Principle
The Single Responsibility Principle states that a class should have only one reason to change. It promotes delegation and specialization. In this example, we have a **Square** class responsible for calculating the area and perimeter of a square, while the UI-related responsibilities are handled by the **SquareUI** class.

## Open-Closed Principle
The Open-Closed Principle suggests that software entities should be open for extension but closed for modification. It emphasizes adaptability to change while maintaining stability. The **InsuranceCompany** demonstrates this principle by providing a discount rate based on customer loyalty. Different types of insurance customers, such as **VehicleInsuranceCustomer**, **HomeInsuranceCustomer**, and **LifeInsuranceCustomer**, implement the **Customer** interface and override the **isLoyalCustomer** method.

## Liskov Substitution Principle
The Liskov Substitution Principle states that objects of a superclass should be replaceable with objects of its subclasses without breaking the application. It promotes trust and behavior consistency between classes. The **Vehicle**, **Car**, and **RacingCar** classes demonstrate this principle, where objects of subclasses behave the same way as objects of the superclass.

## Interface Segregation Principle
The Interface Segregation Principle advises clients to depend on smaller interfaces instead of larger ones. It aims to reduce side effects and increase simplicity and specificity. In the code, different functionality interfaces (**IPrin**t, **IScan**, and **IFax**) are defined, and the CanonPrinter class implements only the necessary interfaces, adhering to the principle.

## Dependency Inversion Principle
The Dependency Inversion Principle states that high-level modules should depend on abstractions rather than concrete implementations. It decouples high-level and low-level modules, allowing changes in low-level modules without affecting the high-level ones. The **ProductCatalog** class demonstrates this principle by depending on the **ProductRepo** abstraction, which is implemented by concrete classes like **SQLProductRepo** and **MongoProductRepo**.

Each principle is accompanied by code examples and explanations. Feel free to explore and learn from them!

Please note that the code snippets provided here are for demonstration purposes and may not represent complete or executable programs.
