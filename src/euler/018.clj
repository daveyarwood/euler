(ns euler.018
  (:require [clojure.string :as str]))

(def triangle
  (->> "75
        95 64
        17 47 82
        18 35 87 10
        20 04 82 47 65
        19 01 23 75 03 34
        88 02 77 73 07 63 67
        99 65 04 28 06 16 70 92
        41 41 26 56 83 40 80 70 33
        41 48 72 33 47 32 37 16 94 29
        53 71 44 65 25 43 91 52 97 51 14
        70 11 33 28 77 73 17 78 39 68 17 57
        91 71 52 38 17 14 91 43 58 50 27 29 48
        63 66 04 68 89 53 67 30 73 16 69 87 40 31
        04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
       (#(str/split % #"\n"))
       (map #(str/split % #"\s+"))
       (map #(remove empty? %))
       (map (fn [row] (map #(str/replace % #"\A0" "") row)))
       (mapv #(mapv read-string %))))

(defn number-at [[row col] triangle] (aget (to-array-2d triangle) row col))

(defn two-below [[row col]]
  "Takes a row-col point and returns the two points to the down-left and 
   down-right of the point."
  [[(inc row) col] [(inc row) (inc col)]])

(defn row-sums [row-number triangle]
  (loop [col 0, sums []]
    (if (> col row-number)
      sums
      (let [n (number-at [row-number col] triangle)
            [x y] (map #(number-at % triangle) (two-below [row-number col]))]
        (recur (inc col) (conj sums (+ n (max x y))))))))

(defn triangle-sums [triangle]
  (loop [triangle triangle, row-number (- (count triangle) 2)]
    (if (< row-number 0)
      triangle
      (recur  (assoc triangle row-number (row-sums row-number triangle))
              (dec row-number)))))

(ffirst (triangle-sums triangle))
