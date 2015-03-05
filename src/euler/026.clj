(ns euler.026)

(defn recurring-cycles [denominator]
  (loop [remainders #{}, numerator 1, counter 0]
    (let [remainder (rem numerator denominator)]
      (if (contains? remainders remainder)
        counter
        (recur (conj remainders remainder)
               (* 10 remainder)
               (inc counter))))))

(loop [d 999, [d' longest-cycle] [nil 0]]
  (if (< d longest-cycle)
    [d' longest-cycle]
    (let [cycles (recurring-cycles d)]
      (recur (dec d) (if (> cycles longest-cycle)
                       [d cycles]
                       [d' longest-cycle])))))
