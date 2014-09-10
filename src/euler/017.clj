(ns euler.017)

(defn letter-count [n]
  (let [number-word-lengths
        {1 3, 2 3, 3 5, 4 4, 5 4, 6 3, 7 5, 8 5, 9 4, 10 3,
         11 6, 12 6, 13 8, 14 8, 15 7, 16 7, 17 9, 18 8, 19 8, 
         20 6, 30 6, 40 5, 50 5, 60 5, 70 7, 80 6, 90 6}]
    (cond 
      (contains? number-word-lengths n) (number-word-lengths n)
      (zero? (rem n 1000)) (+ (number-word-lengths (/ n 1000)) 8) ; thousand
      (zero? (rem n 100)) (+ (number-word-lengths (/ n 100)) 7) ; hundred
      (> n 100) (+ (letter-count (quot n 100)) 7 3 ; hundred and
                   (letter-count (rem n 100)))
      (> n 20) (+ (letter-count (* 10 (quot n 10)))
                  (letter-count (rem n 10))))))

(apply + (map letter-count (range 1 1001)))
