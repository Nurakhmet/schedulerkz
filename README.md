# schedulerkz RESTful API
Application about scheduler, in this app User can use all CRUD operations on Tasks, and some changes in Profile page.
This application used Spring Security to divide into users by their roles.

# front-end
#### ReactJS link [GitHub repo](https://github.com/Nurakhmet/schedulerkz_ReactJS "GitHub repo")

# Getting started
You need Java 8 installed.
```html
./gradlew build
```
# Module
### Spring-Boot
The main library providing features that support the other parts of Spring Boot. These include:

- The SpringApplication class, providing static convenience methods that can be used to write a stand-alone Spring Application. Its sole job is to create and refresh an appropriate Spring ApplicationContext.

- Embedded web applications with a choice of container (Tomcat, Jetty, or Undertow).

- First class externalized configuration support.

- Convenience ApplicationContext initializers, including support for sensible logging defaults.

# Dependencies

### Spring Web
- Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container. 

### Spring Security
- Highly customizable authentication and access-control framework for Spring applications.

### Spring Data JPA
- Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

### MySQL Driver 
- MySQL JDBC and R2DBC driver.

### Lombok 
- Java annotation library which helps to reduce boilerplate code

# Postman requests
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/postAuth.png" width="500" height="500"/>
<hr>
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/getProfile.png" width="500" height="500"/>
<hr>
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/getTaskById.png" width="500" height="500"/>
<hr>
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/getTaskByDate.png" width="500" height="500"/>

# Screenshots
- Registration page
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/registerPage.png" width="400" height="400"/>

- Login page
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/loginPage.png" width="500" height="400" />

- Profile Page
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/profilePage.png" width="500" height="400" />

- Menu page
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/mainMenu.png" width="600" height="400" />

- Menu page 2
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/mainMenu2.png" width="600" height="400" />

- Task Details
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/taskDetails.png" width="700" height="400" />

- Current Day Task
<img src="https://github.com/Nurakhmet/schedulerkz/blob/main/src/main/resources/static/currentDayTasks.png" width="600" height="400" />
