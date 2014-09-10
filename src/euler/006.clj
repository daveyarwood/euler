(ns euler.006)

(def square #(* % %))
(defn sum-of-squares [ns] (apply + (map square ns)))
(defn square-of-sum [ns] (square (apply + ns)))
(defn difference [ns] (Math/abs (- (sum-of-squares ns) (square-of-sum ns))))

(difference (range 1 101))
