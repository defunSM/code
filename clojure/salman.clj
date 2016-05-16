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

(defn create-random-array [amount max-rand]
  "Creates a random array. Amount is the number of elements. Max-rand is the max random."
  (take amount (repeatedly #(rand-int max-rand))))

(defn displayArray [array number-per-row]
  "Prints out the Array created from the create-random-array function."
  (println "-----------Array------------")
  (map #(apply println %) (partition-all number-per-row array)))

(defn sum-of-array [array]
  "Calculates and displays the total of the array."
  (let [sum (reduce + array)]
    sum))

(defn count-array [array]
  "Counts the number of elements in the array"
  (count array))

(defn average-of-array [array]
  "Calculates the average of the array."
  (let [sum (sum-of-array array)
        count (count-array array)
        avg (float (/ sum count))]
    avg))

(defn freq-array [array num]
  "Produces a list of how many of a specific number is in an array."
  (filter #(= num %) array))

(defn percent-array [array num]
  "Calculates the percent of the amount of times the number appears."
  (let [elements (count-array array)]
    (float (* (double (/ (count (freq-array array num)) elements)) 100))))

(defn total-percent-array [array max]
  "Calculates all of the numbers percentages"
  (map #(percent-array myArray %) (range max)))
