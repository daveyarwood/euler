(ns euler.005)

(defn factor?	[num div]
  (zero? (rem num div)))

(defn factors? [divs num]
  (every? (partial factor? num) divs))

(defn smallest-multiple [start end]
  (first 
    (drop-while	
      (complement (partial factors? (range start (inc end))))
      (iterate (partial + end) end))))

(smallest-multiple 1 20)
