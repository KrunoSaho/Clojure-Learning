(comment
    :dependencies [[org.clojure/clojure "1.10.1"]
                 [seancorfield/next.jdbc "1.0.462"]
                 [org.xerial/sqlite-jdbc "3.31.1"]])

(require '[next.jdbc :as jdbc])

(def con-info {:dbtype "sqlite" :dbname ":memory:"})

(let [data-source (jdbc/get-datasource con-info)]
  (with-open [con (jdbc/get-connection data-source)]
    (jdbc/execute! con ["select 6*5;"])))
