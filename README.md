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

***

Execute docker exec -it bills_db psql -U root -d bills -c 'select * from BATCH_JOB_EXECUTION;' 
The output should look like:
<img width="1025" height="202" alt="Screenshot 2025-10-22 at 00 44 20" src="https://github.com/user-attachments/assets/023ef06d-faf6-4119-af4b-1989689c5f5a" />
