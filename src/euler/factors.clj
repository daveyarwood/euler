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

(defn sum-of-factors 
  "The sum of all factors of n, including 1 and n itself."
  [n]
  (let [sqrt   (int (Math/sqrt n))
        prime? (= n (* sqrt sqrt))]
    (reduce (fn [sum x]
              (+ sum
                 (if (zero? (rem n x))
                   x
                   0)))
            (if prime? (+ 1 sqrt) 1)
            (range 2 (if prime? n (inc n))))))
