(defproject ask "0.1.0-SNAPSHOT"
  :description "Query the Wikipedia API for article summaries"
  :url "http://example.com/FIXME"
  :license {:name "GPLv3"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [org.clojure/data.json "0.2.6"]
                 [chic-text "0.2.0"]]
  :main ^:skip-aot ask.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
