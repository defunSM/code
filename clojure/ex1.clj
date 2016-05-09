(ns sm.chess)

[1 2 #?@(:clj [3 4] :cljs [5 6])]

(read-string
 {:read-cond :allow
  :features #{:cljs}}
 "#(:cljs :works! :default :boo)")

(macroexpand '(when (pos? a) (println "positive") (/ b a)))

(-> {} (assoc :a 1) (assoc :b 2))

(macroexpand '(-> {} (assoc :a 1) (assoc :b 2)))

(def my-line [[5 10] [10 20]])

(let [p1 (first my-line)
      p2 (second my-line)
      x1 (first p1)
      y1 (second p1)
      x2 (first p2)
      y2 (second p2)]
  (println "Line from (" x1 ", " y1 ") to (" x2 " to " y2 ")"))

(def my-line [[5 10] [10 20]])

(let [[p1 p2] my-line
      [x1 y1] p1
      [x2 y2] p2]
  (println "Line from (" x1 "," y1 ") to (" x2 ", " y2 ")"))

(def my-vector [1 2 3])

(let [[x y z] my-vector]
  (println x y z))

(defn r->lfix
  ([a op b] (op a b))
  ([a op1 b op2 c] (op1 a (op2 b c)))
  ([a op1 b op2 c op3 d] (op1 a (op2 b (op3 c d)))))

(r->lfix 1 + 2)

(defn l->lfix
  ([a op b] (op a b))
  ([a op1 b op2 c] (op2 c (op1 a b)))
  ([a op1 b op2 c op3 d] (op3 d (op2 c (op1 a b)))))

(r->lfix 10 * 2 + 3)

(def order {+ 0 - 0
            * 1 / 1})

(defn infix3 [a op1 b op2 c]
  (if (< (get order op1) (get order op2))
    (r->lfix a op1 b op2 c)
    (l->lfix a op1 b op2 c)))

(infix3 1 + 2 * 3)

(infix3 10 * 2 + 3)

(def numbers [1 2 3 4 5 6 7 8 9 10])
(def morenumbers [10 9 8 7 6 5 4 3 2 1])

(extend-type String
  Concatenatable
  (cat [this other]
    (concat this other)))

(loop [x 5
       y 2]
  (print x y)
  (if (< x 9)
    (recur (inc x) (dec y))))p

(def somevar [x 2 y []]
  (if (< x 5)
    (recur
     (inc x)
     (conj y (fn [] (print x))))))

(ns joy.chess)

(defn initial-board []
  [\r \n \b \q \k \b \n \r
   \p \p \p \p \p \p \p \p
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \P \P \P \P \P \P \P \P
   \R \N \B \Q \K \B \N \R])

(def ^:dynamic *file-key* \a)
(def ^:dynamic *rank-key* \0)

(defn- file-component [file]
  (- (int file) (int *file-key*)))

(defn- rank-component [rank]
  (->> (int *rank-key*)
       (- (int rank))
       (- 8)
       (* 8)))

(defn- index [file rank]
  (+ (file-component file) (rank-component rank)))

(defn lookup [board pos]
  (let [[file rank] pos]
    (board (index file rank))))

(lookup (initial-board) "a1")

(defn lookup3 [board pos]
  (let [[file rank] (map int pos)
        [fc rc]     (map int [\a \0])
        f (- file fc)
        r (* 8 (- 8 (- rank rc)))
        index (+ f r)]
    (board index)))

(lookup3 (initial-board) "a1")

(defn transform [person]
  (update (assoc person :hair-color :gray) :age inc :weight weight :blood blood))

(transform {:name "Socrates", :age 39})

(transform {:weight 70, age 30})

(defn transform [person]
  (-> person
      (assoc :hair-color :gray)
      (assoc :weight 70)
      (assoc :name "")
      (update :age dec)))

(defrecord Person [hp weight age])

(def salman (new Person 100 121 18))

(get salman :hp)

(transform {:age 2})

(defn calculate [var]
  (reduce + (map #(* % %) (filter even? (range var)))))

(time (calculate 11))

(let [x (time (calculate 17))]
  (println "Answer:" x))

(defn relay [x i]
  (when (:next x)
    (send (:next x) relay i))
  (when (and (zero? i) (:report-queue x))
    (.put (:report-queue x) i))
  x)

(defn run [m n]
  (let [q (new java.util.concurrent.SynchronousQueue)
        hd (reduce (fn [next _] (agent {:next next}))
                   (agent {:report-queue q}) (range (dec m)))]
    (doseq [i (reverse (range n))]
      (send hd relay i))
    (.take q)))

(time (run 1000 1000))

(#'sm.read/pcurrentdir)

(defn sum [& more]
  (let [s (apply #'+ more)]
    (println s)
    s))

(sort #(compare %2 %1 [4 3 2]))

(def salman {:name "Salman" :age 18 :weight 120})
(def fahim  {:name "Fahim" :age 14 :weight 100})
(def dad {:name "Mohammad" :age 50 :weight 140})
(def mom {:name "Feroza" :age 40 :weight 160})
(def family [salman fahim dad mom])

(defn printname [& more]
  (let [{:keys [f-name m-name l-name]} more]
    (println f-name)))



(defn printname [& more]
  (let [{:keys [f-name m-name l-name], :or {f-name (first more) m-name (second more) l-name (third l-name)}}]
    (println f-name m-name l-name)))

(apply #'+ (range 10001))

(for [x (range 2) y (range 2)] [x y (bit-xor x y)])

(defn xors [max-x max-y] (for [x (range max-x) y (range max-y)] [x y (bit-xor x y)]))

(xors 2 2)

(def frame (java.awt.Frame.))

(for [method (seq (.getMethods java.awt.Frame))
      :let [method-name (.getName method)]
      :when (re-find #"Vis" method-name)]
  method-name)

(.isVisible frame)

(.setVisible frame true)

(.setSize frame (java.awt.Dimension. 500 500))

(.setTitle frame "GUI Programming with Clojure")

(def gfx (.getGraphics frame))

(.fillRect gfx 100 100 50 75)

(.setColor gfx (java.awt.Color. 255 128 0))

(doseq [[x y xor] (xors 500 500)]
  (.setColor gfx (java.awt.Color. xor xor xor))
  (.fillRect gfx x y 1 1))

(.printStackTrace *e)

(defn xors [xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (bit-xor x y) 256)]))

(defn clear [g] (.clearRect g 0 0 500 500))

(clear gfx)

(defn f-values [f xs ys]
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn draw-values [f xs ys]
  (clear gfx)
  (.setSize frame (java.awt.Dimension. xs ys))
  (doseq [[x y v] (f-values f xs ys)]
    (.setColor gfx (java.awt.Color. v v v))
    (.fillRect gfx (x y 11))))

(draw-values bit-and 256 256)

(def a (rationalize 1.0e50))

(println (* a (+ a a)))

(rational? 1.0)

(class 1)

(println (/ 1 3))

(println (rationalize (/ 1 3)))

(def myhash {:a 1 :b 2})

(+ (get myhash :a) (get myhash :b))

(:b myhash "No c in hash")

(def myvector (vector 1 2 3 4))

(hash-set 1 1 2 2)

(defn multi-arity
  ([x]
   (println x))
  ([x y]
   (println x y)))

(multi-arity 1 2)

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Second choice: " second-choice))
  (println (str "LOVING: " (clojure.string/join ", " unimportant-choices))))

(chooser ["Salman" "Fahim" "Dad" "MOm"])

(#(identity %&) 8 2)

((fn [name] (println name)) "Salman")

(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo"])

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))
(def inc4 (inc-maker 4))

(inc4 7)

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(time (symmetrize-body-parts asym-hobbit-body-parts))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(time (better-symmetrize-body-parts asym-hobbit-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hash-map [:a 1 :b 2])

(defn titleize
  [topic]
  (str topic " for the Brave and the True."))

(map titleize ["Hamsters" "Ragnarok"])

(map #(titleize (first %)) {:uncomfortable-thing "Winking"})

(println (seq #{1 2 3}))

(println (into {} (seq {:a 1 :b 2 :c 3})))

(def human-consumption [8.1 7.3 6.6 5.0])

(def critter-consumption [0.0 0.2 0.3 1.1])

(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(println (map unify-diet-data human-consumption critter-consumption))

(def sum #(reduce + %))

(def avg #(/ (sum %) (count %)))

(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spiderman" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your Dad"}])

(map :alias identities)

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1
         :critter 3.9})

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)

(drop-while #(< (:month %) 3) food-journal)

(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))

(some #(> (:critter %) 5) food-journal)

(some #(and (> (:critter %) 3) %) food-journal)

(println (reverse (sort-by count ["aaa" "c" "bb"])))

(concat [1 2] [3 4])

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:make-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(time (vampire-related-details 0))

(time (def mapped-details (map vampire-related-details (range 0 1000000))))

(println (time (first mapped-details)))

(concat (take 8 (repeat "na")) ["Batman!"])

(take 3 (repeatedly (fn [] (rand-int 10))))

(defn dice [rolls max-roll]
  (let [rolls rolls
        max-roll max-roll]
      (take rolls (repeatedly (fn [] (rand-int max-roll))))))

(defn sdice [difficulty]
  (let [difficulty difficulty
        dice (dice 10 10)]
    (println "\nDice Pool:" dice "Successes:" (count (filter #(>= % difficulty) dice)) "\n")
    (count (filter #(>= % difficulty) dice))))

(time (map identity {:sunlight-reaction "Glitter!"}))

(time (into {} (map identity {:sunlight-reaction "Glitter!"})))

(conj [0] 1 2 3 4)

(println (max [:name 2 :age 10]))



(defn my-into
  [target additions]
  (apply conj target additions))

(my-into [0] [1 2 3])

(def add10 (partial + 10))

(add10 3)

(defn my-into
  [target additions]
  (apply conj target additions))

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "unobtainium" "adamantium")

(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(def warn (partial lousy-logger :warn))

(def emergency (partial lousy-logger :emergency))

(emergency "this is a warniGg")

(defn identify-humans
  [social-security-numbers]
  (filter #(not (vampire? %))
          (map vampire-related-details social-security-numbers)))

(def not-vampire? (complement vampire?))
(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))

(defn my-complement
  [fun]
  (fn [& args]
    (not (apply fun args))))

(def my-pos? (complement neg?))

(my-pos? 1)

(defn sum
  ([vals] (sum vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
     accumulating-total
     (sum (rest vals) (+ (first vals) accumulating-total)))))

(defn analyze-file
    [filename]
    (analysis (slurp filename)))

(defn analysis
    [text]
    (str "Character count: " (count text)))

(analyze-file "/root/monkey.txt")

(defn sum
    ([vals] (sum vals 0))
    ([vals accumulating-total]
     (if (empty? vals)
       accumulating-total
       (sum (rest vals) (+ (first vals) accumulating-total)))))

(sum [1 2 3 4])

(sum [2 8] 45)

(defn sum
    ([vals]
     (sum vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
     accumulating-total
     (recur (rest vals) (+ (first vals) accumulating-total)))))

(require '[clojure.string :as s])

(defn clean
    [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "My boa constrictor is so sassy lol!   ")

((comp inc *) 2 3 2)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))
(def c-name (comp :name))

(c-name character)
(c-int character)
(c-str character)
(c-dex character)

(defn spell-slots
    [char]
    (int (inc (/ (c-int char) 2))))

(spell-slots character)

(def spell-slots-comp (comp int inc #(/ % 2) c-int))

(spell-slots-comp character)

(defn two-comp
  [f g]
  (fn [% args]
    (f (apply g args))))

(two-comp (comp int inc 1) (comp int inc 2))

(defn tri*
  ([] (tri* 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))

(take 5 tri)

(defn triangular?
  [n]
  (= n (last (take-while #(>= n %) tri))))

(defn row-tri
    [n]
    (last (take n tri)))

(defn row-numa
    [pos]
    (inc (count (take-while #(> pos %) tri))))

(defn connect
  [board max-pos pos neighbor destination]
  (if (<= destination max-pos)
    (reduce (fn [new-board [p1 p2]]
              (assoc-in new-board [p1 :connections p2] neighbor))
            board
            [[pos destination] [destination pos]])
    board))

(connect {} 15 1 2 4)

(def myarray [1 2 3 4])

(println (apply list myarray))

(defn convert-array-to-list
    [array]
  (apply list array))

(convert-array-to-list [:name 2 3 4])

(into [] (first (apply list {:name "Salman" :age 5})))

(defn convert-map-to-array
  ([map] (convert-map-to-array map [])
         ([map newmap]
          (if (empty? newmap)
            (vector map)))))

(time (seq {:name "Salman" :age 5}))
(time (flatten (vec {:name "Salman" :age 5})))

(into [] (apply list (seq {:name "Salman" :age 5})))

(def var "String")

(vec (mapcat seq {"red" "blue"}))

(reduce into [] {})

(vector? (reduce + {1 2}))

(reduce + (reduce + {1 2}))

(flatten (vec {:name "Salman" :age 5}))

(convert-map-to-array {:name "Salman" :age 5})

(filter #(-> % val (= 1)) {:a 1 :b 1 :c 2})

(let [m {:a 1 :b 1 :c 2}]
  (select-keys m (for [[k v] m :when (= v 1)] k)))

(defn fib
  "some function"
  [n]
  (if (< n 2) n (+ (fib (- n 1)) (fib (- n 2)))))

(defn user_input
  "Some function"
  []
  (println (read)))

(user_input)

(defn somethingelse
  "somethingelse function that does something"
  [n]
  (first n))

(def myhashmap {:name "salman" :age 19})

(apply list (somethingelse myhashmap))

(def mycharacter {:name "Salman"
                  :attributes {:strength 85
                               :intelligence 1
                               :age 19
                               :weight 125}})

(def anothercharacter {:name "Fahim"
                       :attributes {:strength 9001
                                    :intelligence 69
                                    :age 19
                                    :weight 2}})

((comp :strength :attributes) mycharacter)

(def c-str (comp :strength :attributes))

(println (c-str anothercharacter))

(defn power
  [number raised]
  (let [original number]
    (if (= raised 0)
      number
      (power (* original original) (- raised 1)))))

(power 2 3)

(seq (.split #"," "one,two,three"))

(re-seq #"\w+" "one-two/three")

(re-seq #"\w*(\w)" "one-two/three")

(def a-to-z (vec (map char (range 65 91))))

(defn print-letter
  [number change]
  (println (nth (apply list a-to-z) number) " has been changed to " change)
  (assoc a-to-z number change))

(defn select-num
  []
  (println "Select number to change!: ")
  (read))

(defn change
  []
  (println "What do you want to change it to?: ")
  (read))

(use ['clojure.string :only '(split)])

(defn str-to-ints
  [string]
  (map #(Integer/parseInt %)
       (split string #" ")))

(defn parse-int
  [s]
  (Integer. (re-find #"\d+" s )))

(print-letter select-num (read-string change))

(replace {2 :a, 4 :b} [1 2 3 2 3 4])

(def matrix
  [[1 2 3]
   [4 5 6]
   [7 8 9]])

(get-in matrix [0 2])

(def great-books ["East o Eden" "The Glass Bead Game"])

great-books

(get (ns-interns *ns*) 'great-books)

(ns-map *ns*)

(deref #'sm.chess/great-books)

(def great-books ["The power of Bees" "Journey to Upstairs"])

(create-ns 'cheese.taxonomy)

(ns-name (create-ns 'cheese.taxonomy))

(def cheddars ["Mild"])


(in-ns 'cheese.analysis)

cheddars

(defn power
  [base exponent]
  (if (= exponent 0)
    base
    (power (* base base) (- exponent 1))))

(power 2 2)
