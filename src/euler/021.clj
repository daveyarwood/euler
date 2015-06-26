(ns euler.021)

(defn sum-of-factors [n]
  (let [sqrt   (int (Math/sqrt n))
        prime? (= n (* sqrt sqrt))]
    (reduce (fn [sum x]
              (+ sum
                 (if (zero? (rem n x))
                   x
                   0)))
            (if prime? (+ 1 sqrt) 1)
            (range 2 (if prime? n (inc n))))))

(defn d [n]
  (- (sum-of-proper-divisors n) n))

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
