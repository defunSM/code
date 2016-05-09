(ns joy.chp3)

(def frame (java.awt.Frame.))

frame

(.setVisible frame false)

(.setSize frame 500 500)

(defn makeframe [title sx sy]
  (let [frame (java.awt.Frame.)]
    (.setSize frame sx sy)
    (.setTitle frame title)
    (.setVisible frame true)))

(makeframe "Test" 300 300)

(def population {:zombies 2700 :humans 9})

(:zombies population)

(defn isone? []
  (let [n (read-line)]
    (cond
    (= n "1") (println "This number is one.")
    :else (println "This number is not one."))))

(isone?)

::not-in-ns

(name 'goat)

(let [x (with-meta 'goat {:ornery true})
      y (with-meta 'goat {:ornery false})]
  [(= x y)
       (identical? x y)
       (meta x)
       (meta y)])
