(ns euler.020)

(defn ! [n] (apply * (range 1M (inc n))))

(defn digits [n] (map #(Character/digit % 10) (str n)))

(apply + (digits (! 100)))
