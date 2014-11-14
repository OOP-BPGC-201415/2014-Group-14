cd actors/
javac -classpath ".:../:../../lib/mysql-connector-java-5.1.34-bin.jar" *.java -d "../../bin/"
cd ..
cd backend/
javac -classpath ".:../:../../lib/mysql-connector-java-5.1.34-bin.jar" *.java -d "../../bin/"
cd ..
cd swd/
javac -classpath ".:../:../../lib/mysql-connector-java-5.1.34-bin.jar" *.java -d "../../bin/"
