# Makefile for ProductApp

JAVAC = javac
JAVA = java
MAINCLASS = za.co.wethinkcode.persist.ProductApp
SRCDIR = src
OUTDIR = out
LIBDIR = lib
CP = -cp "$(LIBDIR)/*:$(OUTDIR)"

# Default target
all: build

# Compile the Java files
build:
	@echo "Compiling Java sources..."
	$(JAVAC) $(CP) -d $(OUTDIR) $(SRCDIR)/za/co/wethinkcode/persist/*.java $(SRCDIR)/za/co/wethinkcode/persist/orm/*.java

# Run the application with default arguments
run: build
	@echo "Running ProductApp..."
	$(JAVA) $(CP) $(MAINCLASS) -d jdbc:sqlite:products_database.db -p 7000

# Clean the build directory
clean:
	@echo "Cleaning up..."
	rm -rf $(OUTDIR)/*

# Help target
help:
	@echo "Usage:"
	@echo "  make          - Builds the project"
	@echo "  make run      - Runs the ProductApp"
	@echo "  make clean    - Cleans the build artifacts"
	@echo "  make help     - Shows this help message"
