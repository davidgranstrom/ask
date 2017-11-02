# ask

A command line app which queries the Wikipedia API.

I wrote this program as an exercise to learn more about Clojure. It most certainly has bugs, and is not intended to be used in any production like environment. 

## Installation

    $ lein uberjar

## Usage

Create a small shell script wrapper to run from the command line, example:

```sh
#!/bin/sh

query="$1"
java -jar path/to/ask/target/uberjar/ask-0.1.0-SNAPSHOT-standalone.jar "$query"
```

## License

Copyright (C) 2017 David Granström

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
