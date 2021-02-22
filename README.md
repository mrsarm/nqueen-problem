N-Queen problem
===============

Implementation of the classical _N-Queen_ problem, plus a second
implementation  so called _"Lone" N-Queen_ were no 3 queens are in
a straight line at _ANY_ angle.

The N Queen is the problem of placing N chess queens on an N×N
chessboard so that no two queens attack each other.

The repository contains a Java library, and a command line app
to solve the N-Queen problem.


Run it
------

Want to run it? in a _*nix_ environment with Java 8+ installed
two convenient scripts  are placed at the root of the source code.
The first one is needed to execute only once, it compiles,
executes the tests, assembles and unpacks the distributable:

    $ ./build.sh

Then execute within the same folder as many times as
you want the app, with the size of the board you want
as an argument (default 8):

    $ ./run.sh 4
    0  1  0  0
    0  0  0  1
    1  0  0  0
    0  0  1  0

Add the argument `--classic` to execute the classic N-Queen problem
(not the _"Lone" N-Queen_ version), and add `--pretty` if your
terminal supports unicode characters:

    $ ./run.sh 8 --pretty
    🔲🔲👑🔲🔲🔲🔲🔲
    🔲🔲🔲🔲👑🔲🔲🔲
    🔲🔲🔲🔲🔲🔲🔲👑
    🔲🔲🔲👑🔲🔲🔲🔲
    👑🔲🔲🔲🔲🔲🔲🔲
    🔲🔲🔲🔲🔲🔲👑🔲
    🔲👑🔲🔲🔲🔲🔲🔲
    🔲🔲🔲🔲🔲👑🔲🔲
    $ ./run.sh 8 --pretty --classic
    👑🔲🔲🔲🔲🔲🔲🔲
    🔲🔲🔲🔲👑🔲🔲🔲
    🔲🔲🔲🔲🔲🔲🔲👑
    🔲🔲🔲🔲🔲👑🔲🔲
    🔲🔲👑🔲🔲🔲🔲🔲
    🔲🔲🔲🔲🔲🔲👑🔲
    🔲👑🔲🔲🔲🔲🔲🔲
    🔲🔲🔲👑🔲🔲🔲🔲


Implementation
--------------

Implemented as a Java 8+ multi-project with Gradle as a build
tool, the folder `nqueen` is the library with the classes that
implement the N-Queen algorithms.

The `app` module uses the `nqueen` module and implements
the command line app interface.

The algorithm chosen to find a solution is **"backtrack"**,
and using a vector of elements to represent the board in
memory while finding the result, consuming less memory than
using a 2D array, though to visualize the board a method
creates a 2D array representation if needed (used in the
command line app to print the result).


Build and run
-------------

Compile and run with Gradle passing arguments to the app:

    $ ./gradlew run --args='4 --pretty'

Compile, run the tests and generate `app.zip` and
`app.tar.gz` distributable files:

    $ ./gradlew build

The distributable files are created in the
`app/build/distributions/` folder.

Unpack the tar.gz file with:

    $ tar -xvf app/build/distributions/app.tar.gz -C DEST

Then you can execute the unpacked distribution
in any system with Java installed calling
`app` (Unix) or `app.bat` (Windows).

    $ cd DEST/app
    $ ./bin/app


TO-DO
-----

- [ ] More documentation explaining the implementation,
      better javadoc maybe?
- [ ] A better _object → string_ implementation
      that does not require to create
      the 2D array.
- [ ] Use a library to parse the arguments
      in the command line app.

About
-----

**Author**: (2021) Mariano Ruiz

**Source code**: https://github.com/mrsarm/nqueen-problem

**License**: MIT License
