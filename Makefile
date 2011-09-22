compile: Ant.java Grid.java World.java Test.java SimComponent.java State.java Simulation.java
	javac *.java

run: Test.class
	java Simulation

clean:
	rm *.class

