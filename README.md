Hi! This is my Inditex Evaluation Backend Project.
The App is an API REST with a single controller, you can acces to it with url: /api/products/filtered?salesWeight={double}&stockWeight={double}

I´ve created this app following the Hex-arquitecture and DDD.

I've created a Docker with MongoDB which has some demo data. 

To try it, just execute a console into directory "/src/main/java/com/InditexProject/restApiIxPt/infrastructure", then execute the command "docker-compose up".
If you haven't the Docker Services just download it from: https://docs.docker.com/compose/install/ > Windows-Linux and Install any 4.x.x version

When finished reviewing, is better to press "CTL+C" into console for STOP Docker and execute "docker-compose down" to fully turn off docker services.

For entities I've created Product wich is the main, and Stock as an aggregation with focused on ValueObjects.

There's 3 test created: Unitary-Integration and E2E with rest reassured.
