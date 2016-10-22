(ns quantum.core)

(defn outcome [arg]
  (reduce + (for [i arg]
              (count i))))

(defn count-occurrences [s list]
  (count (filter #{s} (flatten list))))

(defn product [bra ket]
  (let [counter (count bra)]
    (for [x (range 0 counter)]
      (* (nth bra x) (nth ket x)))))

(defn findr [list minimum maximum]
  (let [rmax (apply max list)
        index (.indexOf list rmax)
        r (nth (range minimum (+ maximum 1)) index)]
    r))

(defn wavefunction [low high]
  (let [list (for [i (range low high)]
               (map (fn [b] (+ i b)) (range low high)))
        outcome (outcome list)
        max (apply max (flatten list))
        min (apply min (flatten list))
        occurances (for [x (range min (+ max 1))]
                     (count-occurrences x list))
        probability (map (fn [x] (/ (Math/sqrt x) (Math/sqrt outcome))) occurances)
        r (findr occurances min max)]
    r))

(wavefunction 1 7)
