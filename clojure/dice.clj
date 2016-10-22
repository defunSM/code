(ns dice.core)

(defn create-dice [low high]
  (for [i (range low high)]
    (map (fn [b] (+ i b)) (range low high))))

(defn outcome [arg]
  (reduce + (for [i arg]
              (count i))))

(defn count-occurrences [s slist]
  (->> slist
       flatten
       (filter #{s})
       count))

(defn percentage [min max dice outcome]
  (for [x (range min (+ max 1))]
    (println x "           " (count-occurrences x dice) "               " (float (/ (count-occurrences x dice) outcome)) "%")))

(defn stats [low high]
  (let [dice-pos (create-dice low high)
        outcome (outcome dice-pos)
        max (apply max (flatten dice-pos))
        min (apply min (flatten dice-pos))]
      (println "\n\nDice Possibilities: " dice-pos "\n\n")
      (println "Total Number of Possibilities: " outcome)
      (println "The Max Sum: " max)
      (println "The Min Sum: " min "\n\n")
      (println "Sum:    #ofPossibilities:    Percentage %:")
      (percentage min max (flatten dice-pos) outcome)))

(stats 1 7)
