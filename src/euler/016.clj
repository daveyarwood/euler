(ns euler.016)

(defn exp [x n] (reduce * (repeat n x)))

(defn digits [n] (map #(Character/digit % 10) (str n)))

(apply + (digits (exp 2M 1000)))
