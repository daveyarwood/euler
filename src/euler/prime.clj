(ns euler.prime)

(defn prime? [n]
  (if (even? n)
    false
    (let [root (int (Math/sqrt n))]
      (loop [x 3]
        (cond
          (> x root)        true
          (zero? (mod n x)) false
          :else (recur (+ x 2)))))))
