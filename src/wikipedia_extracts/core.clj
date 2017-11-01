(ns wikipedia-extracts.core
  (:require [clojure.string :as s]
            [org.httpkit.client :as http]
            [clojure.data.json :as json]
            [chic-text.core :as chic])
  (:gen-class))

(def api "https://en.wikipedia.org/w/api.php")
(def default-opts {:timeout 1000 ; ms
                   :query-params {:action "query"
                                  :prop "extracts"
                                  :format "json"
                                  :exsentences 5
                                  :explaintext true
                                  :exsectionformat "plain"
                                  :exlimit 1}
                   :user-agent "User-agent Mozilla/5.0"})

(declare parse pretty-print)

; utility function
(defn deep-merge
  "Merge two maps overwriting keys in a with keys from b"
  [a b]
  (merge-with (fn [x y]
                (cond (map? y) (deep-merge x y)
                      (vector? y) (concat x y)
                      :else y))
              a b))

(defn request
  "Sends a GET request with a title query to the wikipedia API"
  [query]
  (let [options (deep-merge default-opts {:query-params {:titles query}})]
    @(http/get api options
            (fn [{:keys [status headers body error]}] ;; asynchronous response handling
              (if error
                (println "Failed, exception is " error)
                (parse body))))))

(defn parse
  "Extracts the title and body from a json string"
  [json]
  (let [data (json/read-json json)
        query (into {} (vals (get-in data [:query :pages])))
        title (query :title)
        body (query :extract)]
    (pretty-print {:title title :body body})))

(defn pretty-print
  [m]
  (let [width 72]
    (chic/print-table-of width [m] " " :title " - " :body)))

(defn -main
  [& args]
  (let [query (first args)]
    (request query)))
