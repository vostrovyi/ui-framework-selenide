# install maven (test runner)
sudo apt install maven

# mkdir ui-framework-selenide
cd ui-framework-selenide

# compile
mvn clean compile

# run test
mvn clean test

# results
allure serve allure-results 
