# BillyBills
A personal project oriented to manage bills

***

You will need: docker-compose and maven installed.

Launch compose file before running Java. 
Use: docker compose up -d
Create database user (done in init.sql) and role:
docker exec -it bills_db psql -U root -d bills -c "CREATE ROLE bills WITH LOGIN PASSWORD 'asdfasdf';"


Then, from IDE/terminal, First launch:
mvn clean install
If maven is not installed in your system you will have to get it. I used brew through command: brew install maven

***

Current job execution state:

  1. Spring Boot starts up
  2. BillingJobConfiguration creates the job and step beans
  3. JobLauncherService (our CommandLineRunner) automatically launches the job after startup
  4. The job executes the billingStep tasklet
  5. It prints "processing billing information"
  6. Job completes successfully and shuts down
