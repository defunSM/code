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

(def account (atom {:name 0
                    :age 0
                    :total 0
                    :debit 0
                    :cash 0}))

(defn resetaccount [acc] (reset! acc {:name 0
                                       :age 0
                                       :total 0
                                       :debit 0
                                       :cash 0}))

(defn change [acc change amount] (reset! acc (assoc @acc change amount)))
(defn display-account [acc sel] (sel @acc))

(defn setname [acc name] (change acc :name name))
(defn setage [acc age] (change acc :age age))
(defn settotal [acc total] (change acc :total total))
(defn setdebit [acc debit] (change acc :debit debit))
(defn setcash [acc cash] (change acc :cash cash))

(defn display-name [acc] (display-account acc :name))
(defn display-age [acc] (display-account acc :age))
(defn display-total [acc] (display-account acc :total))
(defn display-debit [acc] (display-account acc :debit))
(defn display-cash [acc] (display-account acc :cash))

(defn display-account-all [acc]
  "Displays all account information."
  (println "-------------------")
  (println "Name: " (:name @acc))
  (println "Age:  " (:age @acc))
  (println "Total:" (:total @acc))
  (println "Debit:" (:debit @acc))
  (println "Cash: " (:cash @acc))
  (println "-------------------"))

(display-account-all account)

(setdebit account 30)

(defn somethingforme
  "Somethingforme is a function that will print out the action."
  [action] (println action))
