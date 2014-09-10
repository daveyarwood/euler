(ns euler.004)

(defn is-palindrome? [n]
	(let [s (seq (str n))]
		(= s (reverse s))))

(let [palindromes (for [x (range 100 1000)
                        y (range 100 x)
                        :when (is-palindrome? (* x y))]
                    (* x y))]
  (apply max palindromes))
