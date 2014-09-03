[![Build Status](https://travis-ci.org/jeremyheiler/gel.svg)](https://travis-ci.org/jeremyheiler/gel)

# Gel

A Clojure implementation of the [Liquid](https://github.com/shopify/liquid) template engine.

## Release

```
[gel "0.1.0-SNAPSHOT"]
```

## Usage

```clojure
(require '[gel.core :as gel])

(gel/render "Hi {{ name }}!" {:name "Sophie"})
;=> "Hi Sophie!"
```

## License

Copyright © 2014 Jeremy Heiler

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
