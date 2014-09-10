(ns euler.lazy)

; primes and powers-of-two copied shamelessly from clojure.contrib/lazy_seqs

(def primes
  (concat 
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
          (fn primes-from [n [f & r]]
            (if (some #(zero? (rem n %))
                      (take-while #(<= (* % %) n) primes))
              (recur (+ n f) r)
              (lazy-seq (cons n (primes-from (+ n f) r)))))
          wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
                        6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
                        2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

(def fibs
  (lazy-cat [0 1] (map +' fibs (rest fibs))))

(def powers-of-2
  (iterate #(bit-shift-left % 1) 1))

(def triangle-numbers
  (map first (iterate (fn [[a b]] [(+ a b) (inc b)]) [1 2])))
