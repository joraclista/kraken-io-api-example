# kraken-io-api-example

This is simple maven based project.
use `mvn clean package` to build it.

This project depends on [kraken-io-api](https://github.com/joraclista/kraken-io-api)
and it's goal is to provide example of direct file upload to kraken.io image optimization API.

This is spring boot project, to run it just run main on [Application class](https://github.com/joraclista/kraken-io-api-example/blob/master/src/main/java/com/github/joraclista/kraken/Application.java).

Application has two controllers:

1) [one](https://github.com/joraclista/kraken-io-api-example/blob/master/src/main/java/com/github/joraclista/kraken/controller/KrakenController.java) to recieve callbacks from kraken.io
    which are basically post requests     
    
          1.1 with form-multipart data for all optimizations except of multiple-resize optimization 
          
          1.2 with json for multiple-resize optimization (yep, kraken io has for some reason different media types for these two)
          
2) [another](https://github.com/joraclista/kraken-io-api-example/blob/master/src/main/java/com/github/joraclista/kraken/controller/KrakenUploadController.java) is for handling file upload requests to kraken:

          2.1 try http POST to ${YOUR_PROTOCOL_HOST_PORT}/kraken/file/upload/image/sync/optimize with 
          
                2.1.1 Content-Type: multipart/form-data, 
                
                2.1.2 request part `file` should contain file

