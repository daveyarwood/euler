(ns euler.015)

(defn ! [n] (apply * (range 2M (inc n))))

(defn a-choose-b [a b]
  "Returns the number of ways of choosing b items from a items."
  (/ (! a) (* (! b) (! (- a b)))))

(let [grid-size 20]
  (a-choose-b (* 2 grid-size) grid-size))


