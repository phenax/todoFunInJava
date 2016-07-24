BUILDER= javac
RUN= java
MAIN_CLASSNAME= TodoApp


build:
	$(BUILDER) $(MAIN_CLASSNAME).java

run:
	$(RUN) $(MAIN_CLASSNAME)

clean:
	rm -rf *.class
