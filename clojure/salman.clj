(ns salman.core
  (:require [clojure.string :as str]))

;; Convert vector to list [Add listify and listify-1 as one function and to accept hasmaps]

(defn listify
  "Will continously keep the list flattened and convert vectors to lists."
  [& etc]
  (flatten (list etc)))

(defn listify-1
  "Converts a map to a list"
  ([etc]
   (flatten (map list etc)))
  ([one & etc]
   (addtolist (map listify-1 etc) (map listify-1 one))))

(defn looplist-1
  "Can repeat a number and change the last term"
  [number repeat list]
  (let [n number
        r repeat
        l list]
    (if (= repeat 1)
      list
      (looplist-1 n (- r 1) (listify n l)))))

(defn looplist
  "Can repeat a number in a list."
  [number repeat]
  (looplist-1 number repeat number))

(defn validMap?
  "Checks if what is passed is of type PersistentArrayMap."
  [map]
  (if (= (type map) clojure.lang.PersistentArrayMap)
    true
    nil))

(defn not
  "Returns true if arguments are false."
  [arg arg2]
  (= (= arg arg2) false))

(defn search
  "Returns true if the keyword is within the collection."
  [coll keyword]
  (if (= (flatten coll) (list keyword))
    true))

(defn in?
  "Attempts to iterate through the collection. Currently broken."
  [coll keyword]
  (map #(search % %2) coll keyword))

(defn search-1
  "A similar function attempting to return true or false if keyword is found."
  [list keyword]
  (let [plist (flatten list)
        elements (count (flatten list))]
    (map #((fn [list keyword] (= list keyword)) % %2) plist keyword)))
