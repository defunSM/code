(ns finance.core
  (:require [clojure.string :as s]))

(def welcome-text "Welcome to Finance Manager.")

(defn display-welcome-message
  [text]
  (println text))

(display-welcome-message welcome-text)

(def database {:users {}})
