(ns finance.core
  (:require [clojure.string :as s]))

(def welcome-text "Welcome to Finance Manager.")

(defn display-welcome-message
  [text]
  (println text))

(display-welcome-message welcome-text)

(def database {:users {}})

(def totalmoney 0)

(defn validAccount? [account]
  (if (= account "Salman")
    true))

(defn accessatm []
  (let [accountname (validAccount? (read))]
    (if (true? accountname))))

(accessatm)

(defmacro infix
  [infix]
  (list (second infix) (first infix) (last infix)))

(infix (1 + 1))

(let [account (read)]
  (when (eq account "Salman")
    (println "TRUE")))

(def salman (atom {:name ""}))

(def fahim "Salman")

(reset! salman {:name (str (read))})

(= (:name @salman) "sa")
