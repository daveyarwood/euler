(ns euler.021
  (:require [euler.factors :refer (sum-of-factors)]))

(defn d [n]
  (- (sum-of-factors n) n))

(reduce (fn [sum n]
          (+ sum 
             (let [sum-of-factors (d n)]
               (if (and (> sum-of-factors n)
                        (< sum-of-factors 10000)
                        (= n (d sum-of-factors)))
                 (+ n sum-of-factors)
                 0))))
        0
        (range 2 10000))
