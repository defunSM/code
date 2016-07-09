(ns arp.core
  (:use clojure.java.shell))

(println (:out (sh "arp" "-a")))

(defn usercmd [])
