(defproject gel "0.1.0-SNAPSHOT"
  :description "A Clojure implementation of the Liquid template engine."
  :url "https://github.com/jeremyheiler/gel"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [instaparse "1.3.1"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.5.8"]]}})
