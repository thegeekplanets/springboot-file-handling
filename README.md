<h1 align="center" id="title">File handling with spring boot</h1>

<p id="description">This application creates a RESTful API that allows for file uploads and downloads with the help of spring boot.</p>

  
  
<h2>🧐 Features</h2>

Here are some of the project's best features:

*   File Upload
*   File Download
  
<h2>🛠️ Installation Steps:</h2>

<p>1. Run application</p>

```
mvn spring-boot:run
```

<p>2. Build</p>

```
mvn clean install -Dmaven.test.skip=true
```

 
<h2>💻 Built with</h2>

Technologies used in the project:

*   Spring boot 
*   Restful API
*   Lombok

<h2>💻 Testing Instructions</h2>

* Use Postman Tool
* Upload files: POST  http://localhost:8080/upload
  ![image](https://github.com/thegeekplanets/springboot-file-handling/assets/155982233/85e385be-f700-4442-af6e-f16727796c17)

* Download files: GET http://localhost:8080/files
  ![image](https://github.com/thegeekplanets/springboot-file-handling/assets/155982233/068e54bc-3c6a-45ab-9bbb-e504e3d3c1b1)

* List of all the uploaded files: GET http://localhost:8080/files/Ganesha.jpg
  ![image](https://github.com/thegeekplanets/springboot-file-handling/assets/155982233/87ad3154-ead6-4211-a88a-4c5411008f4b)
 
