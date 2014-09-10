(ns euler.factors)

(defn prime-factors [n]
  (letfn [(factors-starting-at [f n]
            (cond 
              (= n 1)           []
              (zero? (rem n f)) (cons f (factors-starting-at f (/ n f)))
              :else             (recur (inc f) n)))]
    (factors-starting-at 2 n)))

(defn count-factors [n]
  (apply * (map #(inc %) (vals (frequencies (prime-factors n))))))
