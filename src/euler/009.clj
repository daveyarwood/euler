(ns euler.009)

(def square #(* % %))
(defn pythagorean? [a b c] (= (+ (square a) (square b)) (square c)))

(first (for [c (iterate inc 6)
             b (range 1 c)
             a (range 1 b)
             :when (and (= 1000 (+ a b c))
                        (pythagorean? a b c))]
         (* a b c)))
